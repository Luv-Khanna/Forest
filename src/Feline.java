import java.util.Random;
/**
 * Feline Class is a subclass of Animal Class
 * Feline class that contains and provides information general to the animals belonging in the feline category. 
 * It performs the behaviors that are common to all felines
 * @author Luv Khanna
 *
 */
public abstract class Feline extends Animal
{
	/**
	 * A constructor to initialize the instances variables of the object of class of feline animals
	 * by calling the super class constructor
	 * @param x
	 * 			The x position of the feline
	 * @param y
	 * 			The y position of the feline
	 * @param count
	 * 			A counter to note the number of times the feline has moved
	 */
	public Feline(int x,int y,int count)
	{
		super(x,y,count);
	}
	public void move()
	{
		boolean attackresult=false;
		int x=get_x();
		int y=get_y();
		Random rand=new Random();
		int randomnumberx=rand.nextInt(3)-1;
		int randomnumbery=rand.nextInt(3)-1;
		int newx=x+randomnumberx;
		int newy=y+randomnumbery;
		boolean moveflag=false;
		while (!moveflag)
		{
			if(randomnumberx==0 && randomnumbery==0)
			{
				randomnumberx=rand.nextInt(3)-1;
				randomnumbery=rand.nextInt(3)-1;
				newx=x+randomnumberx;
				newy=y+randomnumbery; 
			}
			else
			{
				if(newx>=0 && newx<=14 && newy>=0 && newy<=14)
				 {
					 moveflag=true;
				 }
				 else
				 {
					  randomnumberx=rand.nextInt(3)-1;
					  randomnumbery=rand.nextInt(3)-1;
					  newx=x+randomnumberx;
					  newy=y+randomnumbery; 		 
				 }
			}
		}
		if(Forest.forestgrid[newx][newy]!=null)
		{
			attackresult=Forest.forestgrid[x][y].attack(Forest.forestgrid[x][y], Forest.forestgrid[newx][newy]);
		}
		else
		{
			attackresult=true;
		}
		if(attackresult)
		{
			Forest.forestgrid[x][y].moveprint(x, y, newx, newy);
			Forest.forestgrid[newx][newy]=Forest.forestgrid[x][y];
			Forest.forestgrid[x][y]=null;
			Forest.forestgrid[newx][newy].set_x(newx);
			Forest.forestgrid[newx][newy].set_y(newy);
		}
	}
}
