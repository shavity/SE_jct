package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

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

    /**
     * Finds all the points of intersection of the given ray with the plane
     * @param ray The ray with which the cutting with the plane is calculated
     * @return All the points of intersection of the ray with the plane
     */

    @Override
    public List<Point_3D> findIntsersections(Ray ray)
    {
        List<Point_3D> list = new ArrayList<Point_3D>();
        Vector n = new Vector(this.v.normalized());   // normal vector 90 degree to the plane
        Vector v = new Vector(ray.getV());            // direction of ray
        Point_3D q0 = this.p;                         // point on the plane
        Point_3D p0 = ray.getP();                     // point on the plane
        // get a vector on the plane by two points on the plane
        if (isZero(n.dotProduct(v)))                     // if n is actually 90 degree to the plane
        {
            return list;
        }

        Vector v1 = p0.subtract(q0);
        v1.scale(1/(n.dotProduct(v)));
        double t = alignZero((n.scale(-1)).dotProduct(v1));
        Point_3D p = p0.add(v.scale(t));

        list.add(p);

        if ((p.subtract(ray.getP()).dotProduct(v)) < 0)
        {
            return new ArrayList<Point_3D>();
        }

        return list;
    }
}
