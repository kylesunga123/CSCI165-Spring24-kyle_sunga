/*Kyle Sunga
 * April 12, 2024
 */

public class MovablePoint extends Point {
    float xSpeed;
    float ySpeed;

    // no- arg constuctor default location
    public MovablePoint() {
        super();
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(int x, int y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(Point xy, float xSpeed, float ySpeed) {
        super(xy.getX(), xy.getY());
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // getter and setters
    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeeds(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint move() {
        //x += xSpeed;
        //y += ySpeed;
        setX(getX() + Math.round(xSpeed));
        setY(getY() + Math.round(ySpeed));
        return this;

    }

    public float getXSpeed() {
        return xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(xSpeed);
        result = prime * result + Float.floatToIntBits(ySpeed);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        MovablePoint other = (MovablePoint) obj;
        if (Float.floatToIntBits(xSpeed) != Float.floatToIntBits(other.xSpeed))
            return false;
        if (Float.floatToIntBits(ySpeed) != Float.floatToIntBits(other.ySpeed))
            return false;
        return true;
    }

    /**
     * Returns the speeds along the X and Y axes in a float array
     * 
     * @return A 2-element float array with xSpeed as the first element and ySpeed
     *         as the second element
     */
    public float[] getSpeeds() {
        return new float[] { xSpeed, ySpeed };
    }

    // public float[] getSpeeds() {
    // float[] result = new float[2]; // construct an ayyay
    // result[0] = xSpeed; // assigning x and y speed to result array position 0 and
    // 1
    // result[1] = ySpeed;
    // return result; // return the array
    // }
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + "): speed = (" + xSpeed + ", " + ySpeed + ")";

    }

}
