import java.util.*;
import java.io.*;

public class day19{
	public static void main(String[] args){
		ArrayList<Integer> gifts = new ArrayList<Integer>(5);
		ArrayList<String> elfNumber = new ArrayList<String>(5);
		for(int i = 1; i <= 5; i++){
			elfNumber.add("" + i);
			gifts.add(1);
		}
		System.out.println(gifts);
		System.out.println(elfNumber);
	}
}