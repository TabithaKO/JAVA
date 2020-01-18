
/* File: Histogram.java
 * Author:Tabitha Oanda
 */

import java.util.Arrays;
import java.util.Scanner;

public class Histogram {

    private static final int SENTINAL = -999; // sentinal value to signal endo of input
    private static final int MAX_NUMBERS = 20; // maximum number of numbers to input
    private static final double UPPER_BOUND = 100.0; // largest numbers accepted as data
    private static final double LOWER_BOUND = 0.0; // smallest numbers accepted as adata
    private static final int NUM_BINS = 10; // number of bins in range [0..100]

    // private static final int BIN_SIZE = ?? // size of each bin

    /*
     * Method to show an example of using StringBuilder.
     *
     * You will also notice that this method is called from the main function.
     *
     */
    public static String getHeaderAsString(String me) {

        // Create an instance of the StringBuilder class
        // which allows us to create an object of
        // a series of strings that can then be converted
        // into one large string via the toString method.
        //
        StringBuilder sb = new StringBuilder();

        sb.append(System.getProperty("line.separator"));
        sb.append("Welcome to the Histogram Program " + me + "!");
        me = getFirstName(me);
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("This program will print out a histogram of the numbers");
        sb.append(System.getProperty("line.separator"));
        sb.append("input by you " + getFirstName(me) + ".");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("Please enter up to " + MAX_NUMBERS + " doubles or " + SENTINAL + " to stop input!");
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }

    /*
     * Method to return the first name of the user in case the full name was
     * entered.
     */
    public static String getFirstName(String name) {
        // Note that add the " " to string to be sure
        // there is something to split
        return (name + " ").split(" ")[0];
    }

    /*
     * This method checks if the user has input valid methods
     */
    public static boolean validInput(Double num) {
        boolean result = false;
        if (num <= UPPER_BOUND && num >= LOWER_BOUND) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
  
    /*
     * This method takes the input an inputs it into an array. It then loops through
     * the array and puts the numbers in their respective bins.
     */
    public static int [] calculateHistogram(double [] newArray ){
        int [] histogram = new int [NUM_BINS];
        for(int y = 0; y < newArray.length; y++){
            double newNum = (newArray[y]/10);
            //If the number is at the boader it needs to be moved to the one before
            if(newNum % 10 != 0.0){
              int answer = (int) Math.floor(newNum);
              histogram[answer] += 1;
            }else{
               int answer = ((int) Math.floor(newNum)) - 1;
               histogram[answer] += 1;
            }
        }
        System.out.println(Arrays.toString(histogram));
        return histogram;
    }
    public static String getHistogramAsString( int [] histogram ) {
        StringBuilder strb = new StringBuilder();
        strb.append("Here's the Histogram:");
       for(int y =0; y< histogram.length; y++){
        strb.append(System.getProperty("line.separator"));
        strb.append("(" + (y*10) + "..." + ((y+1)*10)+"] :");
        for(int i = 0; i < histogram[y]; i++){
            strb.append("*");
        } 
       }
       return strb.toString();
    }
    //This is theoriginal method that I had, that I thought would help me work on my histogram....guess not
    public static double[] inputNumbers() {
        // I need to intoduce a new Scanner object that allows them to put in input and
        // checks it simaultaneously
        double[] numbers = new double[20];
        Scanner scan = new Scanner(System.in);
        System.out.println("\nYou may begin inputting your numbers, one number at a time:");
        int i = 0;
        // I need to have a variable that holds the number of inputted doubles
        int count = 0;
        while (scan.hasNextDouble()) {
            double newNum = scan.nextDouble();

            if (validInput(newNum) == false && (newNum != SENTINAL)) {
                System.out.println("Invalid Input! Try another number between 0.0 and 100.0");
            } else if (validInput(newNum) == true && i < 20 && (newNum != SENTINAL)) {
                System.out.println("Valid!");
                numbers[i] = newNum;
                i += 1;
                count += 1;
            } else {
                System.out.println("OK! You've input all your numbers.");
                break;
            }

        }
        scan.close();

        // Creating a new array based on the number of doubles that the user inputted
        // I will first use a conditional to check the number of doubles
        // Trying to initialize a new array that has only the inputted values
        double[] newArray = new double[count];
        for (int x = 0; x < newArray.length; x++) {
            newArray[x] = numbers[x];
        }
        //trying to check my newArray
        System.out.println(Arrays.toString(newArray));
        numbers = newArray;
        return numbers;
    }

    /*
     * local main test driver
     *
     */
    public static void main(String[] args) {

        // Connect to the keyboard as the input stream
        Scanner userInput = new Scanner(System.in);

        System.out.print("And who am I working with today? ");
        String user = userInput.nextLine();

        String heading = getHeaderAsString(user);

        // Print out welcome message
        System.out.println(heading);

        // Call the method which prompts the user
        // to input the numbers that will be used
        // to build the histogram.
        double[] numbers = inputNumbers();

        // Call the method to create the array histogram
         int[] histogram = calculateHistogram( numbers );

        // Print the historgram
         System.out.println( Arrays.toString( histogram ) );
         //Calling the printed histogram
         System .out.println(getHistogramAsString(histogram));
    }

} // end of class
