package view;

import dao.CategoriaDao;
import model.Categoria;
import model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriaForm {
    private JLabel lblNome;
    private JTextField txtCod;
    private JTextField txtCategoria;
    private JButton enviarButton;
    JPanel panelMain;

    public CategoriaForm() {
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoriaDao dao = new CategoriaDao();
                if (dao.insertCategoria(new Categoria(Integer.valueOf(txtCategoria.getText()), txtCod.getText()))){
                    JOptionPane.showMessageDialog(panelMain, "Livro Inserido");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                }
            }
        });
    }
}
