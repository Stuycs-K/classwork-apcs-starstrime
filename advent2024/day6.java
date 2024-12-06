import java.util.*;
import java.io.*;
public class day6{
  public static void main(String[] args) {
    String[][] map = parse("d6input.txt");
    // System.out.println(Arrays.deepToString(map));
    System.out.println(path(map));
  }
  public static String[][] parse(String filename){
    ArrayList<String> layout = day1.parse(filename);
    String[][] fin = new String[layout.size()][];
    for (int i = 0; i < layout.size(); i++){
      fin[i] = layout.get(i).split("");
    }
    return fin;
  }
  public static int[] locate(String[][] map){
    for (int row = 0; row < map.length; row++){
      for (int col = 0; col < map[0].length; col++){
        if (map[row][col].equals("^")){
          return new int[]{row, col};
        }
      }
    }
    return new int[] {-1, -1};
  }
  public static int path(String[][] map){
    int[] coord = locate(map);
    System.out.println(Arrays.toString(coord));
    int direct = 0;
    int total = 1;
    int[][] move = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    boolean flag = true;
    ArrayList<ArrayList<Integer>> coordList = new ArrayList<ArrayList<Integer>>();
    coordList.add(day2.intAsList(coord));
    map[coord[0]][coord[1]] = ".";
    while (flag){
      if (map[coord[0] + move[direct][0]][coord[1]+move[direct][1]].equals("#")){
        direct++;
        direct %= 4;
      }
      else{
        coord[0] += move[direct][0];
        coord[1] += move[direct][1];
        // System.out.println(Arrays.toString(coord));
        if (coordList.indexOf(day2.intAsList(coord)) < 0){
          total++;
          coordList.add(day2.intAsList(coord));
        }
      }
      if (!boundsCheck(map, coord, move[direct])){
        flag = false;
      }
    }
    // System.out.println(coordList);
    return total;
  }
  public static boolean boundsCheck(String[][] map, int[] coord, int[] move){
    try {
      String test = map[coord[0] + move[0]][coord[1] + move[1]];
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}