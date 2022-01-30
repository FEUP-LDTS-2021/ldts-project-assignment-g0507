package asciibreaker.gui;

import asciibreaker.model.*;
import asciibreaker.model.Button;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI() throws IOException {
        Terminal terminal = createTerminal();
        screen = createScreen(terminal);
    }

    public Screen getScreen() {
        return screen;
    }

    private Terminal createTerminal() throws IOException {
        Font font = new Font(Config.LANTERNA_FONT, Font.PLAIN, Config.LANTERNA_FONT_SIZE);
        SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
        Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(Config.TERMINAL_WIDTH, Config.TERMINAL_HEIGHT)).createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public PressedKey getKeyInput() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        while (screen.pollInput() != null) ;
        if (keyStroke == null) return PressedKey.OTHER;
        if (keyStroke.getKeyType() == KeyType.Escape) return PressedKey.ESCAPE;
        else if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'w' || keyStroke.getCharacter() == 'W'))
            return PressedKey.UP;
        else if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'd' || keyStroke.getCharacter() == 'D'))
            return PressedKey.RIGHT;
        else if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 's' || keyStroke.getCharacter() == 'S'))
            return PressedKey.DOWN;
        else if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'a' || keyStroke.getCharacter() == 'A'))
            return PressedKey.LEFT;
        else if (keyStroke.getKeyType() == KeyType.Enter) return PressedKey.ENTER;
        else return PressedKey.OTHER;
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }

    public void drawButton(Button button) {
        TextGraphics graphics = screen.newTextGraphics();
        if (button.isActive()) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#142930"));
        } else {
            graphics.setBackgroundColor(TextColor.Factory.fromString(button.getButtonColor()));

        }
        graphics.setForegroundColor(TextColor.Factory.fromString(button.getTextColor()));
        drawRectangle(graphics, button.getUpperLeft(), button.getLowerRight());
        int yOffset = (button.getUpperLeft().getY() - button.getLowerRight().getY() - button.getButtonText().size()) / 2;
        int xOffset = (button.getLowerRight().getX() - button.getUpperLeft().getX() - button.getButtonText().get(0).length()) / 2;

        for (int i = 0; i < button.getButtonText().size(); i++) {
            if (button.getButtonText().get(i) != " ") {
                graphics.putString(button.getUpperLeft().getX() + xOffset, Config.TERMINAL_HEIGHT - button.getUpperLeft().getY() + yOffset + i, button.getButtonText().get(i), SGR.BOLD);
            }
        }
    }

    private void drawRectangle(TextGraphics graphics, Position upperLeft, Position lowerRight) {
        for (int i = upperLeft.getX(); i <= lowerRight.getX(); i++)
            for (int j = Config.TERMINAL_HEIGHT - upperLeft.getY(); j <= Config.TERMINAL_HEIGHT - lowerRight.getY(); j++)
                graphics.putString(new TerminalPosition(i, j), " ");
    }

    public void fillBackground(String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(Config.TERMINAL_WIDTH, Config.TERMINAL_HEIGHT), ' ');
    }

    public void drawMenuBackground() {
        fillBackground("#446699");
    }

    public void drawPaddle(Paddle paddle) {
        TextGraphics graphics = screen.newTextGraphics();
        TextGraphics HP = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(paddle.getPaddleColor()));
        HP.setBackgroundColor(TextColor.Factory.fromString("#446699"));
        HP.setForegroundColor(TextColor.Factory.fromString("#000000"));
        drawRectangle(graphics, paddle.getUpperLeft(), paddle.getLowerRight());
        String string = paddle.getLives() + " Lives left";
        HP.putString(1,Config.TERMINAL_HEIGHT - 1, string, SGR.BOLD);

    }

    public void drawBrick(Brick brick) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(brick.getBrickColor()));
        drawRectangle(graphics, brick.getUpperLeft(), brick.getLowerRight());
    }

    public void drawBall(Ball ball) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(ball.getBallColor()));
        drawRectangle(graphics, ball.getUpperLeft(), ball.getLowerRight());
    }
}
