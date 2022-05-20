package view;

import dao.IngredienteDao;
import model.Ingrediente;
import model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngredienteForm {
    private JTextField txtNome;
    private JLabel lblDesc;
    private JTextField txtDesc;
    private JButton btnEnviar;
    JPanel panelMain;

    public IngredienteForm() {
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngredienteDao dao = new IngredienteDao();
                if (dao.insertIngrediente(new Ingrediente(txtNome.getText(), txtDesc.getText()))){
                    JOptionPane.showMessageDialog(panelMain, "Ingrediente Inserido");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                }
            }
        });
    }
}
