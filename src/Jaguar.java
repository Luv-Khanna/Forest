import java.util.Random;
/**
 * Jaguar class is a sub class of Feline class
 * Jaguar class that contains and provides information only specific to the animal Jaguar. 
 * It performs the behaviors that are unique to the Jaguar itself.
 * 
 * @author Luv Khanna
 *
 */
public class Jaguar extends Feline
{
	/**
	 * A constructor to initialize the instances variables of the object of Jaguar class
	 * by calling the super class constructor 
	 * @param x
	 * 			The x position of the jaguar
	 * @param y
	 * 			The y position of the jaguar
	 * @param count
	 * 			A counter to note the number of times the jaguar has moved
	 */
	public Jaguar(int x,int y,int count)
	{
		super(x,y,count);
	}
	public char Symbol()
	{
		return 'j';
	}
	public String name()
	{
		return "Jaguar";
	}
	public void moveprint(int initialx,int initialy,int finalx,int finaly)
	{
		System.out.println("Jaguar moved from ("+initialx+", "+initialy+") to ("+finalx+", "+finaly+")");
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
		if(sdefender=='d' || sdefender=='f' || sdefender=='w')
		{
			attackerwin=true;
			Forest.deadanimallist.add(Forest.forestgrid[dx][dy].name());
			Forest.deadanimalxpos.add(dx);
			Forest.deadanimalypos.add(dy);
			Forest.forestgrid[dx][dy]=null;
		}
		else if(sdefender=='u')
		{
			attackerwin=true;
			Forest.deadanimallist.add(Forest.forestgrid[dx][dy].name());
			Forest.deadanimalxpos.add(dx);
			Forest.deadanimalypos.add(dy);
			Forest.forestgrid[dx][dy]=null;
		}
		else if(sdefender=='j')
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
			System.out.println("Jaguar from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and wins");
			System.out.println(defendertype+" dies at ("+dx+", "+dy+")");
		}
		else
		{
			System.out.println("Jaguar from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and loses");
			System.out.println("Jaguar dies at ("+ax+", "+ay+")");
		}
		return attackerwin;
	}
}
