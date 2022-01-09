import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Paddle {

    public Position position;

    public Paddle(int x, int y ){
        position = new Position(x,y);
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "XXXXXXXXXX");
    }
}
