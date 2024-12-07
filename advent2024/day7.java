import java.util.*;
import java.io.*;
public class day7{
  public static void main(String[] args) {
    long[][] output = parse("d7input.txt");
    // System.out.println(Arrays.deepToString(output));
    System.out.println(solve(output));
  }
  public static long[][] parse(String filename){
    ArrayList<String> input = day1.parse(filename);
    String[] temp;
    long[][] output = new long[input.size()][];
    for (int i = 0; i < input.size(); i++){
      temp = input.get(i).split(" ");
      temp[0] = temp[0].substring(0,temp[0].length()-1);
      output[i] = parseLongArray(temp);
    }
    return output;
  }
  public static long[] parseLongArray(String[] input){
    long[] output = new long[input.length];
    for (int i = 0; i < input.length; i++){
      output[i] = Long.parseLong(input[i]);
    }
    return output;
  }
  public static long test(long target, long[] list){
    long total = 0;
    ArrayList<Integer> act = new ArrayList<Integer>(list.length-1);
    for (int i = 0; i < list.length-1; i++){
      act.add(0);
    }
    for (int i = 0; i <= (Math.pow(3, act.size())); i++){
      total = list[0];
      for (int r = 0; r < act.size(); r++){
        if (act.get(r) == 0){
          total += list[r+1];
        }else if (act.get(r) == 1){
          total *= list[r+1];
        }else if (act.get(r) == 2){
          total = concat(total, list[r+1]);
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
  public static void inc(ArrayList<Integer> arr){
    boolean flag = true;
    int i = 0;
    while (flag && i < arr.size()){
      if (arr.get(i) < 2){
        arr.set(i, arr.get(i) + 1);
        flag = false;
      }else{
        arr.set(i, 0);
        i++;
      }
    }
  }
  public static long[] convert(long[] input){
    long[] output = new long[input.length-1];
    for (int i = 1; i < input.length; i++){
      output[i-1] = input[i];
    }
    return output;
  }
  public static long solve(long[][] input){
    long total = 0;
    for (long[] arr : input){
      total += test(arr[0], convert(arr));
    }
    return total;
  }
  public static long concat(long a, long b){
    String tempA = ("" + a);
    String tempB = ("" + b);
    return(Long.parseLong(tempA+tempB));
  }
}