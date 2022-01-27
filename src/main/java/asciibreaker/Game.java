package asciibreaker;

import asciibreaker.gui.GUI;
import asciibreaker.gui.LanternaGUI;
import asciibreaker.model.StartMenu;
import asciibreaker.state.StartMenuState;
import asciibreaker.state.State;


import java.io.IOException;

public class Game {
    private final GUI GUI;
    private State state;
    private boolean running = true;

    public Game() throws IOException {
        GUI = new LanternaGUI();
        this.state = new StartMenuState(new StartMenu(this));
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }

    public void run() throws IOException {
        int fps = 60;
        int frameTime = 1000/fps;

        while (running) {
            long time = System.currentTimeMillis();

            state.step(this, GUI, time);
            System.out.println();
            long elapsedTime = System.currentTimeMillis() - time;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        GUI.close();
    }

    public void changeState(State state){
        this.state = state;
    }
    public State getState(){ return state;}

    public void end() {
        running = false;
    }
}
