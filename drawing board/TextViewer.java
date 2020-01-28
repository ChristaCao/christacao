import javax.swing.*;

/**
 * The text viewer class
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class TextViewer extends JPanel implements Viewer {
    private DrawingBoard board;

    /**
     * The constructor
     * @param board
     */
    public TextViewer(DrawingBoard board) {
        this.board = board;
        this.board.setTextViewer(this);
    }

    /**
     * Print the string representation of the drawing board
     */
    public void update() {
		System.out.println("----------Below are all the shapes on the board-----------------");
        for (int i = 0; i < board.getCopy().size(); i++) {
           System.out.println(board.getCopy().get(i));
        }
        System.out.println("----------Above are all the shapes on the board-----------------");
        System.out.println("\n");
    }
}
