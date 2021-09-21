/**
 * @(#)ProductNode.java
 *
 *
 * @author 
 * @version 1.00 2017/10/2
 */


public class ProductNode 
{
	private Product data;
	private ProductNode next;
	
    public ProductNode() 
    {
		data = null;
		next = null;
    }
    public ProductNode(Product p)
    {
    	data= p;
    	next = null;
    }
    public ProductNode(Product p, ProductNode n)
    {
    	data = p;
    	next = n;
    }
    public Product getData()
    {
    	return data;
    }
    public ProductNode getNext()
    {
    	return next;
    }
    public void setData(Product p)
    {
    	data = p;
    }
    public void setNext(ProductNode n)
    {
    	next = n;
    }
    
}