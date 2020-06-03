package primitives;

import java.util.Objects;

public class Ray
{
    private Vector v;
    private Point_3D p;

    public Ray(Vector v, Point_3D p)
    {
        this.v = v;
        this.p = p;
    }

    public Ray (Ray r)
    {
        this.p = r.p;
        this.v = r.v;
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
    public String toString()
    {
        return v.toString() + ' ' + p.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Ray ray = (Ray) o;

        return this.v.equals(ray.v) && this.p.equals(ray.p);
    }
}
