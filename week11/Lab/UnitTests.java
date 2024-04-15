
/*Kyle Sunga
 * April 13, 2024
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UnitTests {
    private Point point1;
    private Point point2;

    @Before
    public void setUp() {
        // Initialization of Point objects
        point1 = new Point(3, 4);
        point2 = new Point(0, 0);
    }

    @Test
    public void testDefaultConstructor() {
        Point point = new Point();
        assertEquals("Default constructor X coordinate", 0, point.getX());
        assertEquals("Default constructor Y coordinate", 0, point.getY());
    }

    @Test
    public void testOverloadedConstructor() {
        assertEquals("X coordinate", 3, point1.getX());
        assertEquals("Y coordinate", 4, point1.getY());
    }

    @Test
    public void testCopyConstructor() {
        Point copyOfPoint1 = new Point(point1);
        assertEquals("Copy constructor X coordinate", point1.getX(), copyOfPoint1.getX());
        assertEquals("Copy constructor Y coordinate", point1.getY(), copyOfPoint1.getY());
    }

    @Test
    public void testSetAndGetXY() {
        point1.setXY(5, 6);
        assertArrayEquals("Set and get XY", new int[] { 5, 6 }, point1.getXY());
    }

    @Test
    public void testDistance() {
        double expectedDistance = 5.0; 
        assertEquals("Distance calculation", expectedDistance, point1.distance(), 0.01);
    }

    @Test
    public void testDistanceToAnotherPoint() {
        assertEquals("Distance to another point", 5.0, point1.distance(point2), 0.01);
    }

    @Test
    public void testToString() {
        assertEquals("String representation", "(3,4)", point1.toString());
    }

    @Test
    public void testEquals() {
        Point point3 = new Point(3, 4);
        assertTrue("Equal points", point1.equals(point3));
        assertFalse("Not equal points", point1.equals(point2));
    }

    @Test
    public void testHashCode() {
        Point point3 = new Point(3, 4);
        assertEquals("Hash code", point1.hashCode(), point3.hashCode());
    }
}
