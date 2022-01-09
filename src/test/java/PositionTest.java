import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.text.Position;

public class PositionTest {

    @BeforeAll
    Position position = new Position(5,5);

    @Test
    public void getX(){
        Assertions.assertEquals(5, position.getX());
    }

    @Test
    public void getY(){
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
