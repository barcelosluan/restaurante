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
    }
}
