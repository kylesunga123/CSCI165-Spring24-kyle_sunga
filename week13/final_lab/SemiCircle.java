import java.awt.Color;

public class SemiCircle extends Circle {
    /**
     * Constructs a new SemiCircle with the specified radius.
     * 
     * @param radius The radius of the semicircle.
     */
    public SemiCircle(double radius) {
        super(radius);
    }

    /**
     * Constructs a new SemiCircle with the specified radius, color, location, and
     * fill state.
     *
     * @param radius   The radius of the semicircle.
     * @param color    The color of the semicircle.
     * @param location The location of the semicircle in 2D space.
     * @param filled   Indicates whether the semicircle is filled.
     */
    public SemiCircle(double radius, Color color, Point location, boolean filled) {
        super(radius, color, location, filled);
    }

    /**
     * Calculates and returns the area of the semicircle.
     * The area is defined as half of the area of the circle from which it is
     * derived.
     *
     * @return The area of the semicircle.
     */
    @Override
    public double getArea() {
        // Area of a semicircle is half of the area of a full circle
        return super.getArea() / 2;
    }

    /**
     * Calculates and returns the perimeter of the semicircle.
     * The perimeter includes the diameter and the half-circumference of the circle
     * from which it is derived.
     *
     * @return The perimeter of the semicircle.
     */
    @Override
    public double getPerimeter() {
        // Perimeter of a semicircle includes the diameter plus half the circumference
        // of the full circle
        return Math.PI * getRadius() + 2 * getRadius();
    }

    /**
     * Provides a string representation of the semicircle's properties.
     *
     * @return A string describing the semicircle.
     */
    @Override
    public String toString() {
        return super.toString() + "\n\tType: SemiCircle";
    }

    /**
     * Resizes the semicircle by a specified percentage.
     *
     * @param percent The percentage by which to resize the semicircle's radius.
     */
    @Override
    public void resize(int percent) {
        radius *= percent / 100.0;
    }
}
