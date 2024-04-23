/* File: Loops.java
* Date: 10/17/17
* Authors: Ben Stephen & Destin Altman
* Description: Reads in a positive integer, and displays all of the 
* perfect numbers between 1 and that number and determines the 
* relationship between two strings based on lexicographic ordering
*/

import java.util.Scanner;

public class Loops {
 public static void main(String [] args) {

   Scanner input = new Scanner(System.in);

   // Problem #1

   // Gets positive interger input from user
   int num = input.nextInt();

   //Finds all the perfect numbers between 1 and num and prints them out
   for (int i = 1; i <= num; i++) {
     int sum = 0;
     for (int j = 1; j <= i; j++) {
       if (i % j == 0)
         sum = sum + j;
     }
     if (sum == (2 * i))
       System.out.println(i);
   }

   // Problem #2

   // Gets two string inputs from user
   String str1 = input.next();
   String str2 = input.next();

   // Determines and displays the relationship between the two strings
   int length = Math.min (str1.length(), str2.length());
   for (int k = 0; k <= length; k++) {
     char cha = str1.charAt(k);
     char chb = str2.charAt(k);
     if (((cha < chb) && (str1.substring(k) != str2.substring(k))) || 
         ((cha == chb) && (str1.length() < str2.length()))) {
       System.out.println("less");
       break;
     }
     if (((cha > chb) && (str1.substring(k) != str2.substring(k))) || 
         ((cha > chb) && (str1.length() > str2.length()))) {
       System.out.println("greater");
       break;
     }
     if (str1.substring(k).equals(str2.substring(k))) {
       System.out.println("equal");
       break;
     }
   }
 }
}