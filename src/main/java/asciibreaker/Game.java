package asciibreaker;

import asciibreaker.gui.LanternaGUI;
import asciibreaker.model.Paddle;
import asciibreaker.model.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Game {
    private final LanternaGUI GUI;
    private boolean running = true;
    protected Paddle paddle;

    public Game() throws IOException {
        GUI = new LanternaGUI();
        paddle = new Paddle(35,35);
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }

    private void draw() throws IOException {
        paddle.draw(GUI.getScreen().newTextGraphics());
        GUI.refresh();
    }

    public void run() throws IOException {
        draw();
        while (running) {
            KeyStroke key = GUI.getScreen().readInput();
            if(key.getCharacter() != null) {
                System.out.println(key.getKeyType() + " " + key.getCharacter());
                if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || (key.getKeyType() == KeyType.EOF))
                    running = false;
                if (key.getCharacter() == 'a') movePaddle(paddle.moveLeft());
                if (key.getCharacter() == 'd') movePaddle(paddle.moveRight());
            }
            draw();
        }
        GUI.close();
    }

    private void movePaddle(Position position) {
        paddle.setPosition(position);
    }
}
