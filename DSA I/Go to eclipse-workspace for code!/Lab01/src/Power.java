
//CS2501 DSA1 Lab 01 Prelab - Christine Baca 

//library files
import java.io.*;
import java.util.Scanner;

//power class
public class Power {
	
	//power method defined:
	//Input: integer base and exponent number. Output: the result
	public static long power(int base, int exp){
		//if the exponent is zero, return zero
		if(exp == 0) {
			return 0;
		}
		//calculates power and returns answer
		else {	
			long num = (long)base;
			for(int x=exp;x>1;x--){
				num = num * (long)base;
			}
			return num;
		}
	}
	//main program
	public static void main(String[] args) {
		//creating scanner object
		Scanner in = new Scanner(System.in);
		
		//Computer asks User to input two number
		System.out.println("Input integers for base and power:");
		int base = in.nextInt();
		int pow = in.nextInt();
		
		//calls method power and prints result
		System.out.println("Result: " + power(base,pow));

	}
}
