import java.util.*;
import java.io.*;
public class day10{
  public static void main(String[] args) {
    int[][] map = parse("d10input.txt");
    System.out.println(Arrays.deepToString(map));
  }
  public static int[][] parse(String filename){
    ArrayList<String> map = day1.parse(filename);
    int[][] finalMap = new int[map.size()][map.get(0).length()];
    for (int row = 0; row < finalMap.length; row++){
      for (int col = 0; col < finalMap[0].length; col++){
        finalMap[row][col] = Integer.parseInt(map.get(row).charAt(col));
      }
    }
    return finalMap;
  }
}