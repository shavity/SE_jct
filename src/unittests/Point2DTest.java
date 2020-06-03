package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point_2D;
import primitives.Coordinate;;


public class Point2DTest {

    @Test
    public void test() {
        Point_2D p1 = new Point_2D(new Coordinate(1.0d),new Coordinate(2.0d));
        /**
         check that p1 x = what we insert to him
         */
        assertEquals(p1.getX(),new Coordinate(1.0d));
        /**
         check that p1 y = what we insert to him
         */
        assertEquals(p1.getY(),new Coordinate(2.0d));
        p1.setX(new Coordinate(10));
        p1.setY(new Coordinate(15));
        /**
         check that p1 x = what we change to him
         */
        assertEquals(p1.getX(),new Coordinate(10.0d));

        /**
         check that p1 y = what we change to him
         */
        assertEquals(p1.getY(),new Coordinate(15.0d));
    }

}