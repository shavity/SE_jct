package geometries;

import primitives.*;

import java.util.List;

public interface Geometry
{
    public abstract Vector getNormal(Point_3D p3d);
    List<Point_3D> findIntsersections(Ray ray);
}
