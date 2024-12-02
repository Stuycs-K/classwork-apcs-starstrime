import java.util.*;
import java.io.*;

public class day19{
	public static void main(String[] args){
		int elfcount = 3017957;
		ArrayList<String> elves = new ArrayList<String>(elfcount);
		for(int i = 1; i <= elfcount; i++){
			elves.add("" + i);
		}
		int i = 0;
		while (elves.size() > 1){ // elf eliminator
			System.out.println(elves);
			elves.remove((i+(elves.size()/2))%elves.size()); //this takes like half an hour for the code to process. its bad but it works
			i++;
			if (i >= elves.size()){
				i = 0;
			}
		}
		System.out.println(elves);
	}
}