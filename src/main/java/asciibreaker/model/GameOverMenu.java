package asciibreaker.model;

import asciibreaker.Game;
import asciibreaker.controller.command.PlayCommand;
import asciibreaker.controller.command.StartMenuCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameOverMenu extends Menu{
    public GameOverMenu(Game game) throws IOException {
        super(game);
        List<String> retry = new ArrayList<>();
        List<String> menu = new ArrayList<>();
        retry.add("RETRY");
        menu.add("MAIN MENU");

        buttons.add(new Button(retry,  new Position(20, 20), new Position(60, 18), "#f9aa95","#0062d8"));
        buttons.add(new Button(menu, new Position(20,  16),  new Position(60, 14),"#f9aa95","#0062d8"));
        buttons.get(0).setAction(new PlayCommand(game));
        buttons.get(1).setAction(new StartMenuCommand(game));
        buttons.get(0).setActive(true);

    }
}
