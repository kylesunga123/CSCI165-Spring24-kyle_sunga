import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RaymarcherPanel extends JPanel {

    private final RaymarcherRunner raymarcherRunner;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Camera camera; // Adding the Camera reference
    private March marchInstance;
    private Ray ray; // Use Ray instead of individual March instances


    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getHeight(),
                this.raymarcherRunner.getFrame().getHeight()));
        generateShapes();
        this.setBackground(Color.BLACK);
        this.camera = new Camera(0, 0); // Initialize camera at (0, 0) the origin
        this.ray = new Ray(); // Initialize the Ray instance

        addMouseMotionListener(camera); // Add camera as a mouse motion listener to track movements
        marchInstance = new March(camera, 50, Color.GREEN);// Initialize the march instance

    }

    /**
     * Generates random shapes and adds them to the simulation.
     * Currently generates a fixed number of circles, rectangles, and triangles.
     */
    private void generateShapes() {
        for (int i = 0; i < 5; i++) { // Generate 5 of each type of shape.
            shapes.add(ShapeRandom.createRandomCircle());
            shapes.add(ShapeRandom.createRandomRectangle());
            shapes.add(ShapeRandom.createRandomTriangle());
        }
    }

    // All drawing code goes here
    /**
     * Overridden paintComponent method to handle custom drawing.
     * 
     * @param g The Graphics object to draw on.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Perform standard JPanel painting.
        Graphics2D g2d = (Graphics2D) g;

        // Draw all shapes.
        for (Shape shape : shapes) {
            if (shape instanceof Drawable) {
                ((Drawable) shape).drawObject(g2d);
            }
        }

        // Draw the indicator circle at the camera's position.
        g2d.setColor(Color.RED);
        int circleRadius = 5;
        g2d.fillOval(camera.getX() - circleRadius, camera.getY() - circleRadius, circleRadius * 2, circleRadius * 2);

        // Update and draw the March instance.
        marchInstance.updateMarch(shapes);
        marchInstance.drawObject(g2d);

        ray.drawObject(g2d);

    }

    // Method to update the camera position
    /**
     * Updates the camera's position based on input coordinates and recalculates the
     * march radius.
     * This method is called to update the position of the camera when it moves and
     * to adjust the march radius
     * according to the closest shape from the new position.
     * 
     * @param newX The new x-coordinate for the camera.
     * @param newY The new y-coordinate for the camera.
     */
    public void updateCameraPosition(int newX, int newY) {
        camera.setX(newX); // Update the x-coordinate of the camera.
        camera.setY(newY); // Update the y-coordinate of the camera.

        


        // Initialize the minimum distance to a very high value before comparison.
        double minDistance = Double.MAX_VALUE;
        Point cameraPosition = new Point(newX, newY); // Create a new point at the new camera coordinates.

        // Iterate through all shapes to find the one closest to the new camera
        // position.
        for (Shape shape : shapes) {
            double distance = shape.computeDistance(cameraPosition); // Compute the distance from the shape to the
                                                                     // camera.
            if (distance < minDistance) {
                minDistance = distance; // Update the minimum distance if the current distance is smaller.
            }
        }

        // Update the march instance with the new minimum distance as the radius.
        marchInstance.updateMarch(shapes);

        repaint(); // Repaint the panel to reflect the new camera position and updated march
                   // circle.
    }

}