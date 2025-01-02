import java.util.*;
public class fib{
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    System.out.println(fib(n));
  }
  public static int fib(int n){
    if (n < 2){
      return n;
    }else{
      return fib(n-1) + fib(n-2);
    }
  }
}
