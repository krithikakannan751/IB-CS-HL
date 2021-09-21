/**
 * @(#)College.java
 *
 *
 * @Krithika Kannan
 * 5th period 
 * @version 1.00 2018/8/13
 */


public class College 
{

	//Instance Fields
	private String name;
	private String location;
	private int sat;
	private int act;
	
	//Default Constructor
    public College() 
    {
    	name = "Harvard";
    	location = "Massachusetts";
    	sat = 1500;
    	act = 34;
    }
    
    //Overloaded Constructor
    public College(String name, String location, int sat, int act)
    {
    	this.name = name;
    	this.location = location;
    	this.sat = sat;
    	this.act = act;
    }
    
    //Equals
    public boolean equals(Object o)
    {
    	College other = (College)o;
    	return name.equals(other.name) && location.equals(other.location);
    }
    
    //CompareTo
    public int compareTo(Object o)
    {
    	College other = (College)o;
    	return name.compareTo(other.name);
    }
    
    //ToString
    public String toString()
    {
    	return name + "/n" + location + "/n" + "/nMinimum SAT: " + sat + "/nMinimum ACT" + act;
    }
    
    //Accessors
    
    public String getName()
    {
    	return name;
    }
    
    public String getLocation()
    {
    	return location;
    }
    
    public int getSat()
    {
    	return sat;
    }
    
    public int getAct()
    {
    	return act;
    }
    
    // Mutators
    
    public void changeName(String x)
    {
    	name = x;
    }
    
    public void changeLocation(String x)
    {
    	location = x;
    }
    
    public void changeSat(int x)
    {
    	sat = x;
    }
    
    public void changeAct(int x)
    {
    	act = x;
    }
}