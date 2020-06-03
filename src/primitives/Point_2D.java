package primitives;

import java.util.Objects;

/**
 * Class 'Point-2D' is representing a dot on two-dimensional plane
 * for Cartesian Coordinate system.
 */
public class Point_2D
{
    private Coordinate x;
    private Coordinate y;

    /**
     * Point_2D constructor two Coordinates values, each for an axis
     * @param x for X axis
     * @param y for Y axis
     */

    public Point_2D(Coordinate x, Coordinate y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * default constructor for Point_2d, the point(dot) will be the first the hinges
     * (0, 0)
     */

    public Point_2D()
    {
        this.x = new Coordinate(0);
        this.y = new Coordinate(0);
    }

    /**
     * Point_2D constructor two double values, each for an axis
     * @param x for X axis
     * @param y for Y axis
     */

    public Point_2D(double x, double y)
    {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }

    /**
     * copy constructor for Point_2D
     * @param p2d
     */

    public Point_2D(Point_2D p2d)
    {
        this.x = p2d.x;
        this.y = p2d.y;
    }

    /**
     * Point_2D value getter
     * @return point coordinate
     */

    public Coordinate getX()
    {
        return x;
    }

    public void setX(Coordinate x)
    {
        this.x = x;
    }

    public Coordinate getY()
    {
        return y;
    }

    public void setY(Coordinate y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
        return x.toString() + ", " + y.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) // self
        {
            return true;
        }

        if (o == null || getClass() != o.getClass()) // type || null
        {
            return false;
        }
        Point_2D point_2D = (Point_2D) o;
        return x.equals(point_2D.x) && x.equals(point_2D.y);
    }
}
