import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The graphic viewer
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class GraphicViewer extends JPanel implements Viewer {

	private DrawingBoard board;

	/**
	 * Constructor. It also sets itself to the board
	 * @param board
	 */
	public GraphicViewer(DrawingBoard board) {
		super(); //call super
		this.setPreferredSize(new Dimension(500,500)); //determine the size of of the window
		this.board = board;
		this.board.setGraphicViewer(this);
	}

	/**
	 * Update the viewer
	 */
	public void update() {
		this.repaint();
	}

	/**
	 * Draw all the shapes here
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		//paint background
		super.paintComponent(g);
		Rectangle bounds = getBounds(); // get the bounds to be used for the rectangle size
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, bounds.width, bounds.height);

		ArrayList shapes = board.getCopy();

		//Draw the shapes
		for (int i = 0; i < shapes.size(); i++) {
			if ((((AbstractShape) shapes.get(i)).isSelected())) {
				continue;
			}
			((AbstractShape) shapes.get(i)).draw(g);
		}

		AbstractShape selectedShape = (AbstractShape) board.retrieve();
		if (selectedShape != null) {
			selectedShape.draw(g);
		}

		this.requestFocus();
	}
}
