
/*Kyle Sunga
 * April 27th, 2024 
 * CSCI 165 
 */
import java.awt.Color;

public final class Square extends Rectangle {
    protected double side = 1;

    public Square() {
        super();
    }

    /**
     * Constructor that creates a square with the specified side length.
     *
     * @param side The length of the sides of the square.
     */
    public Square(double side) {
        super(side, side);

    }

    /**
     * Constructor that creates a square with the specified side length, color, fill
     * state, and location.
     *
     * @param side     The length of the sides of the square.
     * @param color    The color of the square.
     * @param filled   The fill state of the square.
     * @param location The starting location of the square in 2D space.
     */
    public Square(double side, Color color, boolean filled, Point location) {
        super(side, side, color, filled, location); // Calls Rectangle's full constructor
    }

    // getters and setters
    /**
     * Gets the side length of the square.
     *
     * @return The side length of the square.
     */
    public double getSide() {
        return getWidth();
    }

    // width and height basically the same as just side
    /**
     * Sets the side length of the square. This will set both the width and height
     * of the square.
     *
     * @param side The new side length of the square.
     */
    public void setSide(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    /**
     * Sets the width of the square. Overridden to ensure the square remains valid
     * with equal sides.
     *
     * @param width The new width of the square, which will also set the height.
     */
    @Override
    public void setWidth(double width) {
        setSide(width); // Set both width and height to the same value
    }

    /**
     * Sets the height of the square. Overridden to ensure the square remains valid
     * with equal sides.
     *
     * @param height The new height of the square, which will also set the width.
     */
    @Override
    public void setHeight(double height) {
        setSide(height); // Set both width and height to the same value
    }

    /**
     * Provides a string representation of the square's properties.
     *
     * @return A string describing the square.
     */
    @Override
    public String toString() {
        // return "Square []"; line 45 given from vscode
        return "Square[" +
                "side=" + getSide() + ", " +
                "color=" + getColor() + ", " +
                "filled=" + isFilled() + ", " +
                "location=" + getLocation() +
                "]";
    }

    /**
     * Compares this square to another object for equality.
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
        Square other = (Square) obj;
        return Double.compare(other.getSide(), this.getSide()) == 0 &&
                (color == null ? other.color == null : color.equals(other.color)) &&
                (filled == other.filled) &&
                (location == null ? other.location == null : location.equals(other.location));
    }

    /**
     * Resizes the square by a percentage.
     *
     * @param percent The percentage by which to resize the square's side.
     */
    @Override
    public void resize(int percent) {
        side *= percent / 100.0;
    }
}
