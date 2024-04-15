import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // Initialize different types of points
        Point p = new Point(3, 4);
        Point3D p3d = new Point3D(5, 6, 7);
        MovablePoint mp = new MovablePoint(8, 9, 1.0f, 1.0f);

        // Demonstrate toString methods
        System.out.println("Point toString(): " + p);
        System.out.println("Point3D toString(): " + p3d);
        System.out.println("MovablePoint toString(): " + mp);

        // Demonstrate moving a MovablePoint and calculating distances
        System.out.println("MovablePoint moved: " + mp.move());
        System.out.println("Distance from Point3D to Point: " + p3d.distance(p.getX(), p.getY()));
        Point somePoint = new Point3D(10, 11, 12); // Upcasting
        System.out.println("Distance from Point to somePoint (which is actually a Point3D): " + p.distance(somePoint));
        MovablePoint mpExample = new MovablePoint(new Point(1, 2), 3, 4);
        Point3D p3dExample = new Point3D(12, 34, 6);
        double dis = mpExample.distance(p3dExample);
        System.out.println("Distance between mpExample and p3dExample: " + dis);

        // Array of Point type with 9 elements
        Point[] points = new Point[9];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(3, 3);
        points[3] = new Point3D(1, 1, 1);
        points[4] = new Point3D(2, 2, 2);
        points[5] = new Point3D(3, 3, 3);
        points[6] = new MovablePoint(1, 1, 1.0f, 1.0f);
        points[7] = new MovablePoint(2, 2, 2.0f, 2.0f);
        points[8] = new MovablePoint(3, 3, 3.0f, 3.0f);

        // Display points using polymorphic behavior
        System.out.println("List of points in array: ");
        for (Point point : points) {
            System.out.println(point.toString());
        }

        // Calculate and display the point furthest from the origin
        ArrayList<Double> distanceList = new ArrayList<>();
        for (Point point : points) {
            distanceList.add(point.distance());
        }
        double maxDistance = 0.0;
        int indexTracker = 0;
        for (int index = 0; index < distanceList.size(); index++) {
            double distance = distanceList.get(index);
            if (distance > maxDistance) {
                maxDistance = distance;
                indexTracker = index;
            }
        }
        Point furthestPoint = points[indexTracker];
        System.out.println("The furthest point from the origin is " + furthestPoint + " with a distance of: " + maxDistance);

        // Define object array to contain each type of point, along with other objects
        Object[] objects = new Object[11];
        System.arraycopy(points, 0, objects, 0, points.length);
        objects[9] = new Customer("Kyle Sunga", "franciskylesunga@gmail.com", "2014437054");
        objects[10] = new MenuItem("Freedom Fries", 2.99, 448);

        // Print all objects using polymorphism
        System.out.println("Printing points from an array of objects: ");
        for (Object obj : objects) {
            System.out.println(obj.toString());
        }
    }
}
