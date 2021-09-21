
import static java.lang.System.*;

public class BinaryTreeTester
{
   public static void main( String args[] )
   {
	   	BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(90);
		tree.add(100);
		tree.add(80);
		tree.add(70);
		tree.add(85);
		tree.add(98);
		tree.add(120);
     
	
		out.println("IN ORDER");
		tree.inOrder();
	
		out.println("PRE ORDER");
		tree.preOrder();

		out.println("POST ORDER");
		tree.postOrder();

		out.println("REVERSE ORDER");
		tree.revOrder();


		out.println("\nTree height is " + tree.getHeight());
		out.println("\nTree width is " + tree.getWidth());
		out.println("\nNumber of leaves is " + tree.getNumLeaves());
		out.println("\nNumber of nodes is " + tree.getNumNodes());
		out.println("\nNumber of levels is " + tree.getNumLevels());

		out.println("\nTree as a string  " + tree.toString());

		out.println(tree.isFull()?"\nThe tree is full.":"\nThe tree is not full.");
		
		out.println(tree.search(100)?"The tree contains 100!":"The does not contain 100!");
		
		out.println(tree.search(114)?"The tree contains 114!":"The does not contain 114!");
		
		out.println("The smallest tree node " + tree.getSmallest());
		
		out.println("The largest tree node " + tree.getLargest());

		// Bonus - level order
		out.println("\nLevel Order:");
		tree.levelOrder();
		
		out.println("\nPicture of Tree:");
		tree.display();	// picture of tree
		// End Bonus
		
		out.println("\nTree before removing any nodes");
		out.println(tree);
		
		tree.remove(90);
		out.println("\nTree after removing 90.");
		out.println(tree);
		
		tree.remove(70);
		out.println("\nTree after removing 70.");
		out.println(tree);
				
		tree.remove(85);
		out.println("\nTree after removing 85.");
		out.println(tree);
		
		tree.remove(98);
		out.println("\nTree after removing 98.");
		out.println(tree);
		
		tree.remove(80);
		out.println("\nTree after removing 80.");
		out.println(tree);
				
		tree.remove(120);	
		out.println("\nTree after removing 120.");
		out.println(tree);
				
		tree.remove(100);						
		out.println("\nTree after removing 100.");
		out.println(tree);
		
		
		
	}
}