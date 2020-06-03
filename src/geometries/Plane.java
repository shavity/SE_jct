package geometries;

import primitives.Vector;
import primitives.Point_3D;
import primitives.Coordinate;
import primitives.Point_2D;

public class Plane implements Geometry
{
    private Vector v;
    private Point_3D p;

    public Plane(Vector v, Point_3D p)
    {
        this.v = v;
        this.p = p;
    }

    public Plane (Plane pl)
    {
        this.p = pl.p;
        this.v = pl.v;
    }

    public Plane (Point_3D a, Point_3D b, Point_3D c)
    {
        this.p = a;
        this.v = a.subtract(b).crossProduct(a.subtract(c));
    }

    public Vector getV()
    {
        return v.normalized();
    }

    public void setV(Vector v)
    {
        this.v = v;
    }

    public Point_3D getP()
    {
        return p;
    }

    public void setP(Point_3D p)
    {
        this.p = p;
    }

    @Override
    public Vector getNormal(Point_3D p3d)
    {
        return v.normalized();
    }
}
