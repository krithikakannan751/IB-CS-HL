/**
 * @(#)Drawable.java
 *
 *
 * @author 
 * @version 1.00 2017/9/8
 */
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.applet.Applet;

public interface Drawable extends Comparable 
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    public void draw(Graphics g, int x, int y);
    public void fill(Graphics g, int x, int y);
    public int getArea();
    
    
}