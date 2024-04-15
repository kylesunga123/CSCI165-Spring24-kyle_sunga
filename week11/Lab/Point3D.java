/*Kyle Sunga
 * April 12, 2024
 */

public class Point3D extends Point {
    // instance variable z
    private int z;

    public Point3D() {
        super();
        this.z = 0; // default z coordinate
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        // this.x = x;
        // this.y = y;
        this.z = z;
    }

    // getters and setters
    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x, int y, int z) {
        this.setX(x);
        this.setY(y);
        this.z = z;
    }

    public void setXYZ(Point xy, int z) {
        if (xy != null) {
            this.setX(xy.getX()); // Use getX() method from Point to set x
            this.setY(xy.getY()); // Use getY() method from Point to set y
            this.z = z;
        }
    }

    public int[] getXYZ() {
        return new int[] { getX(), getY(), z };
    }

    @Override
    public String toString() {
        
        return "(" + getX() + "," + getY() + "," + z + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + z;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point3D other = (Point3D) obj;
        if (z != other.z)
            return false;
        return true;
    }

}
