package geometries;

import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sphere extends RadialGeometry
{
    private Point_3D center;

    public Sphere (Point_3D p, double r)
    {
        super(r);
        this.center = p;
    }

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

    @Override
    public List<Point_3D> findIntsersections(Ray ray) {
        ArrayList<Point_3D> arrayList=new ArrayList<>();
        Vector L=new Vector(center.subtract(ray.getP()));
        double tm=L.dotProduct(ray.getV());
        double d=Math.sqrt(Math.pow(L.length(),2)-Math.pow(tm,2));
        if (d>getRadius())
        {
            return arrayList;
        }
        double th=Math.sqrt(Math.pow(getRadius(),2)-Math.pow(d,2));
        System.out.println(tm);
        System.out.println(th);

        Point_3D point_3D;
        point_3D=ray.getP().add(ray.getV().scale(Math.abs(tm-th)));
        arrayList.add(point_3D);
        Point_3D point_3D1=ray.getP().add(ray.getV().scale(tm+th));
        if (point_3D==point_3D1 || L.length()<getRadius())
        {
            return arrayList;
        }
        arrayList.add(point_3D1);
        return arrayList;
    }
}
