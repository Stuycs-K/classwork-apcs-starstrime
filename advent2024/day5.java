import java.util.*;
import java.io.*;
public class day5{
  public static void main(String[] args) {
    int[][] rules = rulesSplit(day1.parse("d5inputp1.txt"));
    int[][] lists = listSplit(day1.parse("d5inputp2.txt"));
    System.out.println(check(rules, lists));
  }
  public static int[][] rulesSplit(ArrayList<String> input){
    int[][] list = new int[input.size()][];
    String[] temp = new String[2];
    for (int i = 0; i < list.length; i++){
      temp[0] = input.get(i).substring(0,2);
      temp[1] = input.get(i).substring(3);
      // System.out.println(Arrays.toString(temp));
      list[i] = day2.parseIntArray(temp);
    }
    return list;
  }
  public static int[][] listSplit(ArrayList<String> input){
    int[][] list = new int[input.size()][];
    for (int i = 0; i < input.size(); i++){
      list[i] = (day2.parseIntArray(input.get(i).split(",")));
    }
    return list;
  }
  public static boolean confirm(int[][] rules, int input1, int input2){
    for (int[] check : rules){
      if (check[0] == input2 && check[1] == input1){
        return false;
      }
    }
    return true;
  }
  public static int check(int[][] rules, int[][] lists){
    int sum = 0;
    int mid;
    boolean confirmFlag;
    for (int i = 0; i < lists.length; i++){
      confirmFlag = true;
      mid = lists[i][lists[i].length/2];
      for (int e1 = 0; e1 < lists[i].length; e1++){
        for (int e2 = e1; e2 < lists[i].length; e2++){
          if (!confirm(rules, lists[i][e1], lists[i][e2])){
            confirmFlag = false;
          }
        }
      }
      if (confirmFlag){
        sum += mid;
      }
    }
    return sum;
  }
}