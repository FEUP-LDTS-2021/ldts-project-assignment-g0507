package asciibreaker.viewer;


import asciibreaker.gui.GUI;
import asciibreaker.model.StartMenu;

import java.io.IOException;

public class StartMenuViewer extends Viewer<StartMenu> {

    public StartMenuViewer(StartMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenuBackground();
        for (int i = 0; i < getModel().getNumberButtons(); i++) {
            gui.drawButton(getModel().getOptions().get(i));
        }
    }
}
