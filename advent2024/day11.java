import java.util.*;
import java.io.*;
public class day11{
  public static void main(String[] args) {
    String[] parsed = day1.parse("d11input.txt").get(0).split(" ");
    List<String> temp = Arrays.asList(parsed);
    ArrayList<String> input = new ArrayList<String>(temp);
    System.out.println(input);
    System.out.println(blink(input, 75));
  }
  public static int blink(ArrayList<String> input, int loops){
    String temp;
    for (int i = 0; i < loops; i++){
      for (int r = 0; r < input.size(); r++){
        if (input.get(r).equals("0")){
          input.set(r, "1");
        }
        else if (input.get(r).length() % 2 == 0){
          temp = input.get(r);
          input.add(r, Long.parseLong(temp.substring(0, temp.length()/2)) + "");
          input.add(r+1, Long.parseLong(temp.substring(temp.length()/2)) + "");
          input.remove(r+2);
          r++;
        }
        else{
          input.set(r, Long.parseLong(input.get(r)) * 2024 + "");
        }
      }
      // System.out.println(input);
      System.out.println(input.size() + " on loop " + (i + 1) + "/" + loops);
    }
    return input.size();
  }
}