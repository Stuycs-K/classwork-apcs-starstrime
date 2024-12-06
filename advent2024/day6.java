import java.util.*;
import java.io.*;
public class day6{
  public static void main(String[] args) {
    String[][] map = parse("d6input.txt");
    System.out.println(Arrays.deepToString(map));
  }
  public static String[][] parse(String filename){
    ArrayList<String> layout = day1.parse(filename);
    String[][] fin = new String[layout.size()][];
    for (int i = 0; i < layout.size(); i++){
      fin[i] = layout.get(i).split("");
    }
    return fin;
  }
}