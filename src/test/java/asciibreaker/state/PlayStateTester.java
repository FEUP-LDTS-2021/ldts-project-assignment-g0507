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
    private PlayMenu playMenu;
    private Game game;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
        playMenu = new PlayMenu(new Game());
        test = new PlayState(playMenu);
    }

    @AfterEach
    void cleanUp(){
        game.end();
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(playMenu,test.getModel());
    }

    @Test
    void testGetViewer(){
        Assertions.assertEquals(new PlayViewer(playMenu).getModel(), test.getViewer().getModel());
    }
    @Test
    void testGetController(){
        PlayController controller = new PlayController(playMenu);
        Assertions.assertEquals(controller.getModel(), test.getController().getModel());
    }
}
