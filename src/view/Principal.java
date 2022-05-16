package view;

import dao.connector.Connector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    Connector conn = new Connector();
    private JButton btn_app;
    public JPanel panelMain;

    public Principal(){
        btn_app.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
