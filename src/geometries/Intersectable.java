package geometries;

import primitives.Point_3D;
import primitives.Ray;

import java.util.List;

public interface Intersectable {
    List<Point_3D> findIntsersections(Ray ray);
}
