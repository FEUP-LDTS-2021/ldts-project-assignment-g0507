package asciibreaker.model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {
    Paddle paddle;
    @BeforeEach
    public void setUp() {
        paddle = new Paddle(5,5);
    }
}