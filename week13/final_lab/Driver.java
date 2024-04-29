import java.awt.Color;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        // Create a Point object for the location of shapes
        Point p = new Point(1, 2);

        // Creating a Shape reference to a Circle object
        Shape s1 = new Circle(5.5, Color.CYAN, p, false);
        System.out.println(s1); // Calls Circle's toString method
        System.out.println(s1.getArea()); // Calls Circle's getArea method
        System.out.println(s1.getPerimeter()); // Calls Circle's getPerimeter method
        System.out.println(s1.getColor()); // getColor from Shape class
        System.out.println(s1.isFilled()); // isFilled from Shape class

        // Downcast to access Circle-specific methods
        Circle c1 = (Circle) s1; // Downcasting is safe here since we know s1 is a Circle
        System.out.println(c1.getRadius()); // getRadius from Circle class

        // Creating a Shape reference to a Rectangle object
        Shape s2 = new Rectangle(1.0, 2.0, Color.BLUE, true, p);
        System.out.println(s2); // Calls Rectangle's toString method
        System.out.println(s2.getArea()); // Calls Rectangle's getArea method
        System.out.println(s2.getPerimeter()); // Calls Rectangle's getPerimeter method
        System.out.println(s2.getColor()); // getColor from Shape class

        // Downcast to access Rectangle-specific methods
        Rectangle r1 = (Rectangle) s2; // Downcasting is safe here since we know s2 is a Rectangle
        System.out.println(r1.getHeight()); // getHeight from Rectangle class
        System.out.println(r1.getWidth()); // getWidth from Rectangle class

        // Creating a Shape reference to a Square object
        Shape s3 = new Square(3.0, Color.GREEN, true, p);
        System.out.println(s3); // Calls Square's toString method
        System.out.println(s3.getArea()); // Calls Square's getArea method inherited from Rectangle
        System.out.println(s3.getPerimeter()); // Calls Square's getPerimeter method inherited from Rectangle
        System.out.println(s3.getColor()); // getColor from Shape class

        // Downcast to access Square-specific methods
        Square sq1 = (Square) s3; // Downcasting is safe here since we know s3 is a Square
        System.out.println(sq1.getSide()); // getSide from Square class
        // Note: Square might override setWidth and setHeight to ensure both are the
        // same
        sq1.setSide(4.0); // setSide from Square class, changes both width and height
        System.out.println(sq1); // Calls Square's toString method after changing side

        // task4
        Shape s4 = new Triangle(3.0, 4.0, Color.RED, true, p);
        System.out.println(s4); // Calls Triangle's toString method
        System.out.println(s4.getArea()); // Calls Triangle's getArea method
        System.out.println(s4.getPerimeter()); // Calls Triangle's getPerimeter method
        System.out.println(s4.getColor()); // getColor from Shape class
        // task 5
        Shape s5 = new SemiCircle(5.0, Color.MAGENTA, p, true);
        System.out.println(s5); // Calls SemiCircle's toString method
        System.out.println(s5.getArea()); // Calls SemiCircle's getArea method
        System.out.println(s5.getPerimeter()); // Calls SemiCircle's getPerimeter method

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);
        shapes.add(s4);
        shapes.add(s5);
//i got so confused on this portion of the lab.
        ArrayList<Resizable> resizables = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape instanceof Resizable) {
                resizables.add((Resizable) shape);
            }

            int resizePercentage = 10; // Define the percentage by which to resize

            // Call the resize method
            resize(resizables, resizePercentage);

            Shape largestShape = findLargest(shapes);
            double totalShapesArea = totalArea(shapes);

            System.out.println("Largest Shape Area: " + largestShape.getArea());
            System.out.println("Total Area of All Shapes: " + totalShapesArea);
        }
        // System.out.println("Before resize: " + resizable);
        // System.out.println("After resize: " + resizable);
        
    }

    // task3
    // Method to find the Shape with the largest area
    /**
     * Finds the shape with the largest area in a list of shapes.
     *
     * @param shapes An ArrayList of shapes to search through.
     * @return The shape with the largest area, or null if the list is empty.
     */
    public static Shape findLargest(ArrayList<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return null; // Return null if the list is empty or null
        }

        Shape largestShape = shapes.get(0); // Start with the first shape as the largest

        // Iterate through the list of shapes, comparing areas
        for (Shape shape : shapes) {
            if (shape.getArea() > largestShape.getArea()) {
                largestShape = shape; // Update the largest shape if a larger one is found
            }
        }

        return largestShape; // Return the largest shape found
    }

    // Method to calculate the total area of a list of shapes
    /**
     * Calculates the total area of all shapes in a list.
     *
     * @param shapes An ArrayList of shapes whose areas are to be summed.
     * @return The sum of the areas of the shapes in the list.
     */
    public static double totalArea(ArrayList<Shape> shapes) {
        double total = 0; // Initialize total area

        // Iterate through the list and sum the areas
        for (Shape shape : shapes) {
            total += shape.getArea(); // Add each shape's area to the total
        }

        return total; // Return the total area
    }

    /**
     * Resizes each resizable shape in the list by a given percentage.
     * Prints the state of each shape before and after resizing.
     *
     * @param resizables An ArrayList of Resizable shapes to be resized.
     * @param percent    The percentage by which to resize each shape.
     */
    public static void resize(ArrayList<Resizable> resizables, int percent) {
        for (Resizable resizable : resizables) {
            System.out.println("Before resize: " + resizable);
            resizable.resize(percent);
            System.out.println("After resize: " + resizable);
        }
    }

}
