package asciibreaker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class ButtonTest {

    private Button button;
    private List<String> buttonText;
    private Position upperLeft;
    private Position lowerRight;
    private String buttonColor;
    private String textColor;

    @BeforeEach
    void setUp(){
        buttonText = new ArrayList<>();
        buttonText.add("Test");
        upperLeft = new Position(10,10);
        lowerRight = new Position(20,20);
        buttonColor = "#0FFFFF";
        textColor = "#FFFFFF";
        button = new Button(buttonText, upperLeft, lowerRight, buttonColor, textColor);
    }

    @Test
    void testGetButtonText() {
        Assertions.assertEquals(buttonText, button.getButtonText());
    }

    @Test
    void testGetUpperLeft() {
        Assertions.assertEquals(upperLeft, button.getUpperLeft());
    }

    @Test
    void testGetLowerRight() {
        Assertions.assertEquals(lowerRight, button.getLowerRight());
    }

    @Test
    void testGetButtonColor() {
        Assertions.assertEquals(buttonColor, button.getButtonColor());
    }

    @Test
    void testGetTextColor() {
        Assertions.assertEquals(textColor, button.getTextColor());
    }

    @Test
    void testIsActive() {
        Assertions.assertFalse(button.isActive());
    }

    @Test
    void testSetActive() {
        Assertions.assertFalse(button.isActive());
        button.setActive(true);
        Assertions.assertTrue(button.isActive());
        button.setActive(false);
        Assertions.assertFalse(button.isActive());
    }

}
