import java.util.*;
import java.io.*;
public class day9{
  public static void main(String[] args) {
    String input = day1.parse("d9input.txt").get(0);
    // System.out.println(convert2(input));
    // System.out.println(move2(convert2(input)));
    System.out.println(checksum(move2(convert2(input))));
    // ArrayList<Integer>output = convert(input);
    // System.out.println(output);
    // output = move(output);
    // System.out.println(output);
    // long fin = checksum(output);
    // System.out.println(fin);
  }
  public static ArrayList<Integer> convert(String input){
    ArrayList<Integer> converted = new ArrayList<Integer>();
    int count = 0;
    for (int i = 0; i < input.length(); i++){
      if (i % 2 == 0){
        for (int r = 0; r < input.charAt(i) - '0'; r++){
          converted.add(count);
        }
        count++;
      }else{
        for (int r = 0; r < input.charAt(i) - '0'; r++){
          converted.add(-1);
        }
      }
    }
    return converted;
  }
  public static ArrayList<Integer> move(ArrayList<Integer> input){
    ArrayList<Integer> fin = new ArrayList<Integer>();
    for (int i = 0; i < input.size(); i++){
      if (input.get(i) == null || input.get(i) == -1){
        while (input.get(input.size()-1) == (null) || input.get(input.size()-1) == -1){
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
  public static long checksum(ArrayList<Integer> input){
    long sum = 0;
    long offset = 0;
    for (int i = 0; i < input.size(); i++){
      while (i < input.size() && (input.get(i) == null || input.get(i) == -1)){
        i++;
        offset++;
        // System.out.println("SKIPPEDDDDD AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + sum);
      }
      if (i < input.size()){
        sum += ((i-offset) * (input.get(i)));
        // System.out.println(i + " * " + input.get(i) + " = " + (input.get(i) * i) + ". total is now " + sum);
      }
    }
    return sum;
  }
  public static ArrayList<ArrayList<Integer>> convert2(String input){
    ArrayList<ArrayList<Integer>> converted = new ArrayList<ArrayList<Integer>>();
    int count = 0;
    ArrayList<Integer> temp;
    for (int i = 0; i < input.length(); i++){
      temp = new ArrayList<Integer>();
      if (i % 2 == 0){
        for (int r = 0; r < input.charAt(i) - '0'; r++){
          temp.add(count);
        }
        converted.add(temp);
        count++;
      }else{
        converted.add(createFreeList(input.charAt(i)-'0'));
      }
    }
    return converted;
  }
  public static ArrayList<Integer> createFreeList(int size){
    ArrayList<Integer> output = new ArrayList<Integer>();
    for (int i = 0; i < size; i++){
      output.add(-1);
    }
    return output;
  }
  public static ArrayList<Integer> move2(ArrayList<ArrayList<Integer>> input){
    ArrayList<Integer> temp;
    boolean flag;
    for (int i = 0; i < input.size(); i++){
      // System.out.println(input);
      if (input.get(input.size()-(i+1)).size() > 0 && input.get(input.size()-(i+1)).get(0) != -1){
        temp = input.get(input.size()-(i+1));
        // System.out.println(temp);
        for (int r = 0; r < input.size() && (input.size()-i) > r; r++){
          if (input.get(r).size() > 0 && input.get(r).get(0) == -1 && input.get(r).size() >= temp.size()){
            // System.out.println(input + "begin");
            input.add(r, createFreeList(input.get(r).size() - temp.size()));
            // System.out.println(input + "free section added");
            input.remove(r+1);
            // System.out.println(input + "previous free section removed");
            input.add(r, temp);
            // System.out.println(input + "shifted large segment over");
            input.set(input.size()-(i+1), createFreeList(input.get(input.size()-(i+1)).size()));
            // System.out.println(input + "replaced segment with free space");
            flag = true;
            for (int loop = 0; loop < input.size(); loop++){ // deletes empty lists
              if (input.get(loop).size() == 0){
                input.remove(loop);
                loop--;
                if (flag){
                  i--;
                  flag = false;
                }
              }
            }
            i++;
            // System.out.println(input);
            r += 99999;
          }
        }
      }
    }
    ArrayList<Integer> finList = new ArrayList<Integer>();
    for (int i = 0; i < input.size(); i++){
      for (int r = 0; r < input.get(i).size(); r++){
        finList.add(input.get(i).get(r));
      }
    }
    return finList;
  }
}