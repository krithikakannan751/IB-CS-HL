//Name - Krithika Kannan
//Date - 8/20/18
//Lab  - MadLib

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private ArrayList<String> story;
	
	public MadLib()
	{
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		story = new ArrayList<String>();
		
	}

	public MadLib(String fileName)
	{
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		story = new ArrayList<String>();
		//load stuff
		try
		{
			Scanner file = new Scanner(new File(fileName));
			while(file.hasNext())
			{
				story.add(file.next());
			}
			loadAdjectives();
			loadNouns();
			loadVerbs();
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}
	}

	public void loadNouns()
	{
		try
		{
			Scanner file = new Scanner(new File("nouns.dat"));
			while(file.hasNextLine())
			{
				nouns.add(file.nextLine());
			}
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}	
	}
	
	public void loadVerbs()
	{
		try
		{
			Scanner file = new Scanner(new File("verbs.dat"));
			while(file.hasNextLine())
			{
				verbs.add(file.nextLine());
			}
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner file = new Scanner(new File("adjectives.dat"));
			while(file.hasNextLine())
			{
				adjectives.add(file.nextLine());
			}
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}
	}

	public String getRandomVerb()
	{
		int x = (int)(Math.random()*verbs.size());
		return verbs.get(x);
	}
	
	public String getRandomNoun()
	{
		int x = (int)(Math.random()*nouns.size());
		return nouns.get(x);
	}
	
	public String getRandomAdjective()
	{
		int x = (int)(Math.random()*adjectives.size());
		return adjectives.get(x);
	}		

	public String toString()
	{
		String x = "";
		for(int i =0; i<story.size(); i++)
		{
			if(story.get(i).equals("#"))
			{
			x+= getRandomNoun() + " ";
			}
			else if(story.get(i).equals("@"))
			{
			x+=getRandomVerb() + " ";
			}
			else if(story.get(i).equals("&"))
			{
			x+=getRandomAdjective() + " ";
			}
			else
			{
			x+=story.get(i) + " ";
			}
		}
	   return x;
	}
}
