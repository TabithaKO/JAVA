/*
 * Problem Set 1
 *
 * File: Statistics.java
 * Author: Tabitha Oanda
 * Course: CS112, Boston University
 * Section: A
 *
 * Purpose: Template code - Alter to state the purpose of this program
 */


import java.util.Scanner;

public class Statistics { 
    
//The main method is what I use to collect user input
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the first number");
        int num1 = scan.nextInt();  // Read user input
        System.out.println("Enter the second number");
        int num2 = scan.nextInt();  // Read user input
        System.out.println("Enter the third number");
        int num3 = scan.nextInt();  // Read user input
        scan.close();
        System.out.println("The numbers are " + ""+ num1 + " "+ num2 + " "+ num3);  // Output user input 
        display_statistics(num1, num2, num3);
    }
    
    /*
     * display_statistics()
     *
     * Static method of this class which will be used to calulate and
     * display the required statistics.
     *
     * This method accepts three integer arguments as input values and uses
     * the input values to compute the statistics. This method is a void 
     * method and does not return any value.
     */ 
    public static void display_statistics( int numOne, int numTwo, int numThree ) {
        // I'm adding up the numbers 
        int sum = (numOne + numTwo + numThree);
        System.out.println("The sum is " + "" + sum);
        // Evaluating each to find the max and mins
        int maxcheck1 = Math.max(numOne, numTwo);
        int maxcheck2 = Math.max(maxcheck1,numThree);
        System.out.println("The max is " + "" + maxcheck2);
        int mincheck1 = Math.min(numOne, numTwo);
        int mincheck2 = Math.min(mincheck1, numThree);
        System.out.println("The min is " + "" + mincheck2);
        //Finding the mean
        int mean = (numOne + numTwo + numThree)/3;
        System.out.println("The mean is " + "" + mean);
        // Below are the line of code that calculate the standard deviation
        double num12 = Math.pow((numOne - mean),2);
        double num22 = Math.pow((numTwo - mean),2);
        double num32 = Math.pow((numThree - mean),2);
        double newMean = (num12 + num22 + num32)/3.0;
        double deviation = Math.sqrt(newMean);
        System.out.println("The standard deviation is " + "" + deviation);
        int [] array = {numOne, numTwo, numThree};
        for (int i = 0; i < array.length; i++){
            if (array[i] != mincheck2 && array[i] != maxcheck2){
               
                    System.out.println("Here are the numbers in ascending order " + "" + mincheck2 + " " + array[i]  + " "+ maxcheck2);
                
            }
        }
        

        }
        
    };

