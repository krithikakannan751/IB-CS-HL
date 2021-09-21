/**
 * @(#)Rectangle.java
 *
 *
 * @author 
 * @version 1.00 2017/9/11
 */
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.applet.Applet;

public class Rectangle implements Drawable {
	private Color colr;
	private int wid;
	private int hei;
    public Rectangle(Color c, int w, int h) 
    {
    	colr = c;
    	wid = w;
    	hei = h;
    }
    public void draw(Graphics g, int x, int y)
    {
    	Color c = g.getColor();
    	g.setColor(colr);
    	g.drawRect(x,y,wid, hei);
    	g.setColor(c);
    }
    public void fill(Graphics g, int x, int y)
  	{
    	
    	Color c = g.getColor();
    	g.setColor(colr);
    	g.fillRect(x,y,wid, hei);
    	g.setColor(c);
    }
    public int getArea()
    {
    	return wid*hei;
    }
    public int compareTo(Object o)
    {
    	Drawable d = (Drawable)o;
    	return getArea()-d.getArea();
    }
}