package asciibreaker.viewer;

import asciibreaker.gui.GUI;
import asciibreaker.model.PlayMenu;

import java.io.IOException;

public class PlayViewer extends Viewer<PlayMenu> {

    public PlayViewer(PlayMenu menu) { super(menu);}

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenuBackground();
    }
}
