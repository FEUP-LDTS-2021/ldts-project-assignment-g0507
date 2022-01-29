package asciibreaker.model;


import asciibreaker.Game;

import java.io.IOException;

public class PlayMenu extends Menu{
    Paddle paddle;

    public PlayMenu(Game game) throws IOException {
        super(game);
        paddle = new Paddle(new Position(30,4), new Position(50,4), "#886555");
    }

    public Paddle getPaddle() {
        return this.paddle;
    }
}
