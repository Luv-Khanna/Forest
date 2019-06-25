import java.util.Random;
/**
 * Turtle class is a sub class of Animal class
 * Turtle class that contains and provides information only specific to the animal Turtle. 
 * It performs the behaviors that are unique to the Turtle itself.
 * @author Luv Khanna
 *
 */
public class Turtle extends Animal 
{
	/**
	 * A constructor to initialize the instances variables of the object of Turtle class
	 * by calling the super class constructor 
	 * @param x
	 * 			The x position of the turtle
	 * @param y
	 * 			The y position of the turtle
	 * @param count
	 * 			A counter to note the number of times the turtle has moved
	 */
	public Turtle(int x,int y,int count)
	{
		super(x,y,count);
	}
	public char Symbol()
	{
		return 'u';
	}
	public String name()
	{
		return "Turtle";
	}
	public void moveprint(int initialx,int initialy,int finalx,int finaly)
	{
		System.out.println("Turtle moved from ("+initialx+", "+initialy+") to ("+finalx+", "+finaly+")");
	}
	public void move()
	{
		boolean attackresult=false;
		int x=get_x();
		int y=get_y();
		Random rand=new Random();
		int newx=x,newy=y;
		int randomnumberstay=rand.nextInt(100);
		if(randomnumberstay%2==0)
		{
			System.out.println("Turtle stayed in ("+x+", "+y+")");
		}
		else
		{
			int randomnumber=rand.nextInt(4);
			boolean moveflag=false;
			while (!moveflag)
			{
				if(randomnumber==0)
				{
					newx=x-1;
				}
				else if(randomnumber==1) 
				{
					newy=y+1;
				}
				else if(randomnumber==2)
				{
					newx=x+1;
				}
				else 
				{
					newy=y-1;
				}
				if(newx>=0 && newx<=14 && newy>=0 && newy<=14)
				{
					moveflag=true;
				}
				else
				{
					randomnumber=rand.nextInt(4);
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
	public boolean attack(Animal attacker,Animal defender)
	{
		Random rand=new Random();
		int ax=attacker.get_x();
		int ay=attacker.get_y();
		int dx=defender.get_x();
		int dy=defender.get_y();
		boolean attackerwin=false;
		char sdefender=defender.Symbol();
		String defendertype=defender.name();
		if(sdefender=='u')
		{
			int randomnumber=rand.nextInt(2);
			if(randomnumber==0)
			{
				attackerwin=true;
				Forest.deadanimallist.add(Forest.forestgrid[dx][dy].name());
				Forest.deadanimalxpos.add(dx);
				Forest.deadanimalypos.add(dy);
				Forest.forestgrid[dx][dy]=null;
			}
			else
			{
				Forest.deadanimallist.add(Forest.forestgrid[ax][ay].name());
				Forest.deadanimalxpos.add(ax);
				Forest.deadanimalypos.add(ay);
				Forest.forestgrid[ax][ay]=null;
			}
		}
		else
		{
			Forest.deadanimallist.add(Forest.forestgrid[ax][ay].name());
			Forest.deadanimalxpos.add(ax);
			Forest.deadanimalypos.add(ay);
			Forest.forestgrid[ax][ay]=null;
		}
		if(attackerwin)
		{
			System.out.println("Turtle from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and wins");
			System.out.println(defendertype+" dies at ("+dx+", "+dy+")");
		}
		else
		{
			System.out.println("Turtle from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and loses");
			System.out.println("Turtle dies at ("+ax+", "+ay+")");
		}
		return attackerwin;
	}
}
