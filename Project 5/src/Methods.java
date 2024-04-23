/* File: Methods.java
 * Date: 11/2/17
 * Authors: Ben Stephen & Destin Altman
 * Description: Finds the number of occurrences of
 * a specified character in a specified string and
 * takes two lexicographically ordered strings and 
 * merges them into a single new string that is also 
 * lexicographically ordered.
 */

import java.util.Scanner;

public class Methods {
  public static void main(String [] args) {
    
    // Creates a scanner
    Scanner input = new Scanner(System.in);
    
    // Takes input of a string and a character
    String s = input.next();
    char c = input.next().charAt(0);
    
    // Takes input of a string until user enters a valid string
    String str1 = input.next();
    while (!validString(str1)) {
      str1 = input.next();
    }
    String str2 = input.next();
    while (!validString(str2)){
      str2 = input.next();
    }
    
    // Displays what the user entered and the return value of the methods called
    System.out.println(s + " " + c);
    System.out.println(characterCount(s, c));
    System.out.println("String 1: " + str1);
    System.out.println("String 2: " + str2);
    System.out.println(mergeStrings (str1, str2));
  }
  
  // Returns the number of occurrences of the character c in the 
  // String s public static int characterCount(String s, char c) 
  public static int characterCount(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c)
        count++;
    }
    return count;
  }
  
  /**
   * Tests if a string is in lexicographic order
   */
  public static boolean validString(String str) {
    boolean x = true;
    for (int k = 0; k < str.length() - 1; k++) {
      if (str.charAt(k) > str.charAt(k + 1))
        x = false;
      if (str.charAt(k) == str.charAt(k + 1))
        x = true;
    }
    return x;
  }
  
  /**
   * Merges two strings in lexicographic order
   */
  public static String mergeStrings (String str1, String str2) {
    String str3 = "";
    int i = 0;
    int j = 0;
    while (i < str1.length() && j < str2.length()) {
      if (str1.charAt(i) <= str2.charAt(j)) {
       str3 = str3 + str1.charAt(i);
       i++;
      }
      else {
        str3 = str3 + str2.charAt(j);
        j++;
      }
    }
    if(str1.length() == str2.length()) {
      if (j == str2.length() - 1)
        str3 = str3 + str1.substring(i);
      else if (j == str1.length() - 1)
        str3 = str3 + str2.substring(i);
      else if (i == str2.length()-1)
        str3 = str3 + str1.substring(j);
      else
        str3 = str3 + str2.substring(j);
    }
    else if(str1.length() != str2.length()) {
      if (j == str2.length())
        str3 = str3 + str1.substring(i);
      else if (j == str1.length())
        str3 = str3 + str2.substring(i);
      else if (i == str2.length())
        str3 = str3 + str1.substring(j);
      else
        str3 = str3 + str2.substring(j);
    }
    return str3;
  }
}
