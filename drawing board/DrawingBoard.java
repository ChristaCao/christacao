import java.awt.*;
import java.util.*;


/**
 * The drawing board class
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */
public class DrawingBoard
{
	// The drawing board stores a list of shapes and the its viewers
	private ArrayList<AbstractShape> shapes;
	private Viewer textViewer;
	private Viewer graphicViewer;

	/**
	 * The constructor
	 */
	public DrawingBoard() {
		shapes = new ArrayList<AbstractShape>();
	}

	/**
	 * Set text viewer of the board
	 * @param viewer
	 */
	public void setTextViewer(Viewer viewer) {
		this.textViewer = viewer;
	}

	/**
	 * Set graphic view of the board
	 * @param viewer
	 */
	public void setGraphicViewer(Viewer viewer) {
		this.graphicViewer = viewer;
	}

	/**
	 * Helper method to update all the drawers. Called upon state change
	 */
	public void updateViewer() {
		if (textViewer != null)
			textViewer.update();
		if (graphicViewer != null)
			graphicViewer.update();
	}

	/**
	 * Add a shape to the board
	 * @param s
	 */
	public void addShape(AbstractShape s) {
		// Erase all previously selected shapes
		for (int i=0; i<shapes.size(); i++) {
			shapes.get(i).setSelected(false);
		}

		s.setSelected(true);
		shapes.add(s);

		updateViewer();
	}

	/**
	 * Select a shape based on point (x, y)
	 * @param x
	 * @param y
	 */
	public void select(int x, int y) {
		// Erase all previously selected shapes
		for (int i=0; i<shapes.size(); i++) {
			shapes.get(i).setSelected(false);
		}
		
		for (int i=shapes.size()-1; i>=0; i--) {
			if (!shapes.get(i).isOn(x, y))
				continue;
			shapes.get(i).setSelected(true);
			break;
		}

		updateViewer();
	}

	/**
	 *
	 * @return the selected shape
	 */
	public Shape retrieve() {
		for (int i=0; i<shapes.size(); i++) {
			if(shapes.get(i).isSelected()) {
				return shapes.get(i);
			}
		}
		return null;
	}

	/**
	 *  Remove the selected shape if there's any
	 */
	public void remove() {
		AbstractShape selectedShape = (AbstractShape) this.retrieve();
		if (selectedShape == null)
			throw new IllegalStateException("Nothing is selected");

		shapes.remove(selectedShape);
		if (shapes.size() > 0) {
			shapes.get(shapes.size() - 1).setSelected(true);
		}

		updateViewer();
	}

	/**
	 * Set the color of the selected shape if there's any
	 * @param c color
	 */
	public void setColor(Color c) {
		AbstractShape selectedShape = (AbstractShape) this.retrieve();
		if (selectedShape == null)
			throw new IllegalStateException("Nothing is selected");
		selectedShape.setColor(c);

		updateViewer();
	}

	/**
	 * Move the selected shape to point (x, y)
	 * @param x
	 * @param y
	 */
	public void move(int x, int y){
		AbstractShape selectedShape = (AbstractShape) this.retrieve();
		if (selectedShape == null)
			throw new IllegalStateException("Nothing is selected");
		selectedShape.shiftUpperLeftBy(x, y);

		updateViewer();
	}

	/**
	 * Clear all shapes on the board
	 */
	public void clear() {
		shapes = new ArrayList<AbstractShape>();
		updateViewer();
	}

	/**
	 * @return a copy of all the shapes
	 */
	public ArrayList getCopy(){
		return new ArrayList<AbstractShape>(shapes);
	}
}
