import java.util.*;
import java.io.*;

public class day20{
	public static void main(String[] args) {
		System.out.println(solve(split(parse("inputD20.txt"))));
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
}