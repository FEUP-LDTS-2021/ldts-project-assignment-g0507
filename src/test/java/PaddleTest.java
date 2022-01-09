import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaddleTest {
    Position position;

    @BeforeEach
    public void setUp() {
        position = new Position(5,5);
    }

    @Test
    public void moveLeft() {
        position = position.moveLeft();
        Assertions.assertEquals(4, position.getX());
    }

    @Test
    public void moveRight() {
        position = position.moveRight();
        Assertions.assertEquals(6, position.getX());
    }
}
