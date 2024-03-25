import java.awt.Color;
/*
 * Kyle Sunga
 * taken from 3/13 class lecture 
 */
public class Cell {
    public static final int HEIGHT = 10;
    public static final int WIDTH = 10;
    //i just wanted to change the colors a bit. created soem new colors colors
    public static final Color GREEN_GRASS = new Color(0,102,0); //green given was too light. so i googled how to add different colors
    public static final Color LIGHT_YELLOW = new Color(255,255,153);

    public static final Color[] COLORS = {LIGHT_YELLOW, GREEN_GRASS, Color.RED};
    public static enum STATES {EMPTY, TREE, BURNING};

    //instance 
    private Color color;
    private STATES state;

    public Cell(){
        this.state = STATES.EMPTY;
        this.color = COLORS[this.state.ordinal()];
    }
    public void setState(STATES state){
        this.state = state;
        this.color = COLORS[this.state.ordinal()];
    }
    //getters & setters
    public STATES getState(){
        return this.state;
    }

    public Color getColor(){
        return this.color;
    }
}
