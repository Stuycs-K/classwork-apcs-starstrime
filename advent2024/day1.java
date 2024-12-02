import java.util.*;
import java.io.*;
public class day1{
  public static void main(String[] args){
    System.out.println(parse("d1input.txt"));
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
}