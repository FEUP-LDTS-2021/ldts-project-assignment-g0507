package asciibreaker.gui;

import asciibreaker.model.Button;
import asciibreaker.model.Paddle;

import java.io.IOException;

public interface GUI {
    enum PressedKey {UP,DOWN,RIGHT,LEFT,OTHER,ESCAPE, ENTER};
    PressedKey getKeyInput() throws IOException;
    void refresh() throws IOException;
    void close() throws IOException;

    void drawButton(Button button);
    void drawMenuBackground();
    public void drawPaddle(Paddle paddle);
}

