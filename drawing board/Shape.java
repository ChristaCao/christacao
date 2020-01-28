import java.awt.*;
import java.util.*;

/**
 * The interface for shape
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public interface Shape {

    /**
     * Check if point (x, y) is on the shape
     * @param x
     * @param y
     * @return
     */
    boolean isOn(int x, int y);

    /**
     * Check if a shape is selected
     * @return the selected state
     */
    boolean isSelected();

    /**
     * Set the selected state of a shape
     * @param b the intended selected state of a shape
     */
    void setSelected(boolean b);

    /**
     * @return color of the shape
     */
    Color getColor();

    /**
     * Set the color of the shape
     * @param c color
     */
    void setColor(Color c);

    /**
     * Shift the upper left of the shape by delta
     * @param deltaX
     * @param deltaY
     */
    void shiftUpperLeftBy(int deltaX, int deltaY);

    /**
     * Move the upper left of the shape to (x, y)
     * @param newX
     * @param newY
     */
    void moveUpperLeftTo(int newX, int newY);

    /**
     * @return string representation of the shape
     */
    String toString();
}

