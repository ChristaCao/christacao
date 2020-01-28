import java.awt.*;
import java.util.*;

/**
 * An Abstract class AbstractShape
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public abstract class AbstractShape implements Shape {

    protected int x, y, height;
    protected Color c;
    protected boolean isSelected;

    /**
     *  Constructor
     */
    public AbstractShape() {
        this.isSelected = false;
    }

    /**
     * Check if a point is on the shape
     * @param x
     * @param y
     * @return
     */
    public abstract boolean isOn(int x, int y);

    /**
     * Check if selected
     * @return
     */
    public boolean isSelected(){
        return this.isSelected;
    }

    /**
     * Set the selected state
     * @param selected
     */
    public void setSelected(boolean selected){
        this.isSelected = selected;
    }

    /**
     * Getter for x coordinate of upper left
     * @return y
     */
    public int getX(){
        return x;
    }

    /**
     * Getter for y coordinate of upper left
     * @return x
     */
    public int getY(){
        return y;
    }

    /**
     * Getter for color
     * @return Color
     */
    public Color getColor(){
        return c;
    }

    /**
     * Setter for color
     * @param c color to be set
     */
    public void setColor(Color c){
        this.c = c;
    }

    /**
     * Shift the upper left of the shape by delta
     * @param deltaX
     * @param deltaY
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY){
        x += deltaX;
        y += deltaY;
    }

    /**
     * Move the upper left of the shape to a new coordinate
     * @param newX
     * @param newY
     */
    public void moveUpperLeftTo(int newX, int newY){
        x = newX;
        y = newY;
    }
    
    public abstract String toString();

    /**
     * Draw the shape on the GUI
     * @param g swing graphics object
     */
	public abstract void draw(Graphics g);
}
