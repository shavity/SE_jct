package geometries;

import primitives.Vector;
import primitives.Point_3D;
import primitives.Coordinate;
import primitives.Point_2D;

/**
 * class Plane is represnting a plane in three-dimentional space
 * of cartesian coordinate system
 */

public class Plane implements Geometry
{
    private Vector v;
    private Point_3D p;

    /**
     * Plane constructor
     * @param v 90 degrees vector for the plane
     * @param p point on the plane
     */

    public Plane(Vector v, Point_3D p)
    {
        this.v = v;
        this.p = p;
    }

    /**
     * copy constructor
     * @param pl Plane to copy from
     */

    public Plane (Plane pl)
    {
        this.p = pl.p;
        this.v = pl.v;
    }

    /**
     * constructor by three points on the Plane
     * @param a point that starts two vectors on the Plane, and the point on the plane
     * @param b point that it is the destination of one of the vector
     * @param c point that it is the destination of the other
     */

    public Plane (Point_3D a, Point_3D b, Point_3D c)
    {
        this.p = a;
        this.v = a.subtract(b).crossProduct(a.subtract(c));
    }

    /**
     * Vector getter, get the 90 degrees vector of te plane as normal
     * @return normal vector
     */

    public Vector getV()
    {
        return v.normalized();
    }

    public void setV(Vector v)
    {
        this.v = v;
    }

    /**
     * Point_3D getter, get the point that on the plane
     * @return Point_3D
     */

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
        return v.normalize();
    }
}
