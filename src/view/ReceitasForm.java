package view;

import dao.ReceitaDao;
import model.Receita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceitasForm {
    private JLabel lblCodReceita;
    private JTextField txtCodReceita;
    private JLabel lblNomeReceita;
    private JTextField txtNomeReceita;
    private JLabel lblCozinheiro;
    private JTextField txtCozinheiro;
    private JLabel lblCategoria;
    private JTextField txtCategoria;
    private JButton btnEnviar;
    private JButton alterarButton;
    private JButton excluirButton;
    private JButton adicionarButton;
    JPanel panelMain;
    private JTextField txtBusca;
    private JButton buscarButton;


    public ReceitasForm() {
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceitaDao dao = new ReceitaDao();
                if (dao.insertReceita(new Receita(Integer.valueOf(txtCodReceita.getText()), txtNomeReceita.getText() , Integer.valueOf(txtCozinheiro.getText()), Integer.valueOf(txtCategoria.getText())))){
                    JOptionPane.showMessageDialog(panelMain, "Receita Inserida");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                }
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceitaDao dao = new ReceitaDao();
                if (dao.updateReceita(new Receita(Integer.valueOf(txtCodReceita.getText()), txtNomeReceita.getText() , Integer.valueOf(txtCozinheiro.getText()), Integer.valueOf(txtCategoria.getText())))){
                    JOptionPane.showMessageDialog(panelMain, "Receita alterada");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na alteraçao");
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceitaDao dao = new ReceitaDao();
                if (dao.deleteReceita(Integer.valueOf(txtCodReceita.getText()))){
                    JOptionPane.showMessageDialog(panelMain, "Receita Excluida");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na exclusao");
                }
            }
        });
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ingrediente_Receita");
                frame.setContentPane(new IngredienteReceitaForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceitaDao dao = new ReceitaDao();
                Receita receita = dao.getReceitaByCod(Integer.valueOf(txtBusca.getText()));
                txtCodReceita.setText(String.valueOf(receita.getCodigo()));
                txtCategoria.setText(String.valueOf(receita.getCodCategoria()));
                txtCozinheiro.setText(String.valueOf(receita.getCodCozinheiro()));
                txtNomeReceita.setText(receita.getNome());
            }
        });
    }
}
