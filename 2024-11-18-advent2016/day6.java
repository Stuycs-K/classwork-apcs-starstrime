import java.util.*;
import java.io.*;

public class day6{
  public static void main(String[] args) {
    System.out.println(rotate(parse("inputD6.txt")));
  }
  public static ArrayList<String> parse(String filename){ //code copied from day2
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
  public static ArrayList<String> rotate(ArrayList<String> input){
    ArrayList<String> output = new ArrayList<String>();
   // System.out.println(input);
    for (int i = 0; i < input.get(0).length(); i++){
      output.add("");
    }
    for (int row = 0; row < input.get(0).length(); row++){
      for (int column = 0; column < input.size(); column++){
        output.set(row, output.get(row) + input.get(column).charAt(row));
        //System.out.println(output);
      }
    }
    return output;
  }
}