import java.util.*;
public class ArrayListPractice{
  public static void main(String[] args) {
    ArrayList<String> test = createRandomArray(10);
    System.out.println(test);
    replaceEmpty(test);
    System.out.println(test);
    System.out.println(makeReversedList(test));
    System.out.println(mixLists(test,test));
    System.out.println(mixLists(test,mixLists(test,test)));
  }

  public static ArrayList<String>createRandomArray(int size){
    ArrayList<String> out = new ArrayList<String>(size);
    for (int i = 0; i < size; i++){
      out.add("" + (int)(Math.random() * 11));
      if (out.get(i).equals("0")){
        out.set(i, "");
      }
    }
    return out;
  }
  
  public static void replaceEmpty( ArrayList<String> original){
    //Modify the ArrayList such that it has all of the empty strings are
    //replaced with the word "Empty".
    while (original.indexOf("") >= 0){
        original.set(original.indexOf(""), "Empty");
    }
  }

  public static ArrayList<String> makeReversedList( ArrayList<String> original){
    //return a new ArrayList that is in the reversed order of the original.
    ArrayList<String> out = new ArrayList<String>(original.size());
    for(int i = original.size()-1; i >= 0; i--){
      out.add(original.get(i));
    }
    return out;
  }

  public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
    //return a new ArrayList that has all values of a and b in alternating order that is:
    //a[0], b[0], a[1], b[1]...
    //If one list is longer than the other, just attach the remaining values to the end.
    ArrayList<String> out = new ArrayList<String>(a.size() + b.size());
    int minLen = Math.min(a.size(), b.size());
    for (int i = 0; i < minLen; i++){
      out.add(a.get(i));
      out.add(b.get(i));
    }
    if (a.size() > minLen){
      for (int i = minLen; i < a.size(); i++){
        out.add(a.get(i));
      }
    }
    else{
      for (int i = minLen; i < b.size(); i++){
        out.add(b.get(i));
      }
    }
    return out;
  }
}
