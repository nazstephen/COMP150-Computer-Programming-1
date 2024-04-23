/* File: Rectangles.java
 * Date: October 6, 2017
 * Authors: Destin Altman & Ben Stephen
 * Description: Reads in coordinates of rectangles and determines 
 * if contained within one another, disjoint, or overlap.
 * If overlap calculates area of overlap.
 */

import java.util.Scanner;

public class Rectangles {
  
 public static void main(String [] args) {

   // Reads input in from user
   Scanner input = new Scanner(System.in);
   int point1 = input.nextInt();
   int point2 = input.nextInt();
   int point3 = input.nextInt();
   int point4 = input.nextInt();
   int point5 = input.nextInt();
   int point6 = input.nextInt();
   int point7 = input.nextInt();
   int point8 = input.nextInt();

   //Lables variables to proper left and right diagonals of rectangle 1
   int left1X= Math.min(point1, point3);
   int right1X= Math.max(point1, point3);
   int left1Y= Math.max(point2, point4);
   int right1Y= Math.min(point2, point4);

   //Labels for rectangle 2
   int left2X = Math.min(point5, point7);
   int right2X = Math.max(point5, point7);
   int left2Y = Math.max(point6, point8);
   int right2Y = Math.min(point6, point8);

   //Determines realtionship between two rectangles and returns that relationship
   if(left2X < left1X && left2Y > left1Y && right2X > right1X && right2Y < right1Y)
      System.out.println( "1 is inside of 2");

   else if(left2X > left1X && left2Y < left1Y && right2X < right1X && right2Y >right1Y)
      System.out.println( "2 is inside of 1");

   else if(right1X <= left2X || right2X <= left1X || right1Y >= left2Y || right2Y >= left1Y)
      System.out.println("disjoint");
    
   else {   
          int overlapRightBound= Math.min(right1X, right2X);
          int overlapLeftBound=Math.max(left2X, left1X);
          int overlapBottomBound= Math.max(right1Y, right2Y);
          int overlapUpperBound= Math.min(left1Y, left2Y);

          int area = (overlapRightBound-overlapLeftBound) * (overlapUpperBound-overlapBottomBound);
          System.out.println("overlap: area = " + area);
   }
 }
}
