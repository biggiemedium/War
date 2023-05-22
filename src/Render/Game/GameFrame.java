package Render.Game;

import GameLogic.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameFrame {

    private JFrame frame;
    private JPanel panel;
    private String playerName;
    private Game game;

    private JButton hit, restart, exit;

    private int[][] positions = {

    };

    public GameFrame() {
        this.playerName = "";
        this.frame = new JFrame("War");
        this.panel = new JPanel(null);
        this.hit = new JButton("Draw Card");
        this.restart = new JButton("Restart Game");
        this.exit = new JButton("Exit");
        this.game = new Game(playerName == null ? "" : playerName);
        this.frame.setLocationRelativeTo(null);
        this.frame.setUndecorated(true);
        this.frame.setResizable(false);
        this.frame.add(panel);

        this.panel.setSize(frame.getWidth(), frame.getHeight());
        this.panel.add(hit);
        this.panel.add(restart);
        this.panel.add(exit);
        buttons();
    }

    public void buttons() {
        this.hit.setSize(50, 50);
        this.hit.setLocation(frame.getWidth() / 2 - hit.getWidth(), frame.getHeight() - (hit.getHeight() + 5));
        this.hit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public GameFrame withPlayerName(String name) {
        this.playerName = name;
        return this;
    }

    public GameFrame withFrameSize(int width, int height) {
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);
        return this;
    }

    public GameFrame Build() {
        this.frame.setVisible(true);
        this.game.gameLoop();
        return this;
    }

    private int[] getPositionsAt(int row) {
        int[] x = new int[2];

        return x;
    }
}
