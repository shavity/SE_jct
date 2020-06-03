package primitives;

import java.util.Objects;
import java.lang.Math;

public class Vector
{
    private Point_3D v;

    public Vector(Point_3D v)
    {
        if(v.equals(Point_3D.ZERO))
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point_3D(v);
    }

    public Vector(Vector vec)
    {
        this.v = vec.getV();
    }

    public Vector(Coordinate x, Coordinate y, Coordinate z)
    {
        if(x.equals(0d) && y.equals(0d) && z.equals(0d))
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point_3D(x, y, z);
    }

    public Vector(double x, double y, double z)
    {
        if(x == 0d && y == 0d && z == 0d)
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }
        this.v = new Point_3D(x,y,z);
    }

    public Point_3D getV()
    {
        return this.v;
    }

    public void setV(Point_3D v)
    {
        this.v = v;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return v.equals(vector.getV());
    }

    public Vector add(Vector vec)
    {
        return new Vector(this.v.add(vec));
    }

    public Vector subtract(Vector vec)
    {
        return new Vector(this.v.subtract(vec.v));
    }

    public Vector scale (double c)
    {
        return new Vector(this.v.getX().get() * c, this.v.getY().get() * c, this.v.getZ().get() * c);
    }

    public double dotProduct (Vector vec)
    {
        return this.v.getX().get() * vec.v.getX().get()
                +
                this.v.getY().get() * vec.v.getY().get()
                +
                this.v.getZ().get() * vec.v.getZ().get();
    }

    public Vector crossProduct (Vector vec)
    {
        return new Vector((this.v.getY().get() * vec.v.getZ().get()) - (this.v.getZ().get() * vec.v.getY().get()),
                (this.v.getZ().get() * vec.v.getX().get()) - (this.v.getX().get() * vec.v.getZ().get()),
                (this.v.getX().get() * vec.v.getY().get()) - (this.v.getY().get() * vec.v.getX().get()));
    }

    public double lengthSquared()
    {
        return this.v.distanceSquared(Point_3D.ZERO);
    }

    public double length()
    {
        return Math.sqrt(this.lengthSquared());
    }

    public Vector normalize()
    {
        this.v = new Point_3D((new Coordinate(this.v.getX().get() / this.length())), (new Coordinate(this.v.getY().get() / this.length())), (new Coordinate(this.v.getZ().get() / this.length())));

        return this;
    }

    public Vector normalized()
    {
        return  new Vector(new Point_3D(new Coordinate(this.v.getX().get() / this.length()),
                new Coordinate(this.v.getY().get() / this.length()),
                new Coordinate(this.v.getZ().get() / this.length())));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "v=" + v.toString() +
                '}';
    }
}