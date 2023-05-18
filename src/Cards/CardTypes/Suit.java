package Cards.CardTypes;

public enum Suit {

    DIAMOND("Diamond"),
    SPADES("Spade"),
    CLUBS("Club"),
    HEARTS("Heart");

    String name;

     Suit(String name) {
        this.name = name;
    }

    String getName() {
         return this.name;
    }
}
