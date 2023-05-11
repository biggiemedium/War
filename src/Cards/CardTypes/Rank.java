package Cards.CardTypes;

public enum Rank {
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");

    String name;

    Rank(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
