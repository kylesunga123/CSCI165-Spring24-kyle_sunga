
/*Kyle Sunga
 * April 27th, 2024 
 * CSCI 165 
 */
import java.awt.Color;

public class Rectangle extends Shape implements Resizable { // cannot be private because square extends rectangle

    protected double height = 1;
    protected double width = 1;

    public Rectangle() {
    }

    /**
     * Constructor that creates a rectangle with the specified height and width.
     *
     * @param height The height of the rectangle, must be positive.
     * @param width  The width of the rectangle, must be positive.
     */
    public Rectangle(double height, double width) {
        // this.height = height;
        // this.width = width;
        setHeight(height);
        setWidth(width);
    }

    /**
     * Constructor that creates a rectangle with the specified height, width, color,
     * fill state, and location.
     *
     * @param height   The height of the rectangle, must be positive.
     * @param width    The width of the rectangle, must be positive.
     * @param color    The color of the rectangle.
     * @param filled   The fill state of the rectangle.
     * @param location The location of the rectangle in 2D space.
     */
    public Rectangle(double height, double width, Color color, boolean filled, Point location) {
        super(color, filled, location);
        // this.height = height;
        // this.width = width;
        setHeight(height);
        setWidth(width);

    }

    // Copy constructor
    /**
     * Copy constructor that creates a new rectangle based on another rectangle's
     * properties.
     *
     * @param other The rectangle to copy properties from.
     */
    public Rectangle(Rectangle other) {
        super(other.color, other.filled, other.location);
        // this.height = other.height;
        // this.width = other.width;
        setHeight(height);
        setWidth(width);
    }

    // getter and setter methods
    /**
     * Gets the height of the rectangle.
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the height of the rectangle. The height must be positive.
     *
     * @param height The height of the rectangle to set.
     * @throws IllegalArgumentException if the height is not positive.
     */
    public void setHeight(double height) {
        // this.height = height;
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("height must be positive");

        }
    }

    /**
     * Sets the width of the rectangle. The width must be positive.
     *
     * @param width The width of the rectangle to set.
     * @throws IllegalArgumentException if the width is not positive.
     */
    public void setWidth(double width) {
        // this.width = width;
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("width must be positive");

        }
    }

    // math portion
    /**
     * Calculates and returns the area of the rectangle.
     *
     * @return The area of the rectangle.
     */
    @Override
    public double getArea() {
        return height * width;
    }

    /**
     * Calculates and returns the perimeter of the rectangle.
     *
     * @return The perimeter of the rectangle.
     */
    public double getPerimeter() {
        return 2 * (height + width);
    }

    /**
     * Provides a string representation of the rectangle's properties.
     *
     * @return A string describing the rectangle.
     */
    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + "]";
    }

    /**
     * Compares this rectangle to another object for equality.
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
        Rectangle other = (Rectangle) obj;
        return Double.compare(other.width, width) == 0 && Double.compare(other.height, height) == 0;
    }

    /**
     * Resizes the rectangle by a percentage. This changes both the height and
     * width.
     *
     * @param percent The percentage by which to resize the rectangle.
     */
    @Override
    public void resize(int percent) {
        height *= percent / 100.0;
        width *= percent / 100.0;
    }
}
