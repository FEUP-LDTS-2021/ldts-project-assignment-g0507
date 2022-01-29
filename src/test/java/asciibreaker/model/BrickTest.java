package asciibreaker.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrickTest {
    public Brick brick;

    @BeforeEach
    void setUp(){
        brick = new Brick(new Position(0,40), new Position(2,40), "#b9efa3");
    }

    @Test
    void testGetUpperLeft() {
        Assertions.assertEquals(0, brick.getUpperLeft().getX());
        Assertions.assertEquals(40, brick.getUpperLeft().getY());

    }

    @Test
    void testGetLowerRight() {
        Assertions.assertEquals(2, brick.getLowerRight().getX());
        Assertions.assertEquals(40, brick.getLowerRight().getY());    }

    @Test
    void testBrickColor() {
        Assertions.assertEquals("#b9efa3", brick.getBrickColor());
    }

    @Test
    void testGetHP() {
        Assertions.assertEquals(1, brick.getHP());
    }
}
