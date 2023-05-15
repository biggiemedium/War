package GameLogic;

import Cards.Card;
import Cards.Deck;
import Cards.Hand;

import java.util.Map;

public class Game {

    private Deck deck;
    private Hand playerHand, computerHand;
    private Player user, computer;
    private Player currentPlayer;

    public Game(String name) {
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.computerHand = new Hand();
        this.user = new Player(name, playerHand, 0);
        this.computer = new Player("Computer", computerHand, 0);

        this.currentPlayer = user; // user goes first by default
    }

}
