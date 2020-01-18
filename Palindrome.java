/*
 * Palindrome.java
 */
// import java.utils.*;

public class Palindrome {
   
    // Add your definition of isPal here.
    public static boolean isPal(String s){
        //Creating instances of an LLQueue and ArrayStack
     Stack<Character> arr  = new LLStack<Character>();
     Queue<Character> que = new LLQueue<Character>();
        boolean val = true;
        String updString = s.toLowerCase();
        //populating stack and que
        for(int i=0; i < updString.length(); i++){   
            if(Character.isLetter(updString.charAt(i))){
                arr.push(updString.charAt(i));
                que.insert(updString.charAt(i));
            }
        }
        while(que.isEmpty() != true){
            if(!(que.remove().equals(arr.pop()))){
                val = false;
                break;
            }
        }
        return val;

    }
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * Add five more unit tests that test a variety of different
         * cases. Follow the same format that we have used above.
         */

         //This is my first test that looks at empty strings
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(1) Testing on \"(An empty string)\"");
        try {
            boolean results2 = isPal("");
            System.out.println("actual results:");
            System.out.println(results2);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results2 == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        //This is my second test that looks at numbers in strings
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(2) Testing on \"Happy56\"");
        try {
            boolean results3 = isPal("Happy56");
            System.out.println("actual results:");
            System.out.println(results3);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results3 == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
         //This is my third test that looks at single characters
         System.out.println("--- Testing method isPal ---");
         System.out.println();
 
         System.out.println("(3) Testing on \"l\"");
         try {
             boolean results4 = isPal("l");
             System.out.println("actual results:");
             System.out.println(results4);
             System.out.println("expected results:");
             System.out.println("true");
             System.out.print("MATCHES EXPECTED RESULTS?: ");
             System.out.println(results4 == true);
         } catch (Exception e) {
             System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
         }
         
         System.out.println();    // include a blank line between tests

         //This is my fourth test that looks at special characters
         System.out.println("--- Testing method isPal ---");
         System.out.println();
 
         System.out.println("(4) Testing on \"nun!\"");
         try {
             boolean results4 = isPal("nun!");
             System.out.println("actual results:");
             System.out.println(results4);
             System.out.println("expected results:");
             System.out.println("true");
             System.out.print("MATCHES EXPECTED RESULTS?: ");
             System.out.println(results4 == true);
         } catch (Exception e) {
             System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
         }
         
         System.out.println();    // include a blank line between tests


         //This is my fifth test that looks at a fully numbered string
         System.out.println("--- Testing method isPal ---");
         System.out.println();
 
         System.out.println("(5) Testing on \"777\"");
         try {
             boolean results4 = isPal("777");
             System.out.println("actual results:");
             System.out.println(results4);
             System.out.println("expected results:");
             System.out.println("true");
             System.out.print("MATCHES EXPECTED RESULTS?: ");
             System.out.println(results4 == true);
         } catch (Exception e) {
             System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
         }
         
         System.out.println();    // include a blank line between tests
    }
    }

    
