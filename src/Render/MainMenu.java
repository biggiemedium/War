package Render;

import Util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener, Util {

    private JFrame frame;
    private JPanel panel;
    private JButton start;
    private JButton exit;
    private JTextField war;

    public MainMenu() {
        this.frame = new JFrame("War");
        this.panel = new JPanel(null);
        this.start = new JButton("Start");
        this.exit = new JButton("Exit");
        this.war = new JTextField("War");
        handleFrame();
        handleComponents();
    }

    public void handleFrame() {
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.setLocationRelativeTo(null);
        this.frame.setUndecorated(true);
        this.frame.setResizable(false);
        this.frame.add(panel);
        this.frame.setVisible(true);


        this.panel.setSize(frame.getWidth(), frame.getHeight());
        this.panel.add(start);
        this.panel.add(exit);
        this.panel.add(war);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleComponents() {
        this.exit.setBounds(panel.getWidth() / 2 - 100, panel.getHeight() / 2 + 50, 200, 75);
        this.exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.start.setBounds(panel.getWidth() / 2 - 125, panel.getHeight() / 2 - 50, 250, 100);
        this.start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add gameStart
            }
        });

        this.war.setBounds(panel.getWidth() / 2 - 125, 25, 250, 100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
