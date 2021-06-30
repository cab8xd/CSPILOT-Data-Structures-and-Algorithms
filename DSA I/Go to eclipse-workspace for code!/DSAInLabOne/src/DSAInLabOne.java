//Christine Baca 9/6/18
import java.io.*;
import java.util.Arrays;
public class DSAInLabOne {
	
	//1. Given a list, print out the even numbered values only
	public static void evenList(int[] array) {
		for(int x = 0; x < array.length; x++) {
			if (array[x] % 2 == 0)
					System.out.print(array[x]);
		}
	}
	
	//2. Given a list, print out every other element
	public static void otherList(int[] array) {
		for(int i = 0; i<array.length; i++) {
			if(i%2==0)
				System.out.print(array[i]);
		}
	}
	
	//3. Given a list, print out only numbers that increase as you go
	public static void incrList(int[] array) {
		int max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array [i];
				System.out.println(max);
			
			}
		}
	}
	//4. Given two lowercase strings 
	//(a-z characters only), determine if they are anagrams of
	//one another.
	
	public static boolean anagram(String a, String b) {
		if (a.length() != b.length())
			return false;
		
		
	
		else {
			
			char[] a_list = a.toCharArray();
			char[] b_list = b.toCharArray();
			
			
			Arrays.sort(a_list);
			Arrays.sort(b_list);
			
			for(int i = 0; i < a.length(); i++) {
				if (a_list[i] != b_list[i])
					return false;
			}
			return true;
		}
	}

	/*5. Given the cost of a product c, and the amount a customer has paid p (note p >= c), determine
	the exact coins (using quarters, dimes, nickels, and pennies) to give to produce
	the correct amount of change.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Number 1:
		/*
		int[] a = {1,2,3,4,5,6};
		evenList(a);
		*/
		
		//Number 2:
		/*
		int[] a = {1,2,3,4,5,6};
		otherList(a);
		*/
		
		//Number 3:
		/*
		int[] a = {2,4,5,3,7};
		incrList(a);
		*/
		
		//Number 4:
		/*
		String x = "anbn";
		String y = "bana";
		*/
		
		
		//Number 5
		System.out.print(anagram(x,y));
		//System.out.print(x.equals(y));
		

	}

}
