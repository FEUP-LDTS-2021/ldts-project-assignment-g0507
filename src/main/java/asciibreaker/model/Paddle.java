package asciibreaker.model;

public class Paddle {
    public Position position;
    public Paddle(int x, int y) {
        position = new Position(x, y);
    }
    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
    public void setPosition(Position position) {
        this.position = position;
    }

}

