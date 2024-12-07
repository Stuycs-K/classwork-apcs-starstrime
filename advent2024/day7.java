import java.util.*;
import java.io.*;
public class day7{
  public static void main(String[] args) {
    double[][] output = parse("d7input.txt");
    // System.out.println(Arrays.deepToString(output));
    System.out.println(solve(output));
  }
  public static double[][] parse(String filename){
    ArrayList<String> input = day1.parse(filename);
    String[] temp;
    double[][] output = new double[input.size()][];
    for (int i = 0; i < input.size(); i++){
      temp = input.get(i).split(" ");
      temp[0] = temp[0].substring(0,temp[0].length()-1);
      output[i] = parseDoubleArray(temp);
    }
    return output;
  }
  public static double[] parseDoubleArray(String[] input){
    double[] output = new double[input.length];
    for (int i = 0; i < input.length; i++){
      output[i] = Double.parseDouble(input[i]);
    }
    return output;
  }
  public static double test(double target, double[] list){
    double total = 0;
    ArrayList<Boolean> act = new ArrayList<Boolean>(list.length-1);
    for (int i = 0; i < list.length-1; i++){
      act.add(false);
    }
    for (int i = 0; i <= (Math.pow(2, act.size())); i++){
      total = list[0];
      for (int r = 0; r < act.size(); r++){
        if (act.get(r)){
          total += list[r+1];
        }else{
          total *= list[r+1];
        }
      }
      // System.out.print(total);
      // System.out.println(" " + act);
      if (total == target){
        return total;
      }else{
        inc(act);
      }
    }
    return 0;
  }
  public static void inc(ArrayList<Boolean> arr){
    boolean flag = true;
    int i = 0;
    while (flag && i < arr.size()){
      if (arr.get(i) == false){
        arr.set(i, true);
        flag = false;
      }else{
        arr.set(i, false);
        i++;
      }
    }
  }
  public static double[] convert(double[] input){
    double[] output = new double[input.length-1];
    for (int i = 1; i < input.length; i++){
      output[i-1] = input[i];
    }
    return output;
  }
  public static double solve(double[][] input){
    double total = 0;
    for (double[] arr : input){
      total += test(arr[0], convert(arr));
    }
    return total;
  }
}