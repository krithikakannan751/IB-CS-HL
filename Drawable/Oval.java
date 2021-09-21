/**
 * @(#)Oval.java
 *
 *
 * @author 
 * @version 1.00 2017/9/11
 */
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.applet.Applet;

public class Oval implements Drawable{
	private Color colr;
	private int wid;
	private int hei;
    public Oval(Color c, int w, int h) 
    {
    	colr = c;
    	wid = w;
    	hei = h;
    }
    public void draw(Graphics g, int x, int y)
    {
    	Color c = g.getColor();
    	g.setColor(colr);
    	g.drawOval(x,y,wid/2, hei/2);
    	g.setColor(c);
    }
    public void fill(Graphics g, int x, int y)
  	{
    	Color c = g.getColor();
    	g.setColor(colr);
    	g.fillOval(x,y,wid/2, hei/2);
    	g.setColor(c);
    }
    public int getArea()
    {
    	return (int)(((double)wid*0.5)*((double)hei*0.5)*Math.PI);
    }
    public int compareTo(Object o)
    {
    	Drawable d = (Drawable)o;
    	return getArea()-d.getArea();
    }
}