import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Screen screen;

    public Game() throws IOException {

        try {
            DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
            Terminal terminal = defaultTerminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        screen.refresh();
    }


    public void run() throws IOException {
        boolean running = true;
        while (running) {
            KeyStroke key = screen.readInput();
            System.out.println(key.getKeyType());
            if((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || (key.getKeyType() == KeyType.EOF)) {
                running = false;
            }
            else {
                draw();
            }
        }
        screen.close();
    }
}
