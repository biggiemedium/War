package Render;

import Render.Game.GameFrame;
import Util.Util;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener, Util {

    private JFrame frame;
    private JPanel panel;
    private JButton start;
    private JButton exit;
    private JLabel war;
    private JTextField playerName;

    public MainMenu() {
        this.frame = new JFrame("War");
        this.panel = new JPanel(null);
        this.start = new JButton("Start");
        this.exit = new JButton("Exit");
        this.war = new JLabel("War");
        this.playerName = new JTextField("Enter Player Name Here");
        handleFrame();
        handleComponents();
    }

    /**
     * Sets frame dimensions and adds JPanel
     */
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
        this.panel.add(playerName);

    }

    /**
     * Handles all JComponents that aren't JFrame or JPanel
     */
    public void handleComponents() {
        this.exit.setBounds(panel.getWidth() / 2 - 100, panel.getHeight() / 2 + 50, 200, 75);
        this.exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.start.setBounds(panel.getWidth() / 2 - 125, panel.getHeight() / 2 - 50, 250, 100);
        this.start.setSelected(false);
        this.start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame().Build();
            }
        });

        this.war.setBounds(panel.getWidth() / 2 - 20, 25, 250, 100);
        this.war.setFont(new Font(war.getName(), Font.PLAIN, 25));

        this.playerName.setBounds(panel.getWidth() / 2 - 100, start.getY() - (start.getHeight() / 2), 200, 25);
    }

    public String getPlayerName() {
        if(!this.playerName.getText().equalsIgnoreCase("Enter Player Name Here") && !(this.playerName == null)) {
            return this.playerName.getText();
        }

        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
