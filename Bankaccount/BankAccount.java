/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public abstract class BankAccount
{  
	protected double balance; 
	protected String accountNumber;
	
   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount(String accountNumber)
   {  
   	  this.accountNumber = accountNumber;
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance, String accountNumber)
   {  
      balance = initialBalance;
      this.accountNumber = accountNumber;
   }
 
   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   abstract void deposit(double amount);

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   abstract void withdraw(double amount);

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {  
      return balance; 
   }
   
   /**
      Transfers money from the bank account to another account
      @param amount the amount to transfer
      @param other the other account
   */
   public void transfer(double amount, BankAccount other)
   {  
      withdraw(amount);
      other.deposit(amount);
   }
   
   public String toString()
   {
   		return accountNumber + " is: $" + String.format("%9.2f",balance);
   }

   abstract String endOfMonth();
   
   
}
