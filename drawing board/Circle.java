import java.awt.*;
import java.util.*;


/**
 * The circle class
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class Circle extends AbstractShape {

    // stores the origin and the radius here
    private int origin_x, origin_y, radius;

    /**
     * Constructor of the circlt
     * @param x x coord of the center
     * @param y y coord of the center
     * @param r radius
     * @param c color
     */
    public Circle(int x, int y, int r, Color c) {
        origin_x = x;
        origin_y = y;
        radius = r;
        this.x = origin_x - r;
        this.y = origin_y - r;
        this.height = 2*r;
        this.setColor(c);
    }

    /**
     * Check if a point is on the circle
     * @param x
     * @param y
     * @return
     */
    public boolean isOn(int x, int y) {
        // reset origin in case circle being shifted
        origin_x = this.x + radius;
        origin_y = this.y + radius;
        return Math.pow(x-origin_x, 2) + Math.pow(y-origin_y,2) <= Math.pow(radius, 2); 
    }

    /**
     * @return string representation of the circle
     */
     public String toString() {
        return "Circle centered at (" + origin_x + ", " + origin_y + ") " +
            "with radius=" + radius + ". Upper left color is (" + this.x + "," + this.y + ")";
    }

    /**
     * Draw the circle
     * @param g swing graphics object
     */
    public void draw(Graphics g) {
        if (super.isSelected()) {
            g.setColor(Color.RED);
            g.drawOval(x, y, height, height);
        }

        g.setColor(getColor());
        g.fillOval(x, y, height, height);
    }
}
