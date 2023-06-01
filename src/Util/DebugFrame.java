package Util;

import Cards.Card;
import GameLogic.Game;

import javax.swing.*;
import java.util.ArrayList;

public class DebugFrame {

    JFrame frame = new JFrame("Debugger");
    JPanel panel = new JPanel(null);
    JTextField playerCards = new JTextField();
    JTextField computerCards = new JTextField();

    JLabel currentPlayer = new JLabel("");
    JLabel currentComputer = new JLabel("");
    Game game;

    public DebugFrame(Game game) {
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.add(panel);
        this.frame.setVisible(true);

        this.game = game;

        this.panel.add(playerCards);
        this.panel.add(computerCards);
        this.panel.add(currentComputer);
        this.panel.add(currentPlayer);
        buttons();
    }

    public void buttons() {
        RenderUtil.setupComponent(playerCards, new Dimension<Integer>(5, frame.getHeight() / 2 - 100, 150, 250));
        RenderUtil.setupComponent(computerCards, new Dimension<Integer>(frame.getWidth() - 200, frame.getHeight() / 2 - 100, 150, 250));
        RenderUtil.setupComponent(currentPlayer, new Dimension<Integer>(5, 25, 150, 50));
        RenderUtil.setupComponent(currentComputer, new Dimension<Integer>(frame.getWidth() - 200, 25, 150, 50));

        this.currentPlayer.setText("Player Card: " + game.getUser().getHand().getCardAtTop());
        this.currentComputer.setText("Computer Card: " + game.getComputer().getHand().getCardAtTop());
    }

    public void update() {
        this.currentPlayer.setText("Player Card: " + game.getUser().getHand().getCardAtTop());
        this.currentComputer.setText("Computer Card: " + game.getComputer().getHand().getCardAtTop());
    }

}
