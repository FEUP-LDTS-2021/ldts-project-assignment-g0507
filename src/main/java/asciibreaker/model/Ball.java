package asciibreaker.model;

public class Ball {
    private Position upperLeft;
    private Position lowerRight;
    private String ballColor;
    private int xVelocity;
    private int yVelocity;

    public Ball(Position upperLeft, Position lowerRight) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.ballColor = "#89fe05";
        this.xVelocity = 1;
        this.yVelocity = 1;
    }

    public Position getUpperLeft() {
        return upperLeft;
    }

    public Position getLowerRight() {
        return lowerRight;
    }

    public void setUpperLeft(Position upperLeft) {
        this.upperLeft = upperLeft;
    }

    public void setLowerRight(Position lowerRight) {
        this.lowerRight = lowerRight;
    }

    public String getBallColor() { return this.ballColor; }

    public int getXVelocity() { return this.xVelocity; }

    public int getYVelocity() { return this.yVelocity; }

    public void setXVelocity(int xVelocity) { this.xVelocity = xVelocity; }

    public void setYVelocity(int yVelocity) { this.yVelocity = yVelocity; }


    public void update() {
        upperLeft.setX(upperLeft.getX() + xVelocity);
        upperLeft.setY(upperLeft.getY() + yVelocity);
        lowerRight.setX(lowerRight.getX() + xVelocity);
        lowerRight.setY(lowerRight.getY() + yVelocity);
    }
}
