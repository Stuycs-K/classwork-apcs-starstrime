import java.util.*;
import java.io.*;
public class day9{
  public static void main(String[] args) {
    String input = day1.parse("d9input.txt").get(0);
    ArrayList<Long>output = convert(input);
    // System.out.print("[");
    // for (Long a : output){
    //   if (a == null){
    //     System.out.print("|, ");
    //   }else System.out.print(a + ", ");
    // }
    // System.out.println();
    output = move(output);
    // System.out.println(output);
    long fin = checksum(output);
    System.out.println(fin);
  }
  public static ArrayList<Long> convert(String input){
    ArrayList<Long> converted = new ArrayList<Long>();
    long count = 0;
    for (int i = 0; i < input.length(); i++){
      if (i % 2 == 0){
        for (int r = 0; r < input.charAt(i) - '0'; r++){
          converted.add(count);
        }
        count++;
      }else{
        for (int r = 0; r < input.charAt(i) - '0'; r++){
          converted.add(null);
        }
      }
    }
    return converted;
  }
  public static ArrayList<Long> move(ArrayList<Long> input){
    ArrayList<Long> fin = new ArrayList<Long>();
    for (int i = 0; i < input.size(); i++){
      if (input.get(i) == null){
        while (input.get(input.size()-1) == (null)){
          input.remove(input.size()-1);
        }
        fin.add(input.get(input.size()-1));
        input.remove(input.size()-1);
      }else{
        fin.add(input.get(i));
      }
    }
    return fin;
  }
  public static long checksum(ArrayList<Long> input){
    long sum = 0;
    for (int i = 0; i < input.size(); i++){
      sum += (i * (input.get(i)));
      // System.out.println(i + " * " + input.get(i) + " = " + (input.get(i) * i) + ". total is now " + sum);
    }
    return sum;
  }
}