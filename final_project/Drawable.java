import java.awt.Graphics2D;


public interface Drawable {
    /**
     * Draws this object onto a Graphics2D drawing context.
     * Implementing classes will provide specific drawing commands that define the visual representation
     * of the object.
     *
     * @param g2d The Graphics2D context on which the object should be drawn. This context
     *            provides the graphical operations necessary for drawing.
     */
    void drawObject(Graphics2D g2d);
}