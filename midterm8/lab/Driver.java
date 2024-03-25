import javax.swing.JFrame;
 //taken from 3/13 lecture 
public class Driver {
    
    public static void main(String[] args) {
        World world = new World(50);
        Simple_Graphics g = new Simple_Graphics(world);
        JFrame window = new JFrame("Kyle's Wild Fire Simulator :)"); 
        initUI(window, world, g);

        Cell c = new Cell(); //empty cell
        c.setState(Cell.STATES.TREE);
    }
    public static void initUI(JFrame window, World world, Simple_Graphics g){
        window.setSize(world.getNumColumns() * Cell.WIDTH, world.getNumRows() * Cell.HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(g);
        window.setVisible(true);
    }
}
