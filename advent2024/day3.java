import java.util.*;
import java.io.*;
public class day3{
  public static void main(String[] args) {
    ArrayList<String> input = day1.parse("d3input.txt");
    String inputString = input.get(0) + input.get(1) + input.get(2) + input.get(3) + input.get(4) + input.get(5);
    //System.out.println(inputString);
    //System.out.println(input);
    System.out.println(detect(input.get(0))+detect(input.get(1))+detect(input.get(2))+detect(input.get(3))+detect(input.get(4))+detect(input.get(5)));
    System.out.println(detect(inputString));
  }
  public static int detect(String input){
    int sum = 0;
    int temp1;
    boolean skip;
    String val = "";
    for (int i = 0; i < input.length()-4; i++){
      if (input.substring(i,i+4).equals("mul(")){
        skip = true;
        //System.out.println("detected");
        i+=4;
        //System.out.println(input.substring(i));
        while (numDetect(input.substring(i,i+1)) && !input.substring(i,i+1).equals(",")){
          val += input.substring(i,i+1);
          i++;
        }
        if (!input.substring(i,i+1).equals(",") && !numDetect(input.substring(i,i+1))){
          //System.out.println("numnowork");
          val = "0";
          skip = false;
        }
        temp1 = Integer.parseInt(val);
        val = "";
        if (skip){
          i++;
        }
        while (skip && !input.substring(i,i+1).equals(")") && numDetect(input.substring(i,i+1))){
          val += input.substring(i,i+1);
          i++;
        }
        if (!input.substring(i,i+1).equals(")") && !numDetect(input.substring(i,i+1))){
          //System.out.println("numnowork");
          val = "0";
        }else{
          if (!numDetect(val)){
            val = "0";
          }
          sum += temp1 * Integer.parseInt(val);
          if (temp1 == 308){
             System.out.println(val);
          }
          //System.out.println("" + temp1 + " " + val + " " + sum);
          val = "";
          temp1 = 0;
        }
      }
    }
    return sum;
  }
  public static boolean numDetect(String input){
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}