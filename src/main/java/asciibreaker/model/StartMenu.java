package asciibreaker.model;

import asciibreaker.Game;
import asciibreaker.controller.command.ExitCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartMenu extends Menu{
    public StartMenu(Game game) throws IOException {
        super(game);
        List<String> play = new ArrayList<>();
        List<String> settings = new ArrayList<>();
        List<String> exit = new ArrayList<>();
        play.add("PLAY");
        settings.add("SETTINGS");
        exit.add("EXIT");

        buttons.add(new Button(play,  new Position(20, 20), new Position(60, 18), "#f9aa95","#0062d8"));
        buttons.add(new Button(settings, new Position(20,  16),  new Position(60, 14),"#f9aa95","#0062d8"));
        buttons.add(new Button(exit, new Position(20,  12),  new Position(60, 10),"#f9aa95","#0062d8"));
        buttons.get(0).setAction(new ExitCommand(game));
        buttons.get(1).setAction(new ExitCommand(game));
        buttons.get(2).setAction(new ExitCommand(game));
        buttons.get(0).setActive(true);

    }

}
