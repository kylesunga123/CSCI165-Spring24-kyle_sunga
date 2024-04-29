
/*Kyle Sunga
 * April 27th, 2024
 * CSCI 165
 */
import java.awt.Color;

//used chatgpt for all javadocs
public abstract class Shape {

    // 3 protected instance variables
    protected Color color = Color.CYAN;
    protected Boolean filled = false;
    protected final Point location = new Point();

    public Shape() {
    }

    /**
     * Constructor that creates a shape with the specified color, fill state, and
     * location.
     *
     * @param color    The color of the shape.
     * @param filled   The fill state of the shape.
     * @param location The starting location of the shape in 2D space.
     */
    public Shape(Color color, boolean filled, Point location) {
        setColor(color);
        setFilled(filled);
        setLocation(location);
    }

    /**
     * Copy constructor that creates a new shape based on another shape's
     * properties.
     *
     * @param shape The shape to copy properties from.
     */
    public Shape(Shape shape) {
        if (shape != null) {
            // if the shape is null set color, fill, and location to default
            setColor(shape.getColor());
            setFilled(shape.isFilled());
            setLocation(shape.getLocation());

        }

    }

    // getter and setters

    public final Color getColor() {
        return color;
    }

    public final void setColor(Color color) {
        if (color == null) {
            this.color = Color.CYAN;
            // if the color is null set to cyan
        } else {
            this.color = color;
            // else set to color
        }
    }

    public final void setLocation(Point location) {
        if (location != null) {
            this.location.setXY(location.getX(), location.getY());
        } else {
            this.location.setXY(0, 0);
        }
    }

    public final Point getLocation() {
        return new Point(location);
    }

    public final boolean isFilled() {
        return filled;

    }

    public final void setFilled(boolean filled) {
        this.filled = filled;
    }

    // abstract classes
    /**
     * Calculates the area of the shape.
     *
     * @return The area of the shape as a double.
     */
    public abstract double getArea();

    /**
     * Calculates the perimeter of the shape.
     *
     * @return The perimeter of the shape as a double.
     */
    public abstract double getPerimeter();

    @Override
    // vscode generated hashcode
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((filled == null) ? 0 : filled.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        return result;
    }

    @Override
    // vscode generated equals method
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Shape other = (Shape) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (filled == null) {
            if (other.filled != null)
                return false;
        } else if (!filled.equals(other.filled))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Shape(" + getClass().getSimpleName() + ")\n" +
                "\tColor(RGB: " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")\n" +
                "\tFilled: " + (isFilled() ? "Yes" : "No") + "\n" +
                "\tLocation: " + location.toString() + "\n" +
                "\tArea: " + String.format("%.2f", getArea()) + "\n" +
                "\tPerimeter: " + String.format("%.2f", getPerimeter());
    }

}
