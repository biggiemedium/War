package Util;

import Cards.Deck;
import java.util.Collections;

public interface Util {

    default void print(String text) {
        System.out.println(text);
    }

    default boolean isDeckFull(Deck deck) {
        return deck.getCards().size() == (52 - 1);
    }

    default void shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

}
