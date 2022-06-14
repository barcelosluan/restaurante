package view;

import dao.CozinheiroDao;
import dao.ReceitaDao;
import model.Cozinheiro;
import model.Receita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListaCozinheirosForm extends JFrame{
    private JTable tabela;
    JPanel panelMain;
    JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListaCozinheirosForm() {
        criaJTable();

        barraRolagem = new JScrollPane(tabela);
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(BorderLayout.CENTER, barraRolagem);
    }

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Fantasia");
        modelo.addColumn("Nome");
        modelo.addColumn("Quantidade de Receitas");
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(10);
        pesquisar(modelo);
    }

    public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        CozinheiroDao dao = new CozinheiroDao();

        for (Cozinheiro c : dao.getCozinheirosReceita()) {
            modelo.addRow(new Object[]{c.getNome(), c.getNome(), c.getQtd_receitas()});
        }
    }
}
