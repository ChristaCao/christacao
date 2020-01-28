import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * The mouse listener class
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

    private DrawingBoard board;
    private ButtonListener buttonListener;
    // We need to keep track of the coords of previous and current mouse event to implement dragging correctly
    private int[] prevCoord = {0, 0};
    private int[] currCoord = {0, 0};

    /**
     * The constructor
     * @param buttonListener
     * @param board
     */
    public MouseListener(ButtonListener buttonListener, DrawingBoard board) {
        this.board = board;
        this.buttonListener = buttonListener;
    }

    /**
     * Helper method for updating the previous and current clicked position
     * @param e
     */
    private void updateCoord(MouseEvent e) {
        prevCoord[0] = currCoord[0];
        prevCoord[1] = currCoord[1];
        currCoord[0] = e.getX();
        currCoord[1] = e.getY();
    }

    /**
     * Handle all mouse click events
     * @param e
     */
    public void mousePressed(MouseEvent e) {
        this.updateCoord(e);
        Random rand = new Random();
		Color randColor = new Color(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250));

		if (buttonListener.getSelectedButton().equals("Circle")) {
            board.addShape(new Circle(e.getX(), e.getY(), rand.nextInt(50) + 10, randColor));
        }
        else if (buttonListener.getSelectedButton().equals("Delta")) {
            board.addShape(new Delta(e.getX(), e.getY(), rand.nextInt(50) * 2 + 10, randColor));
        }
        else if (buttonListener.getSelectedButton().equals("Tee")) {
            board.addShape(new Tee(e.getX(), e.getY(), rand.nextInt(20)*10 + 10, randColor));
        }
        else if (buttonListener.getSelectedButton().equals("Select")) {
            board.select(e.getX(), e.getY());
        }
    }

    /**
     * Override and update previous and current coordinate here
     * @param e
     */
    public void mouseEntered(MouseEvent e) {
        this.updateCoord(e);
    }

    /**
     * Override and update previous and current coordinate here
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        this.updateCoord(e);
    }

    /**
     * Override and update previous and current coordinate here
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        this.updateCoord(e);
    }

    /**
     * Override and update previous and current coordinate here
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
        this.updateCoord(e);
    }

    /**
     * Update coordinate for dragging
     * @param e
     */
    public void mouseDragged(MouseEvent e) {
        this.updateCoord(e);
        if (board.retrieve() != null) {
            board.move(currCoord[0]-prevCoord[0], currCoord[1]-prevCoord[1]);
        }
    }

    /**
     * Override and update previous and current coordinate here
     * @param e
     */
    public void mouseMoved(MouseEvent e) {
        this.updateCoord(e);
    }
}
