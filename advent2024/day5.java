import java.util.*;
import java.io.*;
public class day5{
  public static void main(String[] args) {
    ArrayList<String> rules = day1.parse("d5inputp1.txt");
    ArrayList<String> lists = day1.parse("d5inputp2.txt");
    System.out.println(rules);
    System.out.println(lists);
  }
}