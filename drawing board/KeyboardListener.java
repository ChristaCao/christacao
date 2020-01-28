import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The keyboard listener class for extra credit
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
class KeyboardListener implements KeyListener {

    private DrawingBoard board;

    /**
     * The constructor
     * @param board
     */
    public KeyboardListener(DrawingBoard board) {
        this.board = board;
    }

    /**
     * Override but do nothing
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Handle all the key press events
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        if (key == 'r') {
            board.remove();
        }
        else if (key == 'e') {
            board.clear();
        }
        else if (key == 'c') {
            Color color = JColorChooser.showDialog(null, "Color", board.retrieve().getColor());
            if (color != null) {
                board.setColor(color);
            }
        }
    }

    /**
     * Override but do nothing
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
