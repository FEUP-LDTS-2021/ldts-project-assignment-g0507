package asciibreaker.gui;

import asciibreaker.model.Button;
import asciibreaker.model.Position;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanternaGUITest {

    private LanternaGUI lanternaGUI;

    @BeforeEach
    void setUp() throws IOException {
        lanternaGUI = new LanternaGUI();
    }

    @Test
    void TestDrawButton() {
        List<String> text = new ArrayList<>();
        text.add("test");
        Button button = new Button(text,
                new Position(10,10),
                new Position(20,20),
                "#0FFFFF",
                "#FFFFFF");

        lanternaGUI.drawButton(button);
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(10, 10).getCharacterString());
    }
}
