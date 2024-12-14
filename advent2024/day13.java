import java.util.*;
import java.io.*;
public class day13{
  public static void main(String[] args) {
    ArrayList<String> data = day1.parse("d13input.txt");
    System.out.println(solve(data));
  }
  public static int solve(ArrayList<String> input){
    int[] buttonA, buttonB, goal;
    int[] coord;
    int total = 0;
    int presscount, remainingX, remainingY;
    int tempCount = 0;
    for (int i = 0; i < input.size(); i+=4){
      tempCount = -3;
      presscount = -1;
      remainingX = 0;
      remainingY = 0;
      buttonA = initCtrl(input.get(i));
      buttonB = initCtrl(input.get(i+1));
      goal = initTarget(input.get(i+2));
      coord = new int[]{-1 * buttonA[0], -1 * buttonA[1]};
      // System.out.println(Arrays.toString(buttonA) + Arrays.toString(buttonB) + Arrays.toString(goal));
      while (presscount <= 100 && coord[0] < goal[0] && coord[1] < goal[1]){
        coord[0] += buttonA[0];
        coord[1] += buttonA[1];
        tempCount+=3;
        presscount++;        
        // System.out.println(Arrays.toString(coord) + presscount + " " + tempCount);
        remainingX = (goal[0] - coord[0]);
        remainingY = (goal[1] - coord[1]);
        if (remainingX % buttonB[0] == 0 && remainingY % buttonB[1] == 0 && remainingX/buttonB[0] == remainingY/buttonB[1]){
          presscount = (remainingX/buttonB[0]);
          // System.out.println(presscount);
          tempCount += (remainingX/buttonB[0]);
          break;
        }
      }
      if (coord[0] > goal[0] || coord[1] > goal[1] || presscount > 100 || remainingX == 0 || remainingY == 0){
        tempCount = 0;
      }
      total += tempCount;
      if (tempCount > 0){
        System.out.println(total + " " + tempCount + Arrays.toString(buttonB) + Arrays.toString(coord) + remainingX + " " + remainingY + " " + remainingX / buttonB[0] + " " + remainingY / buttonB[1]);
      }
    }
    return total;
  }
  public static int[] initCtrl(String input){
    int[] output = new int[2];
    String[] temp = input.split(", ");
    output[0] = Integer.parseInt(temp[0].substring(temp[0].length()-2, temp[0].length()));
    output[1] = Integer.parseInt(temp[1].substring(temp[1].length()-2, temp[1].length()));
    return output;
  }
  public static int[] initTarget(String input){
    int[] output = new int[2];
    String[] temp = input.split("=");
    output[0] = Integer.parseInt(temp[1].substring(0, temp[1].length()-3));
    output[1] = Integer.parseInt(temp[2]);
    return output;
  }
}