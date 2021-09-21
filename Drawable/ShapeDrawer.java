
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.applet.Applet;

/**
 * An applet to test the Drawable interface and Shape classes
 */
public class ShapeDrawer extends Applet
{

    public void paint(Graphics g) 
    {
    	final int SIZE = 200; // maximum size of a shape
    	g.setColor(Color.black);
    	Random r = new Random();
    	setSize(Drawable.WIDTH, Drawable.HEIGHT);
    	
    	ArrayList<Drawable> shapes = new ArrayList<Drawable>();
    	shapes.add(new Square(Color.BLUE, r.nextInt(SIZE)));
    	shapes.add(new Square(Color.RED, r.nextInt(SIZE)));
    	shapes.add(new Oval(Color.CYAN, r.nextInt(SIZE),r.nextInt(SIZE)));
    	shapes.add(new Oval(Color.ORANGE, r.nextInt(SIZE),r.nextInt(SIZE)));
    	shapes.add(new Rectangle(Color.GRAY, r.nextInt(SIZE),r.nextInt(SIZE)));
    	shapes.add(new Rectangle(Color.GREEN , r.nextInt(SIZE),r.nextInt(SIZE)));
    	for(Drawable d: shapes)
    		d.draw(g,r.nextInt(Drawable.WIDTH),r.nextInt(Drawable.HEIGHT));	
    	g.fillRoundRect(0,0,50,30,5,5);	
    	for(Drawable d: shapes)
    		d.fill(g,r.nextInt(Drawable.WIDTH),r.nextInt(Drawable.HEIGHT));
    	
    
    }
    
    
    
    
}





