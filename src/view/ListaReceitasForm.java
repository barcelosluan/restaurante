package view;

import dao.ReceitaDao;
import model.Receita;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    public ListaReceitasForm(int categoria) {
        criaJTableFmt2(categoria);

        barraRolagem = new JScrollPane(tabela);
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(BorderLayout.CENTER, barraRolagem);

        tabela.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        String codigo = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
                        JFrame frame = new JFrame("Ingredientes");
                        frame.setContentPane(new ListaIngredientesForm(codigo).panelMain);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }});
    }

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Data de Criação");
        modelo.addColumn("Cozinheiro");
        modelo.addColumn("Categoria");
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2)
                .setPreferredWidth(80);
        tabela.getColumnModel().getColumn(3)
                .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(4)
                .setPreferredWidth(120);
        pesquisar(modelo);
    }

    public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        ReceitaDao dao = new ReceitaDao();

        for (Receita r : dao.getReceitasIngredientes()) {
            modelo.addRow(new Object[]{r.getCodigo(), r.getNome(),
                    r.getDataCriacao(), r.getNomeCozinheiro(), r.getNomeCategoria()});
        }
    }

    private void criaJTableFmt2(int categoria) {
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Cozinheiro");
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2)
                .setPreferredWidth(80);
        pesquisarFmt2(modelo, categoria);
    }

    public static void pesquisarFmt2(DefaultTableModel modelo, int categoria) {
        modelo.setNumRows(0);
        ReceitaDao dao = new ReceitaDao();

        for (Receita r : dao.getReceitaCategoria(categoria)) {
            modelo.addRow(new Object[]{r.getCodigo(), r.getNome(), r.getNomeCozinheiro()});
        }
    }
}
