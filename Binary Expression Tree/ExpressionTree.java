/**
 * An expression tree stores a mathematical expression in a binary tree.  This
 * one is hard-coded to a specific expression.  All method are static.
 * Because the root is sent as a parameter from the tester, helper methods are
 * not required in this implementation.
 */
public class ExpressionTree
{   
	/** 
	 * Creates a binary expression tree with a specific expression and returns 
	 * a reference to the root
	 * @return a reference to the root of the expression tree
	 */
	public static ExpressionNode createTree()
	{
		ExpressionNode n12  = new ExpressionNode(12,' ',null,null);
		ExpressionNode n6   = new ExpressionNode( 6,' ',null,null);
		ExpressionNode ndiv = new ExpressionNode( 0,'/',n12,n6);
		ExpressionNode n7   = new ExpressionNode( 7,' ',null,null);
		ExpressionNode nadd = new ExpressionNode( 0,'+',n7,ndiv);
		ExpressionNode n2   = new ExpressionNode( 2,' ',null,null);
		ExpressionNode n4   = new ExpressionNode( 4,' ',null,null);
		ExpressionNode ncar = new ExpressionNode( 0,'^',n2,n4);
		ExpressionNode n5   = new ExpressionNode( 5,' ',null,null);
		ExpressionNode nsub = new ExpressionNode( 0,'-',ncar,n5);
		ExpressionNode root = new ExpressionNode( 0,'*',nadd,nsub);
		return root;
	}	
	
	/**
	 * PRINTS an inOrder traversal of the binary expression tree with
	 * spaces between each operator and operand
	 * @param p a reference to the root of the binary expression tree
	 */
	public static void inOrderTraverse (ExpressionNode p)
	{
		if(p!= null)
		{
			if(p.getOpr() != ' ')
			{
			System.out.print("(");
			inOrderTraverse(p.getLeft() );
			System.out.print(" "+p.getOpr()+ " " );
			inOrderTraverse(p.getRight());
			System.out.print(")");
			}
			else
			{
			inOrderTraverse(p.getLeft());
			System.out.print(p.getNum());
			inOrderTraverse(p.getRight());	
			}
		}
	}
	
	/**
	 * PRINTS a preOrder traversal of the binary expression tree with
	 * spaces between each operator and operand
	 * @param p a reference to the root of the binary expression tree
	 */
	public static void preOrderTraverse (ExpressionNode p)
	{
		if(p!= null)
		{
			if(p.getNum() == 0)
			{
		//	System.out.print("(");
		System.out.print(" "+p.getOpr()+ " " );
			preOrderTraverse(p.getLeft() );
			
			preOrderTraverse(p.getRight());
		//	System.out.print(")");
			}
			else
			{
				System.out.print(" "+p.getNum() + " ");
			preOrderTraverse(p.getLeft());
			
			preOrderTraverse(p.getRight());	
			}
		}
	}
	
	/**
	 * PRINTS a postOrder traversal of the binary expression tree with
	 * spaces between each operator and operand
	 * @param p a reference to the root of the binary expression tree
	 */
	public static void postOrderTraverse (ExpressionNode p)
	{
		if(p!= null)
		{
			if(p.getNum() == 0)
			{
		//	System.out.print("(");
		
			postOrderTraverse(p.getLeft() );
			
			postOrderTraverse(p.getRight());
			System.out.print(" "+p.getOpr()+ " " );
		//	System.out.print(")");
			}
			else
			{
				
			postOrderTraverse(p.getLeft());
			
			postOrderTraverse(p.getRight());	
				System.out.print(" "+p.getNum() + " ");
				
			}
		}
	}		
	
	/**
	 * Returns the number of nodes in the expression tree that contain operands
	 * @param p a reference to the root of the binary expression tree
	 * @return the number of operands in the tree
	 */
	public static int numberCount (ExpressionNode p)
	{
		if(p!= null)
		{
			if(p.getLeft() == null && p.getRight() == null)
				return 1;
			else return numberCount(p.getLeft()) + numberCount(p.getRight());
		}
		else return 0;
	}	
	
	/**
	 * Returns the number of nodes in the expression tree that contain operators
	 * @param p a reference to the root of the binary expression tree
	 * @return the number of operators in the tree
	 */		
	public static int operatorCount (ExpressionNode p)
	{
		if(p!= null && p.getOpr() != ' ')
			return 1+ operatorCount(p.getLeft())+operatorCount(p.getRight());
		else return 0;
	}			
	
	/**
	 * THIS METHOD MUST USE RECURSION, not just the stack from the Expression lab!
	 * Returns the numeric result of evaluating the expression
	 * @param p a reference to the root of the binary expression tree
	 * @return the numeric evaluation of the expression
	 */
	public static double evaluate (ExpressionNode p)
	{
		// WRITE RECURSIVELY!!!
		if(p!= null)
		{
			if(p.getLeft() != null && p.getRight() != null) //is operator
			{
				if(p.getOpr() != ' ') //confirm operator
				{
					if(p.getOpr() == '+')
						return evaluate(p.getLeft()) + evaluate(p.getRight());
					else if(p.getOpr() == '*')
						return evaluate(p.getLeft()) * evaluate(p.getRight());
					else if(p.getOpr() == '-')
						return evaluate(p.getLeft()) - evaluate(p.getRight());
					else if(p.getOpr() == '/')
						return evaluate(p.getLeft()) / evaluate(p.getRight());
					else return Math.pow(evaluate(p.getLeft()), evaluate(p.getRight()));
				}
				else return 0;
			}
			else // is number
				return p.getNum();
		}
		else return 0;
	}
	
	/**
	 * Returns a reference to a new binary expression tree that is the mirror of
	 * the original tree
	 * @param p a reference to the root of the binary expression tree
	 * @return a reference to the root of the mirror binary expression tree
	 */
	public static ExpressionNode mirror(ExpressionNode p)
	{
		if(p!= null)
			return new ExpressionNode(p.getNum(), p.getOpr(), mirror(p.getRight()), mirror(p.getLeft()));
		else return null;
	}	
}    
