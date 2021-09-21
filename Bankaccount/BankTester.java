/**
   This program tests the BankAccount class and
   its subclasses. 
*/
import java.util.ArrayList;

public class BankTester
{  
   public static void main(String[] args)
   {  
      ArrayList<BankAccount> bank = new ArrayList<BankAccount>();
      
      // create 4 accounts
      CheckingAccount one = new CheckingAccount(125000,"111111");
      SavingsAccount two = new SavingsAccount(5,"222222");
      CheckingAccount three = new CheckingAccount(9999,"333333");
      SavingsAccount four = new SavingsAccount(5,"444444");
      
      // add accounts to bank
	  bank.add(one);
	  bank.add(two);
	  bank.add(three);
	  bank.add(four);
	  
	  // perform transactions     
      one.deposit(123);
      two.deposit(1000);
      three.withdraw(9999);
      four.withdraw(100);
      three.deposit(5495);
      three.deposit(100);
      three.withdraw(40);
      
      // generate end of month report
      System.out.println("End of month report:");
      for(BankAccount acct: bank)
      {
      	System.out.println(acct.endOfMonth());
      }  
   }
}
