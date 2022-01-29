package asciibreaker.model;

public class Paddle {
    private Position upperLeft;
    private Position lowerRight;
    private String paddleColor;
    private int lives;


    public Paddle(Position upperLeft, Position lowerRight, String paddleColor) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.paddleColor = paddleColor;
        this.lives= 3;
    }

    public void moveRight() {
        upperLeft.setX(upperLeft.getX() + 5);
        lowerRight.setX(lowerRight.getX() + 5);
    }

    public void moveLeft() {
        upperLeft.setX(upperLeft.getX() - 5);
        lowerRight.setX(lowerRight.getX() - 5);
    }

    public Position getUpperLeft() {
        return upperLeft;
    }

    public Position getLowerRight() {
        return lowerRight;
    }

    public void setLives(int lives) { this.lives = lives; }

    public int getLives() { return lives; }

    public String getPaddleColor() { return this.paddleColor;
    }
}

