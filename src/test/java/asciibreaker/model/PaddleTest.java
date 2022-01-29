package asciibreaker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaddleTest {
    Paddle paddle;

    @BeforeEach
    public void setUp() {
        paddle = new Paddle(new Position(5,5),new Position(10,3), "#0062d8");
    }
    @Test
    void testMoveRight() {
        paddle.moveRight();
        Assertions.assertEquals(new Position(10,5).getX(), paddle.getUpperLeft().getX());
        Assertions.assertEquals(new Position(15,3).getX(), paddle.getLowerRight().getX());
    }

    @Test
    void testMoveLeft() {
        paddle.moveLeft();
        Assertions.assertEquals(new Position(0,5).getX(), paddle.getUpperLeft().getX());
        Assertions.assertEquals(new Position(5,3).getX(), paddle.getLowerRight().getX());
    }

    @Test
    void testGetPaddleColor() {
        Assertions.assertEquals("#0062d8", paddle.getPaddleColor());
    }

    @Test
    void testGetLives() {
        Assertions.assertEquals(3, paddle.getLives());
    }

}