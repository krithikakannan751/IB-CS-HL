// The Magic Square
// Student Version

/*
 * The MagicSquare class creates odd-sized magic squares.  
 * A magic square is a square matrix of consecutive numbers, 
 * such that the numbers in the rows, the numbers in the columns, 
 * and the numbers in the diagonals add up to the same sum.
 */
class MagicSquare
{
	private int size;
	private int magic[][];
	
	/* 
	 * Creates a MagicSquare of dimension s
	 * @param s size of the magic square
	 */
	public MagicSquare(int s) 
	{
		magic = new int[s][s];
		size= s;
	}
	
	/*
	 * Places numbers in the magic square
	 */
	public void computeMagicSquare()
	{
		int x = size/2;
		int y = 0;
		int num = 1;
		magic[y][x] = num;
		while(num < size*size)
		{
			num++;
			if(((num-1)% size)==0)
			{
				y+=1;
			}
			else
			{
				x++;
				y--;
			}
			if(x==size)
			{
				x=0;
			}
			if(y==-1)
			{
				y=size-1;
			}
			magic[y][x]=num;
		}
			
	}
	
	/* 
	 * Returns a String version of the magic square with a heading
	 * indicating the size, and with all numbers displaying in 3 digits.
	 */ 
	public String toString()
	{
		String y ="";
		for(int i =0; i<magic.length; i++)
		{
			y+="\n\n";
			for(int x=0;x<magic.length;x++)
			{
				if(magic[i][x]<10)
				{
					y += "00"+magic[i][x] + " ";
				}
				else if(magic[i][x]<100)
				{
					y += "0" + magic[i][x] + " ";
				}
				else
				{
					y+= magic[i][x] + " ";
				}
			}
		}
			return y;
	}	
	
}

