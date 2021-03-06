package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JPanel {

    private JButton btnLivro;
    public JPanel panelMain;
    private JButton receitasButton;
    private JButton ingredienteButton;
    private JButton empregadoButton;
    private JButton restauranteButton;
    private JLabel lblLivro;
    private JLabel lblReceitas;
    private JLabel lblIngrediente;
    private JLabel lblEmpregado;
    private JLabel lblRestaurante;
    private JButton degustarButton;
    private JButton categoriaButton;
    private JButton btnListarReceitas;
    private JLabel lblListaReceitas;
    private JButton btnListaCozinheiros;
    private JLabel lblListaCozinheiros;
    private JButton btnListaCategorias;


    public Principal() {
        btnLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Livro");
                frame.setContentPane(new LivroForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        receitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Receita");
                frame.setContentPane(new ReceitasForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        ingredienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ingrediente");
                frame.setContentPane(new IngredienteForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        empregadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Empregados");
                frame.setContentPane(new EmpregadoForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        restauranteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Restaurante");
                frame.setContentPane(new RestauranteForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        degustarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Degustar");
                frame.setContentPane(new DegustarForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        categoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Categoria");
                frame.setContentPane(new CategoriaForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        btnListarReceitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Receitas");
                frame.setContentPane(new ListaReceitasForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        btnListaCozinheiros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Cozinheiros");
                frame.setContentPane(new ListaCozinheirosForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        btnListaCategorias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Categorias");
                frame.setContentPane(new ListaCategoriasForm().panelMain);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
