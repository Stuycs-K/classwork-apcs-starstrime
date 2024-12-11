import java.util.*;
import java.io.*;
public class day10{
  public static void main(String[] args) {
    int[][] map = parse("d10input.txt");
    // System.out.println(Arrays.deepToString(map));
    System.out.println(find(map));
  }
  public static int[][] parse(String filename){
    ArrayList<String> map = day1.parse(filename);
    int[][] finalMap = new int[map.size()][map.get(0).length()];
    for (int row = 0; row < finalMap.length; row++){
      for (int col = 0; col < finalMap[0].length; col++){
        finalMap[row][col] = Integer.parseInt(map.get(row).substring(col,col+1));
      }
    }
    return finalMap;
  }
  public static int seek(int[][] map, int[] coord, int target, ArrayList<String> accessed){
    int[] tempCoord;
    int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int score = 0;
    for (int i = 0; i < 4; i++){
      tempCoord = new int[]{coord[0]+move[i][0], coord[1]+move[i][1]};
      if (boundsTest(map, coord[0], coord[1], move[i][0], move[i][1]) && map[tempCoord[0]][tempCoord[1]] == target){
        if (target < 9){
         // System.out.println(Arrays.toString(tempCoord)+map[tempCoord[0]][tempCoord[1]]);
          score += seek(map, tempCoord, target+1, accessed);
        }else if (target == 9){
          accessed = new ArrayList<String>();
          if (accessed.indexOf(Arrays.toString(tempCoord)) < 0){
            accessed.add(Arrays.toString(tempCoord));
            // System.out.println(accessed);
            score++;
          }
        }
      }
    }
    return score;
  }
  public static boolean boundsTest(int[][] map, int row, int col, int i, int r){
    try {
      int m = map[row+i][col+r];
      return true;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }
  public static int find(int[][] map){
    int total = 0;
    ArrayList<String> accessed;
    for (int row = 0; row < map.length; row++){
      for (int col = 0; col < map[0].length; col++){
        if (map[row][col] == 0){
          accessed = new ArrayList<String>();
          total += seek(map, new int[]{row, col}, 1, accessed);
          accessed = new ArrayList<String>();
          // System.out.println(seek(map, new int[]{row, col}, 1, accessed) + " added to total. total now at " + total);
        }
      }
    }
    return total;
  }
}