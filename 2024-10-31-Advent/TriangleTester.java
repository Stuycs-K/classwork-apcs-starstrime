import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester{
  public static void main(String[] args) {
    System.out.println(countTrianglesA("inputTri.txt"));
    System.out.println(countTrianglesB("inputTri.txt"));
  }
  public static int countTrianglesA(String filename){
    int count = 0;
    int[] sideLengths;
    try {
      File file = new File(filename);//1
      Scanner input = new Scanner(file);
      while(input.hasNextLine()){
        sideLengths = new int[3];
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

  public static int countTrianglesB(String filename){
    int count = 0;
    int[] sideLengths;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        sideLengths = new int[9];
        for (int i = 0; i < 3; i++){
          for (int x = 0; x < 3; x++){
            sideLengths[i] = input.nextInt();
          }
          input.nextLine();
        }
        for (int i = 0; i != 3; i++){
          if (triangleCheck(new int[]{sideLengths[i], sideLengths[i+3], sideLengths[i+6]})){
            count++;
          }
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      System.exit(1);
    }
    return count;
  }
  public static boolean triangleCheck(int[] arr){
    return(arr[0] < arr[1] + arr[2]) && (arr[1] < arr[0] + arr[2]) && (arr[2] < arr[1] + arr[0]);
  }
}
