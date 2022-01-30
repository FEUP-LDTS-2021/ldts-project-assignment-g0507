package asciibreaker.controller;

import asciibreaker.Game;
import asciibreaker.gui.GUI;
import asciibreaker.model.GameOverMenu;

import java.io.IOException;

public class GameOverController extends Controller<GameOverMenu> {
    public GameOverController(GameOverMenu menuModel) {
        super(menuModel);
    }

    @Override
    public void step(Game game, GUI.PressedKey action, long time) throws IOException {
        switch (action) {
            case LEFT, UP:
                getModel().previousOption();
                break;
            case RIGHT, DOWN:
                getModel().nextOption();
                break;
            case ENTER:
                getModel().getSelectedButton().getAction().execute();
                break;
            case ESCAPE:
                getModel().getOptions().get(1).getAction().execute();
                break;
            default:
                break;
        }
    }
}
