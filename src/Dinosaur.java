import java.util.Random;
/**
 * Dinosaur class is a sub class of Animal class
 * Dinosaur class that contains and provides information only specific to the animal Dinosaur. 
 * It performs the behaviors that are unique to the Dinosaur itself.
 * 
 * @author Luv Khanna
 *
 */
public class Dinosaur extends Animal
{
	private int initialx,initialy;
	/**
	 * A constructor to initialize the instances variables of the object of Dinosaur class
	 * by calling the super class constructor 
	 * @param x
	 * 			The x position of the dinosaur
	 * @param y
	 * 			The y position of the dinosaur
	 * @param count
	 * 			A counter to note the number of times the dinosaur has moved
	 */
	public Dinosaur(int x,int y,int count)
	{
		super(x,y,count);
	}
	public char Symbol()
	{
		return 'i';
	}
	public String name()
	{
		return "Dinosaur";
	}
	public void moveprint(int initialx,int initialy,int finalx,int finaly)
	{
		System.out.println("Dinosaur moved from ("+initialx+", "+initialy+") to ("+finalx+", "+finaly+")");
	}
	public void move()
	{
		int x=get_x();
		int y=get_y();
		Random rand=new Random();
		int randomnumber=rand.nextInt(4);
		int steps=3;
		String direction="";
		int newx=-1,newy=-1;
		boolean moveflag=false;
		while (!moveflag)
		{
			if(randomnumber==0)
			{
				newx=x-3;
				newy=y;
				direction="up";
			}
			else if(randomnumber==1) 
			{
				newy=y+3;
				newx=x;
				direction="right";
			}
			else if(randomnumber==2)
			{
				newx=x+3;
				newy=y;
				direction="down";
			}
			else
			{
				newy=y-3;
				newx=x;
				direction="left";
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
		initialx=x;
		initialy=y;
		newx=x;
		newy=y;
		boolean mflag=true;
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
				attackresult=Forest.forestgrid[x][y].attack(Forest.forestgrid[x][y], Forest.forestgrid[newx][newy]);
			}
			else
			{
				attackresult=true;
			}
			if(attackresult)
			{
				Forest.forestgrid[newx][newy]=Forest.forestgrid[x][y];
				Forest.forestgrid[x][y]=null;
				Forest.forestgrid[newx][newy].set_x(newx);
				Forest.forestgrid[newx][newy].set_y(newy);
				x=get_x();
				y=get_y();
			}
			else
			{
				mflag=false;
				break;
			}
		}
		if(mflag)
		{
			Forest.forestgrid[x][y].moveprint(initialx, initialy, newx, newy);
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
	    if(sdefender=='i')
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
			attackerwin=true;
			Forest.deadanimallist.add(Forest.forestgrid[dx][dy].name());
			Forest.deadanimalxpos.add(dx);
			Forest.deadanimalypos.add(dy);
			Forest.forestgrid[dx][dy]=null;
		}
		if(attackerwin)
		{
			System.out.println("Dinosaur from ("+initialx+", "+initialy+") attacks "+ defendertype + " at ("+dx+", "+dy+") and wins");
			System.out.println(defendertype+" dies at ("+dx+", "+dy+")");
		}
		else
		{
			System.out.println("Dinosaur from ("+initialx+", "+initialy+") attacks "+ defendertype + " at ("+dx+", "+dy+") and loses");
			System.out.println("Dinosaur dies at ("+ax+", "+ay+")");
		}
		return attackerwin;
	}
}
