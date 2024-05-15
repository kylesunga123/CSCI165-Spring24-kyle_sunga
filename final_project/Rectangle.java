
/*Kyle Sunga
 * April 27th, 2024 
 * CSCI 165 
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

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
        return this.height;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return this.width;
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
        return this.height * this.width;
    }

    /**
     * Calculates and returns the perimeter of the rectangle.
     *
     * @return The perimeter of the rectangle.
     */
    public double getPerimeter() {
        return 2 * (this.height + this.width);
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
        this.height += this.height * percent / 100.0;
        this.width += this.height * percent / 100.0;
    }
/**
     * Draws the rectangle on a Graphics2D drawing context. The rectangle can be either filled or outlined
     * based on its filled state.
     *
     * @param g2d The Graphics2D context where the rectangle is drawn.
     */
    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(getColor());
        if (isFilled()) {
            g2d.fill(new Rectangle2D.Double(getLocation().getX(), getLocation().getY(), width, height));
        } else {
            g2d.draw(new Rectangle2D.Double(getLocation().getX(), getLocation().getY(), width, height));
        }
    }
 /**
     * Computes the distance from the specified camera position to the nearest edge of the rectangle.
     * This method calculates the distance using point-to-segment calculations for each edge of the rectangle.
     *
	 * the math for this method was acting up I supose I made an error. i used chat gpt and asked Nicky for some advice
	 * he sugested using Line2D which is built in. so i incorporated both into this function
	 * 
     * @param cameraPosition The position of the camera in 2D space, as a Point object.
     * @return The minimum distance from the camera position to the rectangle's edge.
     */
	@Override
public double computeDistance(Point cameraPosition) {
    double px = cameraPosition.getX();
    double py = cameraPosition.getY();
    
    // Calculate the coordinates of the corners of the rectangle based on its location, width, and height.
    double x1 = getLocation().getX();
    double y1 = getLocation().getY();
    double x2 = x1 + width;
    double y2 = y1 + height;
    
    // Initialize minimum distance as a very large number
    double minimum = Double.POSITIVE_INFINITY;
    
    // Compute the minimum distance to each of the four sides of the rectangle
    minimum = Math.min(Line2D.ptSegDist(x1, y1, x2, y1, px, py), minimum); // Top edge
    minimum = Math.min(Line2D.ptSegDist(x1, y2, x2, y2, px, py), minimum); // Bottom edge
    minimum = Math.min(Line2D.ptSegDist(x1, y1, x1, y2, px, py), minimum); // Left edge
    minimum = Math.min(Line2D.ptSegDist(x2, y1, x2, y2, px, py), minimum); // Right edge

    return minimum;
}

   
    



}
