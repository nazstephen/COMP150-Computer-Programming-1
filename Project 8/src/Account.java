/* File: Sort.java
 * Date: 12/1/17
 * Author: Ben Stephen, Destin Altman, Ahren Foreman
 * Description: Part 2)  A class that represents a bank account.
 */

import java.util.Date;

public class Account {
  // Static variable
  private static int nextId = 1000000; 
  
  // Data fields
  private int id;
  private double balance;
  private Date dateCreated;
  
  // Constructors
  public Account(double balance) {
    this.balance = balance;
    this.id = nextId;
    this.nextId++;
    this.dateCreated = new Date();
  }
  
  public Account() {
    this.balance = 0;
  }
  
  /**
   * Returns ID
   */
  public int getId() {
    return this.id;
  }
  
  /**
   * Returns balance
   */
  public double getBalance() {
    return this.balance;
  }
  
  /**
   * Withdraws money from an account and returns true if its successful
   */
  public boolean withdraw(double amount){
     if (this.balance - amount >= 0) {
       balance = this.balance - amount;
       return true;
     }
     else 
       return false;
   }
  
  /**
   * Deposits money into account
   */
  public void deposit(double amount) {
    this.balance += amount;
  }
  
  /**
   * Returns string that displays the ID, the balance and the current date 
   */
  public String toString() {
      return ("Id: " + getId() + " Balance: $" + String.format("%.2f", balance) + 
              " Date Created: " + dateCreated);
  }
}

    