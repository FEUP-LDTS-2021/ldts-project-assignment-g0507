package asciibreaker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrickGeneratorTest {
    BrickGenerator brickGenerator = new BrickGenerator();

    @BeforeEach
    void setUp(){
        brickGenerator.bricks.add(new Brick(new Position(0,40), new Position(2, 40), "#b9efa3"));
        brickGenerator.bricks.add(new Brick(new Position(2,40), new Position(4, 40), "#008693"));
        brickGenerator.bricks.add(new Brick(new Position(4,40), new Position(6, 40), "#1b7340"));
    }

    @Test
    public void testGeneration(){
        Assertions.assertEquals(0, brickGenerator.bricks.get(0).getUpperLeft().getX());
        Assertions.assertEquals(2, brickGenerator.bricks.get(0).getLowerRight().getX());
        Assertions.assertEquals("#b9efa3", brickGenerator.bricks.get(0).getBrickColor());

        Assertions.assertEquals(2, brickGenerator.bricks.get(1).getUpperLeft().getX());
        Assertions.assertEquals(4, brickGenerator.bricks.get(1).getLowerRight().getX());
        Assertions.assertEquals("#008693", brickGenerator.bricks.get(1).getBrickColor());

        Assertions.assertEquals(4, brickGenerator.bricks.get(2).getUpperLeft().getX());
        Assertions.assertEquals(6, brickGenerator.bricks.get(2).getLowerRight().getX());
        Assertions.assertEquals("#1b7340", brickGenerator.bricks.get(2).getBrickColor());

    }
}
