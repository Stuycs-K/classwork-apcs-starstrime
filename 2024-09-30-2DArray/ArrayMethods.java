public class ArrayMethods{ // Angelo Chen, angeloc81@nycstudents.net, Ivan Chen, ivanc178@nycstudents.net
  public static void main(String[] args) {
    int[] arr1 = {2,3,4,9};
    System.out.println(arrToString(arr1));
    int[][] arr2 = {{2,3,4}, {5,6,7}, {2,4,9}};
    System.out.println(arrToString(arr2));
    System.out.println("big array sum is 42, function returns " + arr2DSum(arr2));
    System.out.println("swapped, the big array returns " + arrToString(swapRC(arr2)));
    int[][] arr3 = {{1,2,3},{4,5,6}};
    System.out.println("using the sample test case {{1,2,3},{4,5,6}}, it returns " + arrToString(swapRC(arr3)) + " when swapped");
  }

//2. Copy your arrToString method from before.
/**Return a String that represets the array in the format:
* "[2, 3, 4, 9]"
* Note the comma+space between values, and between values
*/
  public static String arrToString(int[] nums){
    String result = "[";
    for (int i = 0; i < nums.length; i++){
      result += nums[i];
      if (i < nums.length-1){
        result += ", ";
      }
    }
    return result + "]";
  }
  //3. Write arrToString, with a 2D array parameter.
  //Note: Different parameters are allowed with the same function name.
  /**Return a String that represets the 2D array in the format:
  * "[[2, 3, 4], [5, 6, 7], [2, 4, 9]]"
  * Note the comma+space between values, and between arrays
  * You are encouraged to notice that you may want to re-use
  * previous code, but you should NOT duplicate that code. (Don't copy/paste or retype it)
  */
  public static String arrToString(int[][]ary){ //this should use arrToString(int[])
    String result = "[";
    int i = 0;
    while (i < ary.length){
        result += arrToString(ary[i]) + ",";
        i++;
        if (i == ary.length){
            result = result.substring(0,result.length()-1);
        }
    }
    return result + "]";
  }

  /*Return the sum of all of the values in the 2D array */
  public static int arr2DSum(int[][]nums){ //use a nested loop to solve this
    int ans = 0;
    for (int i = 0; i < nums.length; i++){
      for (int i2 = 0; i2 < nums[i].length; i2++){
          ans += nums[i][i2];
      }
    }
    return ans;
  }

  /**Rotate an array by returning a new array with the rows and columns swapped.
  * You may assume the array is rectangular and neither rows nor cols is 0.
  * e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
  */
  public static int[][] swapRC(int[][]nums){
    int[][]swap = new int[nums[0].length][nums.length];
    for (int row = 0; row < nums.length; row++){
        for (int column = 0; column < nums[row].length; column++){
            swap[column][row] = nums[row][column];
        }
    }
    return swap;
  }

  //3. Modify a given 2D array of integer as follows:
  //Replace all the negative values:
  //-When the row number is the same as the column number replace
  //that negative with the value 1
  //-All other negatives replace with 0
  public static void replaceNegative(int[][] vals){ }

  //4. Make a copy of the given 2d array.
  //When testing : make sure that changing the original does NOT change the copy.
  //DO NOT use any built in methods that "copy" an array.
  //You SHOULD write a helper method for this.
  //If you don't see a good way to do that, you should stop and look at prior methods.
  public static int[][] copy(int[][] nums){
    return null;//placeholder so it compiles
}
}
