package asciibreaker.controller;

import asciibreaker.Game;
import asciibreaker.controller.command.StartMenuCommand;
import asciibreaker.gui.Config;
import asciibreaker.gui.GUI;
import asciibreaker.model.PlayMenu;

import java.io.IOException;

public class PlayController extends Controller<PlayMenu> {

    public PlayController(PlayMenu menuModel) {
        super(menuModel);
    }
    @Override
    public void step(Game game, GUI.PressedKey action, long time) throws IOException {
        switch (action) {
            case ESCAPE:
                new StartMenuCommand(game).execute();
                break;
            case LEFT:
                if(getModel().getPaddle().getUpperLeft().getX() > 0)
                getModel().getPaddle().moveLeft();
                break;
            case RIGHT:
                if(getModel().getPaddle().getLowerRight().getX() < Config.TERMINAL_WIDTH)
                    getModel().getPaddle().moveRight();
                break;
            default:
                break;
        }
    }
}
