package Render.Game;

import Cards.Card;
import GameLogic.Game;
import GameLogic.Player;
import Render.MainMenu;
import Util.DebugFrame;
import Util.Dimension;
import Util.RenderUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class GameFrame extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private String playerName; // current player name. Value is assigned in the MainMenu class
    private Game game; // game class used to organize game

    private JButton hit, restart, exit;
    private JLabel winningMessage; // displays who won the round
    private JLabel playerCardDisplay; // displays what the next card pulled is going to be for the player
    private JLabel deckCount;
    private JLabel playerDisplay, computerDisplay; // Displays what cards are drawn on button press

    private JLabel cardDisplay;
    private int[][] positions = {

    };

    public GameFrame(int width, int height) {
        this.playerName = "Player";
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
        this.deckCount = new JLabel("");
        this.cardDisplay = new JLabel("");
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
        this.panel.add(cardDisplay);
        this.panel.add(deckCount);
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
        this.winningMessage.setSize(150, 100);

        this.playerCardDisplay.setBounds(5, frame.getHeight() / 2 + 180, 250, 100);
        this.playerCardDisplay.setBackground(this.frame.getBackground());
        updateCardDisplay();

        RenderUtil.setupComponent(playerDisplay, new Dimension<Integer>(frame.getWidth() / 2 - 220, frame.getHeight() / 2 - 120, 250, 100));
        RenderUtil.setupComponent(computerDisplay, new Dimension<Integer>(frame.getWidth() / 2 + 70, frame.getHeight() / 2 - 120, 250, 100));
        RenderUtil.setupComponent(cardDisplay, new Dimension<>(frame.getWidth() / 2 - 5, frame.getHeight() / 2 - 80, 50, 50));

        RenderUtil.setupComponent(exit, new Dimension<>(frame.getWidth() - 120, this.frame.getHeight() - 30, 120, 30));
        RenderUtil.handleColouring(exit, new Color(255, 255, 255));
        RenderUtil.setupComponent(restart, new Dimension<Integer>(frame.getWidth() - 120, this.frame.getHeight() - 60, 120, 30));
        RenderUtil.handleColouring(restart, new Color(255, 255, 255));

        RenderUtil.setupComponent(deckCount, new Dimension<>(playerCardDisplay.getX(), playerCardDisplay.getY() + 37, 200, 50));

        this.hit.setVisible(true);
        this.hit.setSelected(false);
        this.hit.setBounds(frame.getWidth() / 2 - 75, this.frame.getHeight() - 100, 150, 50);
        RenderUtil.handleColouring(hit, new Color(255, 255, 255));
        this.hit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card computer = game.getComputerHand().getCardAtTop();
                Card player = game.getPlayerHand().getCardAtTop();
                // if our temp array fills up we need to return the cards back to the player hands
                if(game.getComputerHand().getHand().size() == 1 || game.getPlayerHand().getHand().size() == 1) {
                    System.out.println("Hand is empty... Filling...");
                    ArrayList<Card> remainingComputerCards = new ArrayList<>();
                    ArrayList<Card> remainingPlayercards = new ArrayList<>();
                    game.getTempArray().forEach((card, user) -> {
                        if(user == game.getUser()) {
                            remainingPlayercards.add(card);
                            Collections.shuffle(remainingPlayercards);
                        } else {
                            remainingComputerCards.add(card);
                            Collections.shuffle(remainingComputerCards);
                        }

                        game.getUser().getHand().getHand().addAll(remainingPlayercards);
                        game.getComputer().getHand().getHand().addAll(remainingComputerCards);
                        remainingPlayercards.clear();
                        remainingComputerCards.clear();
                    });
                }
                winnerCheck(); // checks if any player has won. Will end the game

                if(player.getRank().getValue() > computer.getRank().getValue()) {
                    // update visualization
                    cardDisplay.setText(" > ");
                    playerDisplay.setText("Player: " + player);
                    computerDisplay.setText("Computer: " + computer);

                    /**
                     * Puts card in hashmap after player has won the round
                     * @see Game.tempArray
                     */
                    game.getTempArray().put(computer, game.getUser());
                    game.getTempArray().put(player, game.getUser());

                    /**
                     * Removes card at top of deck after it is added to our hashMap
                     * @see Game.tempArray
                     */
                    game.getUser().getHand().getHand().remove(player);
                    game.getComputer().getHand().getHand().remove(computer);

                    game.getUser().increasePoints();

                    winningMessage.setText(playerName + " Wins!");
                    debug(); // paste what is currently happening in the system
                    /**
                     *  seems to be some kind of bug in the code because we call this method before our win check.
                     *  To resolve this we will be running this in every if statement
                     */
                    winnerCheck();
                } else if(player.getRank().getValue() == computer.getRank().getValue()) {
                    // update visualization
                    playerDisplay.setText("Player: " + player);
                    computerDisplay.setText("Computer: " + computer);
                    cardDisplay.setText(" = ");

                    /**
                     * Puts card in hashmap after player has won the round
                     * @see Game.tempArray
                     */
                    game.getTempArray().put(computer, game.getComputer());
                    game.getTempArray().put(player, game.getUser());
                    /**
                     * Removes card at top of deck after it is added to our hashMap
                     * @see Game.tempArray
                     */
                    game.getUser().getHand().getHand().remove(player);
                    game.getComputer().getHand().getHand().remove(computer);

                    winningMessage.setText("War!");
                    debug();// paste what is currently happening in the system
                    /**
                     *  seems to be some kind of bug in the code because we call this method before our win check.
                     *  To resolve this we will be running this in every if statement
                     */
                    winnerCheck();
                } else if(player.getRank().getValue() < computer.getRank().getValue()) {
                    // update visualization
                    cardDisplay.setText(" < ");
                    playerDisplay.setText("Player: " + player);
                    computerDisplay.setText("Computer: " + computer);

                    /**
                     * Puts card in hashmap after player has won the round
                     * @see Game.tempArray
                     */
                    game.getTempArray().put(computer, game.getComputer());
                    game.getTempArray().put(player, game.getComputer());
                    /**
                     * Removes card at top of deck after it is added to our hashMap
                     * @see Game.tempArray
                     */
                    game.getUser().getHand().getHand().remove(player);
                    game.getComputer().getHand().getHand().remove(computer);

                    game.getComputer().increasePoints();

                    winningMessage.setText("Computer" + " Wins!");
                    debug(); // paste what is currently happening in the system
                    /**
                     *  seems to be some kind of bug in the code because we call this method before our win check.
                     *  To resolve this we will be running this in every if statement
                     */
                    winnerCheck();
                }
                updateCardDisplay(); // updates current card display
            }
        });

        this.restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });

        this.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                System.out.println("Shutting down...");
                return;
            }
        });
    }

    private void winnerCheck() {
        if(this.game.getPlayerHand().getHand().size() >= 51) {
            winningMessage.setText(playerName + " Wins!");
            this.playerDisplay.setVisible(false);
            this.computerDisplay.setVisible(false);
            this.hit.setVisible(false);
            this.cardDisplay.setVisible(false);
            this.deckCount.setVisible(false);

            RenderUtil.setDimensions(exit, new Dimension<>(frame.getWidth() / 2 - 75, frame.getHeight() / 2, 150, 120));
            RenderUtil.setDimensions(restart, new Dimension<>(frame.getWidth() / 2 - 75, frame.getHeight() / 2 - 120, 150, 120));
        }

        if(this.game.getComputerHand().getHand().size() >= 51) {
            winningMessage.setText("Computer" + " Wins!");
            this.playerDisplay.setVisible(false);
            this.computerDisplay.setVisible(false);
            this.hit.setVisible(false);
            this.cardDisplay.setVisible(false);
            this.deckCount.setVisible(false);

            RenderUtil.setDimensions(exit, new Dimension<>(frame.getWidth() / 2 - 75, frame.getHeight() / 2, 150, 120));
            RenderUtil.setDimensions(restart, new Dimension<>(frame.getWidth() / 2 - 75, frame.getHeight() / 2 - 120, 150, 120));
        }
    }

    private void updateCardDisplay() {
        this.playerCardDisplay.setText("Next Card: \n" + this.game.getPlayerHand().getHand().get(this.game.getPlayerHand().getHand().size() - 1));
        this.deckCount.setText("Cards remaining: " + game.getUser().getHand().getHand().size() + " " + (game.getUser().getHand().getHand().size() == 1 ? "Refilling..." : " "));
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
            System.out.print(user.getName() + ": " + p.getType() + " " + p.getRank() + ", \n");
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
