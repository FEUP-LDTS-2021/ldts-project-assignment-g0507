package asciibreaker.controller.command;

import asciibreaker.Game;

public class ExitCommand extends ButtonCommand{
    public ExitCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.end();
    }
}
