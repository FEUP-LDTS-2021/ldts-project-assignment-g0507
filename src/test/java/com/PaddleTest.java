package com;

import com.Paddle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaddleTest {
    Paddle paddle;

    @BeforeEach
    public void setUp() {
        paddle = new Paddle(5,5);
    }

    @Test
    public void moveLeft() {
        Assertions.assertEquals(4, paddle.moveLeft().getX());
    }

    @Test
    public void moveRight() {
        Assertions.assertEquals(6, paddle.moveRight().getX());
    }
}
