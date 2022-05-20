package view;

import dao.RestauranteDao;
import model.Restaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteForm {
    JPanel panelMain;
    private JTextField txtCod;
    private JTextField txtNome;
    private JButton enviarButton;

    public RestauranteForm() {
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestauranteDao dao = new RestauranteDao();
                if (dao.insertRestaurante(new Restaurante(Integer.parseInt(txtCod.getText())))){
                    JOptionPane.showMessageDialog(panelMain, "Receita Excluida");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na exclusao");
                }
            }
        });
    }
}
