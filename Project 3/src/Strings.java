/* File: Strings.java
 * Date: 10/12/17
 * Author: Benjamin Stephen & Destin Altman
 * Description: Displays full ISBN number and takes a string composed of three words and prints
 * them out in lexicographic order
 */

import java.util.Scanner;

public class Strings {
  public static void main( String [] args) {
    
    Scanner input = new Scanner(System.in);
    
    // Gets ISBN input
    String isbn = input.nextLine();

    // Sets char variables to certain indexes of string
    char one = isbn.charAt(0);
    char two = isbn.charAt(2);
    char three = isbn.charAt(3);
    char four = isbn.charAt(4);
    char five = isbn.charAt(6); 
    char six = isbn.charAt(7);
    char seven = isbn.charAt(8);
    char eight = isbn.charAt(9);
    char nine = isbn.charAt(10);

    // Gets numeric value at char indexes
    int d1 = Character.getNumericValue(one);
    int d2 = Character.getNumericValue(two);
    int d3 = Character.getNumericValue(three);
    int d4 = Character.getNumericValue(four);
    int d5 = Character.getNumericValue(five);
    int d6 = Character.getNumericValue(six);
    int d7 = Character.getNumericValue(seven);
    int d8 = Character.getNumericValue(eight);
    int d9 = Character.getNumericValue(nine);
    int d10 = ((d1 * 1) + (d2 * 2) + (d3 * 3) + (d4 * 4) + (d5 * 5) + 
               (d6 * 6) + (d7 * 7) + (d8 * 8) +(d9 * 9)) % 11;

    // Declares new string and puts proper value of d10 at the end
    String isbnNew;
    
    if(d10 == 10)
      isbnNew = isbn + "-X";
    else
      isbnNew = isbn + "-" + d10;
    
    System.out.println(isbnNew);
    
    // Second part
    
    // Gets input from user
    String words = input.nextLine();
    
    // Identifies where the words begin and end
    int indexOfSemicolon = words.indexOf(';');
    int lastIndexOfSemicolon = words.lastIndexOf(';');
    
    // Identifies the first word, second word, and third word
    String firstWord, secondWord, thirdWord;
    
    firstWord = words.substring(0, indexOfSemicolon).trim();
    secondWord = words.substring(indexOfSemicolon + 1, lastIndexOfSemicolon).trim();
    thirdWord = words.substring(lastIndexOfSemicolon + 1).trim();
 
    // Capitalizes the first letter and converts all the proceeding letters into lowercase for each word
    firstWord = firstWord.substring(0,1).toUpperCase() + firstWord.substring(1).toLowerCase().trim();
    secondWord = secondWord.substring(0,1).toUpperCase() + secondWord.substring(1).toLowerCase().trim();
    thirdWord = thirdWord.substring(0,1).toUpperCase() + thirdWord.substring(1).toLowerCase().trim();
    
    // Arranges and displays the words in lexicographic order
    if (firstWord.compareTo(secondWord) < 0 && secondWord.compareTo(thirdWord) < 0) {
      System.out.println(firstWord);
      System.out.println(secondWord);
      System.out.println(thirdWord);
    }
    else if (firstWord.compareTo(thirdWord) < 0 && thirdWord.compareTo(secondWord) < 0) {
      System.out.println(firstWord);
      System.out.println(thirdWord);
      System.out.println(secondWord);
    }
    else if (secondWord.compareTo(firstWord) < 0 && firstWord.compareTo(thirdWord) < 0) {
      System.out.println(secondWord);
      System.out.println(firstWord);
      System.out.println(thirdWord);
    }
    else if (secondWord.compareTo(thirdWord) < 0 && thirdWord.compareTo(firstWord) < 0) {
      System.out.println(secondWord);
      System.out.println(thirdWord);
      System.out.println(firstWord);
    }
    else if (thirdWord.compareTo(firstWord) < 0 && firstWord.compareTo(secondWord) < 0) {
      System.out.println(thirdWord);
      System.out.println(firstWord);
      System.out.println(secondWord);
    }
    else if (thirdWord.compareTo(secondWord) < 0 && secondWord.compareTo(firstWord) < 0) {
      System.out.println(thirdWord);
      System.out.println(secondWord);
      System.out.println(firstWord);
    }
  }
}