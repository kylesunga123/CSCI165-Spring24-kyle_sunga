import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

public class DriverTest {

    @Test
    void testFindLargest() {
        ArrayList<Shape> shapes = new ArrayList<>();
        Circle expectedLargestCircle = new Circle(1, Color.RED, new Point(0, 0),false); // Area = π * 1^2
        shapes.add(expectedLargestCircle);
        shapes.add(new Rectangle(1, 2, Color.BLUE, false, new Point(0, 0))); // Area = 1 * 2
        shapes.add(new Square(1.5, Color.GREEN, false, new Point(0, 0))); // Area = 1.5 * 1.5
        shapes.add(new Triangle(1,2, Color.RED,false, new Point(0,0) ));
        shapes.add(new SemiCircle(3.0, Color.ORANGE, new Point(3, 4), false));


        Shape largestShape = Driver.findLargest(shapes);
    
        // Check if the largestShape is an instance of Circle
        assertTrue(largestShape instanceof SemiCircle, "The largest shape should be a SemiCircle");
        
        // Check if the largestShape has the expected area
        assertEquals(Math.PI * Math.pow(3, 2) / 2, largestShape.getArea(), 0.001, "SemiCircle should have the largest area");
    }

    @Test
    void testTotalArea() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(new Circle(1, Color.CYAN, new Point(0, 0), false))); // Area = π * 1^2
        shapes.add(new Rectangle(1, 2, Color.BLUE, false, new Point(0, 0))); // Area = 1 * 2
        shapes.add(new Square(1, Color.GREEN, false, new Point(0, 0))); // Area = 1 * 1
        shapes.add(new Triangle(1,2, Color.RED,false, new Point(0,0) ));
        shapes.add(new SemiCircle(3.0, Color.ORANGE, new Point(3, 4), false));



        double expectedTotal =  Math.PI * 1 * 1 + 1 * 2 + 1 * 1 + 1  + (Math.PI * Math.pow(3, 2) / 2);
        double totalArea = Driver.totalArea(shapes);

        assertEquals(expectedTotal, totalArea, 0.001, "Total area should be the sum of all areas");
    }

    
}
