package asciibreaker.controller;

import asciibreaker.Game;
import asciibreaker.controller.command.GameOverCommand;
import asciibreaker.controller.command.StartMenuCommand;
import asciibreaker.gui.Config;
import asciibreaker.gui.GUI;
import asciibreaker.model.Brick;
import asciibreaker.model.PlayMenu;
import asciibreaker.model.Position;
import asciibreaker.model.StartMenu;

import java.io.IOException;

public class PlayController extends Controller<PlayMenu> {

    public PlayController(PlayMenu menuModel) {
        super(menuModel);
        getModel().getBrickGenerator().generateLvl1();
    }

    @Override
    public void step(Game game, GUI.PressedKey action, long time) throws IOException {
        switch (action) {
            case ESCAPE:
                new StartMenuCommand(game).execute();
                break;
            case LEFT:
                if (getModel().getPaddle().getUpperLeft().getX() > 0)
                    getModel().getPaddle().moveLeft();
                break;
            case RIGHT:
                if (getModel().getPaddle().getLowerRight().getX() < Config.TERMINAL_WIDTH)
                    getModel().getPaddle().moveRight();
                break;
            default:
                break;
        }

        if(getModel().getPaddle().getLives() == 0) {
            new GameOverCommand(game).execute();
        }
        if(getModel().getBricks().size() == 0) {
            new StartMenuCommand(game).execute();
        }

        checkCollisions();
        checkBricks();
        getModel().getBall().update();
    }

    private void checkBricks() {
        for (int i = 0; i < getModel().getBricks().size(); i++) {
            if (getModel().getBricks().get(i).getHP() == 0) {
                getModel().getBricks().remove(i);
            }
        }
    }

    public void checkCollisions() {
        //checks brick collision
        for (Brick brick : getModel().getBricks()) {
            if (!(getModel().getBall().getUpperLeft().getX() > brick.getLowerRight().getX() ||
                    getModel().getBall().getLowerRight().getX() < brick.getUpperLeft().getX() ||
                    getModel().getBall().getUpperLeft().getY() < brick.getLowerRight().getY() ||
                    getModel().getBall().getLowerRight().getY() > brick.getUpperLeft().getY())) {
                getModel().getBall().setYVelocity(getModel().getBall().getYVelocity() * -1);
                brick.setHP(brick.getHP() - 1);
            }
        }
        //checks screen collision
        if (getModel().getBall().getLowerRight().getX() > Config.TERMINAL_WIDTH || getModel().getBall().getUpperLeft().getX() <= 0) {
            getModel().getBall().setXVelocity(getModel().getBall().getXVelocity() * -1);
        }
        if (getModel().getBall().getUpperLeft().getY() > Config.TERMINAL_HEIGHT) {
            getModel().getBall().setYVelocity(getModel().getBall().getYVelocity() * -1);
        }
        if (getModel().getBall().getLowerRight().getY() <= 1) {
            getModel().getPaddle().setLives(getModel().getPaddle().getLives() - 1);
            int newX = getModel().getPaddle().getUpperLeft().getX() + ((getModel().getPaddle().getLowerRight().getX() - getModel().getPaddle().getUpperLeft().getX()) / 2);
            int newY = getModel().getPaddle().getUpperLeft().getY() + 1;
            getModel().getBall().setUpperLeft(new Position(newX, newY));
            getModel().getBall().setLowerRight(new Position(newX + 1, newY));
        }

        //checks paddle collision
        if (!(getModel().getBall().getUpperLeft().getX() > getModel().getPaddle().getLowerRight().getX() ||
                getModel().getBall().getLowerRight().getX() < getModel().getPaddle().getUpperLeft().getX() ||
                getModel().getBall().getUpperLeft().getY() < getModel().getPaddle().getLowerRight().getY() ||
                getModel().getBall().getLowerRight().getY() > getModel().getPaddle().getUpperLeft().getY())) {
            getModel().getBall().setYVelocity(getModel().getBall().getYVelocity() * -1);
        }
    }
}
