import java.util.Random;
/**
 * Canine Class is a subclass of Animal Class
 * Canine class that contains and provides information general to the animals belonging in the canine category. 
 * It performs the behaviors that are common to all canines
 * @author Luv Khanna
 *
 */
public abstract class Canine extends Animal 
{
	/**
	 * A constructor to initialize the instances variables of the object of class of canine animals
	 * by calling the super class constructor
	 * @param x
	 * 			The x position of the canine
	 * @param y
	 * 			The y position of the canine
	 * @param count
	 * 			A counter to note the number of times the canine has moved
	 */
	public Canine(int x,int y,int count)
	{
		super(x,y,count);
	}
	public void move()
	{
		int x=get_x();
		int y=get_y();
		Random rand=new Random();
		int randomnumber=rand.nextInt(8);
		int steps=0;
		String direction="";
		int newx=-1,newy=-1;
		boolean moveflag=false;
		while (!moveflag)
		{
			if(randomnumber==0)
			{
				newx=x-1;
				newy=y;
				steps=1;
				direction="up";
			}
			else if(randomnumber==1) 
			{
				newy=y+1;
				newx=x;
				steps=1;
				direction="right";
			}
			else if(randomnumber==2)
			{
				newx=x+1;
				newy=y;
				steps=1;
				direction="down";
			}
			else if(randomnumber==3)
			{
				newy=y-1;
				newx=x;
				steps=1;
				direction="left";
			}
			else if(randomnumber==4)
			{
				newx=x-2;
				newy=y;
				steps=2;
				direction="up";
			}
			else if(randomnumber==5)
			{
				newy=y+2;
				newx=x;
				steps=2;
				direction="right";
			}
			else if(randomnumber==6)
			{
				newx=x+2;
				newy=y;
				steps=2;
				direction="down";
			}
			else if(randomnumber==7)
			{
				newy=y-2;
				newx=x;
				steps=2;
				direction="left";
			}
			if(newx>=0 && newx<=14 && newy>=0 && newy<=14)
			{
				moveflag=true;
			}
			else
			{
				randomnumber=rand.nextInt(8);
			}
		}
		int initialx=x;
		int initialy=y;
		newx=x;
		newy=y;
		boolean attackflag=false;
		for(int i=1;i<=steps;i++)
		{
			boolean attackresult=false;
			if(direction.equals("up"))
			{
				newx=x-1;
			}
			else if(direction.equals("down"))
			{
				newx=x+1;
			}
			else if(direction.equals("left"))
			{
				newy=y-1;
			}
			else if(direction.equals("right"))
			{
				newy=y+1;
			}
			if(Forest.forestgrid[newx][newy]!=null)
			{
				if(i==2)
				{
					Forest.forestgrid[x][y].moveprint(initialx, initialy, x, y);
					attackflag=true;
				}
				attackresult=Forest.forestgrid[x][y].attack(Forest.forestgrid[x][y], Forest.forestgrid[newx][newy]);
				if(!attackresult)
				{
					attackflag=true;
					break;
				}
			}
			else if(Forest.forestgrid[newx][newy]==null)
			{
				attackresult=true;
			}
			if(attackresult) 
			{
				if(attackflag)
				{
					Forest.forestgrid[x][y].moveprint(x, y, newx, newy);
				}
				Forest.forestgrid[newx][newy]=Forest.forestgrid[x][y];
				Forest.forestgrid[x][y]=null;
				Forest.forestgrid[newx][newy].set_x(newx);
				Forest.forestgrid[newx][newy].set_y(newy);
				x=get_x();
				y=get_y();
			}
		}
		if(!attackflag)
		{
			Forest.forestgrid[x][y].moveprint(initialx, initialy, x, y);
		}
	}
}
