package Util;

import Cards.Deck;
import Cards.Hand;
import GameLogic.Player;

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

    default boolean isDeckEmpty(Player player) {
        return player.getHand().getHand().isEmpty();
    }
}
