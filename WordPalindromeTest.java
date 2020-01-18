import java.util.Arrays;
import java.util.Scanner;
import java.lang.String ;

public class WordPalindromeTest{
  
    public static boolean  isWordPalindrome( String s ){
        boolean isPal = false;
        //converting the string to lowercase
        String string = s.toLowerCase();
        //removing all non-digit, not-letter and non-white space characters
        String removed = string.replaceAll("[^a-zA-Z0-9 ]", "");
        System.out.println(removed);
        //Spliting the string into multiple array elements
        String strArray[] = removed.split(" ");
        System.out.println(Arrays.toString(strArray));
        //Introducing the breakpoints in the string to create the mirror
        int stop = 0;
        if(strArray.length%2 == 0){
            stop = (strArray.length/2)-1;
        }else{
            stop = (strArray.length-1)/2;
        }
        //Udjuating the reverse counter
        int check = strArray.length -1;
        for (int i = 0; i<= stop; i++){
            //Comparing the strings using equals keyword

            if (strArray[i].equals(strArray[check])){
                isPal = true;
                check = check -1;
            }
            else{
                isPal = false;
            }
        }
        System.out.println(isPal);
        return isPal; 
     
    };
    public static void main(String [] args){
        Scanner scan = new Scanner (System.in);
        System.out.println("Give us a string:");
        String input = scan.nextLine();
        isWordPalindrome(input);
        scan.close();
    }

    }
    