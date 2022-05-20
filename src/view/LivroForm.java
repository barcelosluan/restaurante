package view;

import dao.LivroDao;
import model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroForm extends JPanel{
    JPanel panelMain;
    private JLabel lblIsbn;
    private JTextField txtIsbn;
    private JLabel lblEditor;
    private JTextField txtEditor;
    private JButton btnCadastraLivro;
    private JLabel lbltitulo;
    private JTextField lblTitulo;


    public LivroForm() {
        btnCadastraLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivroDao dao = new LivroDao();
                if (dao.insertLivro(new Livro(lblTitulo.getText(),txtIsbn.getText(),Integer.valueOf(txtEditor.getText())))){
                    JOptionPane.showMessageDialog(panelMain, "Livro Inserido");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                }
            }
        });
    }
}
