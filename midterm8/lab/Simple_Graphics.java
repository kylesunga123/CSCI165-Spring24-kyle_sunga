
import java.awt.Graphics; // import the Graphics class
import java.awt.Graphics2D; // import the Graphics2D class
import java.awt.event.ActionEvent; // Timer kicks out ActionEvents
import java.awt.event.ActionListener; // The class needs to listen for ActionEvents
import javax.swing.JPanel; // A JPanel is a simple container for graphics
import javax.swing.Timer; // A Timer object kicks out ActionEvents at regular intervals

// Don't worry too much about "extends JPanel" and "implements ActionListener"
// We will cover that in excruciating detail in the future
public class Simple_Graphics extends JPanel implements ActionListener {
	private final int DELAY = 400; // delay for ActionListener Timer. Change this to change the speed of the
	private Timer timer; // Timer object to control repainting.
	private World world; // needs a reference to the class that contains the matrix

	/**
	 * Constructor
	 * 
	 * @param grid - the World object to be rendered
	 */
	public Simple_Graphics(World world) {
		this.world = world; // store the reference to the grid
		initTimer(); // initialize the timer
	}

	/**
	 * Method to initialize and start the Timer object
	 */
	private void initTimer() {
		timer = new Timer(DELAY, this); // create a new Timer object with delay and reference to ActionListener class
		timer.start(); // start the timer
	}
	public void setWorld(Cell[][] grid){
		world.setWorld(grid);
	}
	// method to render the world in Java 2D Graphics
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; // type cast Graphics object to 2D. DON'T REMOVE
		
		for (int i = 0; i < world.getNumRows(); i++) { //loop through the rows
			for(int j = 0; j < world.getNumColumns(); j++){ // loop through the columns
				Cell cell = world.getCell(i, j); // location of cells
				g2d.setPaint(cell.getColor());
				g2d.fillRect(j * Cell.WIDTH, i * Cell.HEIGHT, Cell.WIDTH, Cell.HEIGHT);
			}
		//grid.tick();
		}
		// TO DO: draw the world as a series of rectangles
		// get the color of the cell and draw a rectangle at the appropriate location
	}

	@Override // method will be called each time timer "ticks"
	public void actionPerformed(ActionEvent arg0) {
		world.fireStep(0.5); //probabilty of next tree catching fire
		// This method represents a time step
		// TO DO: update the grid by iterating through the cells and updating their
		// state
		// with the transition rules
		// then repaint the grid
		this.repaint(); // call the repaint method, which will call paintComponent
	}

	/*
	 * If you put all your drawing code in doDrawing, you don't need to worry about
	 * this method
	 */
	@Override // automatically called by "repaint"
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // call the superclass method. DON'T REMOVE
		doDrawing(g); // call the doDrawing method. THIS IS YOURS
	}
//thought i was going to need to use this. nevermind. just kept it here as a reference
	//public void paintComponent(Graphics g) { //coppied from bouncing ball 
		//Graphics2D g2d = (Graphics2D) g; // 2D Graphics only for this project
		//super.paintComponent(g2d); // Tell our parent to paint
	//}
}