package asciibreaker.gui;

import com.googlecode.lanterna.SGR;
import asciibreaker.model.Button;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI {
    private final Screen screen;
    private final TerminalSize terminalSize = new TerminalSize(80,40);

    public LanternaGUI() throws IOException {
        Terminal terminal = createTerminal();
        screen = createScreen(terminal);
    }

    public Screen getScreen(){
        return screen;
    }

    private Terminal createTerminal() throws IOException {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
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

    public void drawButton(Button button) {

        int yOffset=(button.getUpperLeft().getY()-button.getLowerRight().getY()-button.getButtonText().size())/2;
        int xOffset=(button.getLowerRight().getX()-button.getUpperLeft().getX()-button.getButtonText().get(0).length())/2;

        TextGraphics graphics = screen.newTextGraphics();

        graphics.setForegroundColor(TextColor.Factory.fromString(button.getTextColor()));

        for(int i = button.getUpperLeft().getX(); i <= button.getLowerRight().getX(); i++ )
            for(int j = terminalSize.getRows()-button.getUpperLeft().getY(); j <= terminalSize.getRows()-button.getLowerRight().getY(); j++)
                graphics.putString(new TerminalPosition(i, j), " ");

        for(int i=0;i<button.getButtonText().size();i++){
            if(button.getButtonText().get(i).equals(" ")){
                graphics.putString(  button.getUpperLeft().getX() + xOffset, terminalSize.getRows()-button.getUpperLeft().getY()+yOffset +i,button.getButtonText().get(i),SGR.BOLD);
            }
        }

    }
}
