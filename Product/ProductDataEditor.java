
import java.io.IOException;
import java.util.Scanner;

/**
   This program edits a random access file of product data.   
*/
public class ProductDataEditor
{  
   public static void main(String[] args) throws IOException
   {  
      Scanner in = new Scanner(System.in);
      ProductData data = new ProductData();
      try
      {  
         data.open("product.dat");
         Product currentProduct = null;
         int currentProductIndex = 0;	// needs to store the index of the product most recently found or edited
         boolean done = false;
         while (!done)
         {  
            System.out.print("A)dd record  F)ind record  Change P)rice  Change Q)uantity  E)xit: ");
            String command = in.next().toUpperCase();
            if (command.equals("A"))
            {
               System.out.print("Name is: ");
               in.nextLine(); 
               String name = in.nextLine();
               System.out.print("Price: ");
               double price = in.nextDouble();
               System.out.print("Quantity: ");
               int quantity = in.nextInt();
               
               // add statements to make the new product and write it to the end of the file 
               currentProductIndex = data.size();
               data.write(currentProductIndex, new Product(name, price,quantity));
               // using the ProductData object
               
            }
            else if (command.equals("F"))
            {
               System.out.print("Name: ");
               in.nextLine(); 
               String name = in.nextLine();
               // add statements to determine if the product is in the database. 
               // if not, display "no product selected"
               // if it is in the database, display price and quantity labeled (see sample run)
               currentProductIndex = data.find(name);
               if(currentProductIndex !=-1)
               {
               	System.out.println ("Price: " + data.read(currentProductIndex).getPrice()+ " Quantity: " + data.read(currentProductIndex).getQuantity());
               }
            }
            else if (command.equals("P"))
            {
               if (currentProductIndex == -1)
                  System.out.println("no product selected");
               else
               {
                  System.out.print("New price: ");
                  double price = in.nextDouble();
                  // add statements to update the price of the product and write it to the file
                  String name = data.read(currentProductIndex).getName();
                  int quantity = data.read(currentProductIndex).getQuantity();
                  
                  data.write(currentProductIndex,new Product(name, price, quantity));
               }
            }
            else if (command.equals("Q"))
            {
               if (currentProductIndex == -1)
                  System.out.println("no product selected");
               else
               {
                  System.out.print("New quantity: ");
                  int quantity = in.nextInt();
                  // add statements to update the quantity of the product and write it to the file
                  String name = data.read(currentProductIndex).getName();
                  double price = data.read(currentProductIndex).getPrice();
                  
                  data.write(currentProductIndex,new Product(name, price, quantity));
               }
            }
            else if (command.equals("E"))
            {
               done = true;
            }
         }
      }
      finally
      {
         data.close();
      }
   }
}
