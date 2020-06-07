package geometries;

import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Tube extends RadialGeometry
{
    private Ray center;

    public Tube(Ray r, double d)
    {
        super(d);
        this.center = r;
    }

    public Ray getCenter()
    {
        return center;
    }

    @Override
    public Vector getNormal(Point_3D point) {
        /**
         * בעיקון לא צריך לעשות בדיקה שהנקודה תקינה
         *מסובך מדי נשלים בהמשך
         *  */
        return null;
    }

    @Override
    public List<Point_3D> findIntsersections(Ray ray) {
        return null;
    }
}
