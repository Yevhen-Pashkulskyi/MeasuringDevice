package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderPanel extends JFrame {

    public BorderPanel() {
        JPanel jPanel1 = new javax.swing.JPanel();
        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jPanel1.setLayout(new BorderLayout());

        jPanel1.add(button1, BorderLayout.NORTH);
        jPanel1.add(button2, BorderLayout.SOUTH);

        add(jPanel1, BorderLayout.CENTER);

        setSize(400,400);
        setVisible(true);

        button1.setText("button1");
        button1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
    }

    private void button1MouseClicked(MouseEvent evt) {
        System.out.println("button1MouseClicked");
        JOptionPane.showMessageDialog(this, "button1MouseClicked");
    }

}
