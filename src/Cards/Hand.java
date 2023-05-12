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

}
