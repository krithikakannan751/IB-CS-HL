//*** Object class to practice Linked Lists

public class Product
{  
   private String name;
   private double price;
   private int quantity;
 
   /**
      Constructs a product with empty name and 0 price and
      quantity.
   */
   public Product()
   {  
      name = "";
      price = 0;
      quantity = 0;
     
   }
   
   /**
      Constructs a product with the given name, price and 
      quantity.
      @param aName product name
      @param aPrice product price
      @param aQuantity product quantity
   */
   public Product(String aName, double aPrice, int aQuantity)
   {  
      name = aName;
      price = aPrice;
      quantity = aQuantity;
   }

   /**
      Returns the product name.
      @return the product name
   */
   public String getName()
   {  
      return name;
   }
   
   /**
      Returns the product price.
      @return the product price
   */
   public double getPrice()
   {  
      return price;
   }
   
   /**
      Returns the product quantity.
      @return the product quantity
   */
   public int getQuantity()
   {  
      return quantity;
   }
   
   /**
      Sets the product price.
      @param newPrice the new product price
   */
   public void setPrice(double newPrice)
   {  
      price = newPrice;
   }

   /**
      Sets the product quantity.
      @param newQuantity the new product quantity
   */
   public void setQuantity(int newQuantity)
   {  
      quantity = newQuantity;
   }
   
 	// add toString, equals and compareTo
 	public String toString()
 	{
 		
 		return "Product: " + name + " has a price of " + price           + " and quantity: " + quantity;
 	}
 	public boolean equals(Object o)
 	{
 		Product p = (Product)o;
 		if (p.getName().equals(this.name))
 			return true;
 		else return false;
 	}
 	///////change to compare names
 	public int compareTo(Object o)
 	{
 		Product p = (Product)o;
 		return this.quantity-p.getQuantity();
 	}
}

