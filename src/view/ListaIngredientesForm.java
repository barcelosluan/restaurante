package view;

import dao.CozinheiroDao;
import dao.Ingreditentes_ReceitasDao;
import model.Cozinheiro;
import model.Ingredientes_Receitas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListaIngredientesForm {
    JTable tabela;
    JPanel panelMain;
    private JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListaIngredientesForm(String receita) {
        criaJTable(receita);

        barraRolagem = new JScrollPane(tabela);
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(BorderLayout.CENTER, barraRolagem);
    }

    private void criaJTable(String receita) {
        tabela = new JTable(modelo);
        modelo.addColumn("Código da Receita");
        modelo.addColumn("Nome do Cozinheiro");
        modelo.addColumn("Ingredientes");
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(120);
        pesquisar(modelo, receita);
    }

    public static void pesquisar(DefaultTableModel modelo, String receita) {
        modelo.setNumRows(0);
        Ingreditentes_ReceitasDao dao = new Ingreditentes_ReceitasDao();

        int cod_receita = Integer.parseInt(receita);
        for (Ingredientes_Receitas i : dao.getIngredientes(cod_receita)) {
            modelo.addRow(new Object[]{i.getReceita(), i.getCozinheiro(), i.getIngrediente()});
        }
    }
}
