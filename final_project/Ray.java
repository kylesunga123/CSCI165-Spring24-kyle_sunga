import java.awt.Graphics2D;
import java.util.ArrayList;

public class Ray implements Drawable {
    private ArrayList<March> marches = new ArrayList<>();

    public Ray() {}  // No Argument Constructor

    public ArrayList<March> getMarches() {
        return this.marches;
    }

    public void addMarch(March march) {
        if (march != null) {
            marches.add(march);
        } else {
            System.err.println("Attempted to add a null March object.");
        }
    }

    public void removeMarch(March march) {
        if (!marches.remove(march)) {
            System.err.println("Attempted to remove a March that does not exist.");
        }
    }

    public void clearMarches() {
        marches.clear();
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        if (marches.isEmpty()) {
            System.err.println("No marches to draw.");
            return;
        }

        for (March march : marches) {
            if (march != null) {
                march.drawObject(g2d);
            } else {
                System.err.println("Null March object found during draw operation.");
            }
        }
    }
}
