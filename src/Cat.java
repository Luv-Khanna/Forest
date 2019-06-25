import java.util.Random;
/**
 * Cat class is a subclass of Feline class
 * Cat class that contains and provides information only specific to the animal cat. 
 * It performs the behaviors that are unique to the cat itself
 * @author Luv Khanna
 *
 */
public class Cat extends Feline
{
	/**
	 * A constructor to initialize the instances variables of the object of Cat class
	 * by calling the super class constructor
	 * @param x
	 * 			The x position of the cat
	 * @param y
	 * 			The y position of the cat
	 * @param count
	 * 			A counter to note the number of times the cat has moved
	 */
	public Cat(int x,int y,int count)
	{
		super(x,y,count);
	}
	public char Symbol()
	{
		return 'c';
	}
	public String name()
	{
		return "Cat";
	}
	public void moveprint(int initialx,int initialy,int finalx,int finaly)
	{
		System.out.println("Cat moved from ("+initialx+", "+initialy+") to ("+finalx+", "+finaly+")");
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
		else if(sdefender=='c')
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
			System.out.println("Cat from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and wins");
			System.out.println(defendertype+" dies at ("+dx+", "+dy+")");
		}
		else
		{
			System.out.println("Cat from ("+ax+", "+ay+") attacks "+ defendertype + " at ("+dx+", "+dy+") and loses");
			System.out.println("Cat dies at ("+ax+", "+ay+")");
		}
		return attackerwin;
	}
}

