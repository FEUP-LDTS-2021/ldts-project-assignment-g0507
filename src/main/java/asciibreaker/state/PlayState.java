package asciibreaker.state;


import asciibreaker.controller.Controller;
import asciibreaker.controller.PlayController;
import asciibreaker.model.PlayMenu;
import asciibreaker.viewer.PlayViewer;
import asciibreaker.viewer.Viewer;

import java.io.IOException;

public class PlayState extends State<PlayMenu>{

    public PlayState(PlayMenu model) throws IOException {
        super(model);
    }

    @Override
    protected Viewer<PlayMenu> getViewer() {
        return new PlayViewer(getModel());
    }

    @Override
    protected Controller<PlayMenu> getController() {
        return new PlayController(getModel());
    }
}
