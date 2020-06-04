package unittests;

import geometries.Plane;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point_3D;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class TriangleTests {
    @Test
    public void testNormal()
    {
        Triangle triangle = new Triangle(new Point_3D(1, 0, 0), new Point_3D(0, 1, 0),new Point_3D(-1,0,0));
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        assertEquals(triangle.getNormal(new Point_3D(1,1,1)),new Vector(1,1,1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(triangle.getNormal(new Point_3D(0,0,0)),new Vector(0,0,1));
    }
}
