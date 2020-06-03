package geometries;

import primitives.Point_3D;
import primitives.Vector;

public class Sphere extends RadialGeometry
{
    private Point_3D center;

    public Sphere (Point_3D p, double r)
    {
        super(r);
        this.center = p;
    }

    public Point_3D getCenter()
    {
        return center;
    }

    @Override
    public Vector getNormal(Point_3D p)
    {
        return null;
    }
}
