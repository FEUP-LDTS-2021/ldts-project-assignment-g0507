package asciibreaker.controller.command;

import asciibreaker.Game;
import asciibreaker.model.GameOverMenu;
import asciibreaker.state.GameOverState;

import java.io.IOException;

public class GameOverCommand extends ButtonCommand {
    public GameOverCommand(Game game) {super(game); }

    @Override
    public void execute() throws IOException {
        game.changeState(new GameOverState(new GameOverMenu(game)));
    }
}
