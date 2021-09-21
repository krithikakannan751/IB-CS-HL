// The Parking Sticker Program
// Student Version
// You need to complete readFile and distributeParkingStickers
// Enumerated types (such as the students grade) can be compared with .compareTo and .equals
// To access a specific value in the enumerated type, use Rank.Senior, Rank.Junior, etc.


import java.io.*;
import java.util.*;

enum Rank {Senior, Junior, Sophomore, Freshman};


/**
 * Manages a database of students, and determines which students get parking stickers
 */
public class ParkingStickers
{
	/**
	 * Do not modify this main method
	 * @param args not used
	 */
	public static void main (String args[]) throws IOException
	{
		System.out.println("\nLab30B -- The Parking Sticker Program\n");
		
		PriorityQueue<Student> students = readFile("students3.dat");
				
		System.out.println(students); 

		int numStickers = getNumStickers();
		
		distributeParkingStickers(students, numStickers);
		    
		while (!students.isEmpty())   // This will display students according to their priority order.
		    System.out.print(students.remove());		    
	}
	
	/**
	 * Reads students from the data file and places them in the priority queue
	 * You must complete this method
	 */
	public static PriorityQueue<Student> readFile(String fileName) throws IOException
	{
		File f = new File(fileName);
		PriorityQueue<Student> students = new PriorityQueue<Student>();
		
		if (f.exists())
		{
			FileReader inFile = new FileReader(f);
			BufferedReader inStream = new BufferedReader(inFile);
		    
			String name,sage,rank;						
			int age = 0;
			Rank grade = Rank.Freshman; // grade has to be initialized to something to prevent a compile error
			
			// while there are 3 more pieces of data in the file (reads in and checks each for null all at once.
			// all data is read in as Strings.  sage must be converted and stored in age.  rank must be converted and
			// stored in grade.  Then, object can be created and enqueued.  See comments at the top of file for
			// using enumerated type for grade.
			while( ((name = inStream.readLine()) != null) && 
				   ((sage = inStream.readLine()) != null) &&
				   ((rank = inStream.readLine()) != null) )			
			{
				if(rank.equals("Senior"))
				{
					grade = Rank.Senior;
				}
				else if(rank.equals("Junior"))
				{
					grade = Rank.Junior;
				}
				else if(rank.equals("Sophomore"))
				{
					grade = Rank.Sophomore;
				}
				else
				{
					grade = Rank.Freshman;
				}
				students.add(new Student(name, Integer.parseInt(sage), grade));








			} 
			inStream.close();    			
			System.out.println();
		}
		else
		{
			System.out.println(f.getName() + " does not exist");
		}
				    
		System.out.println("\nStudent information read in from "+fileName);
		System.out.println("==============================================\n");
		return students;
		
	}
	
	/**
	 * Prompts user for number of stickers and returns.
	 * Do not modify this method.
	 * @return number of available stickers.
	 */
	public static int getNumStickers()
	{
 		Scanner input = new Scanner(System.in);
		System.out.print("\n\nHow many parking stickers are available?  --> ");										
		int numStickers = input.nextInt();		
		return numStickers;
	}
	
	/**
	 * Issues parking stickers to students based on their value in the priority queue.  There
	 * may be more stickers than eligible students, or less.  A temporary priority queue is used
	 * so that as students are issued parking stickers (see the object method in Student for issuing),
	 * they can be placed in the temporary queue.  After stickers are issued, the students queue must
	 * have all students back in it.
	 * The method also keeps track of statistics and a report is generated at the end of the method.
	 */
	public static void distributeParkingStickers(PriorityQueue<Student> students, int numStickers)
	{
		PriorityQueue<Student> temp = new PriorityQueue<Student>();
				
		int numSeniorStickers    = 0;
		int numJuniorStickers    = 0;
		int numSophomoreStickers = 0;
		int numFreshmanStickers  = 0;
		int totalStickers = numStickers;
				
		while(!students.isEmpty())
		{
			Student s = (Student) students.remove();
			if(numStickers>0)
			{
				
				if(!(s.getAge()<16 || s.getGrade() == Rank.Freshman))
				{
					
				
				if(s.getGrade() == Rank.Senior)
				{
					numStickers--;
				s.issueParkingSticker();
					numSeniorStickers++;
				}
				else if(s.getGrade() == Rank.Junior)
				{
					numStickers--;
					s.issueParkingSticker();
					numJuniorStickers++;
				}
				else if(s.getGrade() == Rank.Sophomore)
				{
					numStickers--;
					s.issueParkingSticker();
					numSophomoreStickers++;
				}
				}
				
			}
			temp.add(s);
		}
		while(!temp.isEmpty())
		{
			students.add((Student) temp.remove());
		}
 
		System.out.println("\n\nParking Sticker Statistics");
		System.out.println("==========================\n");
		System.out.println("Number of Senior stickers issued:    " + numSeniorStickers);
		System.out.println("Number of Junior stickers issued:    " + numJuniorStickers);
		System.out.println("Number of Sophomore stickers issued: " + numSophomoreStickers);
		System.out.println("Number of Freshman stickers issued:  " + numFreshmanStickers);
		System.out.println("Number of unissued stickers:         " + numStickers);
		System.out.println("Total Number of stickers:            " + totalStickers);
		
		Scanner input = new Scanner(System.in);
		System.out.print("Press <Enter> to continue... ");										
		String dummy = input.nextLine();
		System.out.println("\n\nStudent information from the PriorityQueue");
		System.out.println("==========================================\n");					
	}
}




	
	