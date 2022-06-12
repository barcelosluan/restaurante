package view;

import dao.ReceitaDao;
import model.Receita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaReceitasForm {
    private JTable tabela;
    JPanel panelMain;
    JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListaReceitasForm() {
        criaJTable();

        barraRolagem = new JScrollPane(tabela);
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(BorderLayout.CENTER, barraRolagem);
    }

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Data de Criação");
        modelo.addColumn("Cozinheiro");
        modelo.addColumn("Categoria");
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        pesquisar(modelo);
    }

    public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        ReceitaDao dao = new ReceitaDao();

        for (Receita r : dao.getReceitas()) {
            modelo.addRow(new Object[]{r.getCodCategoria(), r.getNome(),
                    r.getDataCriacao(), r.getCodCozinheiro(), r.getCodCategoria()});
        }
    }
}
