package asciibreaker.controller;

import asciibreaker.Game;
import asciibreaker.gui.GUI;
import asciibreaker.model.StartMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StartMenuControllerTest {
    StartMenuController menuController;
    StartMenu startMenu;
    StartMenu test;
    Game game;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
        startMenu = new StartMenu(game);
        menuController = new StartMenuController(startMenu);
        test = menuController.getModel();
    }

    @AfterEach
    void close(){
        game.end();
    }

    @Test
    void testLeft() throws IOException {
        test.previousOption();
        menuController.step(game, GUI.PressedKey.LEFT, 0);
        Assertions.assertEquals(test, menuController.getModel());
    }

    @Test
    void testRight() throws IOException {
        test.nextOption();
        menuController.step(game, GUI.PressedKey.RIGHT, 0);
        Assertions.assertEquals(test, menuController.getModel());
    }

    @Test
    void testUp() throws IOException {
        test.previousOption();
        menuController.step(game, GUI.PressedKey.UP, 0);
        Assertions.assertEquals(test, menuController.getModel());
    }

    @Test
    void testDown() throws IOException {
        test.nextOption();
        menuController.step(game, GUI.PressedKey.DOWN, 0);
        Assertions.assertEquals(test, menuController.getModel());
    }

    @Test
    void testEnter() throws IOException{
        test.getSelectedButton().getAction().execute();
        menuController.step(game, GUI.PressedKey.ENTER,0);
        Assertions.assertEquals(test,menuController.getModel());
    }

    @Test
    void testEscape() throws IOException{
        test.getOptions().get(2).getAction().execute();
        menuController.step(game, GUI.PressedKey.ESCAPE,0);
        Assertions.assertEquals(test,menuController.getModel());
    }

    @Test
    void testGetModel() throws IOException{
        Assertions.assertEquals(startMenu,menuController.getModel());
    }
}
