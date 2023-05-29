package Util;

import Cards.Card;

import java.util.function.Predicate;

public class CardCompare implements Predicate<Card> {

    public Card card;

    public CardCompare(Card card) {
        this.card = card;
    }

    @Override
    public boolean test(Card card) {
        return card.getRank().getValue() > this.card.getRank().getValue();
    }
}
