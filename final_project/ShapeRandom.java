import java.awt.Color;
import java.util.Random;

/**
 * Utility class for creating random geometric shapes. This class includes methods to generate random circles,
 * rectangles, and triangles with varying dimensions, colors, and positions.
 */
public class ShapeRandom {
    private static Random rand = new Random(); // Shared Random instance for generating all random values.

    /**
     * Creates a random circle with a random radius, color, and position.
     * The circle is always filled.
     *
     * @return a randomly generated Circle object.
     */
    public static Circle createRandomCircle() {
        double radius = 10 + rand.nextDouble() * 100; // Generate random radius between 10 and 110.
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Random color.
        Point location = new Point(rand.nextInt(640), rand.nextInt(640)); // Random location within a 640x640 area.
        return new Circle(radius, color, location, true); // Create and return a filled circle.
    }

    /**
     * Creates a random rectangle with random width, height, color, and position.
     * The rectangle is always filled.
     *
     * @return a randomly generated Rectangle object.
     */
    public static Rectangle createRandomRectangle() {
        double width = 10 + rand.nextDouble() * 100; // Generate random width between 10 and 110.
        double height = 10 + rand.nextDouble() * 100; // Generate random height between 10 and 110.
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Random color.
        Point location = new Point(rand.nextInt(640), rand.nextInt(640)); // Random location within a 640x640 area.
        return new Rectangle(width, height, color, true, location); // Create and return a filled rectangle.
    }

    /**
     * Creates a random triangle with random base, height, color, and position.
     * The triangle is always filled.
     *
     * @return a randomly generated Triangle object.
     */
    public static Triangle createRandomTriangle() {
        double base = 10 + rand.nextDouble() * 100; // Generate random base between 10 and 110.
        double height = 10 + rand.nextDouble() * 100; // Generate random height between 10 and 110.
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Random color.
        Point location = new Point(rand.nextInt(640), rand.nextInt(640)); // Random location within a 640x640 area.
        return new Triangle(base, height, color, true, location); // Create and return a filled triangle.
    }
}
