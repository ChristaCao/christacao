import java.awt.*;
import java.util.*;

/**
 * The Tee class
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class Tee extends AbstractShape {

    /**
     * The constructor
     * @param x
     * @param y
     * @param height
     * @param c
     */
    public Tee(int x, int y, int height, Color c) {
        if (height % 10 != 0) {
            throw new IllegalArgumentException("the height of the tee should be a multiple of 10");
        }
        this.x = x;
        this.y = y;
        this.height = height;
        this.setColor(c);
    }

    /**
     * Check if point (x, y) is on the Tee
     * @param x
     * @param y
     * @return
     */
    public boolean isOn(int x, int y) {
        // not on shape if outside the bounding box
        if (x < this.x || x > this.x+height || y < this.y || y > this.y+height)
            return false;

        int thickness = this.height / 5;
        // in shape if within horizontal strip
        if (y < this.y + thickness)
            return true;

        // in shape if within vertical strip
        if (x > this.x + height/2 - thickness/2 && x < this.x + height/2 + thickness/2)
            return true;

        return false;
    }


    /**
     * @return string representation of the tee
     */
    public String toString() {
        return "Tee with upper left corner at (" + this.x + "," + this.y + ").";
    }

    /**
     * Draw the tee on the GUI
     * @param g swing graphics object
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        int thickness = height/5;
        g.fillRect(x, y, height, height/5);
        g.fillRect(x + thickness*2, y+thickness, thickness, thickness*4);

        if (isSelected) {
            g.setColor(Color.RED);
            g.drawRect(x, y, height, height/5);
            g.drawRect(x + thickness*2, y+thickness, thickness, thickness*4);
        }
    }
}
