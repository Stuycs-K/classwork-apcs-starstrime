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
  public static int[] returnCopy(int[] ary){
    int[] ary2 = new int[ary.length];
    for (int i = 0; i < ary.length; i++){
      ary2[i] = ary[i];
    }
    return ary2;
  }
  public static void main(String[] args) {
    int[] ary1 = new int[]{5, 6, 2, 8};
    int[] ary2 = returnCopy(ary1);
    System.out.println("array 1 returns "+aryToString(ary1)+", array 2 returns "+aryToString(ary2));
    System.out.println("address of array1 is "+ary1+", adress of array2 is "+ary2);
  }
}
