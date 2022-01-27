package asciibreaker.state;

import asciibreaker.Game;
import asciibreaker.controller.PlayController;
import asciibreaker.model.PlayMenu;
import asciibreaker.viewer.PlayViewer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PlayStateTester {

    private PlayState test;
    private PlayMenu startMenu;
    private Game game;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
        startMenu = new PlayMenu(new Game());
        test = new PlayState(startMenu);
    }

    @AfterEach
    void cleanUp(){
        game.end();
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(startMenu,test.getModel());
    }
    @Test
    void testGetViewer(){
        Assertions.assertEquals(new PlayViewer(startMenu).getModel(), test.getViewer().getModel());
    }
    @Test
    void testGetController(){
        PlayController controller = new PlayController(startMenu);
        Assertions.assertEquals(controller.getModel(), test.getController().getModel());
    }
}
