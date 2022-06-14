package view;

import dao.CategoriaDao;
import dao.ReceitaDao;
import model.Categoria;
import model.Receita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ListaCategoriasForm {
    private JComboBox cbCategorias;
    JPanel panelMain;
    private JButton btnPesquisar;
    public ListaCategoriasForm() {
       panelMain.setSize(1200,800);
        criaJCombo();

        cbCategorias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = cbCategorias.getSelectedIndex();
                if (item != 0) {
                    btnPesquisar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame = new JFrame("Receitas");
                            frame.setContentPane(new ListaReceitasForm(item).panelMain);
                            frame.pack();
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                        }
                    });
                }

            }
        });

    }

    private void criaJCombo() {
        try {
            CategoriaDao dao = new CategoriaDao();
            for (Categoria c : dao.getAllCategorias()) {
                cbCategorias.addItem(c.getDescricao());
            }
        } catch (Exception e) {

        }
    }

}
