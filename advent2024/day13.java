import java.util.*;
import java.io.*;
public class day13{
  public static void main(String[] args) {
    ArrayList<String> data = day1.parse("d13input.txt");
    // System.out.println(solve(data));
    System.out.println(solve2(data));
  }
  public static long solve2(ArrayList<String> input){
    long[] buttonA, buttonB, goal;
    long total = 0;
    double varX, varY;
    for (int i = 0; i < input.size(); i+=4){
      buttonA = initCtrl(input.get(i));
      buttonB = initCtrl(input.get(i+1)); 
      goal = initTarget(input.get(i+2));
      goal[0] += 10000000000000L;
      goal[1] += 10000000000000L;
      varY = ((goal[1]+(-1 * buttonA[1]*((double)goal[0]/buttonA[0])))/(-1*buttonA[1]*((double)buttonB[0]/buttonA[0])+buttonB[1]));
      varX = (goal[0] - (buttonB[0] * varY))/buttonA[0];
      // System.out.println(varY + " " + varX);
      if (closeEnough(varX, Math.round(varX)) && closeEnough(varY, Math.round(varY))){
        total += varY + (3 * varX);
      }
    }
    return total;
  }
  public static boolean closeEnough(double a, double b){ // stealing this from trianglelab
    if (a == 0 || b == 0){
      return (a == b);
    }
    double varDiff = Math.abs(a - b);
    return (varDiff  / b < 0.00000000000001);
  }
  public static long solve(ArrayList<String> input){
    long[] buttonA, buttonB, goal;
    long[] coord;
    long total = 0;
    long remainingX, remainingY;
    long tempCount = 0;
    for (int i = 0; i < input.size(); i+=4){
      tempCount = -3;
      remainingX = 0;
      remainingY = 0;
      buttonA = initCtrl(input.get(i));
      buttonB = initCtrl(input.get(i+1));
      goal = initTarget(input.get(i+2));
      coord = new long[]{-1 * buttonA[0], -1 * buttonA[1]};
      // System.out.println(Arrays.toString(buttonA) + Arrays.toString(buttonB) + Arrays.toString(goal));
      while (coord[0] < goal[0] && coord[1] < goal[1]){
        coord[0] += buttonA[0];
        coord[1] += buttonA[1];
        tempCount+=3;
        remainingX = (goal[0] - coord[0]);
        remainingY = (goal[1] - coord[1]);
        if (remainingX % buttonB[0] == 0 && remainingY % buttonB[1] == 0 && remainingX/buttonB[0] == remainingY/buttonB[1]){
          tempCount += (remainingX/buttonB[0]);
          break;
        }
      }
      if (coord[0] > goal[0] || coord[1] > goal[1] || remainingX == 0 || remainingY == 0){
        tempCount = 0;
      }
      total += tempCount;
      // if (tempCount > 0){
        // System.out.println(total + " " + tempCount + Arrays.toString(buttonB) + Arrays.toString(coord) + remainingX + " " + remainingY + " " + remainingX / buttonB[0] + " " + remainingY / buttonB[1]);
      // }
    }
    return total;
  }
  public static long[] initCtrl(String input){
    long[] output = new long[2];
    String[] temp = input.split(", ");
    output[0] = Long.parseLong(temp[0].substring(temp[0].length()-2, temp[0].length()));
    output[1] = Long.parseLong(temp[1].substring(temp[1].length()-2, temp[1].length()));
    return output;
  }
  public static long[] initTarget(String input){
    long[] output = new long[2];
    String[] temp = input.split("=");
    output[0] = Long.parseLong(temp[1].substring(0, temp[1].length()-3));
    output[1] = Long.parseLong(temp[2]);
    return output;
  }public static long[] initTarget2(String input){
    long[] output = new long[2];
    String[] temp = input.split("=");
    output[0] = Long.parseLong(temp[1].substring(0, temp[1].length()-3));
    output[1] = Long.parseLong(temp[2]);
    return output;
  }
}