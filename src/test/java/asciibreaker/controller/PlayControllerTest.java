package asciibreaker.controller;

import asciibreaker.Game;
import asciibreaker.gui.GUI;
import asciibreaker.model.StartMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PlayControllerTest {
    PlayController playController;
    PlayMenu playMenu;
    PlayMenu test;
    Game game;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
        playMenu = new PlayMenu(game);
        playController = new PlayController(playMenu);
        test = playController.getModel();
    }

    @AfterEach
    void close(){
        game.end();
    }

    @Test
    void testLeft() throws IOException {
        test.previousOption();
        playController.step(game, GUI.PressedKey.LEFT, 0);
        Assertions.assertEquals(test, playController.getModel());
    }

    @Test
    void testRight() throws IOException {
        test.nextOption();
        playController.step(game, GUI.PressedKey.RIGHT, 0);
        Assertions.assertEquals(test, playController.getModel());
    }


    @Test
    void testEscape() throws IOException{
        test.getOptions().get(1).getAction().execute();
        playController.step(game, GUI.PressedKey.ESCAPE, 0);
        Assertions.assertEquals(test, playController.getModel());
    }

    @Test
    void testGetModel() throws IOException{
        Assertions.assertEquals(playMenu,playController.getModel());
    }
}
