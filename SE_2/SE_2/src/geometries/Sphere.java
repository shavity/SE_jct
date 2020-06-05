package geometries;

import primitives.Point_3D;
import primitives.Vector;

/**
 * class sphere is representing a hollow ball like the atmosphere
 */

public class Sphere extends RadialGeometry
{
    private Point_3D center;

    /**
     * Sphere constructor
     * @param p Point_3D the location of the center of the sphere
     * @param r double the radius of the sphere
     */

    public Sphere (Point_3D p, double r)
    {
        super(r);
        this.center = p;
    }

    /**
     * Point_3D getter
     * @return center of the sphere
     */

    public Point_3D getCenter()
    {
        return center;
    }

    @Override
    public Vector getNormal(Point_3D p)
    {
        /**
         * בעיקון לא צריך לעשות בדיקה שהנקודה תקינה
         */
         return new Vector(p.subtract(center));
    }
}
