import java.util.ArrayList;
import java.util.Random;
/**
 * Animal class is a super class.
 * It contains all the methods that are common to the animal.
 * It also contains the abstract methods that are used by the specific animal type
 * in accordance to their specific behaviour. 
 * @author Luv Khanna
 *
 */
public abstract class Animal
{
	private int x,y,count;
	/**
	 * It is a constructor that initializes all the variables of the objects of each animal type
	 * @param xpos
	 * 				The x position of the animal
	 * @param ypos
	 * 				The y position of the animal
	 * @param icount
	 * 				A counter to note the number of times an animal has moved 
	 */
	public Animal(int xpos,int ypos,int icount)
	{
		x=xpos;
		y=ypos;
		count=icount;
	}
	/**
	 * A getter method
	 * @return the x position of the animal
	 */
	public int get_x()
	{
		return x;
	}
	/**A setter method
	 * @param xpos
	 * 				the x position of the animal
	 */
	public void set_x(int xpos)
	{
		x=xpos;
	}
	/**
	 * A getter method
	 * @return the y position of the animal
	 */
	public int get_y()
	{
		return y;
	}
	/**
	 * A setter method 
	 * @param ypos
	 * 				the y position of the animal
	 */
	public void set_y(int ypos)
	{
		y=ypos;
	}
	/**
	 * A getter method 
	 * @return the count of moves of the animal 
	 */
	public int get_count()
	{
		return count;
	}
	/**
	 * A setter method
	 * @param icount
	 * 				counter to note the number of times an animal has moved
	 */
	public void set_count(int icount)
	{
		count=icount;
	}
	/**
	 * A method that increments the count variable 
	 */
	public void addcount()
	{
		count++;
	}
	/**
	 * Method that return the symbol used to represent the animal
	 * @return symbol used to represent the animal
	 */
	public abstract char Symbol();
	/**
	 * Method that controls the movement of the specific animal during every iteration.
	 */
	public abstract void move();
	/**
	 * Method to return the type of the animal
	 * @return animal type
	 */
	public abstract String name();
	/**
	 * Method to print the movement specific to the animal after the animal has successfully completed it's movement
	 * @param initialx
	 * 					The initial x position of the animal
	 * @param initialy
	 * 					The initial y position of the animal
	 * @param finalx
	 * 					The final x position of the animal
	 * @param finaly
	 * 					The final y position of the animal 
	 */
	public abstract void moveprint(int initialx,int initialy,int finalx,int finaly);
	/**
	 * Method that controls the attack behaviour specific to each animal
	 * @param attacker
	 * 					Animal that attacks
	 * @param defender
	 * 					Animal that is being attacked and has to defend
	 * @return boolean value to indicate the result of the fight
	 */
	public abstract boolean attack(Animal attacker,Animal defender);
}

