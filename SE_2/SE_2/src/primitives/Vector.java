package primitives;

import java.util.Objects;
import java.lang.Math;

/**
 * class Vector is represent a vector between two Point_3D, one any Point_3D, second (0, 0, 0)
 */

public class Vector
{
    private Point_3D v;

    /**
     * one point is enough because its from (0, 0, 0)
     * @param v Point_3D destination of the vector
     */

    public Vector(Point_3D v)
    {

        /**
         * check for valuable vector
         */

        if(v.equals(Point_3D.ZERO))
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point_3D(v);
    }

    /**
     * copy constructor
     * @param vec av vector to copy from
     */

    public Vector(Vector vec)
    {
        this.v = vec.getV();
    }

    /**
     * Vector constructor three Coordinate values
     * @param x for axis x
     * @param y for axis y
     * @param z for axis z
     */

    public Vector(Coordinate x, Coordinate y, Coordinate z)
    {

        /**
         * check for valuable vector
         */

        if(x.equals(0d) && y.equals(0d) && z.equals(0d))
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }

        this.v = new Point_3D(x, y, z);
    }

    /**
     * Vector constructor three double values
     * @param x for axis x
     * @param y for axis y
     * @param z for axis z
     */

    public Vector(double x, double y, double z)
    {

        /**
         * check for valuable vector
         */

        if(x == 0d && y == 0d && z == 0d)
        {
            throw new IllegalArgumentException("Error - Vector 0");
        }
        this.v = new Point_3D(x,y,z);
    }

    /**
     * Vector getter value
     */

    public Point_3D getV()
    {
        return this.v;
    }

    public void setV(Point_3D v)
    {
        this.v = v;
    }

    /**
     * check two things, first, is 'this' have value
     * second, is the object is just like 'this'
     * @param o an Object type (also may be Vector)
     * @return true if they are equal, else false
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return v.equals(vector.getV());
    }

    /**
     * calculate new Vector to combine two Vectors as one
     * @params vec second vector to add it to ours
     * @return the sum of this two vectors (Vector)
     */

    public Vector add(Vector vec)
    {
        return new Vector(this.v.add(vec));
    }

    /**
     * calculate the differance between two Vectors
     * @params vec secod vector to calc the differane
     * @return differance (Vector)
     */

    public Vector subtract(Vector vec)
    {
        return new Vector(this.v.subtract(vec.v));
    }

    /**
     * calculate the multipalction between Vector and a scale (number)+
     * @params c the scale to multiplay with
     * @return multiplaction (Vector)
     */

    public Vector scale (double c)
    {
        Coordinate x = new Coordinate(this.v.getX().get() * c);
        Coordinate y = new Coordinate(this.v.getY().get() * c);
        Coordinate z = new Coordinate(this.v.getZ().get() * c);

        Point_3D p = new Point_3D(x, y, z);

        this.v = p;

        return this;
    }

    /**
     * calculate a number out of two vectors to get the value that comes out of '*' multiplaction
     * @params vec Vector to multiplay with
     * @return the multiplaction (double)
     */

    public double dotProduct (Vector vec)
    {
        return this.v.getX().get() * vec.v.getX().get()
                +
                this.v.getY().get() * vec.v.getY().get()
                +
                this.v.getZ().get() * vec.v.getZ().get();
    }

    /**
     * calculate a vector out of two vectors to get the value that comes out of'x' multiplaction
     * @params vec Vector to multiplay with
     * @return the multiplaction (Vector)
     */

    public Vector crossProduct (Vector vec)
    {
        return new Vector((this.v.getY().get() * vec.v.getZ().get()) - (this.v.getZ().get() * vec.v.getY().get()),
                (this.v.getZ().get() * vec.v.getX().get()) - (this.v.getX().get() * vec.v.getZ().get()),
                (this.v.getX().get() * vec.v.getY().get()) - (this.v.getY().get() * vec.v.getX().get()));
    }

    /**
     * a build up function to calculate the length of a vector
     * @returns double (length of vector) ^ (2)
     */

    public double lengthSquared()
    {
        return this.v.distanceSquared(Point_3D.ZERO);
    }

    /**
     * calculate the lengtj of a vector
     * @return double length
     */

    public double length()
    {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * calculate and change the vector in to a normalize vector
     * @return Vector as normal
     */

    public Vector normalize()
    {
        this.v = new Point_3D((new Coordinate(this.v.getX().get() / this.length())), (new Coordinate(this.v.getY().get() / this.length())), (new Coordinate(this.v.getZ().get() / this.length())));

        return this;
    }

    /**
     * claculate a new vector that will be the normal vector of 'this' Vector
     * @return Vector as normal
     */

    public Vector normalized()
    {
        return  new Vector(new Point_3D(new Coordinate(this.v.getX().get() / this.length()),
                new Coordinate(this.v.getY().get() / this.length()),
                new Coordinate(this.v.getZ().get() / this.length())));
    }

    /**
     * casting the value of Vector to a String to represnt it as a String
     * @return String of a vector
     */

    @Override
    public String toString() {
        return "Vector{" +
                "v=" + v.toString() +
                '}';
    }
}