package Cards.CardTypes;

public enum Rank {
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);

    String name;
    int value;

    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    String getName() {
        return this.name;
    }

    public int getValue() {
        return value;
    }
}
