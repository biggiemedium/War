package Render.Game;

import Cards.Card;
import GameLogic.Game;
import GameLogic.Player;
import Util.DebugFrame;
import Util.Dimension;
import Util.RenderUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameFrame extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private String playerName; // current player name. Value is assigned in the MainMenu class
    private Game game; // game class used to organize game

    private JButton hit, restart, exit;
    private JLabel winningMessage; // displays who won the round
    private JLabel playerCardDisplay; // displays what the next card pulled is going to be for the player
    private JLabel playerDisplay, computerDisplay; // Displays what cards are drawn on button press

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
        this.game = new Game(playerName == null ? "" : playerName).handleDeck(); // if playerName is null make name nothing
        this.playerDisplay = new JLabel("");
        this.computerDisplay = new JLabel("");
        this.playerCardDisplay = new JLabel("");
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

        // JLabels
        this.panel.add(playerCardDisplay);
        this.panel.add(playerDisplay);
        this.panel.add(computerDisplay);

        this.panel.add(exit);
        buttons();

        new DebugFrame(this.game);
    }

    /**
     * Method used to handle all our JButtons
     * Sets dimensions, locations, and action listeners
     */
    public void buttons() {
        this.winningMessage.setVisible(true);
        this.winningMessage.setBounds(frame.getWidth() / 2 - 25, 25, 150, 50);
        this.winningMessage.setSize(100, 100);

        this.playerCardDisplay.setBounds(5, frame.getHeight() / 2 + 180, 250, 100);
        this.playerCardDisplay.setBackground(this.frame.getBackground());
        updateCardDisplay();

        RenderUtil.setupComponent(playerDisplay, new Dimension<Integer>(frame.getWidth() / 2 - 220, frame.getHeight() / 2 - 100, 250, 100));
        RenderUtil.setupComponent(computerDisplay, new Dimension<Integer>(frame.getWidth() / 2 + 50, frame.getHeight() / 2 - 100, 250, 100));

        this.hit.setVisible(true);
        this.hit.setSelected(false);
        this.hit.setBounds(frame.getWidth() / 2 - 75, this.frame.getHeight() - 100, 150, 50);
        this.hit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card computer = game.getComputerHand().getCardAtTop();
                Card player = game.getPlayerHand().getCardAtTop();
                Player winner = null;
                if(player.getRank().getValue() > computer.getRank().getValue()) {

                    playerDisplay.setText("Player: " + player);
                    computerDisplay.setText("Computer: " + computer);

                    winner = game.getUser();
                    game.getTempArray().put(computer, game.getUser());
                    game.getTempArray().put(player, game.getUser());

                    game.getUser().getHand().getHand().remove(player);
                    game.getComputer().getHand().getHand().remove(computer);

                    winningMessage.setText(winner.getName() + " Wins!");
                    game.giveWinnerPrize(game.getUser());
                    debug();
                } else if(player.getRank().getValue() == computer.getRank().getValue()) {
                    ArrayList<Card> playerWins = new ArrayList<>();
                    ArrayList<Card> computerWins = new ArrayList<>();
                    playerDisplay.setText("Player: " + player);
                    computerDisplay.setText("Computer: " + computer);
                    //game.shuffleCards(game.getDeck()); // so it stops looping at a tie
                    //TODO: if cards values are equal. Remove from top of deck and add to random position in deck

                    if(!game.getTempArray().isEmpty()) {
                        game.getTempArray().forEach((card, user) -> {
                            if(user == game.getUser()) {
                                playerWins.add(card);
                            }
                            if(user == game.getComputer()) {
                                computerWins.add(card);
                            }
                        });
                    }

                    // THIS IS NULL IDK WHY
                    //for(int i = 0; i < 3; i++) {
                    //    game.getPrizeArray().add(playerWins.get(i));
                    //    game.getPrizeArray().add(computerWins.get(i));
                    //}
                    winningMessage.setText("War!");
                    debug();
                } else if(player.getRank().getValue() < computer.getRank().getValue()) {
                    winner = game.getComputer();
                    playerDisplay.setText("Player: " + player);
                    computerDisplay.setText("Computer: " + computer);

                    game.getTempArray().put(computer, game.getComputer());
                    game.getTempArray().put(player, game.getComputer());

                    game.getUser().getHand().getHand().remove(player);
                    game.getComputer().getHand().getHand().remove(computer);

                    winningMessage.setText(winner.getName() + " Wins!");
                    game.giveWinnerPrize(game.getComputer());
                    debug();
                }
                updateCardDisplay();
            }
        });
    }

    private void updateCardDisplay() {
        this.playerCardDisplay.setText("Next Card: \n" + this.game.getPlayerHand().getHand().get(this.game.getPlayerHand().getHand().size() - 1));
    }

    private void debug() {
        System.out.println("User Hand:");
        game.getPlayerHand().getHand().forEach(p -> {
            System.out.print(p.getType() + " " + p.getRank() + ", \n");
        });
        System.out.println("");
        System.out.println("Computer Hand:");
        game.getComputerHand().getHand().forEach(p -> {
            System.out.print(p.getType() + " " + p.getRank() + ", \n");
        });
        System.out.println("");
        System.out.println("TempArray:");
        game.getTempArray().forEach((p, user) -> {
            System.out.print(user.getName() + ": \n" + p.getType() + " " + p.getRank() + ", ");
        });
        System.out.println("\nNEW GAME: \n\n");
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
