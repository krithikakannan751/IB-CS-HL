/**
 * An ExpressionNode is a node in a binary expression tree.  Each
 * node either represents an operator or an operand.  If the node represents
 * an operator, getNum() will return 0 and getOpr() will return a character operator.
 * If the node is an operand, getNum() will return the numeric value and getOpr() will
 * return ' '. Operator nodes are parents which have operands or operators as children.  Operand
 * nodes are leaves.
 */
 public class ExpressionNode
{
	private double num;
	private char opr;
	private ExpressionNode left;
	private ExpressionNode right;
	
	/**
	 * Constructs an ExpressionNode with a number value, an operator value and references
	 * to its left and right child nodes.
	 * @param initNum the number value - 0 if node is an operator
	 * @param initOpr the operator value - ' ' if node is an operand
	 * @param initLeft the left child node
	 * @param initRight the right child node
	 */
	public ExpressionNode(double initNum, char initOpr, ExpressionNode initLeft, ExpressionNode initRight)
	{
		num = initNum;
		opr = initOpr;
		left = initLeft;
		right = initRight;
	}
	
	/**
	 * returns the number value of the node.  0 if the node is an operator
	 * @return the number value
	 */
	public double getNum()								{ return num; 			}
	
	/**
	 * returns the operator value of the node.  ' ' if the node is an operand
	 * @return the operator value
	 */
	public char getOpr()								{ return opr;			}
	
	/**
	 * returns the left child node
	 * @return the left child node
	 */
	public ExpressionNode getLeft()						{ return left; 			}
	
	/**
	 * returns the right child node
	 * @return the right child node
	 */
	public ExpressionNode getRight()					{ return right; 		}
	
	/** 
	 * Sets the number value to a specified value
	 * @param theNewNum the number value to be set
	 */
	public void setNum(int theNewNum)					{ num = theNewNum; 		}
	
	/**
	 * Sets the operator value to a specified operator character
	 * @param theNewOpr the operator value to be set
	 */
	public void setOpr(char theNewOpr)					{ opr = theNewOpr;		}
	
	/**
	 * Sets the left child node to a specified node
	 * @param theNewLeft the new left child node
	 */
	public void setLeft(ExpressionNode theNewLeft)		{ left = theNewLeft; 	}
	
	/**
	 * Sets the right child node to a specified node
	 * @param theNewRight the new right child node
	 */
	public void setRight(ExpressionNode theNewRight)	{ right = theNewRight; 	}
	

}