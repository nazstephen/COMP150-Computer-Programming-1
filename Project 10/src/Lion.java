/* File: Bear.java
 * Author: Ahren, Ben, Destin
 * Date: December 14, 2017
 * Description: A Lion class, extension of Critter class..
 */
import java.awt.Color;

public class Lion extends Critter {
  private boolean hunger;
  private int moves = 0;
  
  public Lion() {
  }
  
  // Sets color of lion to RED
  public Color getColor() {
    return Color.RED;
  }
  
  // Method for eating
  public boolean eat() {
    // When hungry, will eat, and sets hunger to false
    if (hunger == true) {
      hunger = false;
      return true;
    }
    // When not hungry, will not eat
    else {
      return false;
    }
  }
  
  // Method for fighting
  public Attack fight(String opponent) {
    // Becomes hungry from fighting
    hunger = true;
    // If opponent is a bear, use roar
    if (opponent.equals("B")) {
      return Attack.ROAR;
    }
    // If not a bear, use pounce
    else {
      return Attack.POUNCE;
    }
  }
  
  // Method for movement
  public Direction getMove() {
    // Moves in a square of 5 units
    if (moves <= 4) {
      moves++;
      return Direction.SOUTH;
    }
    else if (moves <= 9) {
      moves++;
      return Direction.WEST;
    }
    else if (moves <= 14) {
      moves++;
      return Direction.NORTH;
    }
    else if (moves <= 18) {
      moves++;
      return Direction.EAST;
    }
    // Resets movement counter
    else {
      moves = 0;
      return Direction.EAST;
    }
  }
  
  // Displays "L" for lions
  public String toString() {
    return "L";
  }
}