package geometries;

import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube
{
    private double len;

    public Cylinder (Ray c,double l, double r)
    {
        super(c, r);
        this.len = l;
    }

    public double getLen()
    {
        return len;
    }

    @Override
    public Vector getNormal(Point_3D p)
    {
        return null;
    }
}
