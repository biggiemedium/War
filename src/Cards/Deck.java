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

    public void assignValues() {
        for(Suit s : Suit.values()) {
            for(Rank r : Rank.values()) {
                Card c = new Card(s, r);
                this.cards.add(c);
            }
        }
    }

    public void reset() {
        this.cards.clear();
        this.pulledCards.clear();
        assignValues(); // refilling deck after clear
    }

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
