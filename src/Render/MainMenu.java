package Render;

import Util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener, Util {

    private JFrame frame;
    private JPanel panel;
    private JButton start;
    private JButton exit;

    public MainMenu() {
        this.frame = new JFrame("War");
        this.panel = new JPanel(null);
        this.start = new JButton("Start");
        this.exit = new JButton("Exit");
        handleFrame();
    }

    public void handleFrame() {
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.setUndecorated(true);
        this.frame.add(panel);

        this.panel.setSize(frame.getWidth(), frame.getHeight());
        this.panel.add(start);
        this.panel.add(exit);
    }

    public void handleButtons() {
        this.exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add gameStart
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
