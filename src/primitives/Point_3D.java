package primitives;

import java.util.Objects;
import java.lang.Math;

public class Point_3D extends Point_2D
{
    public static Point_3D ZERO = new Point_3D(0, 0, 0);  //ראשית הצירים

    private Coordinate z;

    public Point_3D(Coordinate x, Coordinate y, Coordinate z)
    {
        super(x, y);
        this.z = z;
    }

    public Point_3D()
    {
        super(0d, 0d);
        this.z = new Coordinate(0);
    }

    public Point_3D(double x, double y, double z)
    {
        super(x, y);
        this.z = new Coordinate(z);
    }

    public Point_3D(Point_3D p3d)
    {
        super(p3d.getX(), p3d.getY());
        this.z = p3d.z;
    }

    public Coordinate getZ()
    {
        return z;
    }

    public void setZ(Coordinate z)
    {
        this.z = z;
    }

    @Override
    public String toString ()
    {
        return super.toString() + ", " + z.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Point_3D point_3D = (Point_3D) o;

        return point_3D.getX().equals(this.getX()) && point_3D.getY().equals(this.getY()) && point_3D.getZ().equals(this.getZ());
    }

    public Vector subtract(Point_3D p3d)
    {
        return new Vector(new Point_3D((-p3d.getX().get() + this.getX().get()), (-p3d.getY().get() + this.getY().get()), (-p3d.getZ().get() + this.getZ().get())));
    }

    public Point_3D add(Vector vec)
    {
        return new Point_3D((this.getX().get() + vec.getV().getX().get()), (this.getY().get() + vec.getV().getY().get()), (this.getZ().get() + vec.getV().getZ().get()));
    }

    public double distanceSquared (Point_3D p3d)
    {
        return ((this.getX().get() - p3d.getX().get()) * (this.getX().get() - p3d.getX().get())
                +
                ((this.getY().get() - p3d.getY().get()) * (this.getY().get() - p3d.getY().get()))
                +
                ((this.getZ().get() - p3d.getZ().get()) * (this.getZ().get() - p3d.getZ().get())));
    }

    public double distance (Point_3D p3d)
    {
        return Math.sqrt(this.distanceSquared(p3d));
    }
}
