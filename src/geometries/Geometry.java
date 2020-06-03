package geometries;

import primitives.Point_3D;
import primitives.Vector;
import primitives.Point_2D;
import primitives.Coordinate;

public interface Geometry
{
    public abstract Vector getNormal(Point_3D p3d);
}
