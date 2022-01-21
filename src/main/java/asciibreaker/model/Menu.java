package asciibreaker.model;

import asciibreaker.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Button> buttons;
    protected int selected;
    protected final Game game;

    public Menu(Game game) throws IOException {
        this.game = game;
        buttons = new ArrayList<>();
        selected = 0;
    }

    public void addOption(Button newButton){
        buttons.add(newButton);
    }

    public List<Button> getOptions(){
        return this.buttons;
    }

    public int getNumberButtons(){
        return this.buttons.size();
    }

    public int getSelected() {
        return selected % buttons.size();
    }

    public Button getSelectedButton() {
        return this.buttons.get(getSelected());
    }

    public void nextOption() {
        getSelectedButton().setActive(false);
        selected++;
        getSelectedButton().setActive(true);
    }

    public void previousOption(){
        getSelectedButton().setActive(false);
        selected--;
        if(selected < 0)
            selected = buttons.size() - 1;
        getSelectedButton().setActive(true);
    }
}
