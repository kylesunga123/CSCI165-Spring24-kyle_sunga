import java.util.List;
import java.util.ArrayList;

public class World {
    private int size = 25; 
    private Cell[][] world; // 2D Grid of Cell Objects

    public World(int size) {
        if (size > 0)
            this.size = size;
        world = new Cell[this.size][this.size];
        initWorld();
    }

    private void initWorld() { //initworld function taken from 3/13 lecture 
        for (int i = 0; i < world.length; ++i) {
            for (int j = 0; j < world[i].length; ++j) {
                world[i][j] = new Cell(); // Assume Cell has a default constructor
                if (i == 0 || i == world.length - 1 || j == 0 || j == world[i].length - 1)
                    world[i][j].setState(Cell.STATES.EMPTY);
                else
                    world[i][j].setState(Cell.STATES.TREE);
            }
        }
        int middle = this.size / 2;
        world[middle][middle].setState(Cell.STATES.BURNING);
    }
    //getters and setters
    public int getNumColumns() {
        return this.size;
    }

    public int getNumRows() {
        return this.size;
    }

    public Cell getCell(int i, int j) { //return specific location of row and column in grid
        return world[i][j];
    }

    public void setWorld(Cell[][] newWorld) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                world[i][j].setState(newWorld[i][j].getState());// update the state of the cell in the current world with the state

            }
        }
    }

    public Cell[][] applySpread(double probCatch) {
        Cell[][] newWorld = new Cell[this.size][this.size];  // create a new world grid to represent the next state after fire spread.


        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                newWorld[i][j] = new Cell(); // new cell
                newWorld[i][j].setState(world[i][j].getState());// copy state of originakl world 
            }
        }

        for (int i = 1; i < this.size - 1; ++i) {
            for (int j = 1; j < this.size - 1; ++j) {
                if (world[i][j].getState() == Cell.STATES.BURNING) { //fire spread to neiboring cells. probcatch is probabilty of next tree catching on fire
                    applyFireSpreadToNeighbors(newWorld, i, j, probCatch);
                    newWorld[i][j].setState(Cell.STATES.EMPTY);//after tree is burnt cell becomes empty. set cell to empty
                }
            }
        }
        return newWorld;
    }
    //i used chatgpt a bit for this function. confused on how to implement the different directions the fire can spread.
    //added comments for this function myself so I can understand how to write this in the future. 
    private void applyFireSpreadToNeighbors(Cell[][] newWorld, int i, int j, double probCatch) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; //columns and rows for different coordinates [ex. northeast southest northwest southwest]
        for (int[] dir : directions) { //iterate through the different directions
            int newI = i + dir[0]; //new row and col index moving in the current dirrecrion. 
            int newJ = j + dir[1];
            if (newI >= 0 && newI < this.size && newJ >= 0 && newJ < this.size) {
                if (world[newI][newJ].getState() == Cell.STATES.TREE && Math.random() < probCatch) {
                    newWorld[newI][newJ].setState(Cell.STATES.BURNING);
                }
            }
        }
    }

    public List<Cell[][]> simulateFire(int n, double probCatch) {
        List<Cell[][]> grids = new ArrayList<>(); //holds world at each step
        Cell[][] currentGrid = world; //current world state
        grids.add(currentGrid);

        for (int step = 1; step <= n; step++) {
            Cell[][] newGrid = applySpread(probCatch); //generate new state of world
            grids.add(newGrid);
            currentGrid = newGrid; // Update the reference for the next iteration
        }

        return grids;
    }

    public void fireStep(double probCatch) {
        world = applySpread(probCatch);
    }
}
