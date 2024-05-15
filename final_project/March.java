import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
//javadocs done using AI

public class March implements Drawable {
    
    private Camera camera; // Camera object representing the current position in 2D space.
    private double radius; // Radius of the march circle.
    private Color color; // Color used to draw the march circle.

    /**
     * Constructs a new March object.
     * 
     * @param camera The camera object representing the starting position of the march.
     * @param initialRadius Initial radius of the march circle.
     * @param color The color of the march circle.
     */
    public March(Camera camera, double initialRadius, Color color) {
        this.camera = camera;
        this.radius = initialRadius;
        this.color = color;
    }
 
    /**
     * Updates the radius of the march based on the shortest distance to any shape in the given list.
     * The march's radius will be set to the distance to the closest shape.
     * 
     * @param shapes An array list of Shape objects to calculate distances from the current camera position.
     */
    public void updateMarch(ArrayList<Shape> shapes) {
        double minDistance = Double.MAX_VALUE; // Start with the largest possible value.
        for (Shape shape : shapes) {
            double distance = shape.computeDistance(new Point(camera.getX(), camera.getY()));
            if (distance < minDistance) {
                minDistance = distance; // Find the minimum distance to a shape.
            }
        }
        this.radius = minDistance; // Update the radius to the minimum distance found.
    }
 
    /**
     * Draws the march circle on a Graphics2D drawing context.
     * The circle is drawn centered at the camera's position with the dynamically calculated radius.
     * 
     * @param g2d The Graphics2D context where the circle is drawn.
     */
    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(color); // Set the color for the drawing.
        // Draw a circle (oval with equal width and height) centered at the camera's position.
        g2d.drawOval(camera.getX() - (int) radius, camera.getY() - (int) radius, (int) (2 * radius), (int) (2 * radius));
    }
}
