import java.util.*;
import java.io.*;
public class day8{
  public static void main(String[] args) {
    String[][] map = day6.parse("d8input.txt");
    System.out.println(solve(map));
  }
  public static int solve(String[][] map){
    int total = 0;
    ArrayList<String> nodes = new ArrayList<String>();
    for (int row = 0; row < map.length; row++){
      for (int col = 0; col < map[0].length; col++){
        if (!map[row][col].equals(".")){
          total += nodeCount(map, new int[]{row, col}, nodes);
        }
      }
    }
    return total;
  }
  public static int nodeCount(String[][] map, int[] point, ArrayList<String> nodes){
    int total = 0;
    int[] move, coord, finalCoord;
    String nodeString = "";
    for (int row = 0; row < map.length; row++){
      for (int col = 0; col < map[0].length; col++){
        coord = new int[]{row, col};
        if (map[row][col].equals(map[point[0]][point[1]])){
          move = new int[]{row - point[0], col - point[1]};
          if (!(row == (point[0]) && col == point[1])){
            if (nodes.indexOf(Arrays.toString(point)) == -1){
              total++;
              nodes.add(Arrays.toString(point));
            }
            while (day6.boundsCheck(map, coord, move)){
              finalCoord = new int[]{coord[0] + move[0], coord[1] + move[1]};
              nodeString = Arrays.toString(finalCoord);
              if (nodes.indexOf(nodeString) == -1){
                total++;
                nodes.add(nodeString);
              }
              coord[0] = finalCoord[0];
              coord[1] = finalCoord[1];
              // System.out.println(Arrays.toString(point) + Arrays.toString(coord) + Arrays.toString(move) + nodeString + nodes + " " );
            }
          }
        }
      }
    }
    // System.out.println(nodes);
    return total;
  }
}