/* File: Bear.java
 * Author: Ahren, Ben, Destin
 * Date: December 14, 2017
 * Description: A Torero class, extension of Critter class.
 */
import java.awt.Color;
import java.util.Random;

public class Torero extends Critter {
  Random randomNum = new Random();
  private int hunger = 0;
  private int moves = 0;
  private int attack = randomNum.nextInt(2);
  
  public Torero() {
  }
  
  // Sets color of Torero to blue
  public Color getColor() {
    return Color.BLUE;
  }
  
  // Method for eating
  public boolean eat() {
    // Hunger grows
    this.hunger++;
    // When hunger is 3, Torero eats
    if (this.hunger > 2) {
      this.hunger = 0;
      return true;
    }
    // When hunger is < 3, Torero will not eat
    else {
      return false;
    }
  }
  
  // Method for fighting
  public Attack fight(String opponent) {
    // Chosen attack is random
    if (this.attack == 0) {
      return Attack.ROAR;
    }
    else if (this.attack == 1) {
      return Attack.SCRATCH;
    }
    else {
      return Attack.POUNCE;
    }
  }
  
  // Method for movement
  public Direction getMove() {
    /* Sideways "S" movement, slowly 
     * ascending in northeast direction
     */
    if (moves <= 2) {
      moves++;
      return Direction.SOUTH;
    }
    else if (moves <= 5) {
      moves++;
      return Direction.EAST;
    }
    else if (moves <= 9) {
      moves++;
      return Direction.NORTH;
    }
    else if (moves <= 11) {
      moves++;
      return Direction.EAST;
    }
    else {
      moves = 0;
      return Direction.EAST;
    }
  }
  
  // Displays "T" for Toreroes
  public String toString() {
    return "T";
  }
}
  