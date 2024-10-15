import java.lang.Math;
public class Point{
  private double x,y;

  public String toString(){
    return "(" + x + ", " + y + ")";
  }

  //Initialize this Point to have the same values as the other Point.
  public Point(Point other){
    this.x = other.x;
    this.y = other.y;
    //COMPLETE THIS SECOND
    //Then write test cases.
  }

  //Initialize this Point to have the provided values
  public Point(double x, double y){
    this.x=x;
    this.y=y;
  }
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }

  /*
  Write this method FOURTH, go to the main and do that one first.
  */
  public double distanceTo(Point other){
    double distance = 0;
    distance = Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));
    return distance;
  }

  /*
  Write this method last. Re-use (NOT COPY/PASTE) prior work and
  do not write redundant code.
  */
  public static double distance(Point a, Point b){
    return Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y),2));
  }


}
