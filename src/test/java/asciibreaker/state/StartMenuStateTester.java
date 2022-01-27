package asciibreaker.state;

import asciibreaker.Game;
import asciibreaker.controller.StartMenuController;
import asciibreaker.model.StartMenu;
import asciibreaker.viewer.StartMenuViewer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StartMenuStateTester {

        private StartMenuState test;
        private StartMenu startMenu;
        private Game game;

        @BeforeEach
        void setUp() throws IOException {
            game = new Game();
            startMenu = new StartMenu(new Game());
            test = new StartMenuState(startMenu);
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
            Assertions.assertEquals(new StartMenuViewer(startMenu).getModel(), test.getViewer().getModel());
        }
        @Test
        void testGetController(){
            StartMenuController controller = new StartMenuController(startMenu);
            Assertions.assertEquals(controller.getModel(), test.getController().getModel());
        }
}
