package asciibreaker.model;


import asciibreaker.Game;

import java.io.IOException;
import java.util.List;

public class PlayMenu extends Menu{
    Paddle paddle;
    BrickGenerator brickGenerator;


    public PlayMenu(Game game) throws IOException {
        super(game);
        paddle = new Paddle(new Position(30,4), new Position(50,4), "#886555");
        brickGenerator = new BrickGenerator();
    }

    public Paddle getPaddle() {
        return this.paddle;
    }

    public List<Brick> getBricks() {
        return this.brickGenerator.bricks;
    }

    public BrickGenerator getBrickGenerator() {
        return this.brickGenerator;
    }
}
