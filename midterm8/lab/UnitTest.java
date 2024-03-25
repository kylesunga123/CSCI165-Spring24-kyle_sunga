import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitTest {

    private World world; //state variable

    @BeforeEach
    void setUp() {
        world = new World(50); //initalize 
    }

    @Test
    public void testSetWorldSize() {
        World world = new World(50);
        assertEquals(50, world.getNumRows());
        assertEquals(50, world.getNumColumns());
    }



    @Test
    public void testFireSpreadToNeighbors() {
        // Set up the world with a single burning tree surrounded by trees
        for (int i = 4; i <= 6; i++) { //looping from row 4 to 6 same w/ columns 
            for (int j = 4; j <= 6; j++) {
                world.getCell(i, j).setState(Cell.STATES.TREE);
            }
        }
        world.getCell(5, 5).setState(Cell.STATES.BURNING); //center cell burning

        // 100% probability catch fire
        Cell[][] newWorld = world.applySpread(1.0);

        // Check that all trees around the originally burning tree are now burning
        assertEquals(Cell.STATES.BURNING, newWorld[4][5].getState());
        assertEquals(Cell.STATES.BURNING, newWorld[6][5].getState());
        assertEquals(Cell.STATES.BURNING, newWorld[5][4].getState());
        assertEquals(Cell.STATES.BURNING, newWorld[5][6].getState());

        // diagnol cells 
        assertEquals(Cell.STATES.BURNING, newWorld[4][4].getState());
        assertEquals(Cell.STATES.BURNING, newWorld[4][6].getState());
        assertEquals(Cell.STATES.BURNING, newWorld[6][4].getState());
        assertEquals(Cell.STATES.BURNING, newWorld[6][6].getState());
    }
    @Test
    public void testWorldInitialization() {
        World world = new World(10);   // set valid world
        // test boundaries
        assertEquals(Cell.STATES.EMPTY, world.getCell(0, 0).getState());
        assertEquals(Cell.STATES.EMPTY, world.getCell(9, 9).getState());
        // test if central cell is burning
        assertEquals(Cell.STATES.BURNING, world.getCell(5, 5).getState());
    }
    @Test
    public void testApplySpread() {
        world.getCell(12, 11).setState(Cell.STATES.TREE); // Tree near the center burning cell.
        Cell[][] newWorld = world.applySpread(1.0); // 100% chance to catch fire.
        assertEquals(Cell.STATES.TREE, newWorld[12][11].getState());
    }
    
}
