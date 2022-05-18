import dao.CozinheiroDao;
import dao.EmpregadoDao;
import model.Cozinheiro;
import model.Empregado;
import view.Principal;


import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}