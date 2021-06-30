//PostLabOne - Christine Baca

//Library file
import java.util.Scanner;
import java.util.Arrays;

public class PostLabOne {
	//Methods
	
	/*max: Accepts an array of integers as a parameter, 
	and returns the largest integer among them*/
	
	public static int max(int[] array) {
		int max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max)
				max = array [i];
		}
		return max;
		}
	
	
	/*min: Accepts an array of integers as a parameter, 
	  and return the lowest integer among them */
	public static int min(int[] array) {
		int min = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min)
				min =  array[i];
		}
		return min;
		}

	/*average: Accepts an array of integers as a parameter, and returns the average of the
	numbers as a double.*/
	public static int average(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) 
			sum += array[i];
		return sum/array.length;
	}
	
	/*CHECK median: Accepts an array of integers as a parameter, and returns the median of the
	numbers. Note that you can invoke your max and min function here to make this easier.
	You don’t necessarily need to sort the data.*/
	
	public static int median(int[] array) {
		Arrays.sort(array);
	    int middle = array.length/2;
	    return array[middle];
	}
	
	/* stddev: Accepts an array of integers as a parameter, and return the standard deviation
	of the numbers. Note that you can invoke your average method here.*/
	public static int stddev(int[] array) {
		int s[] = new int[array.length];
		
		for(int i = 0; i < array.length; i++) 
			s[i] = (int) (Math.pow((int) array[i] - (int) average(array),2));
		return average(s);
	}
		
	
	/* mode: Accepts and array of integers as a parameter, and returns the most commonly
	occurring value among them. If there is more than one mode, you may return any of
	them.*/
	
	public static int mode(int array[]) {
	    int maxNum = 0;
	    int maxC = 0;

	    for (int i = 0; i < array.length; ++i) {
	        int count = 0;
	        for (int j = 0; j < array.length; ++j) {
	            if (array[j] == array[i])
	            	count++;
	        }
	        if (count > maxC) {
	            maxC = count;
	            maxNum = array[i];
	        }
	    }

	    return maxNum;
	}
	
	public static void main(String[] args) {
		
		//creating scanner object
		Scanner in = new Scanner(System.in);
		
		//Computer asks User to input number to indicate wanted calculation
		System.out.println("Input Preference (1 = max, 2 = min, 3 =\n" + 
				"average, 4 = median, 5 = stddev, 6 = mode): ");
		int base = in.nextInt();
		
		//Checking if user inputs an expected number
		if(base < 0 || base > 6)
			return;
		
		//Asks user for seven numbers and creates the respective list
		int lst[] = new int[7]; 
		System.out.println("Input 7 integers:");
		for(int i = 0; i < 7; i++)
			lst[i] = in.nextInt();
		
		//Executes user-inputed calculation
		if(base == 1)
			System.out.println("Max: " + max(lst));
		if(base == 2)
			System.out.println("Min: " + min(lst));
		if(base == 3)
			System.out.println("Avg: " + average(lst));
		if(base == 4)
			System.out.println("Median: " + median(lst));
		if(base == 5)
			System.out.println("Standard Dev: " + stddev(lst));
		if(base == 6)
			System.out.println("Mode: " + mode(lst));
	
	}

}
