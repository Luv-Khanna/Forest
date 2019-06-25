import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Map;
import java.util.ArrayList;

/**
 * The ForestNew class controls the program flow and user interaction
 * 
 * @author Luv Khanna
 * 
 */
public class ForestNew
{
	private static int moveNum = 0;
	private static char animalsymbols[] = {'c','i','d','f','j','k','l','u','w'};
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		ForestNew f=new ForestNew();
		f.displayforest();
		boolean flag=true;
		while(flag)
		{

			f.displaymenu();
			int choice=sc.nextInt();
			if(choice==0)
			{
				flag=false;
			}
			else
			{
				int p1,p2;
				p1=rand.nextInt(15);
				p2=rand.nextInt(15);
				boolean oflag=true;
				while(oflag)
				{
					if(Forest.forestgrid[p1][p2]!=null)
					{
						p1=rand.nextInt(15);
						p2=rand.nextInt(15);
					}
					else 
					{
						oflag=false;
					}
				}
				if(choice==1)
				{
					
					Forest.forestgrid[p1][p2]=new Dog(p1,p2,0);
					System.out.println("Added Dog at ("+p1+","+p2+"): Dog is Canine, Canine moves in four directions, one or two steps a time.");
				}
				if(choice==2)
				{
					Forest.forestgrid[p1][p2]=new Fox(p1,p2,0);
					System.out.println("Added Fox at ("+p1+","+p2+"): Fox is Canine, Canine moves in four directions, one or two steps a time.");
				}
				if(choice==3)
				{
					Forest.forestgrid[p1][p2]=new Wolf(p1,p2,0);
					System.out.println("Added Wolf at ("+p1+","+p2+"): Wolf is Canine, Canine moves in four directions, one or two steps a time.");
				}
				if(choice==4)
				{
					Forest.forestgrid[p1][p2]=new Jaguar(p1,p2,0);
					System.out.println("Added Jaguar at ("+p1+","+p2+"): Jaguar is Feline, Feline moves in all eight directions, one step a time.");
				}
				if(choice==5)
				{
					Forest.forestgrid[p1][p2]=new Lion(p1,p2,0);
					System.out.println("Added Lion at ("+p1+","+p2+"): Lion is Feline, Feline moves in all eight directions, one step a time.");
				}
				if(choice==6)
				{
					Forest.forestgrid[p1][p2]=new Cat(p1,p2,0);
					System.out.println("Added Cat at ("+p1+","+p2+"): Cat is Feline, Feline moves in all eight directions, one step a time.");
				}
				if(choice==7)
				{
					Forest.forestgrid[p1][p2]=new Kitten(p1,p2,0);
					System.out.println("Added Kitten at ("+p1+","+p2+"): Kitten is Cat, Kitten has 30% chance stay in the same position, and 70% chance move in all eight directions, one step at a time.");
				}
				if(choice==8)
				{
					Forest.forestgrid[p1][p2]=new Dinosaur(p1,p2,0);
					System.out.println("Added Dinosaur at ("+p1+","+p2+"): Dinosaur is Animal, Dinosaur moves in four directions, three steps a time.");
				}
				if(choice==9)
				{
					Forest.forestgrid[p1][p2]=new Turtle(p1,p2,0);
					System.out.println("Added Turtle at ("+p1+","+p2+"): Turtle is Animal, Turtle has 50% chance stay in the same position, and 50% chance move in four directions, one step at a time.");
				}
			}
			f.displayforest();
		}
		sc.nextLine();
		boolean iflag=true;
		System.out.print("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit: ");
		String ichoice=sc.nextLine();
		while(iflag)
		{
			if(ichoice.equals("exit"))
			{
				iflag=false;
				f.displayforest();
				//f.livinganimaldisplay();
				f.deadanimaldisplay();
			}
			else
			{
				if(ichoice.equals("print"))
				{
					f.displayforest();
					f.deadanimaldisplay();
				}
				else
				{
					f.movement();
					f.displayforest();
				}
				System.out.print("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit: ");
				ichoice=sc.nextLine();
			}
		}
	}
	/**
	 * A method to display the forest grid 
	 */
	public void displayforest()
	{
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				if(Forest.forestgrid[i][j]==null)
					System.out.print(".");
				else 
					 System.out.print(Forest.forestgrid[i][j].Symbol());
			}
			System.out.println();
		}
		System.out.println();
	}
	public void displaymenu()
	{
		System.out.println("1.	Dog (d)");
		System.out.println("2.	Fox (f)");
		System.out.println("3.	Wolf (w)");
		System.out.println("4. 	Jaguar (j)");
		System.out.println("5.	Lion (l)");
		System.out.println("6.	Cat (c)");
		System.out.println("7.	Kitten (k)");
		System.out.println("8.	Dinosaur (i)");
		System.out.println("9.	Turtle (u)");
		System.out.println("What would you like to add to the Forest?");
		System.out.print("Please enter your choice (1-9, or 0 to finish the animal input): ");
	}
	/**
	 * A method to display the list of living animals
	 */
	public void livinganimaldisplay()
	{
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				if(Forest.forestgrid[i][j]!=null)
					System.out.println(Forest.forestgrid[i][j].name()+" alive at location ("+i+", "+j+")");
			}
		}
		System.out.println();
	}
	
	/**
	 * A method to display the list of dead animals
	 */
	public void deadanimaldisplay()
	{
		for(int i=0;i<Forest.deadanimallist.size();i++)
		{
			System.out.println(Forest.deadanimallist.get(i)+" died at location ("+Forest.deadanimalxpos.get(i)+", "+Forest.deadanimalypos.get(i)+")");
		}
		System.out.println();
	}
	
	/**
	 * A method to ensure that each animal only moves once during every iteration
	 */
	public void movement()
	{
		for(int as=0;as<animalsymbols.length;as++)
		{
			for(int i=0;i<15;i++)
			{
				for(int j=0;j<15;j++)
				{
					if(Forest.forestgrid[i][j]!=null)
					{
						if(Forest.forestgrid[i][j].Symbol()==animalsymbols[as] && Forest.forestgrid[i][j].get_count() == moveNum)
						{
							
							Forest.forestgrid[i][j].addcount();
							Forest.forestgrid[i][j].move();
						}
					}
				}
			}
		}
		moveNum++;
	}
}
/**
 * The Forest class stores the forest grid
 * 
 * @author Luv Khanna
 *
 */
class Forest
{
	/**
	 * An array to contain the whole forest. Each element of the array is an object of the Animal class.
	 */
	public static Animal forestgrid[][]=new Animal[15][15];
	/**
	 * An ArrayList to store the type of the animal that dies
	 */
	public static ArrayList<String> deadanimallist= new ArrayList<String>();
	/**
	 * An ArrayList to store the x position of the dead animal
	 */
	public static ArrayList<Integer> deadanimalxpos=new ArrayList<Integer>();
	/**
	 * An ArrayList to store the y position of the dead animal
	 */
	public static ArrayList<Integer> deadanimalypos=new ArrayList<Integer>();
}
