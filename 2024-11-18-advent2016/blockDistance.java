import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class blockDistance{
  public static void main(String[] args) {
    //System.out.println(distanceBlock("inputD1.txt"));
    System.out.println(repeatBlock("inputD1.txt"));
  }
  public static int distanceBlock(String filename){
    int xDist = 0;
    int yDist = 0;
    int direct = 0;
    String fullInput;
    String dir;
    int dist;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while(input.hasNext()){
        fullInput = input.next();
        dir = fullInput.substring(0,1);
        dist = Integer.parseInt(fullInput.substring(1,fullInput.length()-1));
        if (dir.equals("R")){
          direct++;
          direct = direct % 4;
        }
        else if (dir.equals("L")){
          direct += 3;
          direct = direct % 4;
        }
        if (direct == 0){
          yDist++;
        }
        if (direct == 1){
          xDist++;
        }
        if (direct == 2){
          yDist--;
        }
        if (direct == 3){
          xDist--;
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      System.exit(1);
    }
    return Math.abs(xDist) + Math.abs(yDist);
  }
  public static String repeatBlock(String filename){
    int xDist = 0;
    int yDist = 0;
    int direct = 0;
    String fullInput;
    String dir;
    int dist;
    int index = 0;
    String location;
    ArrayList<String> tracker = new ArrayList<String>();
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while(input.hasNext()){
        fullInput = input.next();
        dir = fullInput.substring(0,1);
        dist = Integer.parseInt(fullInput.substring(1,fullInput.length()-1));
        if (dir.equals("R")){
          direct++;
          direct = direct % 4;
        }
        else if (dir.equals("L")){
          direct += 3;
          direct = direct % 4;
        }
        for (int i = 0; i < dist; i++){
          if (direct == 0){
            yDist++;
          }
          if (direct == 1){
            xDist++;
          }
          if (direct == 2){
            yDist--;
          }
          if (direct == 3){
            xDist--;
          }
          location = (xDist + "," + yDist);
          //System.out.println(location);
          if (tracker.indexOf(location) > 1){
            return location;
          }
          tracker.add(location);
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      System.exit(1);
    }
    return null;
  }
}
