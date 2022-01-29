package asciibreaker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball ball;
    private Position upperLeft;
    private Position lowerRight;
    private int xVelocity;
    private int yVelocity;

    @BeforeEach
    void setUp() {
        upperLeft = new Position(10,10);
        lowerRight = new Position(20,20);
        ball = new Ball(upperLeft, lowerRight);
    }

    @Test
    void testGetUpperLeft() {
        Assertions.assertEquals(upperLeft.getX(), ball.getUpperLeft().getX());
        Assertions.assertEquals(upperLeft.getY(), ball.getUpperLeft().getY());
    }

    @Test
    void testGetLowerRight() {
        Assertions.assertEquals(lowerRight.getX(), ball.getLowerRight().getX());
        Assertions.assertEquals(lowerRight.getY(), ball.getLowerRight().getY());

    }

    @Test
    void testSetUpperLeft() {
        ball.setUpperLeft(new Position(30,30));
        Assertions.assertEquals(30, ball.getUpperLeft().getX());
        Assertions.assertEquals(30, ball.getUpperLeft().getY());
    }

    @Test
    void testSetLowerRight() {
        ball.setLowerRight(new Position(30,30));
        Assertions.assertEquals(30, ball.getLowerRight().getX());
        Assertions.assertEquals(30, ball.getLowerRight().getY());
    }

    @Test
    void testGetBallColor() {
        Assertions.assertEquals("#89fe05", ball.getBallColor());
    }

    @Test
    void testGetXVelocity() {
        Assertions.assertEquals(1, ball.getXVelocity());
    }

    @Test
    void testGetYVelocity() {
        Assertions.assertEquals(1, ball.getYVelocity());
    }

    @Test
    void testUpdate() {
        ball.update();
        Assertions.assertEquals(11, ball.getUpperLeft().getX());
        Assertions.assertEquals(11, ball.getUpperLeft().getY());
        Assertions.assertEquals(21, ball.getLowerRight().getX());
        Assertions.assertEquals(21, ball.getLowerRight().getY());
    }
}
