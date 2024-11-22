import java.util.*;
import java.io.*;

public class day20{
	public static void main(String[] args) {
		System.out.println(absoluteSolve(split(parse("inputD20.txt"))));
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
	public static double[][] split(ArrayList<String> input){
		double[][] output = new double[input.size()][];
		String[][] temp = new String[input.size()][];
		for (int i = 0; i < input.size(); i++){
			temp[i] = input.get(i).split("-");
			output[i] = new double[]{Double.parseDouble(temp[i][0]), Double.parseDouble(temp[i][1])};
		}
		return output;
	}
	public static double solve(double[][] input){
		double min = 0;
		double max = 0;
		for (int i = 0; i < input.length; i++){
			if (input[i][0] >= min && input[i][0] <= max && max < input[i][1]){
				min = input[i][0];
				max = input[i][1];
				i = 0;
			}
		}
		return max + 1;
	}

	public static int absoluteSolve(double[][] input){
		int total = 0;
		ArrayList<String> debug = new ArrayList<String>();
		double[] range = new double[]{solve(input),solve(input)};
		double[] trueMax = new double[]{0,0};
		double[] nextRange = new double[]{0,0};
		for (int i = 0; i < input.length; i++){
			if (input[i][1] > trueMax[1]){
				trueMax = input[i];
			}
		}
		nextRange = trueMax;
		while(range[1] < trueMax[1]){
			for (int i = 0; i < input.length; i++){
				if (input[i][0] < range[1] && range[1] < input[i][1]){
					range = input[i];
					nextRange = trueMax;
					i = 0;
				}
				if (input[i][0] > range[1] && input[i][0] < nextRange[0]){
					nextRange = input[i];
					i = 0;
				}
			}
			if (range[1] < trueMax[1]){
			debug.add(String.valueOf(range[1] + 1));
			total += (nextRange[0] - range[1]) - 1;
			System.out.println(Arrays.toString(range) + Arrays.toString(nextRange) + " " + total + " ,changed by " + (nextRange[0]-range[1]-1));
			range = nextRange;
			nextRange = trueMax;
			}
		}
		System.out.println(debug);
		System.out.println(debug.size());
		return total;
	}
}