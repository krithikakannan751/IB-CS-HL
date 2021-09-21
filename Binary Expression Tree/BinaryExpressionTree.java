
import java.util.*;


/**
 * Tester for the ExpressionTree class
 */      
public class BinaryExpressionTree
{
	public static void main(String args[])
	{
		ExpressionNode root = ExpressionTree.createTree();
		
		System.out.println("Original Tree");
		System.out.println("=============");
		System.out.print("\nIn-Fix Notation:    ");
		ExpressionTree.inOrderTraverse(root);
		System.out.print("\n\nPre-Fix Notation:   ");
		ExpressionTree.preOrderTraverse(root);
		System.out.print("\n\nPost-Fix Notation:  ");		
		ExpressionTree.postOrderTraverse(root);
		System.out.println("\n");		
		
		System.out.println("This tree has "+
		    ExpressionTree.operatorCount(root)+" operators and "+
		   	ExpressionTree.numberCount(root)+" numbers, and evaluates to "+
		    ExpressionTree.evaluate(root)+"\n\n"); 
		    
		ExpressionNode mirrorRoot = ExpressionTree.mirror(root);
		
		System.out.println("\nMirror Tree");
		System.out.println("===========");
		System.out.print("\nIn-Fix Notation:    ");
		ExpressionTree.inOrderTraverse(mirrorRoot);
		System.out.print("\n\nPre-Fix Notation:   ");
		ExpressionTree.preOrderTraverse(mirrorRoot);
		System.out.print("\n\nPost-Fix Notation:  ");		
		ExpressionTree.postOrderTraverse(mirrorRoot);
		System.out.println("\n");		
					
		System.out.println("This tree has "+
		    ExpressionTree.operatorCount(mirrorRoot)+" operators and "+
		   	ExpressionTree.numberCount(mirrorRoot)+" numbers, and evaluates to "+
		    ExpressionTree.evaluate(mirrorRoot)+"\n"); 		
	}
}


