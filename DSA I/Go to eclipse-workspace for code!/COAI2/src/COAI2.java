/* Lab 3 COA I Christine Baca [cab8xd]
 * 
 * Tested: 
 * 	tarzan.txt
 * 		You got 11 out of 20 guesses correct!
		Entropy:0.8624964762500651
	pi.txt 
		You got 3 out of 20 guesses correct!
		Entropy:2.736965594166206
 	Text filled with words such as tarzan.txt are easier to inference the next letter based on
 	common words used in the text and get more guesses correct. English is more entropic then numbers to my understanding because of the presence of necessary vowels 
 	and common words in a language unlike the random nature and equally repetitive nature of numbers 
 	Though, if i knew the math behind pi.txt I would probably be able 
 	to calculate the next digit and get a higher score
 	
 	My results tend to stay in the same range for both text files. 
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class COAI2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		Scanner input = new Scanner(new File("pi.txt"));
		Scanner in = new Scanner(System.in);
		String text = "";
		String guess;
		int correct = 0;
		
		while (input.hasNextLine())
		{
		   text += input.nextLine();
		}
	
		
		for(int i = 0; i < 21; i ++) {
			int num = (int) (Math.random()* text.length());
			String part = text.substring(num-50,num);
			System.out.println(part);
			System.out.println("What's the next character?");
			guess = in.nextLine();
			if (guess.equals(text.substring(num,num+1))) {
				System.out.println("Correct!");
				correct++;
			}
			else
				System.out.println("Wrong! It's " + text.substring(num,num+1));
		}
		System.out.println("You got " + correct + " out of 20 guesses correct!");
		
		double entropy = (Math.log(20.0/((double)correct))/Math.log(2));
		
		System.out.println("Entropy:" + entropy);
		input.close();
		in.close();
		

	}

}
