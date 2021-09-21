/**
 * @(#)Square.java
 *
 *
 * @author 
 * @version 1.00 2017/9/11
 */
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.applet.Applet;

public class Square implements Drawable{
	
	private Color colr;
	private int siz;
    public Square(Color c, int s) 
    {
    	colr = c;
    	siz = s;
    }
    public void draw(Graphics g, int x, int y)
    {
    	Color c = g.getColor();
    	g.setColor(colr);
    	g.drawRect(x,y,siz, siz);
    	g.setColor(c);
    }
    public void fill(Graphics g, int x, int y)
  	{
  		Color c = g.getColor();
    	g.setColor(colr);
    	g.fillRect(x,y,siz, siz);
    }
    public int getArea()
    {
    	return siz*siz;
    }
    public int compareTo(Object o)
    {
    	Drawable d = (Drawable)o;
    	return getArea()-d.getArea();
    }
    
    
}