import java.util.*;
import java.io.*;
public class day4{
  public static void main(String[] args) {
    System.out.println(seek(day1.parse("d4input.txt")));
  }
  public static int seek(ArrayList<String> input){
    int count = 0;
    for (int col = 0; col < input.size(); col++){
      for (int row = 0; row < input.get(0).length(); row++){
        if (input.get(col).charAt(row) == 'X'){
          // System.out.println("first seek detected at " + col + ", " + row);
          count += seek(input, 'M', col, row); 
        }
      }
      System.out.println(col+1 + " row complete");
    }
    return count;
  }
  public static int seek(ArrayList<String> input, char target, int col, int row){
    int total = 0;
    int totalpast;
    boolean flagI = true;
    boolean flagR = true;
    for (int r = -1; r < 2; r++){
      for (int i = -1; i < 2; i++){
        if (col == 0 && i == 1 && flagI){
          i--;
          flagI = false;
        }
        if (col == input.size()-1 && i == -1){
          i++;
        }
        if (row == 0 && r == 1 && flagR){
          r--;
          flagR = false;
        }
        if (row == input.get(0).length()-1 && r == -1){
          r++;
        }
        if (boundsTest(input, col, row, i, r) && input.get(col-i).charAt(row-r) == target){
          // System.out.println("second seek detected at " + (col-i) + ", " + (row-r));
          totalpast = total;
          total += seek(input, 'A', col, row, i, r);
          if ((!flagI) && totalpast < total){
            total--;
          }
        }
      }
    }
    return total;
  }
  public static int seek(ArrayList<String> input, char target, int col, int row, int i, int r){
    if (i > 0){
      i++;
    }else if (i < 0){
      i--;
    }
    if (r > 0){
      r++;
    }else if (r < 0){
      r--;
    }
    if (!boundsTest(input, col, row, i, r)){
      // System.out.println("nope");
      return 0;
    }
    if (input.get(col-i).charAt(row-r) == target){
      if (target == 'A'){
        // System.out.println("third seek detected at " + (col-i) + ", " + (row-r));
        return seek(input, 'S', col, row, i, r);
      }
      if (target == 'S'){
        // System.out.println("fourth seek detected at " + (col-i) + ", " + (row-r));
        confirm(input, col, row, i, r);
        return 1;
      }
    }
    // System.out.println("nope");
    return 0;
  }
  public static boolean boundsTest(ArrayList<String> input, int col, int row, int i, int r){
    try {
      input.get(col-i).charAt(row-r);
      return true;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public static void confirm(ArrayList<String> input, int col, int row, int i, int r){
    int finR = row-r;
    int finC = col-i;
    ArrayList<Character> fin = new ArrayList<Character>();
    fin.add(0, input.get(col-i).charAt(row-r));
    for (int x = 0; x < 3; x++){
      if (i > 0){
        i--;
      }else if (i < 0){
        i++;
      }
      if (r > 0){
        r--;
      }else if (r < 0){
        r++;
      }
      fin.add(0, input.get(col-i).charAt(row-r));
    }
    System.out.println(fin + " " + row + " " + col + " " + finR + " " + finC);
  }
}
