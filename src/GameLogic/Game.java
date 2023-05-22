package GameLogic;

import Cards.Card;
import Cards.Deck;
import Cards.Hand;
import Util.Util;

import java.util.Map;

public class Game implements Util {

    private Deck deck;
    private Hand playerHand, computerHand;
    private Player user, computer;
    private Player currentPlayer;
    private Map<Card, Player> tempArray;

    public Game(String name) {
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.computerHand = new Hand();
        this.user = new Player(name, playerHand, 0);
        this.computer = new Player("Computer", computerHand, 0);

        this.currentPlayer = user; // user goes first by default
    }

    public void gameLoop() {
        this.currentPlayer = user; // user goes first by default
        this.deck.assignValues();
        shuffleCards(deck);
        this.dealCards(user, deck);
        this.dealCards(computer, deck);
    }

    /**
     * We are using 26 because it is half of 52 (deck size)
     * Removes card from deck after it is assigned to player
     */
    private void dealCards(Player player, Deck deck) {
        for(int i = 0; i < 26; i++) {
            player.getHand().addCardToTop(deck.getCards().remove(deck.getCards().size() - 1));
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public Hand getComputerHand() {
        return computerHand;
    }

    public void setComputerHand(Hand computerHand) {
        this.computerHand = computerHand;
    }

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public Player getComputer() {
        return computer;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
