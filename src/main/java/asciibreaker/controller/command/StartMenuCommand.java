package asciibreaker.controller.command;

import asciibreaker.Game;
import asciibreaker.model.StartMenu;
import asciibreaker.state.StartMenuState;

import java.io.IOException;

public class StartMenuCommand extends ButtonCommand{
    public StartMenuCommand(Game game) {super(game);};

    @Override
    public void execute() throws IOException {
        game.changeState(new StartMenuState(new StartMenu(game)));
    }
}
