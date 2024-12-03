import java.util.*;
import java.io.*;
public class day2{
  public static void main(String[] args){
    ArrayList<String> input = day1.parse("d2input.txt");
    // System.out.println(input);
    // System.out.println(solve(input));
    System.out.println(solve2(input));
  }
  public static int solve(ArrayList<String> input){
    int ans = 0;
    String[] current;
    for (int i = 0; i < input.size(); i++){
      current = input.get(i).split(" ");
      // System.out.println(Arrays.toString(current));
      if (safeCheck(parseIntArray(current))){
        ans++;
      }
    }
    return ans;
  }
  public static int[] parseIntArray(String[] input){
    int[] output = new int[input.length];
    for (int i = 0; i < input.length; i++){
      output[i] = Integer.parseInt(input[i]);
    }
    return output;
  }
  public static boolean safeCheck(int[] input){
    boolean increasing = (input[0] < input[1]);
    int inc;
    for (int i = 1; i < input.length; i++){
      inc = input[i]-input[i-1];
      if (Math.abs(inc) > 3){
        return false;
      }if (increasing){
        if (inc <= 0){
          return false;
        }
      }if (!increasing){
        if (inc >= 0){
          return false;
        }
      }
    }
    return true;
  }
  public static boolean safeCheckPlus(ArrayList<Integer> input){
    boolean increasing = (input.get(0) < input.get(1));
    int inc;
    for (int i = 1; i < input.size(); i++){
      inc = input.get(i) - input.get(i-1);
      if (Math.abs(inc) > 3){
        return false;
      }
      if (increasing){
        if (inc <= 0){
         return false;
        }
      }if (!increasing){
        if (inc >= 0){
         return false;
        }
      }
    }
    return true;
  }
  public static ArrayList<Integer> intAsList(int[] input){
    ArrayList<Integer> output = new ArrayList<Integer>(input.length);
    for (int i = 0; i < input.length; i++){
      output.add(input[i]);
    }
    return output;
  }
  public static int solve2(ArrayList<String> input){
    int ans = 0;
    String[] current;
    ArrayList<Integer> line, newLine;
    for (int i = 0; i < input.size(); i++){
      current = input.get(i).split(" ");
      // System.out.println(Arrays.toString(current));
      line = intAsList(parseIntArray(current));
      if (safeCheckPlus(line)){
        ans++;
      }
      else{
        for (int ind = 0; ind < line.size(); ind++){
          newLine = new ArrayList<Integer>(line);
          newLine.remove(ind);
          if (safeCheckPlus(newLine)){
            ans++;
            System.out.println(newLine);
            ind += 99;
          }
        }
      }
    }
    return ans;
  }
}