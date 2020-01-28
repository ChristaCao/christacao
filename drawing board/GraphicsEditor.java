import javax.swing.*;

/**
 * The Main class for graphics editor
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class GraphicsEditor {
    /**
     * The main class
     * @param args
     */
    public static void main(String[] args) {
        new GraphicsEditor();

    }

    /**
     * Constructor
     */
    public GraphicsEditor() {

        JFrame win = new JFrame("Drawing Board");
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BoardController controller = new BoardController(new DrawingBoard());
        win.getContentPane().add(controller);

        win.pack();
        win.setVisible(true);

    }
}
