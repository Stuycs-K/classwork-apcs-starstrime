import java.util.*;
import java.io.*;
public class day1{
  public static void main(String[] args){
    System.out.println(solveP1(separate(parse("d1input.txt"))));
    
  }
  public static int[][] separate(ArrayList<String> input){
    int[][] output = new int[2][input.size()];
    String[] temp;
    for (int i = 0; i < input.size(); i++){
      temp = input.get(i).split("   ");
      output[0][i] = Integer.parseInt(temp[0]);
      output[1][i] = Integer.parseInt(temp[1]);
    }
    Arrays.sort(output[0]);
    Arrays.sort(output[1]);
    return output;
  }
  public static ArrayList<String> parse(String filename){
    ArrayList<String> output = new ArrayList<String>();
    try{
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        output.add(input.nextLine());
      }
      input.close();
      return output;
    }catch (Exception e){
      System.exit(1);
    }
    return null;
  }
  public static int solveP1(int[][] input){
    int ans = 0;
    for (int i = 0; i < input[0].length; i++){
      ans += Math.abs(input[0][i] - input[1][i]);
    }
    return ans;
  }
}