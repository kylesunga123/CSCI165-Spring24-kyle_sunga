import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class Camera implements MouseMotionListener {
    private int x; // X-coordinate of the camera's position.
    private int y; // Y-coordinate of the camera's position.
    private Point point;

    /**
     * Constructs a new Camera with initial coordinates.
     * 
     * @param x Initial x-coordinate of the camera.
     * @param y Initial y-coordinate of the camera.
     */
    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the camera's position.
     * 
     * @return the current x-coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the x-coordinate of the camera's position.
     * 
     * @param x New x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of the camera's position.
     * 
     * @return the current y-coordinate.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the y-coordinate of the camera's position.
     * 
     * @param y New y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method not used but required by the MouseMotionListener interface.
     * 
     * @param e MouseEvent object (not used).
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        // Not used for camera movement
    }

    /**
     * Updates the camera's position based on the current mouse coordinates when the mouse is moved.
     * 
     * @param e MouseEvent that contains the new mouse coordinates.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        setX(e.getX()); // Update the x-coordinate based on the mouse's current x-position.
        setY(e.getY()); // Update the y-coordinate based on the mouse's current y-position.
    }

    public Camera(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }
}

