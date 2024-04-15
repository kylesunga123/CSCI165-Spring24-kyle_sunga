/* Kyle Sunga
 * Week 11 lab
 * April 12, 2024
 */

public class Point {
    // Two instance variables x (int) and y (int)
    private int x;
    private int y;

    // no- arg constuctor default location
    public Point() {
        this(0, 0);
    }

    // overload constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // copy constructor
    public Point(Point another) {
        this.x = another.x;
        this.y = another.y;
    }

    // getter and setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // returns x and y into an array list
    public int[] getXY() {
        return new int[] { x, y };
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Calculates the distance from this point to another point specified by its x
     * and y coordinates.
     * 
     * @param x The x-coordinate of the other point.
     * @param y The y-coordinate of the other point.
     * @return The distance between the current point and the point defined by the
     *         given x and y coordinates.
     */
    public double distance(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // returns distance from this point to given point instance
    public double distance(Point other) {
        return distance(other.x, other.y);
    }

    // returns the distance from this point to the origin
    public double distance() {
        return distance(0, 0);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(x);
        result = prime * result + Float.floatToIntBits(y);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
            return false;
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
            return false;
        return true;
    }

}