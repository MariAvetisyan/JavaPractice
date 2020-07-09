import exeptions.InvalidPositionException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


/**
 * Created by mari.avetisyan on 09/07/2020.
 */
public class PositionTest {
    private Position position1 = new Position("h4");
    private Position position2 = new Position("H4");
    private Position position3 = new Position("e5");
    private Position position4 = new Position("C8");
    private Position position5 = new Position("h4");
    private Position position6 = new Position("d1");
    private Position position7 = new Position("c5");

    @Test
    public void getPositionX() {
        assertEquals('c', position4.getPositionX());
        assertEquals('d', position6.getPositionX());
    }

    @Test
    public void getPositionXNumericValue() {
        assertEquals(2, position4.getPositionXNumericValue());
        assertEquals(3, position6.getPositionXNumericValue());
    }

    @Test
    public void getPositionY() {
        assertEquals(8, position4.getPositionY());
        assertEquals(1, position6.getPositionY());
    }

    @Test
    public void isPositionValid() {
        assertThrows(InvalidPositionException.class, () -> {
            Position.isPositionValid("p5");
        });
        assertThrows(InvalidPositionException.class, () -> {
            Position.isPositionValid("g0");
        });
        assertThrows(InvalidPositionException.class, () -> {
            Position.isPositionValid("e9");
        });
        assertThrows(InvalidPositionException.class, () -> {
            Position.isPositionValid("C71");
        });
    }

    @Test
    public void isPositionsEqual() {
        assertEquals(true, position1.isPositionsEqual(position2));
        assertEquals(true, position1.isPositionsEqual(position5));
        assertEquals(false, position3.isPositionsEqual(position7));
    }
}
