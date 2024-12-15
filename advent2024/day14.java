import java.util.*;
import java.io.*;
public class day14{
  public static void main(String[] args) {
    ArrayList<String> input = day1.parse("d14input.txt");
    System.out.println(solve(input, 100));
  }
  public static int[] initBotPos(String input){
    String[] temp = input.split("=");
    return day2.parseIntArray(temp[1].substring(0, temp[1].length()-2).split(","));
  }
  public static int[] initBotVel(String input){
    String[] temp = input.split("=");
    return day2.parseIntArray(temp[2].split(","));
  }
  public static long solve(ArrayList<String> input, int loops){
    int[] pos = new int[2];
    int[] vel = new int[2];
    long sf1 = 0, sf2 = 0, sf3 = 0, sf4= 0;
    for (String line : input){
      pos = initBotPos(line);
      vel = initBotVel(line);
      // System.out.println(Arrays.toString(pos) + Arrays.toString(velocity));
      pos[0] += vel[0] * loops;
      pos[1] += vel[1] * loops;
      pos[0] %= 101;
      pos[1] %= 103;
      if (pos[0] < 0){
        pos[0] = 101 + pos[0];
      }
      if (pos[1] < 0){
        pos[1] = 103 + pos[1];
      }
      // System.out.println(Arrays.toString(pos));
      if (pos[0] < 50 && pos[1] < 51){
        sf1++;
      }else if (pos[0] < 50 && pos[1] > 51){
        sf3++;
      }else if (pos[0] > 50 && pos[1] > 51){
        sf4++;
      }else if (pos[0] > 50 && pos[1] < 51){
        sf2++;
      }
    }
    System.out.println(sf1 + " " + sf2 + " " + sf3 + " " + sf4);
    return sf1 * sf2 * sf3 * sf4;
  }
}