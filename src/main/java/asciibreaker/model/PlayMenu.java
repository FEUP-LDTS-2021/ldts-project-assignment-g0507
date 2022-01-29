package asciibreaker.model;


import asciibreaker.Game;

import java.io.IOException;
import java.util.List;

public class PlayMenu extends Menu{
    Paddle paddle;
    Ball ball;
    BrickGenerator brickGenerator;


    public PlayMenu(Game game) throws IOException {
        super(game);
        paddle = new Paddle(new Position(30,4), new Position(50,4), "#886555");
        ball = new Ball(new Position(40, 5), new Position(41, 5));
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

    public Ball getBall() {
        return this.ball;
    }
}
