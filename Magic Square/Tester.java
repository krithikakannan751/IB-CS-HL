/**
 * @(#)Tester.java
 *
 *
 * @author 
 * @version 1.00 2018/8/22
 */
import java.util.Scanner;
public class Tester 
{
    public static void main(String[] args) 
    {
        // TODO code application logic here
        System.out.print ("Enter the odd# size of the magic square --> ");
        Scanner red = new Scanner(System.in);
        
		
			int x = red.nextInt();
	        MagicSquare blue = new MagicSquare(x);
	        blue.computeMagicSquare();
	        System.out.println ("");
	        System.out.println (x +"x"+ x + "Magic Square");
	        System.out.println ("==================");
	        System.out.print(blue.toString());
	        System.out.println ();
  
    }
}
