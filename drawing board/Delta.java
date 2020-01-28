import java.awt.*;
import java.util.*;


/**
 * The delta class
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class Delta extends AbstractShape {

    /**
     * Constructor of the delta class
     * @param x x coord of the apex
     * @param y y coord of the apex
     * @param height height of the delta
     * @param c color
     */
    public Delta(int x, int y, int height, Color c) {
        if (height % 2 != 0)     
            throw new IllegalArgumentException("Height should be even.");
        this.x = x - height / 2;
        this.y = y;
        this.height = height;
        this.setColor(c);
    }

    /**
     * Check if a point x, y is on delta
     * @param x
     * @param y
     * @return
     */
    public boolean isOn(int x, int y) {
        // not on shape if outside the bounding box
        if (x < this.x || x > this.x+height || y < this.y || y > this.y+height)
            return false;

        // not on shape if within bounding box, but point above two edges of the shape
        if ((this.y + height - y) > (x - this.x) * 2)
            return false;

        if ((this.y + height - y) > (this.x + height - x) * 2)
            return false;

        return true;
    }

    /**
     *
     * @return string representation of the delta
     */
    public String toString() {
        return "Delta with apex at (" + (this.x + height/2) + "," + this.y + ")" + " and height=" + this.height;
    }

    /**
     * Draw the delta on GUI
     * @param g swing graphics object
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        int xCoord[] = {x+height/2,x+height,x};
        int yCoord[] = {y,y+height,y+height};
        g.fillPolygon(xCoord, yCoord, 3);

        if (super.isSelected()) {
            g.setColor(Color.RED);
            g.drawPolygon(xCoord, yCoord, 3);
        }
    }
}
