/**
   An account that earns interest at a fixed rate.
*/
public class SavingsAccount extends BankAccount
{  

   private double interestRate;
   private double interestCurrent;
   /**
      Constructs a bank account with a given interest rate.
      @param rate the interest rate
   */
   public SavingsAccount( double rate, String accountNumber) 
   {  
   	  super( accountNumber);
      interestRate = rate;
   }

   /**
      Adds the earned interest to the account balance.
   */
   public void addInterest() 
   {  
      double interest = getBalance() * interestRate / 100;
      interestCurrent = interest;
      deposit(interest); 
   }
   public void deposit(double amount)
   {
   		balance+=amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
   	 	balance-=amount;
   }
   
   public String endOfMonth()
   {
   		addInterest();
   		double i = interestCurrent;
   		interestCurrent = 0;
    	return "Current balance for account " + super.toString() + " Interest earned: $ " + i;
   }
}
