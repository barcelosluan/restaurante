package view;

import dao.Ingreditentes_ReceitasDao;
import model.Ingredientes_Receitas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngredienteReceitaForm {
    private JTextField txtReceita;
    private JTextField txtCozinheiro;
    private JTextField txtIngrediente;
    private JTextField txtQuantidade;
    private JTextField txtMedida;
    private JTextField txtDesc;
    private JTextField txtRendimento;
    private JButton enviarButton;
    JPanel panelMain;

    public IngredienteReceitaForm() {
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingreditentes_ReceitasDao dao = new Ingreditentes_ReceitasDao();
                Ingredientes_Receitas ing = new Ingredientes_Receitas(txtReceita.getText(),
                        Integer.valueOf(txtCozinheiro.getText()),
                        Integer.valueOf(txtIngrediente.getText()),
                        Double.valueOf(txtQuantidade.getText()),
                        txtMedida.getText(),
                        txtDesc.getText(),
                        txtRendimento.getText());
                if (dao.insertIngrediente_Receita(ing)){
                    JOptionPane.showMessageDialog(panelMain, "Ingrediente Inserido na receita");
                }else{
                    JOptionPane.showMessageDialog(panelMain, "Erro na Inserção");
                }
            }
        });
    }
}
