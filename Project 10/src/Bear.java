/* File: Bear.java
 * Author: Ahren, Ben, Destin
 * Date: December 14, 2017
 * Description: A Bear class, extension of Critter class..
 */
import java.awt.Color;

public class Bear extends Critter {
  private boolean grizzly;
  private int moves;

  public Bear(boolean grizzly) {
    this.grizzly = grizzly;
  }
  
  // Method for eating
  public boolean eat() {
    // Will always eat
    return true;
  }

  // Method for fighting
  public Attack fight(String opponent) {
    // Will always scratch
    return Attack.SCRATCH;
  }
  
  // Method to set color
  public Color getColor() {
    // If bear is grizzly, color is brown
    if (this.grizzly) {
      return new Color(190, 110, 50);
    }
    // If not, polor bear, and color is white
    else {
      return Color.WHITE;
    }
  }

  // Method for movement
  public Direction getMove() {
    moves++;
    // Moves in a zigzag northwest
    if (moves % 2 == 0) {
      return Direction.WEST;
    }
    else {
      return Direction.NORTH;
    }
  }
  
  // Displays "B" for bears
  public String toString() {
    return "B";
  }
}