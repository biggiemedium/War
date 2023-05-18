package GameLogic;

import Cards.Hand;

public class Player {

    private String name;
    private Hand hand;
    private int points;

    public Player(String name, Hand hand, int points) {
        this.name = name;
        this.hand = hand;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
