package asciibreaker.controller;

import asciibreaker.Game;
import asciibreaker.gui.GUI;
import asciibreaker.model.GameOverMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GameOverControllerTest {
    GameOverController gameOverController;
    GameOverMenu gameOverMenu;
    GameOverMenu test;
    Game game;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
        gameOverMenu = new GameOverMenu(game);
        gameOverController = new GameOverController(gameOverMenu);
        test = gameOverController.getModel();
    }

    @AfterEach
    void close(){
        game.end();
    }

    @Test
    void testLeft() throws IOException {
        test.previousOption();
        gameOverController.step(game, GUI.PressedKey.LEFT, 0);
        Assertions.assertEquals(test, gameOverController.getModel());
    }

    @Test
    void testRight() throws IOException {
        test.nextOption();
        gameOverController.step(game, GUI.PressedKey.RIGHT, 0);
        Assertions.assertEquals(test, gameOverController.getModel());
    }

    @Test
    void testUp() throws IOException {
        test.previousOption();
        gameOverController.step(game, GUI.PressedKey.UP, 0);
        Assertions.assertEquals(test, gameOverController.getModel());
    }

    @Test
    void testDown() throws IOException {
        test.nextOption();
        gameOverController.step(game, GUI.PressedKey.DOWN, 0);
        Assertions.assertEquals(test, gameOverController.getModel());
    }

    @Test
    void testEnter() throws IOException{
        test.getSelectedButton().getAction().execute();
        gameOverController.step(game, GUI.PressedKey.ENTER,0);
        Assertions.assertEquals(test, gameOverController.getModel());
    }

    @Test
    void testEscape() throws IOException{
        test.getOptions().get(1).getAction().execute();
        gameOverController.step(game, GUI.PressedKey.ESCAPE,0);
        Assertions.assertEquals(test, gameOverController.getModel());
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(gameOverMenu, gameOverController.getModel());
    }
}
