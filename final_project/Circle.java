
/*Kyle Sunga
 * April 27th, 2024 
 * CSCI 165 
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;




//used chat gpt for javadocs
public class Circle extends Shape implements Resizable {
    protected double radius = 1;
    

    public Circle() {
    }

    /**
     * Constructor that creates a circle with the specified radius.
     *
     * @param radius The radius of the circle. Must be non-negative.
     */
    public Circle(double radius) {
        super();
        setRadius(radius);// this.radius = radius
    }

    /**
     * Constructor that creates a circle with the specified radius, color, location,
     * and fill state.
     *
     * @param radius   The radius of the circle. Must be non-negative.
     * @param color    The color of the circle.
     * @param location The location of the circle in 2D space.
     * @param filled   The fill state of the circle.
     */
    public Circle(double radius, Color color, Point location, boolean filled) {
        super(color, filled, location);
        setRadius(radius);// this.radius = radius
    }

    // copy constructor, same thing as in shape class line25 reference
    /**
     * Copy constructor that creates a new circle based on another circle's
     * properties.
     *
     * @param circle The circle to copy properties from.
     */
    public Circle(Circle circle) {
        if (circle != null) {
            setColor(circle.getColor());
            setFilled(circle.isFilled());
            setLocation(circle.getLocation());
            setRadius(circle.getRadius());
        }
    }

    // getters and setter method for radius
    // pi * radius * radusi area
    /**
     * Sets the radius of the circle. The radius cannot be negative.
     *
     * @param radius The radius of the circle to set.
     * @throws IllegalArgumentException if the radius is negative.
     */
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    /**
     * Gets the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return this.radius;
    }

    // math portion
    /**
     * Calculates and returns the area of the circle.
     *
     * @return The area of the circle.
     */
    @Override
    public double getArea() {
        // return Math.PI * getRadius() * getRadius();
        return Math.PI * Math.pow(getRadius(), 2);
    }

    /**
     * Calculates and returns the perimeter (circumference) of the circle.
     *
     * @return The perimeter of the circle.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    /**
     * Provides a string representation of the circle's properties.
     *
     * @return A string describing the circle.
     */
    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tRadius(" + getRadius() + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Compares this circle to another object for equality.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Circle other = (Circle) obj;
        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
            return false;
        return true;
    }

    /**
     * Resizes the circle by a percentage.
     *
     * @param percent The percentage by which to resize the circle.
     */
    @Override
    public void resize(int percent) {
        this.radius += this.radius * percent / 100.0;
    }
    /**
     * Draws the circle on a Graphics2D drawing context. The circle can be either filled or outlined
     * based on its filled state.
     *
     * @param g2d The Graphics2D context where the circle is drawn.
     */
    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(getColor()); // Set the color of the Graphics2D context to the color of the circle
        if (isFilled()) {
            g2d.fill(new Ellipse2D.Double(getLocation().getX() - radius, getLocation().getY() - radius, 2 * radius, 2 * radius));
        } else {
            g2d.draw(new Ellipse2D.Double(getLocation().getX() - radius, getLocation().getY() - radius, 2 * radius, 2 * radius));
        }
    }
   
    /**
     * Computes the distance from the specified camera position to the edge of the circle.
     * This method calculates the Euclidean distance from the camera to the center of the circle
     * and subtracts the radius to find the distance to the edge.
     *
     * @param cameraPosition The position of the camera in 2D space, as a Point object.
     * @return The distance from the camera position to the edge of the circle.
     */
    @Override
    public double computeDistance(Point cameraPosition) {
        // Calculate the Euclidean distance from the camera position to the circle's center
        double distanceToCenter = Math.sqrt(Math.pow(cameraPosition.getX() - getLocation().getX(), 2) + 
                                            Math.pow(cameraPosition.getY() - getLocation().getY(), 2));
        // Subtract the circle's radius to get the distance to the circle's edge
        return distanceToCenter - getRadius();
    }
    
    

    
}

