public class makeWords{
  public static void main(String[] args) {
    // makeWords(2, "", "abc");
    System.out.println(toWords(3));
  }
  public static void makeWords(int remainingLetters, String result, String alphabet){
    if (remainingLetters == 0){
      System.out.println(result);
    }else{
      for (int i = 0; i < alphabet.length(); i++){
        makeWords(remainingLetters - 1, result + alphabet.charAt(i), alphabet);
      }
    }
  }
  public static String[] numbers = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
  public static String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
  public static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
  public static String toWords(int n){
    String value = "" + n;
    if (value.length() == 1){
      return numbers[n];
    }
    return "";
  }
}
