import java.awt.*;
import javax.swing.*;

 /**
 * Controller of the drawing board
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class BoardController extends JPanel {
    private DrawingBoard board;

     /**
      * Helper class to add a button with a listener
      *
      * @param text text on the button
      * @param buttons list of all buttons to add
      * @param listener listener of the button
      */
    private void addToButtons(String text, JPanel buttons, ButtonListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        buttons.add(button);
    }

     /**
      * Constructor of the board controller
      *
      * All GUI components and their associated listeners are constructed here
      * @param board
      */
    public BoardController(DrawingBoard board) {
        this.board = board;
        setLayout(new BorderLayout());

        // Buttons and their listener
        JPanel buttons = new JPanel();
        ButtonListener buttonListener = new ButtonListener(board);

        addToButtons("Select", buttons, buttonListener);
        addToButtons("Erase", buttons, buttonListener);
        addToButtons("Remove", buttons, buttonListener);
        addToButtons("Change Color", buttons, buttonListener);
        addToButtons("Circle", buttons, buttonListener);
        addToButtons("Delta", buttons, buttonListener);
        addToButtons("Tee", buttons, buttonListener);
        this.add(buttons, BorderLayout.SOUTH);

        // Text Viewer
        TextViewer textViewer = new TextViewer(board);
        this.board.setTextViewer(textViewer);

        // Graphic Viewer and its listeners
        GraphicViewer graphicViewer = new GraphicViewer(board);
        this.add(graphicViewer, BorderLayout.NORTH);
        this.board.setGraphicViewer(graphicViewer);

        MouseListener mouseListener = new MouseListener(buttonListener, board);
        graphicViewer.addMouseMotionListener(mouseListener);
        graphicViewer.addMouseListener(mouseListener);

        // Extra credit: support remove, clear and set color
        KeyboardListener keyBoardListener = new KeyboardListener(board);
        graphicViewer.addKeyListener(keyBoardListener);
    }
}
