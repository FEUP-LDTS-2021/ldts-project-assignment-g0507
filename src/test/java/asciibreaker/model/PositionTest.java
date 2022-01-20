package asciibreaker.model;

import asciibreaker.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    Position position;

    @BeforeEach
    public void setUp() {
        position = new Position(5,5);
    }

    @Test
    public void getX(){
        Assertions.assertEquals(5, position.getX());
    }

    @Test
    public void getY(){
        int x = position.getX();
        Assertions.assertEquals(5, position.getX());
    }

    @Test
    public void setY(){
        position.setY(3);
        Assertions.assertEquals(3, position.getY());
    }

    @Test
    public void setX(){
        position.setX(3);
        Assertions.assertEquals(3, position.getX());
    }
}
