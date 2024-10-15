import java.lang.Math;
public class Demo{

  /*
  Write this method third. Test it then move on
  to the others.
  */
  public static double distance(Point a, Point b){
    return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
  }

  public static void main(String[]args){
    Point p1 = new Point(1,1);
    Point p2 = new Point(-1,-1);
    Point p3 = new Point(3,4);
    Point p4 = new Point(p3);
    System.out.println( p3);
    System.out.println( p4);
    System.out.println( distance(p1,p2));
    System.out.println( Point.distance(p1,p2));
    System.out.println( p1.distanceTo(p2));
    Point tri1 = new Point(0,0);
    Point tri2 = new Point(6,0);
    Point tri3 = new Point(3,Math.sqrt(27));
    System.out.println( tri1.distanceTo(tri2));
    System.out.println( tri1.distanceTo(tri3));
    System.out.println( tri2.distanceTo(tri3));

  }
}
