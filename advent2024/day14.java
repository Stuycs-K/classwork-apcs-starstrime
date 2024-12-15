import java.util.*;
import java.io.*;
public class day14{
  public static void main(String[] args) {
    ArrayList<String> input = day1.parse("d14input.txt");
    // System.out.println(solve(input, 100));
    tree(input, 10000);
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
  public static void tree(ArrayList<String> input, int attempts){
    int[][][] bots = new int[500][2][2];
    int row = 0;
    int botCount = 0;
    ArrayList<String> botSet = new ArrayList<String>();
    for (int i = 0; i < input.size(); i++){
      String line = input.get(i);
      bots[i][0] = initBotPos(line);
      bots[i][1] = initBotVel(line);
    }
    for (int count = 1; count <= attempts; count++){
      for (int i = 0; i < bots.length; i++){
        bots[i][0][0] += bots[i][1][0];
        bots[i][0][1] += bots[i][1][1];
        bots[i][0][0] %= 101;
        bots[i][0][1] %= 103;
        if (bots[i][0][0] < 0){
          bots[i][0][0] = 101 + bots[i][0][0];
        }
        if (bots[i][0][1] < 0){
          bots[i][0][1] = 103 + bots[i][0][1];
        }
      }
      boolean flag = false;
      botSet.clear();
      for (int[][] position : bots){
        botSet.add(Arrays.toString(position[0]));
      }
      botSet.sort(Comparator.naturalOrder());
      for (String botPos : botSet){
        int[] pos = day2.parseIntArray(botPos.substring(1,botPos.length()-1).split(", "));
        if (pos[0] != row){
          botCount = 0;
          row = pos[0];
        }
        botCount++;
        if (botCount > 30){
          flag = true;
          botCount = 0;
          break;
        }
      }
      if (flag){
        System.out.println("ATTEMPT #" + count);
        drawMap(bots);
        System.out.println();
      }
    }
  }
  public static void drawMap(int[][][] botPos){
    String[][] map = new String[101][103];
    for (int i = 0; i < map.length; i++){
      for (int r = 0; r < map[0].length; r++){
        map[i][r] = ".";
      }
    }
    for (int[][] position : botPos){
      map[position[0][0]][position[0][1]] = "#";
    }
    for (int i = 0; i < map.length; i++){
      for (int r = 0; r < map[i].length; r++){
        System.out.print(map[i][r]);
      }
      System.out.println();
    }
  }
}