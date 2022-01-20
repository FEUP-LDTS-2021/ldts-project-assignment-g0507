package asciibreaker.gui;

import asciibreaker.model.Button;
import asciibreaker.model.Position;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LanternaGUITest {

    private LanternaGUI lanternaGUI;

    @BeforeEach
    void setUp() throws IOException {
        lanternaGUI = new LanternaGUI();
    }

    @Test
    void TestDrawButton() {
        Button button = new Button("test",
                new Position(10,10),
                new Position(20,20),
                "#0FFFFF",
                "#FFFFFF");

        lanternaGUI.drawButton(button);
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(10, 10).getCharacterString());
    }
}
