package Cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    /**
     * Adds card to bottom of deck by putting it at value 0
     */
    public void addCardToBottom(Card card) {
        this.hand.add(0, card);
    }

    /**
     * This will automatically add cards to the top of our deck
     * The Highest number in the array represents top of deck and 0 is bottom
     */
    public void addCardToTop(Card card) {
        this.hand.add(card);
    }

}
