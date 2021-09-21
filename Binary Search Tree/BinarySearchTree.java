
import static java.lang.System.*;
//import java.util.LinkedList;
import java.util.*;
public class BinarySearchTree<T extends Comparable<T>> 
{
	private TreeNode<T> root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(T val)
	{
		root = add(val, root);
	}

	private TreeNode<T> add(T val, TreeNode<T> tree)
	{
	   if(tree == null)
			tree = new TreeNode<T>(val);
		T treeValue = tree.getValue();
		if( val.compareTo(treeValue) < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(val.compareTo(treeValue) > 0)
			tree.setRight(add(val, tree.getRight()));
		return tree;
	}

   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode<T> tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder
   public void preOrder()
	{
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode<T> tree)
	{
		if (tree != null){
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());	
		}
	}
	public void postOrder()
	{
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode<T> tree)
	{
		if (tree != null){
			postOrder(tree.getLeft());	
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}
   public void revOrder()
	{
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode<T> tree)
	{
		if (tree != null){
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());	
		}
	}
	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode<T> tree)
	{
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
			return 1+getNumLevels(tree.getLeft());
		else
			return 1+getNumLevels(tree.getRight());
	}
	//numLeaves
	public int getNumLeaves()
	{
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode<T> tree)
	{
		if(tree == null)
			return 0;
		else if(tree.getLeft() == null && tree.getRight() == null)
			return 1;
		
		else //there is something
		{
			return getNumLeaves(tree.getLeft())+ getNumLeaves(tree.getRight());
		}
	}
	
		//getSmallest
	public T getSmallest()
	{
		return getSmallest(root).getValue();
	}

	private TreeNode<T> getSmallest(TreeNode<T> tree)
	{
		if(tree==null)
			return null;
		else if(tree.getLeft() == null)
			return tree;
		else 
		{
			return 	getSmallest(tree.getLeft());
		}
	}
	
		//getLargest
	public T getLargest()
	{
		return getLargest(root).getValue();
	}

	private TreeNode<T> getLargest(TreeNode<T> tree)
	{
		if(tree==null)
			return null;
		else if(tree.getRight() == null)
			return tree;
		else 
		{
			return 	getLargest(tree.getRight());
		}
	}
	
	public String toString()
	{
		return toString(root);	
	}

	private String toString(TreeNode tree)
	{
		String s = "";
		if (tree != null){
			if(tree.getLeft()!= null)
				s+= toString(tree.getLeft());
			
			s+=tree.getValue() + " ";
			if(tree.getRight()!= null)
				s+= toString(tree.getRight());
		}
		return s;
	}
	//search
	public boolean search(int i)
	{
		return search(root, i);	
	}

	private boolean search(TreeNode tree, int i)
	{
		if(tree == null)
		{
			return false;
		}
		else
		{
			if(tree.getValue().equals(i))
				return true;
			else return search(tree.getLeft(), i) || search(tree.getRight(), i);
		}
		
	}
	public int getHeight()
	{
		return getNumLevels(root)-1;
	}
	//getNumNodes
	public int getNumNodes()
	{
		return getNumNodes(root);	
	}

	private int getNumNodes(TreeNode tree)
	{
		if(tree == null)
		{
			return 0;
		}
		else
		{
			return getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight())+1;
		}
		
	}
	//isFull
	public boolean isFull()
	{
		return getNumNodes() == Math.pow(2,getNumLevels())-1;
	//	return isFull(root);	
	}

/*	private boolean isFull(TreeNode tree)
	{
		if(tree == null)
		{
			return true;
		}
		else
		{
			return isFull(tree.getLeft()) && isFull(tree.getRight());
		}
		
	}*/
	//getWidth
	public int getWidth()
	{
		return getWidth(root);
	}
	public int getWidth(TreeNode temp)
	{
		if(temp == null)
		{
			return 0;
		}
		else if(temp.equals(root))
		{
			return 1+getWidth(temp.getLeft())+getWidth(temp.getRight());
		}
		else
		{
			if(getWidth(temp.getLeft())>getWidth(temp.getRight()))//left path
				return 1+getWidth(temp.getLeft());
			else //right path
				return 1+getWidth(temp.getRight());	
		}
	//	return 0;
	}

	//remove
	public void remove(int i)
	{
		if(root!= null)
		{
			TreeNode p = root;
			TreeNode temp = root;
			while(p!= null && !p.getValue().equals(i))
			{
				temp = p;
				if(p.getValue().compareTo(i) >0)
					p = p.getLeft();
				else p = p.getRight();
			}
			if(p!= null && p.getValue().equals(i))
			{
				if(p.getLeft() == null && p.getRight() == null)
					removeLeaf(p, temp);
				else if (p.getLeft() == null || p.getRight() == null)
				{
					removeParent1(p,temp);
				}
				else removeParent2(p);
			}
			
		}	
	}
	public void removeLeaf(TreeNode p, TreeNode temp)
	{
		if(p==temp)
		{
			root = null;
		}
		else
		{
			if(temp.getLeft() == p)
				temp.setLeft(null);
			else 
				temp.setRight(null);
		}
	}
	public void removeParent1(TreeNode p, TreeNode temp)
	{
		if(p == temp)
		{
			if(p.getLeft() == null)
			{
				root = root.getRight();
			}
			else root = root.getLeft();
		}
		else
		{
			if(temp.getLeft() ==p)
				if(p.getLeft() == null)
					temp.setLeft(p.getRight());
				else 
					temp.setLeft(p.getLeft());
			else
				if(p.getLeft() == null)
					temp.setRight(p.getRight());
				else
					temp.setRight(p.getLeft());
		}
	}
	public void removeParent2(TreeNode p)
	{
		TreeNode temp1 = p.getLeft();
		TreeNode temp2 = p;
		while(temp1.getRight()!=null)
		{
			temp2 = temp1;
			temp1 = temp1.getRight();
		}
		p.setValue(temp1.getValue());
		if(p==temp2)
			temp2.setLeft(temp1.getLeft());
		else
			temp2.setRight(temp1.getLeft());
	}


