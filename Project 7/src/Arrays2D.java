/* File: Arrays2D.java
 * Date: 11/16/17
 * Author: Ben Stephen, Destin Altman, Ahren Foreman
 * Description: Part 1)  Takes as parameters an integer 2D array 'ar' and
 *                       returns the index of the column with maximum sum.
 *              Part 2)  Takes as parameters an integer 2D array 'ar' and
 *                       tests whether it has four (or more) consecutive
 *                       numbers of the same value, either horizontally or
 *                       vertically. Returns true if it does, and false if not.
 */
 
import java.util.Scanner;
 
public class Arrays2D {
  public static void main(String [] args) {
   
    Scanner input = new Scanner(System.in);
   
// PART 1
    // Get number of rows and columns from user; Create 2Darray
    int rows = input.nextInt();
    int cols = input.nextInt();
   
    int [][] ar = new int [rows][cols];
   
    // Get elements of 2Darray from user
    for (int r = 0; r < ar.length; r++) {
      for (int c = 0; c < ar[r].length; c++) {
        ar[r][c] = input.nextInt();
      }
    }
   
    System.out.println(indexMaxColumnSum(ar));
   
// PART 2
    // Get number of rows and columns from user; Create another 2Darray
    int row2 = input.nextInt();
    int col2 = input.nextInt();
   
    int [][] ar2 = new int [row2][col2];
   
    // Get elements of the new 2Darray from user 
    for (int r = 0; r < ar2.length; r++) {
      for (int c = 0; c < ar2[r].length; c++) {
        ar2[r][c] = input.nextInt();
      }
    }
   
    // Call method, and display result
    if (isConsecutiveFour(ar2) == true)
      System.out.println("Has four consecutive values");
    if (isConsecutiveFour(ar2) == false)
      System.out.println("Does not have four consecutive values");
  }
 
  /**
   * Part 1
   * Takes as parameters an integer 2D array 'ar' and
   * returns the index of the column with maximum sum.
   */
  public static int indexMaxColumnSum(int [][] ar) {
    // Create variables for the column's sum, a max column, and its index
    int sum = 0;
    int max = 0;
    int index = 0;
   
    for (int c = 0; c < ar[ar.length - 1].length; c++) {
      sum = 0;
      // Add all numbers in the column
      for (int r = 0; r < ar.length; r++) {
        sum += ar[r][c];
      }
      // Test if column's sum is the largest
      if (sum > max) {
        max = sum;
        index = c;
      }
    }
    return index;
  }
 
  /**
   * Part 2
   * Takes as parameters an integer 2D array 'ar' and
   * tests whether it has four (or more) consecutive
   * numbers of the same value, either horizontally or
   * vertically. Returns true if it does, and false if not.
   */
  public static boolean isConsecutiveFour(int [][] ar) {
   
    // Check rows
    for (int r = 0; r < ar.length; r++) {
      // Keep count of consecutive nums
      int current = ar[r][0];
      int consecutiveCount = 0;
     
      for (int c = 0; c < ar[r].length; c++) {
        // Test if elements are the same
        if (ar[r][c] == current) {
          consecutiveCount++;
          if (consecutiveCount >= 4)
            return true;
        }
        else {
          current = ar[r][c];
          consecutiveCount = 1;
        }
      }
    }
   
    // Check columns
    for (int c = 0; c < ar[0].length; c++) {
      // Keep count of consecutive nums
      int consecutiveCount = 0;
      int current = ar[0][c];
     
      for (int r = 0; r < ar.length; r++) {
        // Test if elements are the same
        if (ar[r][c] == current) {
          consecutiveCount++;
          if (consecutiveCount >= 4)
            return true;
        }
        else {
          current = ar[r][c];
          consecutiveCount = 1;
        }
      }
    }
    return false; 
  }
}