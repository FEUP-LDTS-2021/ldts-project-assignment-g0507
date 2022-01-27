package asciibreaker.controller;

import asciibreaker.Game;
import asciibreaker.gui.GUI;
import asciibreaker.model.PlayMenu;
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
    void testGetModel() throws IOException{
        Assertions.assertEquals(playMenu,playController.getModel());
    }
}
