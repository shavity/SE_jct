package unittests;

import geometries.Plane;
import org.junit.Test;
import primitives.Point_3D;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class PlaneTests {

    @Test
    public void testNormal()
    {
        //check if get nurmal give the vector (because he was מנורמל)
        Plane testPlane = new Plane(new Vector(1, -2, 4), new Point_3D(0, 4, -1));
        assertEquals(testPlane.getNormal(new Point_3D(0, 4, -1)), new Vector(1, -2, 4).normalize());
    }
}

