package geometries;

import primitives.Point_3D;
import primitives.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle extends Polygon
{
    public Triangle(Point_3D p1, Point_3D p2, Point_3D p3)
    {
        super(p1, p2, p3);
    }
    public ArrayList<Point_3D> getPoints()
    {
        ArrayList<Point_3D> list=new ArrayList<Point_3D>();
        list.add(this._vertices.get(0));
        list.add(this._vertices.get(1));
        list.add(this._vertices.get(2));
        return list;
    }
    @Override
    public Vector getNormal(Point_3D point) {
        /**
         * בעיקון לא צריך לעשות בדיקה שהנקודה תקינה
         * */
        Vector v1 = this._vertices.get(1).subtract(this._vertices.get(0));
        Vector v2 = this._vertices.get(2).subtract(this._vertices.get(0));
        return (v1.crossProduct(v2).normalize());
    }
}
