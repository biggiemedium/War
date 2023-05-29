package Render.Game;

import GameLogic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private String playerName;
    private Game game;

    private JButton hit, restart, exit;

    private int[][] positions = {

    };

    public GameFrame(int width, int height) {
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
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(panel);

        this.panel.setSize(frame.getWidth(), frame.getHeight());
        this.panel.add(hit);
        this.panel.add(restart);
        this.panel.add(exit);
        buttons();
    }

    /**
     * Method used to handle all our JButtons
     * Sets dimensions, locations, and action listeners
     */
    public void buttons() {
        this.hit.setVisible(true);
        this.hit.setSelected(false);
        this.hit.setBounds(frame.getWidth() / 2 - 75, this.frame.getHeight() - 100, 150, 50);
        this.hit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    /**
     * Method used to render what player has the higher cards on pull
     */
    private void renderGame() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g = this.getGraphics();
        if(g == null) {
            return;
        }

        g.create();
        g.drawString(playerName == null ? "Player" : playerName, 2, 5);
        g.drawRect(5, this.frame.getHeight() / 2 - 5, frame.getWidth() - 10, 2);
        g.dispose();
    }

    public GameFrame withPlayerName(String name) {
        this.playerName = name;
        return this;
    }

<<<<<<< HEAD
=======
    public GameFrame withFrameSize(int width, int height) {
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);
        return this;
    }

>>>>>>> 86e49eaa14da93697fbb2db02ced6e43157fec16
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
