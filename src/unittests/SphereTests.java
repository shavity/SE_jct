package unittests;

import geometries.Cylinder;
import geometries.Sphere;
import org.junit.Test;
import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SphereTests {
    @Test
    public void testNormal() {
        Sphere sphere = new Sphere(new Point_3D(0, 0, 0), 10);
        /**
         * chek if get nurmal know if the point is ok (here is not ok)
         * */
        //assertEquals(sphere.getNormal(new Point_3D(1, 1, 1)), new Vector(1, 1, 1));
        /**
         * chek if get nurmal know if the point is ok (here is ok)
         * */
        assertEquals(sphere.getNormal(new Point_3D(10, 0, 0)), new Vector(new Point_3D(10, 0, 0).subtract(new Point_3D(0, 0, 0))));
    }
    @Test
    public void testFindIntsersections1()
    {
        Sphere sphere=new Sphere(new Point_3D(0,0,3),1);
        Ray ray=new Ray(new Vector(0,0,1),new Point_3D(0,0,0));
        ArrayList<Point_3D> arrayList = new ArrayList<>();
        arrayList.add(new Point_3D(0,0,2));
        arrayList.add(new Point_3D(0,0,4));
        assertEquals(sphere.findIntsersections(ray),arrayList);
    }

    @Test
    public void testFindIntsersections2() {
        Sphere s=new Sphere(new Point_3D(20,20,0),10);
        Ray ray=new Ray(new Vector(1,1,0),new Point_3D(0,0,0));
        List<Point_3D> g=s.findIntsersections(ray);
        if(g.isEmpty())
            System.out.println("is empty!");

        System.out.println(g.get(0));
        System.out.println(g.get(1));

        assertEquals(12.93,g.get(0).getX().get(),0.01);
        assertEquals(27.07,g.get(1).getX().get(),0.01);
    }

    @Test
    public void testFindIntsersections3() {
        Sphere s=new Sphere(new Point_3D(0,0,0),10);
        Ray ray=new Ray(new Vector(1,1,0),new Point_3D(0,0,0));
        List<Point_3D> g=s.findIntsersections(ray);
        if(g.isEmpty())
            System.out.println("is empty!");

        System.out.println(g.get(0));

        assertEquals(7.07,g.get(0).getX().get(),0.01);
    }

    @Test
    public void testFindIntsersections4() {
        Sphere s=new Sphere(new Point_3D(20,20,0),10);
        Ray ray=new Ray(new Vector(10,1,0),new Point_3D(0,0,0));
        List<Point_3D> g=s.findIntsersections(ray);
        String a = new String();
        if(g.isEmpty()) {
            a = new String("is empty!");
        }

        assertEquals(a,"is empty!");
    }
}