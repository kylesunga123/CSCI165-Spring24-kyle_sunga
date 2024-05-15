/**
 * Represents a point in a two-dimensional coordinate system.
 * This class provides methods to manipulate and retrieve the point's coordinates, as well as to calculate
 * distances between points and the origin.
 */
public class Point {
    private int x; // X-coordinate of the point
    private int y; // Y-coordinate of the point

    /**
     * Constructs a default point at the origin (0, 0).
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Constructs a point with specified x and y coordinates.
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new point that is a copy of the specified point.
     * @param another The point to copy.
     */
    public Point(Point another) {
        this.x = another.x;
        this.y = another.y;
    }

    /**
     * Returns the x-coordinate of this point.
     * @return The x-coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the x-coordinate of this point.
     * @param x The new x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of this point.
     * @return The y-coordinate.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the y-coordinate of this point.
     * @param y The new y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets both the x and y coordinates of this point.
     * @param x The new x-coordinate.
     * @param y The new y-coordinate.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x and y coordinates of this point as an array of integers.
     * @return An array containing the x and y coordinates.
     */
    public int[] getXY() {
        return new int[] { this.x, this.y };
    }

    /**
     * Provides a string representation of the point in the format "(x,y)".
     * @return A string representation of the point.
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Calculates the Euclidean distance from this point to another point specified by x and y coordinates.
     * @param x The x-coordinate of the other point.
     * @param y The y-coordinate of the other point.
     * @return The distance between the two points.
     */
    public double distance(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculates the Euclidean distance from this point to another point.
     * @param other The other point.
     * @return The distance between the two points.
     */
    public double distance(Point other) {
        return distance(other.x, other.y);
    }

    /**
     * Calculates the Euclidean distance from this point to the origin.
     * @return The distance from this point to the origin.
     */
    public double distance() {
        return distance(0, 0);
    }

    /**
     * Generates a hash code for this point.
     * @return A hash code value for this point.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    /**
     * Compares this point to another object for equality based on their coordinates.
     * @param obj The object to compare with this point.
     * @return true if the specified object is a point with the same coordinates; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }
}
