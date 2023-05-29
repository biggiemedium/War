package Cards;

import Cards.CardTypes.Rank;
import Cards.CardTypes.Suit;

public class Card {

    private Suit type;
    private Rank rank;

    public Card(Suit type, Rank rank) {
        this.type = type;
        this.rank = rank;
    }

    public String toString() {
        return this.type + " " + this.rank;
    }

    public Suit getType() {
        return type;
    }

    public void setType(Suit type) {
        this.type = type;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
