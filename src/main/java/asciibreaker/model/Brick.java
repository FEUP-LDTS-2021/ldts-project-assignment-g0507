package asciibreaker.model;

public class Brick {
    private int hp;
    private Position upperLeft;
    private Position lowerRight;
    private String brickColor;

    public Brick(Position upperLeft, Position lowerRight, String brickColor) {
        this.hp = 1;
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.brickColor = brickColor;
    }

    public Position getUpperLeft() {
        return upperLeft;
    }

    public Position getLowerRight() {
        return lowerRight;
    }

    public String getBrickColor() { return this.brickColor; }

    public int getHP() {
        return this.hp;
    }
}
