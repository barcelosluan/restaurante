package view;

import dao.connector.Connector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JPanel {

    private JButton btn_Livro;
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


    public Principal() {
        btn_Livro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Livro");
                frame.setContentPane(new LivroForm().panelMain);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
