package asciibreaker.viewer;

import asciibreaker.gui.GUI;
import asciibreaker.model.GameOverMenu;

public class GameOverViewer extends Viewer<GameOverMenu>{

    public GameOverViewer(GameOverMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawMenuBackground();
        for (int i = 0; i < getModel().getNumberButtons(); i++) {
            gui.drawButton(getModel().getOptions().get(i));
        }
    }

}
