/* File: Sort.java
 * Date: 12/1/17
 * Author: Ben Stephen, Destin Altman, Ahren Foreman
 * Description: Part 1)  Takes as its parameter an integer 1D array
 *                       ar and uses bubble sort to sort the values 
 *                       from smallest at the left endto largest at the 
 *                       right.
 */

import java.util.Scanner;

public class Sort {
  public static void main(String [] args) {

   Scanner input = new Scanner(System.in);
   
   // Reads in amount of elements from user
   int n = input.nextInt();
   int [] ar = new int[n];
   
   // Assigns each element a value inputed by the user 
   for (int i = 0; i < n; i++)
     ar[i] = input.nextInt();
   
   // Calls bubbleSort method
   bubbleSort(ar);
   
   // Displays sorted array
   System.out.print("Sorted array: [");
   for(int i = 0; i < ar.length - 1; i++)
     System.out.print(ar[i] + " ");
   System.out.print(ar[ar.length - 1]);
   System.out.print("]");
 }
  
  /**
   * Sorts the values in the array from smallest to largest
   */
  public static void bubbleSort(int [] ar) {
    boolean fixed = false;
    while (fixed == false) {
      fixed = true;
      for (int i = 0; i < ar.length - 1; i++) {
        if (ar[i] > ar[i + 1]) {
          int temp = ar[i + 1];
          ar[i + 1] = ar[i];
          ar[i] = temp;
          fixed = false;
        }
      }
    }
  }
}

