import java.io.*;
import java.util.*;

public class day2{
  public static void main(String[] args) {
    System.out.println(solve2(parse("inputD2.txt")));
  }
  public static ArrayList<String> parse(String filename){
    ArrayList<String> output = new ArrayList<String>();
    try{
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        output.add(input.nextLine());
      }
      return output;
    }catch (Exception e){
      System.exit(1);
    }
    return null;
  }
  public static String solve(ArrayList<String> input){
    String pass = "";
    int[] coord = new int[]{1,1};
    int[][] code = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    for (int indexA = 0; indexA < input.size(); indexA++){
      for (int indexB = 0; indexB < input.get(indexA).length(); indexB++){
        if (input.get(indexA).charAt(indexB)=='U'){
          coord[0]--;
        }if (input.get(indexA).charAt(indexB)=='D'){
          coord[0]++;
        }if (input.get(indexA).charAt(indexB)=='L'){
          coord[1]--;
        }if (input.get(indexA).charAt(indexB)=='R'){
          coord[1]++;
        }
        returnBounds(coord);
      }
      System.out.println(Arrays.toString(coord));
      pass += code[coord[0]][coord[1]];
      System.out.println(pass);
    }
    return pass;
  }
  public static void returnBounds(int[] coord){
    for (int i = 0; i < coord.length; i++){
      if (coord[i] < 0){
        coord[i] = 0;
      }
      if (coord[i] > 2){
        coord[i] = 2;
      }
    }
  }
  public static String solve2(ArrayList<String> input){
    String ans = "";
    int[] coord = new int[]{2,0};
    String[][] pass = new String[][]{{null,null,"D",null,null},{null,"A","B","C",null},{"5","6","7","8","9"},{null,"2","3","4",null},{null,null,"1",null,null}};
    for (int indexA = 0; indexA < input.size(); indexA++){
      for (int indexB = 0; indexB < input.get(indexA).length(); indexB++){
        char var = input.get(indexA).charAt(indexB);
        if (var=='U'){
          coord[0]++;
        }if (var=='D'){
          coord[0]--;
        }if (var =='L'){
          coord[1]--;
        }if (var=='R'){
          coord[1]++;
        }
        returnBounds2(coord, pass, var);
      }
      System.out.println(Arrays.toString(coord));
      ans += pass[coord[0]][coord[1]];
      System.out.println(ans);
    }
    return ans;
  }
  public static void returnBounds2(int[] coord, String[][] bounds,char letter){
    for (int i = 0; i < coord.length; i++){
      if (coord[i] < 0){
        coord[i] = 0;
      }
      if (coord[i] > 4){
        coord[i] = 4;
      }
    }
    String nullTest = bounds[coord[0]][coord[1]];
    if (nullTest == null){
      if (letter=='U'){
        coord[0]--;
      }if (letter=='D'){
        coord[0]++;
      }if (letter =='L'){
        coord[1]++;
      }if (letter=='R'){
        coord[1]--;
      }
    }
  }
}
