
public class TreeNode <T extends Comparable<T>> implements Treeable<T>
{
	private T treeNodeValue;
	private TreeNode<T> leftTreeNode;
	private TreeNode<T> rightTreeNode;
	
	/**
	 * Constructs a Tree Node with null for value and references
	 */
	public TreeNode( )
	{
		treeNodeValue = null;
		leftTreeNode = null;
		rightTreeNode = null;
	}

	/**
	 * Constructs a TreeNode with a specified value.  Left and right
	 * references are null
	 * @param value the data content of the node
	 */
	public TreeNode(T value)
	{
		treeNodeValue = value;
		leftTreeNode = null;
		rightTreeNode = null;
	}

	/**
	 * Constructs a TreeNode with specified value and references
	 * @param value the data content of the node
	 * @param left the left child reference
	 * @param right the right child reference
	 */
	public TreeNode(T value, TreeNode<T> left, TreeNode<T> right)
	{
		treeNodeValue = value;
		leftTreeNode = left;
		rightTreeNode = right;
	}

	/**
	 * returns the data content of the node
	 * @return the data
	 */
	public T getValue()
	{
		return treeNodeValue;
	}

	/**
	 * returns the left child
	 * @return the left child
	 */
	public TreeNode<T> getLeft()
	{
		return leftTreeNode;
	}

	/**
	 * returns the right child
	 * @return the right child
	 */
	public TreeNode<T> getRight()
	{
		return rightTreeNode;
	}

	/**
	 * sets the data to a specified value
	 * @param value the data value to set
	 */
	public void setValue(T value)
	{
		treeNodeValue = value;
	}

	/**
	 * sets the left child reference
	 * @param left the left child reference
	 */
	public void setLeft(Treeable<T> left)
	{
		leftTreeNode =(TreeNode<T>) left;
	}

	/**
	 * sets the right child reference
	 * @param right the right child reference
	 */
	public void setRight(Treeable<T> right)
	{
		rightTreeNode = (TreeNode<T>)right;
	}
}