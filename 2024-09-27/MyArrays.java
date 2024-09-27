public class MyArrays{
  public static String aryToString(int[] nums){
    String result = "[";
    for (int i = 0; i < nums.length; i++){
      result += nums[i];
      if (i < nums.length-1){
        result += ", ";
      }
    }
    return result + "]";
  }
  public static void main(String[] args) {
    System.out.println(aryToString(new int[]{1, 2, 3}));
  }
}
