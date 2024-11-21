import java.io.*;
import java.util.*;

public class day4{
  public static void main(String[] args){
    int output = 0;
    ArrayList<String> input = parse("inputD4.txt");
    while(input.size() > 0){
      output += solveLine(input.get(0));
      input.remove(0);
    }
    System.out.println(output);
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

  public static int solveLine(String line){
    String checksum = line.substring(line.length()-6, line.length()-1);
    int value = Integer.parseInt(line.substring(line.length()-10,line.length()-7));
    String[] letters = line.substring(0,line.length()-11).split("");
    String[] alphabet = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    int[] letterTracker = new int[26];
    String checkTest = "";
    char letter;
    for (int i = 0; i < letters.length; i++){
      letter = letters[i].charAt(0);
      if (letter != '-'){
        letterTracker[letter-97]++;
      }
    }
    System.out.println(Arrays.toString(letterTracker));
    for (int i = 0; i < 5; i++){
      checkTest += alphabet[maxValue(letterTracker)];
      System.out.println(checkTest);
      letterTracker[maxValue(letterTracker)] = 0;
    }
    if (checkTest.equals(checksum)){
      return value;
    }
    else return 0;
  }

  public static int maxValue(int[] input){
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
}