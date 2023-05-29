package Render.Game;

import Cards.Card;
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
    private JLabel winningMessage;

    private int[][] positions = {

    };

    public GameFrame(int width, int height) {
        this.playerName = "";
        this.frame = new JFrame("War");
        this.panel = new JPanel(null);
        this.hit = new JButton("Draw Card");
        this.restart = new JButton("Restart Game");
        this.winningMessage = new JLabel("Start battle...");
        this.exit = new JButton("Exit");
        this.game = new Game(playerName == null ? "" : playerName).handleDeck();
        this.frame.setLocationRelativeTo(null);
        this.frame.setUndecorated(true);
        this.frame.setResizable(false);
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(panel);

        this.panel.setSize(frame.getWidth(), frame.getHeight());
        this.panel.add(hit);
        this.panel.add(winningMessage);
        this.panel.add(restart);
        this.panel.add(exit);
        buttons();
    }

    /**
     * Method used to handle all our JButtons
     * Sets dimensions, locations, and action listeners
     */
    public void buttons() {
        this.winningMessage.setVisible(true);
        this.winningMessage.setBounds(frame.getWidth() / 2 - 25, 25, 150, 50);
        this.winningMessage.setSize(100, 100);

        this.hit.setVisible(true);
        this.hit.setSelected(false);
        this.hit.setBounds(frame.getWidth() / 2 - 75, this.frame.getHeight() - 100, 150, 50);
        this.hit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card computer = game.getComputerHand().getCardAtTop();
                Card player = game.getPlayerHand().getCardAtTop();
                if(player.getRank().getValue() > computer.getRank().getValue()) {
                    winningMessage.setText(game.getUser().getName() + " Wins!");
                    
                }
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
        g.drawRect(25, 25, 25, 2);
        g.dispose();
    }

    public GameFrame withPlayerName(String name) {
        this.playerName = name;
        return this;
    }

    public GameFrame Build() {
        this.frame.setVisible(true);
        return this;
    }

    private int[] getPositionsAt(int row) {
        int[] x = new int[2];

        return x;
    }
}
