package unittests;

import geometries.Cylinder;
import geometries.Sphere;
import org.junit.Test;
import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class SphereTests {
    @Test
    public void testNormal() {
        Sphere sphere = new Sphere(new Point_3D(0, 0, 0), 10);
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        assertEquals(sphere.getNormal(new Point_3D(1, 1, 1)), new Vector(1, 1, 1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(sphere.getNormal(new Point_3D(10, 0, 0)), new Vector(new Point_3D(10, 0, 0).subtract(new Point_3D(0, 0, 0))));
    }
}