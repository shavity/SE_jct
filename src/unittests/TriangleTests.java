package unittests;

import geometries.Plane;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TriangleTests {
    @Test
    public void testNormal() {
        Triangle triangle = new Triangle(new Point_3D(1, 0, 0), new Point_3D(0, 1, 0), new Point_3D(-1, 0, 0));
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        //assertEquals(triangle.getNormal(new Point_3D(1, 1, 1)), new Vector(1, 1, 1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(triangle.getNormal(new Point_3D(0, 0, 0)), new Vector(0, 0, 1));
    }

    @Test
    public void findIntsersections1() {
        Point_3D x = new Point_3D(-100, -100, -200);
        Point_3D y = new Point_3D(100, -100, -200);
        Point_3D z = new Point_3D(0, 100, -200);
        Triangle t = new Triangle(x, y, z);
        Vector v = new Vector(0, -1, -3);
        Point_3D point3D = new Point_3D(0, 0, 0);
        Point_3D point = t.findIntsersections(new Ray(v, point3D)).get(0);
        assertEquals(-66.6666, point.getY().get(), 0.01);
    }

    @Test
    public void findIntsersections2() {
        Point_3D x = new Point_3D(10, 10, 50);
        Point_3D y = new Point_3D(20, 50, -20);
        Point_3D z = new Point_3D(30, 40, -10);
        Triangle t = new Triangle(x, y, z);
        Vector v = new Vector(1, 5, 0);
        Point_3D point3D = new Point_3D(0, 0, 0);
        List<Point_3D> g = t.findIntsersections(new Ray(v, point3D));

        boolean flag = false;
        if (g.isEmpty())
            flag = true;

        assertEquals(flag, true);
    }

    @Test
    public void findIntsersections3() {
        Point_3D x = new Point_3D(0, 1, -2);
        Point_3D y = new Point_3D(-1, -1, -2);
        Point_3D z = new Point_3D(1, -1, -2);
        Triangle t = new Triangle(x, y, z);
        List<Point_3D> g = t.findIntsersections(new Ray(new Vector(1, 0, 0), Point_3D.ZERO));
        boolean flag = true;
        if (g.isEmpty())
            flag = false;

        assertEquals(flag, false);
    }
}
