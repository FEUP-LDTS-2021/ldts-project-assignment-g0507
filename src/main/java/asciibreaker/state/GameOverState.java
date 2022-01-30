package asciibreaker.state;

import asciibreaker.controller.Controller;
import asciibreaker.controller.GameOverController;
import asciibreaker.model.GameOverMenu;
import asciibreaker.viewer.GameOverViewer;
import asciibreaker.viewer.Viewer;

import java.io.IOException;

public class GameOverState extends State<GameOverMenu>{
    public GameOverState(GameOverMenu model) throws IOException {
        super(model);
    }

    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverController(getModel());
    }

}
