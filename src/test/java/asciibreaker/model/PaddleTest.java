package asciibreaker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {
    Paddle paddle;
    @BeforeEach
    public void setUp() {
        paddle = new Paddle(5,5);
    }
    @Test
    void moveRight() {
        Assertions.assertEquals(6, paddle.moveRight().getX());
    }
}