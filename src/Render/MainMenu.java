package Render;

import Render.Game.GameFrame;
import Util.Dimension;
import Util.RenderUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton start;
    private JButton exit;
    private JLabel war;
    private JLabel warningLabel;
    private JTextField playerName;

    public MainMenu() {
        this.frame = new JFrame("War");
        this.panel = new JPanel(null);
        this.start = new JButton("Start");
        this.exit = new JButton("Exit");
        this.war = new JLabel("War");
        this.playerName = new JTextField("Enter Player Name Here");
        this.warningLabel = new JLabel("Warning: Name entered is invalid...");
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
        //this.panel.setOpaque(true);
        this.panel.add(start);
        this.panel.add(exit);
        this.panel.add(war);
        this.panel.add(playerName);
        this.panel.add(warningLabel);
    }

    /**
     * Handles all JComponents that aren't JFrame or JPanel
     */
    public void handleComponents() {
        RenderUtil.setupComponent(warningLabel, new Dimension<>(3, frame.getHeight() - 40, 250, 50));
        warningLabel.setForeground(Color.RED);
        warningLabel.setVisible(false);

        this.exit.setBounds(panel.getWidth() / 2 - 100, panel.getHeight() / 2 + 50, 200, 75);
        RenderUtil.handleColouring(exit, new Color(255, 255, 255));
        this.exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                return;
            }
        });

        this.start.setBounds(panel.getWidth() / 2 - 125, panel.getHeight() / 2 - 50, 250, 100);
        this.start.setSelected(false);
        RenderUtil.handleColouring(start, new Color(255, 255, 255));
        this.start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(playerName.getText().equalsIgnoreCase("Enter Player Name Here") || playerName.getText().isEmpty() || playerName.getText().length() >= 20) {
                    warningLabel.setVisible(true);
                    return;
                }

                new GameFrame(frame.getWidth(), frame.getHeight())
                        .withPlayerName(playerName.getText()) // we don't need ternary operator because of method above
                        .Build();
                frame.dispose();
            }
        });

        this.war.setBounds(panel.getWidth() / 2 - 20, 25, 250, 100);
        this.war.setFont(new Font(war.getName(), Font.PLAIN, 25));

        this.playerName.setBounds(panel.getWidth() / 2 - 100, start.getY() - (start.getHeight() / 2), 200, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Empty code block. ActionListener requires this to be here since its an interface
    }
}
