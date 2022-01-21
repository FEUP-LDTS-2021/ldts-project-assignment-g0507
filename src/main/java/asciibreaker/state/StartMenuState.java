package asciibreaker.state;

import asciibreaker.controller.Controller;
import asciibreaker.controller.StartMenuController;
import asciibreaker.model.StartMenu;
import asciibreaker.viewer.StartMenuViewer;
import asciibreaker.viewer.Viewer;

import java.io.IOException;

public class StartMenuState extends State<StartMenu>{

    public StartMenuState(StartMenu model) throws IOException {
        super(model);
    }

    @Override
    protected Viewer<StartMenu> getViewer() {
        return new StartMenuViewer(getModel());
    }

    @Override
    protected Controller<StartMenu> getController() {
        return new StartMenuController(getModel());
    }

}
