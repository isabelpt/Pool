public class Player {
    private String name;
    private boolean hasWon;
    private boolean ownsSolids;
    private int ballsWon;

    public Player(String name, boolean hasWon, boolean ownsSolids, int ballsWon) {
        this.name = name;
        this.hasWon = hasWon;
        this.ownsSolids = ownsSolids;
        this.ballsWon = ballsWon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean isOwnsSolids() {
        return ownsSolids;
    }

    public void setOwnsSolids(boolean ownsSolids) {
        this.ownsSolids = ownsSolids;
    }

    public int getBallsWon() {
        return ballsWon;
    }

    public void setBallsWon(int ballsWon) {
        this.ballsWon = ballsWon;
    }
}
