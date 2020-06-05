package unittests;

import geometries.Plane;
import geometries.Tube;
import org.junit.Test;
import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class TubeTests {
    @Test
    public void testNormal()
    {
        Tube tube=new Tube(new Ray(new Vector(1,0,0),new Point_3D(0,0,0)),1);
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        assertEquals(tube.getNormal(new Point_3D(1,1,1)),new Vector(1,1,1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(tube.getNormal(new Point_3D(1,0,1)),new Vector(new Point_3D(1,0,1).subtract(new Point_3D(1,1,0))));
    }
}
