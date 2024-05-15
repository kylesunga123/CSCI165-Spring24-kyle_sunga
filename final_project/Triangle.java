import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Line2D;

public class Triangle extends Shape implements Resizable {
    protected double height = 1;
    protected double base = 1;

    public Triangle() {
        super();
    }

    /**
     * Constructor that creates a triangle with the specified base and height.
     *
     * @param height The height of the triangle, must be positive.
     * @param base   The base of the triangle, must be positive.
     */
    public Triangle(double height, double base) {
        setHeight(height);
        setBase(base);
    }

    /**
     * Constructor that creates a triangle with specified base, height, color, fill
     * state, and location.
     *
     * @param base     The base of the triangle, must be positive.
     * @param height   The height of the triangle, must be positive.
     * @param color    The color of the triangle.
     * @param filled   The fill state of the triangle.
     * @param location The location of the triangle in 2D space.
     */
    public Triangle(double base, double height, Color color, boolean filled, Point location) {
        super(color, filled, location);
        setBase(base);
        setHeight(height);
    }

    // Getters and setters
    /**
     * Gets the base of the triangle.
     *
     * @return The base of the triangle.
     */
    public double getBase() {
        return this.base;
    }

    /**
     * Sets the base of the triangle. The base must be positive.
     *
     * @param base The base of the triangle to set.
     * @throws IllegalArgumentException if the base is not positive.
     */
    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        } else {
            throw new IllegalArgumentException("Base must be positive");
        }
    }

    /**
     * Gets the height of the triangle.
     *
     * @return The height of the triangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Sets the height of the triangle. The height must be positive.
     *
     * @param height The height of the triangle to set.
     * @throws IllegalArgumentException if the height is not positive.
     */
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be positive");
        }
    }

    /**
     * Calculates and returns the area of the triangle using the formula 0.5 * base
     * * height.
     *
     * @return The area of the triangle.
     */
    @Override
    public double getArea() {
        // Area of a triangle is 0.5 * base * height
        return 0.5 * this.base * this.height;
    }

    /**
     * Calculates and returns the perimeter of the triangle, which includes the
     * base,
     * height, and the hypotenuse.
     *
     * @return The perimeter of the triangle.
     */
    @Override
    public double getPerimeter() {
        double hypotenuse = Math.sqrt(base * base + height * height);
        return this.base + this.height + hypotenuse;
    }

    /**
     * Provides a string representation of the triangle's properties.
     *
     * @return A string describing the triangle.
     */
    @Override
    public String toString() {
        return "Triangle[base=" + base + ", height=" + height + ", color=" + getColor() + ", filled=" + isFilled()
                + ", location=" + getLocation() + "]";
    }

    /**
     * Compares this triangle to another object for equality based on base, height,
     * color, fill, and location.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;
        return Double.compare(base, other.base) == 0 &&
                Double.compare(height, other.height) == 0 &&
                color.equals(other.color) &&
                filled == other.filled &&
                location.equals(other.location);
    }

    /**
     * Resizes the triangle by a certain percentage.
     *
     * @param percent The percentage by which to resize the triangle.
     */
    @Override
    public void resize(int percent) {
        this.height += this.height * percent / 100.0;
        this.base += this.base * percent / 100.0;

    }

    /**
     * Draws the triangle on a graphics context.
     *
     * @param g2d The Graphics2D context to draw the triangle on.
     */
    @Override
    public void drawObject(Graphics2D g2d) {
        // Calculate the vertices of the triangle based on base and height
        int x1 = getLocation().getX();
        int y1 = getLocation().getY();
        int x2 = x1 + (int) base; // Extends to the right
        int y2 = y1; // Same vertical position as the location (flat along the x-axis)
        int x3 = x1; // Same horizontal position as the location (vertical rise from the base line)
        int y3 = y1 - (int) height; // Extends upwards

        int[] xPoints = { x1, x2, x3 };
        int[] yPoints = { y1, y2, y3 };
        int nPoints = 3; // A triangle has 3 points

        g2d.setColor(getColor());
        if (isFilled()) {
            g2d.fill(new Polygon(xPoints, yPoints, nPoints));
        } else {
            g2d.draw(new Polygon(xPoints, yPoints, nPoints));
        }
    }
/**
 * Computes the minimum distance from the given point (camera position) to the triangle.
 * used AI for this fucntion partially. 
 * @param cameraPosition The position of the camera as a Point object.
 * @return The minimum distance from the camera position to the triangle.
 
 */
    @Override
    public double computeDistance(Point cameraPosition) {
        // Calculate the vertices of the triangle based on base and height
        int x1 = getLocation().getX();
        int y1 = getLocation().getY();
        int x2 = x1 + (int) base; // Base runs horizontally
        int y2 = y1;
        int x3 = x1; // Assuming this is a right triangle, x3 aligns vertically above x1
        int y3 = y1 - (int) height; // Vertically above y1

        // Camera position
        double x0 = cameraPosition.getX();
        double y0 = cameraPosition.getY();

        // Calculate distance from the camera position to each side of the triangle
        double distSide1 = Line2D.ptSegDist(x1, y1, x2, y2, x0, y0); // Base
        double distSide2 = Line2D.ptSegDist(x2, y2, x3, y3, x0, y0); // Hypotenuse
        double distSide3 = Line2D.ptSegDist(x3, y3, x1, y1, x0, y0); // Height

        // Return the minimum distance
        return Math.min(Math.min(distSide1, distSide2), distSide3);
    }

}
