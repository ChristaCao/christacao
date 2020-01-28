import java.awt.*;

/**
 * The Tester class for unit testings of the drawing borad
 *
 * @author Yuxiao Cao
 * @version 19 Oct 2018
 */

/**
 * Main class for unit testing
 */
public class Test {
    public static void main(String[] args) {
        // test the class circle
        Color col = new Color(200,200,200);
        Circle c = new Circle(5,5,4,col);

        // test isOn method for using two point one on the shape the other is not
        assert(c.isOn(5,5) == true);
        assert(c.isOn(0,0) == false);

        // test the class delta
        Delta d = new Delta(2,1,2,col);
        assert(d.isOn(2,2) == true);
        assert(d.isOn(1,1) == false);

        // test the class delta
        Tee t = new Tee(0,0,10,col);
        assert(t.isOn(1,1) == true);
        assert(t.isOn(15,15) == false);

        c.moveUpperLeftTo(1,2);
        assert(c.getX() == 1);
        assert(c.getY() == 2);

        c.shiftUpperLeftBy(1,2);
        assert(c.getX() == 2);
        assert(c.getY() == 4);

        // testing setSelected and isSeleced methods
        c.setSelected(true);
        assert(c.isSelected() == true);
        c.setSelected(false);
        assert(c.isSelected() == false);

        // test select
        DrawingBoard db = new DrawingBoard();
        db.addShape(c);
        db.addShape(d);
        db.addShape(t);
        db.select(5,4);

        assert(((AbstractShape) db.retrieve()).getX() == 0);
        assert(((AbstractShape) db.retrieve()).getY() == 0);

        // test move
        db.move(1,1);
        assert(((AbstractShape) db.retrieve()).getX() == 1);
        assert(((AbstractShape) db.retrieve()).getY() == 1);

        // test remove
        db.remove();
        assert(((AbstractShape) db.retrieve()).getX() == 1);
        assert(((AbstractShape) db.retrieve()).getY() == 1);

        // test change color
        Color c2 = new Color(100,100,100);
        db.setColor(c2);
        assert(((AbstractShape) db.retrieve()).getColor() == c2);

        // test get copy
        assert(db.getCopy().size() == 2);

        System.out.println("Pass all unit tests");
    }
}