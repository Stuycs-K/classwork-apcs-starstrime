import java.util.*;
import java.io.*;

public class day6{
  public static void main(String[] args) {
    System.out.println(solve(rotate(parse("inputD6.txt"))));
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

  public static int maxValue(int[] input){ //code from d4
    int highest = input[0];
    int index = 0;
    for (int i = 0; i < input.length; i++){
     if (input[i] > highest){
        highest = input[i];
        index = i;
      }
    }
    return index;
  }

	public static int minValue(int[] input){ //code from d4
    int lowest = input[0];
    int index = 0;
    for (int i = 0; i < input.length; i++){
     if (input[i] < lowest){
        lowest = input[i];
        index = i;
      }
    }
    return index;
  }

  public static String solve(ArrayList<String> file){
    String result = ""; //most of this code is also stolen from day 4
    String[] alphabet = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    int[] letterTracker = new int[26];
    String line;
    String text;
    char letter;
    for (int index = 0; index < file.size(); index++){
			line = file.get(index);
      for (int i = 0; i < line.length(); i++){
        letter = line.charAt(i);
        letterTracker[letter-97]++;
				System.out.println(Arrays.toString(letterTracker));
      }
			result += alphabet[minValue(letterTracker)];
			letterTracker = new int[26];
    }
    return result;
  }
}