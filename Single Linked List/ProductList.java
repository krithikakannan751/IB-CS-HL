/**
 * @(#)ProductList.java
 *
 *
 * @author Krithika
 * @version 1.00 2017/10/2
 */
import java.util.*;
import java.io.*;

public class ProductList 
{
	private ProductNode first;
	private ProductNode last;
	public ProductList()
	{
		first = null;
		last = null;
	}
	
	
	
	public Product find(String name)
	{
		ProductNode nextNode = first;
	//	String s = "";
		while(nextNode != null)
		{
			if(nextNode.getData().getName().equals(name))
				return nextNode.getData();
			nextNode = nextNode.getNext();
		}
		return null;
	}
	
	public void add(int index, Product p) //throws Exception
	{
		if(first == null) 
			first = last = new ProductNode(p, null);
		else
		{
			if(size() == index) //correct
			{
			/*	ProductNode n = new ProductNode(p, null);
			//	System.out.println(last.getData().getName());
				last.setNext(n);
			//	System.out.println(n.getData().getName());
				last = n;
			//	System.out.println(p.getName()); */
				addLast(p);
			}
			else if(index>size()) //correct
			{ 
				throw new IndexOutOfBoundsException("index out of bound");
			}
			else if(index == 0) //correct
			{
				addFirst(p);
			}
			else
			{
				ProductNode n = first;
			//	System.out.println(p.getName());
				int i = 0;
				while(n != null)
				{
					if(i == index-1)
					{
						n.setNext(new ProductNode(p, n.getNext()));
			//			System.out.println(n.getNext());
					}
					i++;
					n = n.getNext();
				}
			}
		}
	}
	
	public void add(Product p) 
	{
		if(first == null)
			first = last = new ProductNode(p); //if there is nothing in the list everything is this
		else //if not check your pointer for greater or less then move from there
		{
			ProductNode n = first;

			while(n!= null)
			{
				if(size() == 1)
				{
					
					if(n.getData().getName().compareTo(p.getName())>0)
					{	
						addFirst(p);
			
						break;
					}
					else
					{
						addLast(p);
			
						break;
					}
				}
				else if(n.getNext() != null)
				{
					
					if(n.getNext().getData().compareTo(p)<0)
					{
						n.setNext(new ProductNode(p, n.getNext()));
				
						break;
					}
				}
				else
				{
					ProductNode o = new ProductNode(p,n.getNext());
					n.setNext(o);
					last = o;
					break;
				}
				n= n.getNext();
					
			}
			

		}
	}
	
	
	public Product remove(int index)
	{
		if(!(index>=size()))
		{
			if(index == 0)
			{
				Product p = first.getData();
				first = first.getNext();
				return p;
			}
			else
			{
				ProductNode nextNode = first;
				int i = 0;
				while(nextNode != null)
				{
					if(i == index-1)
					{
						Product p = nextNode.getNext().getData();
						nextNode.setNext(nextNode.getNext().getNext());
						if(i == size()-1)
							last = nextNode;
						return p;
					}
					
					nextNode = nextNode.getNext();
					i++;
				}
			}
		}
		
		return null;
	}
	
	public void set(int i, Product p)
	{
		//trying this***************************
	//	System.out.println(last.getData());
		Product old = remove(i);
		if(old!= null)
			add(i,p);
		else throw new IndexOutOfBoundsException("index out of bound"); 
	}
	
	
	//working gaurantee*************************************************************************************
	public void addFirst(Product p)
	{
		if(first == null)
		{
			first = last = new ProductNode(p);
		}
		else
		{
			ProductNode n = new ProductNode(p, first);
			first = n;
		}
		
	}
	
	public void addLast(Product p)
	{
		if(first == null)
		{
			first = last = new ProductNode(p);
		}
		else
		{
			ProductNode n = new ProductNode(p, null);
			last.setNext(n);
			last = n;
		}
		
	}
	public void clear()
	{
		first = last = null;
	}
	public int size()
	{
		ProductNode nextNode = first;
		int i =0;
		while(nextNode != null)
		{
			i++;
			nextNode = nextNode.getNext();
		}
		return i;
	}
	
	public String toString()
	{
		ProductNode nextNode = first;
		String s = "";
		while(nextNode != null)
		{
			s+=nextNode.getData().toString() +"\n";
			nextNode = nextNode.getNext();
		}
		return s;
	}
	public Product remove(String name)
	{
		return remove(indexOf(name));
	}
	public int indexOf(String name)
	{
		ProductNode nextNode = first;
		int i = -1;
		while(nextNode != null)
		{
			if(nextNode.getData().getName().equals(name))
				return i+1;
			nextNode = nextNode.getNext();
			i++;
		}
		return -1;
	}
	public Product getFirst()
	{
		if(first!= null)
			return first.getData();
		else throw new NoSuchElementException("no products in list");
	}
	public Product getLast()
	{
		if(first!= null)
			return last.getData();
		else throw new NoSuchElementException("no products in list");
	}
	

}