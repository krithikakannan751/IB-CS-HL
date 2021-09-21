
import java.io.IOException;
import java.io.RandomAccessFile;

/**
   This class is a conduit to a random access file
   containing savings product data.
*/
public class ProductData
{
   private RandomAccessFile file;

   // complete the following constants by adding their initial values
   public static final int INT_SIZE = 4;  	// number of bytes used to store an int
   public static final int DOUBLE_SIZE = 8;  // number of bytes used to store a double
   public static final int NAME_LENGTH = 30;	// number of characters in a name
   public static final int NAME_SIZE = 60;	// number of bytes used to store a name
   public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE + NAME_SIZE;  // size of a complete Product record (use other constants to calculate)
         
   /**
      Constructs a ProductData object that is not associated
      with a file.
   */
   public ProductData()
   {
      file = null;
   }
   
   public ProductData(RandomAccessFile file)
   {
   	this.file = file;
   }

   /**
      Opens the data file.
      @param filename the name of the file containing savings
      product information
   */
   public void open(String filename) throws IOException
   {
   		// if there is already a file assigned, close it
   		if(file!=null)
   			file.close();
   		// then instantiate file as a random access file for reading and writing
  		file = new RandomAccessFile(filename, "rw");
   }

   /**
      Gets the number of products in the file.
      @return the number of products
   */
   public int size() throws IOException
   {
   		// determine and return the number of Product records in the file
   		 return (int)file.length()/RECORD_SIZE;
   }

   /**
      Closes the data file.
   */
   public void close() throws IOException
   {
   		// if file has been instantiated, close it
   		if(file!=null)
   			file.close();
   		// set file back to null
      	file=null;
   }

   /**
      Reads a product record.
      @param n the index of the product in the data file
      @return a product object initialized with the file data
   */
   public Product read(int n) throws IOException
   {  
   		// move the file pointer to the record at index n
   		// use readFixedString to read in the name from the file
   		// read in the price and quantity from the file
   		// return a new product with those fields
   		file.seek(n*RECORD_SIZE);
   		String x = readFixedString(NAME_LENGTH);
   		double y = file.readDouble();
   		int z = file.readInt();
   		return new Product(x,y,z);
   }

   /**
      Finds the position of a product with a given name
      @param productName the product name to find
      @return the position of the product with the given name, 
      or -1 if there is no such product
   */
   public int find(String productName) throws IOException
   {
   		// Go through the file reading names (use readFixedString) until the productName
   		// is found.  If it is found, return the index.  If not, return -1
   		String x = "";
      	for(int i = 0; i< file.length(); i++)
      	{
      		file.seek(i*RECORD_SIZE);
      		if(readFixedString(NAME_LENGTH).equals(productName))
      		{
      			return i;
      		}
      	}
      	return -1;
   }

   /**
      Writes a product record to the data file
      @param n the index of the product in the data file
      @param product the product to write
   */
   public void write(int n, Product product) throws IOException
   {  
   		// write product to the appropriate location in the file
   		// use writeFixedString to write the name
 		file.seek(n*RECORD_SIZE);
 		writeFixedString(product.getName(), NAME_LENGTH);
 		file.writeDouble(product.getPrice());
 		file.writeInt(product.getQuantity());
   }

   /**
      Reads a fixed width string.
      @param size the number of characters to read
      @return the string with trailing spaces removed
   */
   public String readFixedString(int size) throws IOException
   {  
      String b = "";
      for (int i = 0; i < size; i++)
         b += file.readChar();
      return b.trim();
   }
   
   /**
      Writes a fixed width string.
      @param s the string to write
      @param size the number of characters to write
   */
   public void writeFixedString(String s, int size) throws IOException
   {  
      if (s.length() <= size)
      {  
         file.writeChars(s);
         for (int i = s.length(); i < size; i++)
            file.writeChar(' ');
      }
      else
         file.writeChars(s.substring(0, size));
   }

}
