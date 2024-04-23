/* File: AccountTest.java
 * Date: 12/1/17
 * Author: Ben Stephen, Destin Altman, Ahren Foreman
 * Description: Part 3)  A class that tests Account
 */

import java.util.Scanner;

public class AccountTest {
  public static void main(String [] args) {
    
    Scanner input = new Scanner(System.in);
    
    // Reads in initial amount of money in the account1 from user
    double balance1 = input.nextDouble();
    Account account1 = new Account(balance1);
    
    // Reads in initial amount of money in the account2 from user
    double balance2 = input.nextDouble();
    Account account2 = new Account(balance2);
    
    // Withdraws or deposits money from account1 depending on the value inputed
    double x = 1;
    while (x != 0) {
      x = input.nextDouble();
      if(x > 0)
      account1.deposit(x);
      else
      account1.withdraw(Math.abs(x));
    }
    
    // Withdraws or deposits money from account2 depending on the value inputed
    double x2 = 1;
    while (x2 != 0) {
      x2 = input.nextDouble();
      if (x2 > 0)
      account2.deposit(x2);
      else
      account2.withdraw(Math.abs(x2));
    }
    
    // Displays the ID, the balance and the current date
    System.out.println(account1.toString());
    System.out.println(account2.toString());
  }
}