/*	private void remove(TreeNode tree, Comparable i)
	{
		if(tree == null)
		{
			return;
		}
		else
		{
			if(tree.getLeft() != null && tree.getLeft().getValue().equals(i)) //left has value
			{
				if(tree.getLeft().getLeft() == null && tree.getLeft().getRight() == null) //leaf
				{
					tree.setLeft(null);
				}
				else if(tree.getLeft().getLeft() == null && tree.getLeft().getRight() != null) //right child
				{
					tree.setLeft(tree.getLeft().getRight());
				}
				else if(tree.getLeft().getLeft() != null && tree.getLeft().getRight() == null) //left child
				{
					tree.setLeft(tree.getLeft().getLeft());
				}
			}	
			else if(tree.getRight()!= null && tree.getRight().getValue().equals(i)) //right has value
			{
				if(tree.getRight().getLeft() == null && tree.getRight().getRight() == null)
				{
					tree.setRight(null);
				}
				else if(tree.getRight().getLeft() == null && tree.getRight().getRight() != null)
				{
					tree.setRight(tree.getRight().getRight());
				}
				else if(tree.getRight().getLeft() != null && tree.getRight().getRight() == null) //left child
				{
					tree.setRight(tree.getRight().getLeft());
				}
					
			}
			else if(tree.getValue().equals(i)) //I have value
			{
				if( tree.getLeft()!= null) //root has value
				{
					TreeNode tempRoot = root;
					TreeNode temp = tree.getLeft();
					while(temp.getRight()!= null)
						temp = temp.getRight();
					tree.setValue((T)temp.getValue());
					remove(tree.getLeft(), tree.getValue());
				}
				else if(tree.getLeft() == null)
				{
					TreeNode tempTree = tree;
					tempTree = tree.getRight();
					tree.setRight(tempTree);
					if(tempTree!= null)
						remove(tempTree, tempTree.getValue());
				}
				else if(tree.getLeft()!= null)
				{
					TreeNode tempTree = tree;
					tree.setValue(tree.getLeft().getValue());
					remove(tempTree.getLeft(), tempTree.getLeft().getValue());
				}
				else if(tree.getRight()!= null)
				{
					TreeNode tempTree = tree;
					tree.setValue(tree.getRight().getValue());
					remove(tempTree.getRight(), tempTree.getRight().getValue());
				}
			
				
			}
			else
			{
				remove(tree.getRight(),i);
				remove(tree.getLeft(),i);
			}
		}
	} */ //commented remove, my attempt
		//level order (bonus)
	public void levelOrder()
	{
		//***********************************************************************
		Queue<TreeNode> qOut = new LinkedList<TreeNode>();
		qOut.add(root);
		while(root!= null && !qOut.isEmpty())
		{
			Queue<TreeNode> qIn = new LinkedList<TreeNode>();
			for(TreeNode t: qOut)
			{
				System.out.print(t.getValue() + " ");
				if(t.getLeft() != null)
					qIn.add(t.getLeft());
				if(t.getRight() != null)
					qIn.add(t.getRight());
			}
			qOut=qIn;
		}
		
	}
	public String levelToString()
	{
		String s = "";
		Queue<TreeNode> qOut = new LinkedList<TreeNode>();
		qOut.add(root);
		while(root!= null && !qOut.isEmpty())
		{
			Queue<TreeNode> qIn = new LinkedList<TreeNode>();
			for(TreeNode t: qOut)
			{
				s+=(t.getValue() + " ");
				if(t.getLeft() != null)
					qIn.add(t.getLeft());
				if(t.getRight() != null)
					qIn.add(t.getRight());
			}
			qOut=qIn;
		}
//		System.out.println(s);
//		System.out.println (" ********************");
		return s;
	}
	//display like a tree (bonus)
	public void display()
	{
		if(root!= null)
		{
		
	//	System.out.println ("\n\n**************DISPLAY TREE**************");
		String[] arr = levelToString().split(" ");
		ArrayList<String> aListLevel = new ArrayList<String>();
		
		//get the root printed
		aListLevel.add(arr[0]);
		System.out.print (centerStrings(aListLevel));
		aListLevel.clear();
		for(int i = 1; i<arr.length; i++)
		{
			if(Integer.parseInt(arr[i-1])>Integer.parseInt(arr[i])) //if needs to be on new line (is to the left)
			{
				System.out.print( centerStrings(aListLevel)+"\n");
				aListLevel.clear();
			}
			aListLevel.add(arr[i]);
	//		System.out.println(i);
		}
		System.out.println (centerStrings(aListLevel));
		}
	}
	public String centerStrings(ArrayList<String> sList)
	{
		String[] arr = inOrderString(root).split(" ");
		for(int i = 0; i<arr.length; i++)
		{
			if(sList.indexOf(arr[i]) == -1)
			{
				//	arr[i] = "  ";
				String space = "";
				for(int spaceL = 0; spaceL<arr[i].length(); spaceL++)
				{
					space+= " ";
				}
				arr[i] = space;
			}
		}
		String sRet = "";
		for(String sAdd: arr)
		{
			sRet += sAdd;
		}
		return sRet;
	}
	
	
	private String inOrderString(TreeNode<T> tree)
	{
		String s = "";
		if (tree != null)
		{
			s+= inOrderString(tree.getLeft());
			s+= tree.getValue() + " ";
			s+=	inOrderString(tree.getRight());
		}
		return s;
	}
}