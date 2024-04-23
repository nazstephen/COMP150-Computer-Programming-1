/* File: Energy.java
 * Date: 9/20/17
 * Author: Benjamin Stephen & Destin Altman
 * Description: Finds energy needed to heat water from an initial to a final temperature
 */

import java.util.Scanner;

public class Energy {
  public static void main(String [] args) {
     
    // Create scanner object to get user input.
    Scanner scanner = new Scanner(System.in);
    
    // Get input from user.
    System.out.print("Enter the amount of water in kilograms:");
    double weightOfWater = scanner.nextDouble();
    System.out.println("Enter the initial temperature:");
    double initialTemp = scanner.nextDouble();
    System.out.println("Enter the final temperature:");
    double finalTemp = scanner.nextDouble();
    
    // Compute and display energy
    double energy = weightOfWater * (finalTemp - initialTemp) * 4184;
    System.out.println("The energy needed is " + energy + " joules");
  }
}



