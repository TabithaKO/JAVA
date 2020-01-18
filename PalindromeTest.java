import java.util.Arrays;
import java.util.Scanner;
import java.lang.String ;

public class PalindromeTest{
    public static boolean isPalindrome( String s ) {
        boolean isPal = false;    // assume that it is not
        //removing all the non-string and digit values
        String str = s.toLowerCase();
        String removed = str.replaceAll("[^a-zA-Z0-9]", "");
        //replacing the spaces with no spaces'
       String newString = removed.replaceAll("\\s","");

        // Here the list values are all 0 (null)
        int [] x = new int [newString.length()];
        int y = 0;
        for (int i = newString.length() - 1; i>=0 ; i--){
           x[i] = y;
            ++y;
        }
        
        String compare = "";
        for(int i =0; i<x.length; i++){
            compare += newString.charAt(x[i]);
        }
        System.out.println(compare);
       
        for(int i = 0; i < newString.length(); i++){
            if(newString.equals(compare)){
                 isPal = true;
            }
        }
       // final palindrome test 
       //Using the mirror method
       int stop = 0;
        if(newString.length()%2 == 0){
            stop = (newString.length()/2)-1;
        }else{
            stop = (newString.length()-1)/2;
        }
        int check = newString.length() -1;
        for (int i = 0; i< stop; i++){
            if (newString.charAt(i) == newString.charAt(check)){
                isPal = true;
                check = check -1;
            }
            else{
                isPal = false;
            }
        }
        System.out.println(isPal);
        return( isPal ); 
     
    };
    public static int[] inputStringPalindrome(){
        int elem1 = 0;
        int elem2 = 0;
        Scanner scan = new Scanner (System.in);
        System.out.println("\nType in a line of text (a String) or \"quit\" to end:");
      
        while (scan.hasNextLine()) {
            String palString = scan.nextLine();
        if (palString.equals("quit")){
            break;
        }else{
            System.out.println("You input: " + palString) ; 
            elem1 +=1;
            isPalindrome(palString);
            if(isPalindrome(palString)== true){
                elem2 += 1;
            }
            
           }
        }
        System.out.println("bye!");
        scan.close();
        int [] arr = {elem1, elem2};
        System.out.print(Arrays.toString(arr));
        return arr;
    }

   
     public static void main(String [] args){
       inputStringPalindrome();
        
    };

};