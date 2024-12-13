import java.util.*;
import java.io.*;
public class day12{
  public static void main(String[] args) {
    ArrayList<String> map = day1.parse("d12input.txt");
    System.out.println(solve(map));
  }
  public static int solve(ArrayList<String> map){
    ArrayList<String> points = new ArrayList<String>();
    ArrayList<String> tempPoints = new ArrayList<String>();
    int[] coord;
    int area, perimeter;
    String coordString;
    int total = 0;
    for (int row = 0; row < map.size(); row++){
      for (int col = 0; col < map.get(row).length(); col++){
        coord = new int[]{row, col};
        coordString = Arrays.toString(coord);
        if (points.indexOf(coordString) < 0){
          tempPoints.add(coordString);
          tempPoints = findArea(map, tempPoints, coord, map.get(row).charAt(col));
          area = tempPoints.size();
          perimeter = findPerim(map, tempPoints, map.get(row).charAt(col));
          points.addAll(tempPoints);
          tempPoints.clear();
          // System.out.println(area + " * " + perimeter);
          total += area * perimeter;
        }
      }
    }
    return total;
  }
  public static ArrayList<String> findArea(ArrayList<String> map, ArrayList<String> points, int[] coord, char target){
    int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int[] pos = new int[2];
    int[] newpos = new int[2];
    int sizeCheck = 0;
    boolean flag = true;
    String[] step;
    ArrayList<String> temp2 = new ArrayList<String>(points);
    while (flag){
      points.clear();
      points.addAll(temp2);
      sizeCheck = points.size();
      for (String point : points){
        step = point.split(", ");
        pos[0] = Integer.parseInt(step[0].substring(1));
        pos[1] = Integer.parseInt(step[1].substring(0, step[1].length()-1));
        for (int i = 0; i < 4; i++){
          newpos = new int[]{pos[0] + move[i][0], pos[1] + move[i][1]};
          if (day4.boundsTest(map, pos[0], pos[1], -move[i][0], -move[i][1]) && map.get(newpos[0]).charAt(newpos[1]) == target){
            if (temp2.indexOf(Arrays.toString(newpos)) < 0){
              temp2.add(Arrays.toString(newpos));
            }
          }
        }
      }
      if (sizeCheck == temp2.size()){
        flag = false;
      }
    }
    points.clear();
    points.addAll(temp2);
    return points;
  }
  public static int findPerim(ArrayList<String> map, ArrayList<String> points, char target){
    int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int[] pos = new int[2];
    int[] newpos = new int[2];
    int total = 0;
    String[] step;
    for (String point : points){
      step = point.split(", ");
      pos[0] = Integer.parseInt(step[0].substring(1));
      pos[1] = Integer.parseInt(step[1].substring(0, step[1].length()-1));
      for (int i = 0; i < 4; i++){
        newpos = new int[]{pos[0] + move[i][0], pos[1] + move[i][1]};
        if (!day4.boundsTest(map, pos[0], pos[1], -move[i][0], -move[i][1]) || (day4.boundsTest(map, pos[0], pos[1], -move[i][0], -move[i][1]) && map.get(newpos[0]).charAt(newpos[1]) != target)){
          total++;
        }
      }
    }
    return total;
  }
}