/* File: Bear.java
 * Author: Ahren, Ben, Destin
 * Date: December 14, 2017
 * Description: A Tiger class, extension of Critter class.
 */
import java.awt.Color;
import java.util.Random;

public class Tiger extends Critter {
  Random randomNum = new Random();
  private int hunger;
  private int steps;
  private int moves = randomNum.nextInt(3);
  
  public Tiger(int hunger) {
    // Hunger is random from 3 - 8
    this.hunger = randomNum.nextInt(4) + 5;
  }
  
  // Sets color of tiger to yellow
  public Color getColor() {
    return Color.YELLOW;
  }
  
  // Method for eating
  public boolean eat() {
    // Hunger is the number of times tiger will eat
    if (this.hunger > 0) {
      this.hunger--;
      return true;
    }
    // When hunger is 0, tiger no longer eats
    else {
      return false;
    }
  }
  
  // Method for fighting
  public Attack fight(String opponent) {
    // If hunger is still left, tiger uses scratch
    if (this.hunger > 0) {
      return Attack.SCRATCH;
    }
    // When hunger is 0, tiger only uses pounce
    else {
      return Attack.POUNCE;
    }
  }
  
  // Method for movement
  public Direction getMove() {
    // First two steps in a random direction
    if (this.moves == 0 && this.steps < 2) {
      this.steps++;
      return Direction.NORTH;
    }
    else if (this.moves == 1 && this.steps < 2) {
      this.steps++;
      return Direction.EAST;
    }
    else if (this.moves == 2 && this.steps < 2) {
      this.steps++;
      return Direction.SOUTH;
    }
    else if (this.moves == 3 && this.steps < 2) {
      this.steps++;
      return Direction.WEST;
    }
    /* Final third step in said direction, 
     * and sets a random direction
     */
    else {
      if (this.moves == 0) {
        this.steps = 0;
        this.moves = randomNum.nextInt(3);
        return Direction.NORTH;
      }
      else if (this.moves == 1) {
        this.steps = 0;
        this.moves = randomNum.nextInt(3);
        return Direction.EAST;
      }
      else if (this.moves == 2) {
        this.steps = 0;
        this.moves = randomNum.nextInt(3);
        return Direction.SOUTH;
      }
      else {
        this.steps = 0;
        this.moves = randomNum.nextInt(3);
        return Direction.WEST;
      }
    }
  }
  
  // Displays number of hunger left for tigers
  public String toString() {
    return "" + this.hunger;
  }
}