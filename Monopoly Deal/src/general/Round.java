package general;

public class Round {
    public static int turnround;

    public int getRound() {
        return turnround;
    }

    public void setRound(int round) {
        this.turnround = turnround;
    }

    public int roundbegin() {
        return turnround = 1;
    }
}