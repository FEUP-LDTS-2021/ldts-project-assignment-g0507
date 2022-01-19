package state;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStateTest {
    private GameState gameState;
    private Game game;
    private List<Button> buttons;

    @BeforeEach
    void setUp() {
        this.game = Mockito.mock(Game.class);
        this.gameState = Mockito.mock(GameState.class);
        this.buttons = Arrays.asList(new Button(null, null, Arrays.asList("Color")));
        Mockito.when(gameState.getGame()).thenReturn(game);
        Mockito.when(gameState.getButtons()).thenReturn(buttons);
    }

    @Test
    void testGetGame() {
        Game test = gameState.getGame();
        Assertions.assertEquals(test, game);
    }

    @Test
    void testGetButtons() {
        List<Button> test = gameState.getButtons();
        Assertions.assertEquals(test.size(), 1);
        Assertions.assertEquals(test, buttons);
    }
}
