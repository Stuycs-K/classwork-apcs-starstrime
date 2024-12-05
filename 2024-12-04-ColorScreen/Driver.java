import java.util.Random;
public class Driver{
  public static void main(String[] args) {
    create();
    distribute();
    Text.go(34, 0);
    System.out.println(Text.RESET);
  }
  public static void create(){
    System.out.println(Text.CLEAR_SCREEN);
    System.out.println(Text.HIDE_CURSOR);
    Text.go(1,1);
    for (int col = 0; col < 32; col++){
      for (int row = 0; row < 84; row++){
        if (row <= 1 || col == 0 || row >= 82 || col == 31){
          Text.color(Text.BLUE, 7);
        }else{
          System.out.print(Text.RESET);
        }
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println(Text.RESET);
  }
  public static void distribute(){
    Random rng = new Random();
    int[] arr = new int[3];
    for (int i = 0; i < 3; i++){
      arr[i] = rng.nextInt(100);
    }
    Text.go(2,17);
    colorSelect(arr[0]);
    System.out.print(arr[0]);
    Text.go(2,42);
    colorSelect(arr[1]);
    System.out.print(arr[1]);
    Text.go(2,67);
    colorSelect(arr[2]);
    System.out.print(arr[2]);
    Text.go(3,3);
    Text.color(Text.BLUE, Text.background(Text.YELLOW), 7);
    for (int i = 0; i < 80; i++){
      System.out.print("-");
    }
    System.out.print(Text.RESET);
  }
  public static void colorSelect(int i){
    if (i < 25){
      Text.color(Text.RED, Text.BRIGHT);
    }else if (i > 75){
      Text.color(Text.GREEN, Text.BRIGHT);
    }else Text.color(Text.WHITE);
  }
}