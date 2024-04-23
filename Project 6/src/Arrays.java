/* File: Arrays.java
 * Date: 11/8/17
 * Author: Ahren Foreman, Destin Altman, Ben Stephen
 * Description: Part 1)  Takes as parameters an integer array 'ar' and a positive integer 'num', 
 *                       and returns an array that is 'num' times as long as 'ar' and has 'num' copies 
 *                       of each element of 'ar'
 *              Part 2)  Prints out the state of lockers (one per line), after all 'n' students 
 *                       have passed through and changed the lockers
 */

import java.util.Scanner;

public class Arrays {
  public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    
// PART 1
    // Get length of array from user and declare said array
    int arLength = input.nextInt();
    int [] ar = new int [arLength];
    
    // Get elements of array from user
    for (int i = 0; i < ar.length; i++) {
      ar[i] = input.nextInt();
    }
    
    // Get scale factor from user, all "copyIntArray" method, and display result
    int num = input.nextInt();
    int [] arCopy = copyIntArray(ar, num);
    displayIntArray(ar, arCopy, num);
    
// PART 2
    // Get number of students and lockers from user
    int n = input.nextInt();
    boolean [] lockerState = new boolean [n];
    System.out.println(n);
    
    // 1st student opens ALL lockers
    for (int i = 0; i < n; i++)
      lockerState[i] = true;
    
    // 2nd student closes every 2nd locker; 3rd stu. opens 3rds; 4th closes 4ths; etc...
    for (int j = 1; j < n; j++) {
      for (int k = j; k < n; k++) {
        if ((((k + 1) % (j + 1)) == 0) && (lockerState[k] == true))
          lockerState[k] = false;
        else if ((((k + 1) % (j + 1)) == 0) && (lockerState[k] == false))
          lockerState[k] = true;
      }
    }
  
    for (int p = 0; p < n; p++) {
      if (lockerState[p] == true)
        System.out.println("Locker " + (p + 1) + " is open");
      else
        System.out.println("Locker " + (p + 1) + " is closed");
    }
  }
  
  // Copies elements of an array 'n' number of times
  public static int [] copyIntArray(int [] ar, int n) {
    
    // Declare and allocate space for the array copy
    int [] arCopy = new int [ar.length * n];
    int index = 0;
  
    // Copy elements 'n' times into arCopy
    for (int i = 0; i < ar.length; i++) {
      for (int k = 0; k < n; k++)
        arCopy[k + index] = ar[i];
      index += n;
    }
    return arCopy;
  }
  
  // Displays an array
  public static void displayIntArray(int [] ar, int [] ar2, int num) {
    System.out.println(ar.length);
    for (int i = 0; i < ar.length; i++)
      System.out.print(ar[i] + " ");
    System.out.println();
    System.out.println(num);
    System.out.print("[");
    for (int j = 0; j < ar2.length - 1; j++)
      System.out.print(ar2[j] + " ");
    System.out.println(ar[ar.length - 1] + "]");
  }
}