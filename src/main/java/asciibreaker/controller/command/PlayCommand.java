package asciibreaker.controller.command;

import asciibreaker.Game;
import asciibreaker.model.PlayMenu;
import asciibreaker.state.PlayState;

import java.io.IOException;

public class PlayCommand extends ButtonCommand{
    public PlayCommand(Game game) {super(game); }

    @Override
    public void execute() throws IOException {
        game.changeState(new PlayState(new PlayMenu(game)));
    }
}
