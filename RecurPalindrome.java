
/* Starter code */

import java.util.Scanner;

public class RecurPalindrome {

    public static void main(String[] args) {

	// Welcome message 
	System.out.println("\nWelcome to the Palindrome Test Program!");

	// Takes in one user input
	Scanner userInput = new Scanner(System.in);
	System.out.println("\nType in a word and press enter:");
	String word = userInput.nextLine();
	userInput.close();

	
	// Call the recursive function here!
	// ** Note: true is a space holder.   **
	// ** Remove it and insert your code! **
	//Call my function here
	
	boolean isPalindrome = rPalindrome(word); 

        

	
	// Printing out the result
	if (isPalindrome)
	    System.out.println("Palindrome!");
	else
	    System.out.println("Not a palindrome!");
    }


    
    private static boolean rPalindrome(String s) {
		boolean val = true;
	 if(s.length()== 0 || s.length() == 1)
		val = true;
	else if (s.charAt(0)== s.charAt(s.length() -1)){
		String newCheck = s.substring(1, s.length()-1);
		val = rPalindrome(newCheck);
	}else{
		val = false;
	}
      return val;
    }
    
}
	
