import java.awt.Color;

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
        return base;
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
        return height;
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
        return 0.5 * base * height;
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
        return base + height + hypotenuse;
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

    @Override
    public void resize(int percent) {
        height *= percent / 100.0;
        base *= percent / 100.0;

    }
}
