package geometries;

import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

public class Tube extends RadialGeometry
{
    private Ray center;

    public Tube(Ray r, double d)
    {
        super(d);
        this.center = r;
    }

    public Ray getCenter()
    {
        return center;
    }

    @Override
    public Vector getNormal(Point_3D p)
    {
        return null;
    }
}
