package view;

import dao.Degustadores_ReceitasDao;
import model.Degustador_Receita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DegustarForm {
    private JLabel lblCodCozinheiro;
    private JTextField txtCozinheiro;
    private JLabel lblReceita;
    private JTextField txtReceita;
    private JLabel lblNota;
    private JTextField txtNota;
    private JButton btnAvaliar;
    JPanel panelMain;

    public DegustarForm() {
        btnAvaliar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Degustadores_ReceitasDao dao = new Degustadores_ReceitasDao();
                if (dao.insertDegustadorReceita(new Degustador_Receita(Integer.parseInt(txtCozinheiro.getText()),Integer.parseInt(txtReceita.getText()),Double.parseDouble(txtNota.getText())))){
                    JOptionPane.showMessageDialog(panelMain, "Ingrediente Inserido na receita");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                }
            }
        });
    }
}
