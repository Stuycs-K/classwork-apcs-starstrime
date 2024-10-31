import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester{
  public static void main(String[] args) {
    System.out.println(countTrianglesA("inputTri.txt"));
  }
  public static int countTrianglesA(String filename){
    int count = 0;
    int[] sideLengths = new int[3];
    try {
      File file = new File(filename);//1
      Scanner input = new Scanner(file);
      while(input.hasNextLine()){
        for (int i = 0; i < 3 && input.hasNextInt(); i++){
          sideLengths[i] = input.nextInt();
        }
        if ((sideLengths[0] < sideLengths[1] + sideLengths[2]) && (sideLengths[1] < sideLengths[0] + sideLengths[2]) && (sideLengths[2] < sideLengths[1] + sideLengths[0])){
          count++;
        }
        input.nextLine();
      }
      input.close();

    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      System.exit(1);
    }
    return count;
  }
}
