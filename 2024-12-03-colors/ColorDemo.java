public class ColorDemo{
  public static void main(String[] args) {
    System.out.println(HIDE_CURSOR); 
    for (int i = 0; i < 10; i++){
      for (int row = 0; row < 16; row++){
        // color(RED, BLUE, (i * 32), 0, 0);
        // System.out.print("|");
        System.out.print("\u001b[38;2;"+(i*25)+";"+((15-row) * 16)+";"+((9-i)*16)+";7m.");
      }
      System.out.println();
    }
    // System.out.println(CLEAR_SCREEN);
    // for(int r = 0; r < 256; r+=32){
    //   for(int g = 0; g <= 256; g+=32){
    //     for(int b = 0; b <= 256; b+=32){
    //       System.out.print("\u001b[38;2;"+r+";"+g+";"+b+";7m.");
    //     }
    //   }
    //     System.out.println();
    // }
    System.out.println("\u001b[0m");
  }
  public static final String CLEAR_SCREEN =  "\u001b[2J"; // final essentially "locks in" the variable. it can not be reassigned.
  public static final String HIDE_CURSOR =  "\u001b[?25l";
  public static final String SHOW_CURSOR =  "\u001b[?25h";
  public static int BLACK = 30;
  public static int RED = 31;
  public static int GREEN = 32;
  public static int YELLOW = 33;
  public static int BLUE = 34;
  public static int MAGENTA = 35;
  public static int CYAN = 36;
  public static int WHITE = 37;

  public static void color(int foreground,int background){
    System.out.print( "\u001b[" + foreground + ";" + (10+background) + "m");
  }

  public static void color(int foreground, int background, int modifier){
    System.out.print( "\u001b[" + foreground + ";" + (10+background) + ";" + modifier + "m");
  }
  public static void go(int r,int c){
    System.out.print("\u001b[" + r + ";" + c + "f");
  }
  public static void color(int foreground, int background, int red, int grn, int blu){
    System.out.print("\u001b[" + foreground + ";" + (10 + background) + red + ";" + grn + ";" + blu + "m");
  }
  public static void color(int foreground, int background, int red, int grn, int blu, int mod){
    System.out.print("\u001b[" + foreground + ";" + (10 + background) + red + ";" + grn + ";" + blu + ";" + mod + "m");
  }
}
