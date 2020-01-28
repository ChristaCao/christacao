import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Listener that handles all the button events
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
class ButtonListener implements ActionListener {

    private DrawingBoard board;
    private String selectedButton;
    private Color color;

    /**
     * Constructor of the listener
     * @param board
     */
    public ButtonListener(DrawingBoard board) {
        this.board = board;
    }

    /**
     * Logic for handling all the button events
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        selectedButton = e.getActionCommand();
        if (selectedButton.equals("Remove")) {
            board.remove();
        }
        else if (selectedButton.equals("Erase")) {
            board.clear();
        }
        else if (selectedButton.equals("Change Color") ) {
            color = JColorChooser.showDialog(null, "Color", board.retrieve().getColor());
            if (color != null) {
                board.setColor(color);
            }
        }
    }

    /**
     *
     * @return the button being selected now, if there's any
     */
    public String getSelectedButton() {
        return selectedButton;
    }
}
