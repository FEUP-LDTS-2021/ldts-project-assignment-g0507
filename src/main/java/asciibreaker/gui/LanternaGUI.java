package asciibreaker.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI {
    private final Screen screen;

    public LanternaGUI() throws IOException {
        Terminal terminal = createTerminal();
        screen = createScreen(terminal);
    }

    public Screen getScreen(){
        return screen;
    }

    private Terminal createTerminal() throws IOException {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(80,40));
        return defaultTerminalFactory.createTerminal();
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public void refresh() throws IOException {
        screen.refresh();
        screen.clear();
    }

    public void close() throws IOException {
        screen.close();
    }
}
