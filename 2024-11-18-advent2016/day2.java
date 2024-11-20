import java.io.*;
import java.util.*;

public class day2{
  public static void main(String[] args) {
    System.out.println(solve(parse("inputD2.txt")));
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
        if input.get(indexA).charAt(indexB).equals("U"){

        }
      }
    }
    return pass;
  }
}
