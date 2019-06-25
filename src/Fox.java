import java.util.Random;
/**
 * Fox Class is a subclass of Canine Class
 * Fox class that contains and provides information only specific to the animal fox. 
 * It performs the behaviors that are unique to the fox itself
 * @author Luv Khanna
 *
 */
public class Fox extends Canine
{
	/**
	 * A constructor to initialize the instances variables of the object of Fox class
	 * by calling the super class constructor
	 * @param x
	 * 			The x position of the fox
	 * @param y
	 * 			The y position of the fox
	 * @param count
	 * 			A counter to note the number of times the fox has moved
	 */
	public Fox(int x,int y,int count)
	{
		super(x,y,count);
	}
	public char Symbol()
	{
		return 'f';
	}
	public String name()
	{
		return "Fox";
	}
	public void moveprint(int initialx,int initialy,int finalx,int finaly)
	{
		System.out.println("Fox moved from ("+initialx+", "+initialy+") to ("+finalx+", "+finaly+")");
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
		if(sdefender=='c' || sdefender=='l' || sdefender=='t')
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
		else if(sdefender=='u')
		{
			int randomnumber=rand.nextInt(100);
			if(randomnumber<20)
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
		else if(sdefender=='f')
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
		else if(sdefender=='c')
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
		if(attackerwin)
		{
			System.out.println("Fox from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and wins");
			System.out.println(defendertype+" dies at ("+dx+", "+dy+")");
		}
		else
		{
			System.out.println("Fox from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and loses");
			System.out.println("Fox dies at ("+ax+", "+ay+")");
		}
		return attackerwin;
	}
}
