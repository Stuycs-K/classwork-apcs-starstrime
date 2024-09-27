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

  public static int[] concatAry(int[] ary1, int[] ary2){
    int[] fullAry = new int[ary1.length + ary2.length];
    int i = 0;
    while (i < ary1.length){
      fullAry[i] = ary1[i];
      i++;
    }
    for (int index = 0; index < ary2.length; index++){
      fullAry[i] = ary2[index];
      i++;
    }
    return fullAry;
  }

  public static void main(String[] args) {
    int[] ary1 = new int[]{2, 68, 281, 5394};
    int[] ary2 = returnCopy(ary1);
    System.out.println("address of array1 is "+ary1+", address of array2 is "+ary2);
    System.out.println("array 1 returns "+aryToString(ary1)+", array 2 returns "+aryToString(ary2));
    System.out.println("concatenating both arrays together returns "+aryToString(concatAry(ary1,ary2)));
    int[] ary3 = new int[]{1, 2, 5, 8};
    int[] ary4 = new int[]{9, 26, 6020, 5202, 19692};
    System.out.println("concatenate arrays "+aryToString(ary3)+" and"+aryToString(ary4)+" returns "+aryToString(concatAry(ary3,ary4)));
  }
}
