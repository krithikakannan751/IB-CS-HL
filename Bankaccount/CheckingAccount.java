/**
   A checking account that charges transaction fees.
*/
public class CheckingAccount extends BankAccount
{  

   private int transactionCount;
   private double monthFee;
   private static final int FREE_TRANSACTIONS = 3;
   private static final double TRANSACTION_FEE = 2.0;
   
   /**
      Constructs a checking account with a given balance.
      @param initialBalance the initial balance
   */
   public CheckingAccount(double initialBalance, String accountNumber)
   {  
      // Construct superclass
      super(initialBalance, accountNumber);
   
      // Initialize transaction count
      transactionCount = 0; 
   }

   public void deposit(double amount) 
   {  
      transactionCount++;
      
      // Now add amount to balance 
      balance+=amount;
    
   }
   
   public void withdraw(double amount) 
   {  
      transactionCount++;
      // Now subtract amount from balance 
      balance-=amount;
   
   }

   /**
      Deducts the accumulated fees and resets the
      transaction count.
   */
   public void deductFees()
   {  
      if (transactionCount > FREE_TRANSACTIONS)
      {  
         double fees = TRANSACTION_FEE *
               (transactionCount - FREE_TRANSACTIONS);
         withdraw(fees);
         monthFee+=fees;
      }
      transactionCount = 0;
   }
   
   public String endOfMonth()
   {
   		deductFees();
   		double i = monthFee;
   		monthFee = 0;
    	return "Current balance for account " + super.toString() + " Fees charged: $ " + i;
   }
   
   


}
