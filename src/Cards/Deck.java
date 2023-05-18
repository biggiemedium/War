package Cards;

import Cards.CardTypes.Rank;
import Cards.CardTypes.Suit;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;
    private ArrayList<Card> pulledCards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.pulledCards = new ArrayList<>();
    }

    /**
     * Assigns 1 of all 52 card values to arraylist
     */
    public void assignValues() {
        for(Suit s : Suit.values()) {
            for(Rank r : Rank.values()) {
                this.cards.add(new Card(s, r));
            }
        }
    }

    /**
     * Resets all cards and any cards that were pulled
     * Reassigns all card values to card deck
     */
    public void reset() {
        this.cards.clear();
        this.pulledCards.clear();
        assignValues(); // refilling deck after clear
    }

    /**
     * Shuffles cards so that they are all random
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Color getCardColor(Card card) {
        switch (card.getType()) {
            case DIAMOND:
                return Color.RED;
            case CLUBS:
                return Color.BLACK;
            case HEARTS:
                return Color.RED;
            case SPADES:
                return Color.BLACK;
        }

        return null;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getPulledCards() {
        return pulledCards;
    }

    public void setPulledCards(ArrayList<Card> pulledCards) {
        this.pulledCards = pulledCards;
    }

    public static Deck INSTANCE = new Deck();
}
