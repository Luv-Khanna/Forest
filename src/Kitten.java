import java.util.Random;
/**
 * Kitten class is a sub class of Cat class
 * Kitten class that contains and provides information only specific to the animal Kitten. 
 * It performs the behaviors that are unique to the Kitten itself.
 * 
 * @author Luv Khanna
 *
 */
public class Kitten extends Cat
{
	/**
	 * A constructor to initialize the instances variables of the object of Kitten class
	 * by calling the super class constructor 
	 * @param x
	 * 			The x position of the kitten
	 * @param y
	 * 			The y position of the kitten
	 * @param count
	 * 			A counter to note the number of times the kitten has moved
	 */
	public Kitten(int x,int y,int count)
	{
		super(x,y,count);
	}
	public char Symbol()
	{
		return 'k';
	}
	public String name()
	{
		return "Kitten";
	}
	public void moveprint(int initialx,int initialy,int finalx,int finaly)
	{
		System.out.println("Kitten moved from ("+initialx+", "+initialy+") to ("+finalx+", "+finaly+")");
	}
	public void move()
	{
		boolean attackresult=false;
		int x=get_x();
		int y=get_y();
		Random rand=new Random();
		int randomnumberstay=rand.nextInt(100);
		if(randomnumberstay<30)
		{
			System.out.println("Kitten stayed in ("+x+", "+y+")");
		}
		else
		{
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
		if(sdefender=='c')
		{
			int randomnumber=rand.nextInt(100);
			if(randomnumber<30)
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
		else if(sdefender=='k')
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
			System.out.println("Kitten from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and wins");
			System.out.println(defendertype+" dies at ("+dx+", "+dy+")");
		}
		else
		{
			System.out.println("Kitten from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and loses");
			System.out.println("Kitten dies at ("+ax+", "+ay+")");
		}
		return attackerwin;
	}
}
