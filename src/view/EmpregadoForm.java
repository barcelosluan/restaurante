package view;

import dao.CozinheiroDao;
import dao.DegustadorDao;
import dao.EditorDao;
import dao.EmpregadoDao;
import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Empregado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class EmpregadoForm {
    private JLabel lblCodEmpregado;
    private JTextField txtEmpregado;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblData;
    private JFormattedTextField txtDate;
    private JLabel lblRg;
    private JTextField txtRg;
    private JButton enviarButton;
    private JComboBox comboEmpregado;
    private JTextField txtFantasia;
    private JLabel lblFantasia;
    JPanel panelMain;
    private JButton editarButton;
    private JButton excluirButton;
    private JTextField txtBusca;
    private JButton buscarButton;

    public EmpregadoForm() {
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboEmpregado.getSelectedItem().toString().equals("Cozinheiro")){
                    CozinheiroDao dao = new CozinheiroDao();
                    if (dao.insereCozinheiro(new Cozinheiro(Integer.valueOf(txtEmpregado.getText()), txtNome.getText(), Date.valueOf(txtDate.getText()),txtRg.getText(),txtFantasia.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                } else if (comboEmpregado.getSelectedItem().toString().equals("Editor")){
                    EditorDao dao = new EditorDao();
                    if (dao.insertEditor(new Editor(Integer.valueOf(txtEmpregado.getText()), txtNome.getText(), Date.valueOf(txtDate.getText()),txtRg.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                }else if (comboEmpregado.getSelectedItem().toString().equals("Degustador")){
                    DegustadorDao dao = new DegustadorDao();
                    if (dao.insereDegustador(new Degustador(Integer.valueOf(txtEmpregado.getText()), txtNome.getText(), Date.valueOf(txtDate.getText()),txtRg.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboEmpregado.getSelectedItem().toString().equals("Cozinheiro")){
                    CozinheiroDao dao = new CozinheiroDao();
                    if (dao.updateCozinheiro(new Cozinheiro(Integer.valueOf(txtEmpregado.getText()), txtNome.getText(), Date.valueOf(txtDate.getText()),txtRg.getText(),txtFantasia.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                } else if (comboEmpregado.getSelectedItem().toString().equals("Editor")){
                    EditorDao dao = new EditorDao();
                    if (dao.updateEmpregado(new Editor(Integer.valueOf(txtEmpregado.getText()), txtNome.getText(), Date.valueOf(txtDate.getText()),txtRg.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                }else if (comboEmpregado.getSelectedItem().toString().equals("Degustador")){
                    DegustadorDao dao = new DegustadorDao();
                    if (dao.updateEmpregado(new Degustador(Integer.valueOf(txtEmpregado.getText()), txtNome.getText(), Date.valueOf(txtDate.getText()),txtRg.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboEmpregado.getSelectedItem().toString().equals("Cozinheiro")){
                    CozinheiroDao dao = new CozinheiroDao();
                    if (dao.deleteCozinheiro(Integer.valueOf(txtEmpregado.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                } else if (comboEmpregado.getSelectedItem().toString().equals("Editor")){
                    EditorDao dao = new EditorDao();
                    if (dao.deleteEditor(Integer.valueOf(txtEmpregado.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                }else if (comboEmpregado.getSelectedItem().toString().equals("Degustador")){
                    DegustadorDao dao = new DegustadorDao();
                    if (dao.deleteDegustador(Integer.valueOf(txtEmpregado.getText()))){
                        JOptionPane.showMessageDialog(panelMain, "Empregado Inserido");
                    }else{
                        JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                    }
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpregadoDao dao = new EmpregadoDao();
                CozinheiroDao daoc = new CozinheiroDao();
                Cozinheiro cozinheiro = daoc.getCozinheiroByCod(Integer.valueOf(txtBusca.getText()));
                Empregado empregado = dao.getEmpregadoByCod(Integer.valueOf(txtBusca.getText()));
                txtEmpregado.setText(String.valueOf(empregado.getCodigo()));
                txtNome.setText(empregado.getNome());
                txtDate.setText(String.valueOf(empregado.getDataContrato()));
                txtRg.setText(empregado.getRg());
                if (!cozinheiro.getFantasia().isBlank() || !cozinheiro.getFantasia().isEmpty()){
                    txtFantasia.setText(cozinheiro.getFantasia());
                }
            }
        });
    }
}
