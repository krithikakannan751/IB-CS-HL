//import java.util.Scanner;
import java.io.*;
import java.util.*;
/**
 * Text menu driven program allowing the user to shop for items
 */
public class Shop
{
	
	static	FileOutputStream outFile = null;
	
	static	ObjectOutputStream outObj = null;
	public static void main(String[] args) throws IOException
    {
    	
    	ShoppingCart myCart = new ShoppingCart();
		Scanner input = new Scanner(System.in);
		boolean fileProbs = true;
		
/*		while(fileProbs)
		{
		
	//	try{
		
		System.out.println("Input file name:");
			fileProbs = false;
			String s = input.nextLine();
			inpFile = new FileInputStream(s);
			inpObj = new ObjectInputStream(inpFile);
			outFile = new FileOutputStream(s);
			outObj = new ObjectOutputStream(outFile);
//		}catch(Exception e)
	//	{
			System.out.println("Invalid");
	//		fileProbs = true;
	//	}
		}
		 */
		char choice;
		do
		{
			printMenu();
			choice = input.nextLine().charAt(0);
			choice = Character.toUpperCase(choice);
			if (choice != 'Q')
			{
				dispatch(choice, myCart); // process their choice
			}
		
    	}
    	while(choice != 'Q');
		System.out.println("Thanks for shopping!");
    }

   	/**
   	 * Process the menu choices
   	 * @param choice the user's menu choice
   	 * @param basket the current shopping cart
   	 */
    public static void dispatch(char choice, ShoppingCart basket)
    {
try{

    	boolean probs = true;
    	String itemName = "";
		double itemPrice = 0;
		int quantity = 0;
		Scanner input = new Scanner(System.in);
		switch(choice)
		{
		    
		    case 'A': // add an item to the cart
probs = true;
				while(probs)
				{
					try{			
					System.out.print ("Enter the name of the item: "); 
					itemName = input.nextLine();
					probs = false;
					}
					catch(Exception e)
					{
						probs = true;
						System.out.println("try again");
					}
				}
				probs = true;
				while(probs)
				{
					try{
						System.out.print ("Enter the unit price: ");
				itemPrice = input.nextDouble();
				probs = false;
				}
					catch(Exception e)
					{
						probs = true;
						System.out.println("try again");
					}
				}	
					probs = true;
				while(probs)
				{
					try{
				System.out.print ("Enter the quantity: ");
				quantity = input.nextInt();
				probs = false;
						}
					catch(Exception e)
					{
						probs = true;
						System.out.println("try again");
					}
				}
				input.nextLine();
		
				basket.addItem(new Item(itemName, itemPrice, quantity));
			
				break;
		    case 'F': // find an item in the cart
		    probs = true;
		    	while(probs)
				{
					try{
						System.out.print("Item are you looking for: ");
						itemName = input.nextLine();
				
						probs = false;
						}
					catch(Exception e)
					{
						probs = true;
						System.out.println("try again");
					}
				}
				int count = basket.countItem(new Item(itemName));
				System.out.println("You have " + count + " " +itemName + " in your cart.");
				break;
		    case 'P': // print the cart contents
				System.out.println(basket);
				break;
			
			case 'R':  // remove an item from the cart
			probs = true;
		    	while(probs)
				{
					try{
				System.out.print("Item to remove: ");
				itemName = input.nextLine();
				probs = false;
						}
					catch(Exception e)
					{
						probs = true;
						System.out.println("try again");
					}
				}
				if (basket.removeItem(new Item(itemName)))
					System.out.println(itemName + " has been removed from your cart.");
				else
					System.out.println("You have no " + itemName + " in your cart to remove.");
				break;
			case 'C': // check out
				System.out.printf("The total cost of your purchase before tax is $%.2f",basket.getTotalCost());
				basket.emptyCart();
				break;
				
			case 'E': // empty cart
				basket.emptyCart();
				break;
			
			//***************************************************************************my stuff
			case 'S': // save
			probs = true;
		    	while(probs)
				{
					try{
				System.out.println("enter file name");
				FileOutputStream outFile = new FileOutputStream(new File(input.nextLine()));
				ObjectOutputStream outObj = new ObjectOutputStream(outFile);
				outObj.writeObject(basket);	
					probs = false;
				}
					catch(Exception e)
					{
						probs = true;
						System.out.println("try again");
					}
				}		
				break;
			case 'L': // load
			while(probs)
				{
					try{
			System.out.println("enter file name");
				FileInputStream inpFile = new FileInputStream(new File(input.nextLine()));
				ObjectInputStream inpObj = new ObjectInputStream(inpFile);
				basket.copyCart((ShoppingCart)inpObj.readObject());
				probs = false;
				}
					catch(Exception e)
					{
						probs = true;
						System.out.println("try again");
					}
				}		
				break;
			
		    default:
				System.out.println("Sorry, invalid choice");
    	}
}catch(Exception e){}

    }


    /**
     * Prints the menu choices)
     */
    public static void printMenu()
    {

		System.out.println("\n   Menu   ");
		System.out.println("   ====");
		
		System.out.println("A: Add an item to the cart");
		System.out.println("F: Find an item in the cart by name");
		System.out.println("P: Print the cart contents");
		System.out.println("R: Remove an item from the cart");
		System.out.println("C: Check out");
		System.out.println("E: Start over with an empty cart");
		System.out.println("S: Save the cart to a file");
		System.out.println("L: Load the cart from a file");
		System.out.println("Q: Quit");
		System.out.print("\nEnter your choice: ");
    }


}

