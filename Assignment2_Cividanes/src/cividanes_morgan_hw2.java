import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import java.util.Random;
import java.util.Scanner;
import org.newdawn.slick.AppGameContainer;
/*
 * Author: Morgan Cividanes
 * Date: 02/23/2021
 * Description: The cividanes_morgan_hw2 Class -
 * Main class for project that extends BasicGame
 */
public class cividanes_morgan_hw2 extends BasicGame
{
	private int width;
	private int height;
	private int pixWidth;
	private int pixHeight;
	private Zone[][] zone; //array to hold the zones
	private int[][] types; //array to keep track of types

	private static AverageDenResidential averageDen = new AverageDenResidential();
	private static Commercial commercial = new Commercial();
	private static HighDenResidential highDen = new HighDenResidential();
	private static Industrial industrial = new Industrial();
	private static LowDenResidential lowDen = new LowDenResidential();
	private static RecreationSpace recreation = new RecreationSpace();

	public cividanes_morgan_hw2(String title, int width, int height) 
	{
		super("Basic Procedural Generation");
		
		this.width = width;
		this.height = height;		
		this.zone = new Zone[height][width]; //setting the size of zone
		this.types = new int[height][width]; //setting the size of types
	}

	public static void main(String[] args) 
	{
		AppGameContainer container = null;
		cividanes_morgan_hw2 game;
		int width;
		int height;
		//****** USED FOR TAKING IN USER INPUT FOR THE SIZE OF THE ZONE
		Scanner input = new Scanner(System.in);
		System.out.print("Input Width: ");
		width = input.nextInt();
		System.out.print("Input Height: ");
		height = input.nextInt();
		//*********************************************************

		game = new cividanes_morgan_hw2("Basic Procedural Generation",width,height);
		
		try
		{
			container = new AppGameContainer(game);
		}
		catch (SlickException error)
		{
			System.out.println("Could not build game!");
			error.printStackTrace();
		}
		
		try
		{
			container.setTargetFrameRate(60);
			container.start();
		}
		catch (SlickException error)
		{
			System.out.println("Could't start game!");
			error.printStackTrace();
		}
	
	}
	
	/**
	 * decision method: used for generating neighbors based on the previously generated zone type
	 * @param lastOne - variable for last zone type created
	 * @param isFirstTime - boolean checking to see if this is the first zone
	 * @return neighbor - this is the new neighbor and is returned in order to use it to store what was generated last
	 */
	public static int decision(int lastOne, boolean isFirstTime)
	{
		int neighbor = 0;
		
		//This only happens the first time in order to choose a random starting zone time 
		if(isFirstTime == true)
		{
			Random random = new Random();
			int randomConv = random.nextInt(6) + 1; //Choose number between 1-6
			return randomConv;
		}
		else
		{
			//Commercial
			if(lastOne == 1)
			{
				neighbor = commercial.generateNeighbor();
			}
			//Average Density Residential
			else if(lastOne == 2)
			{
				neighbor = averageDen.generateNeighbor();
			}
			//Low Density Residential
			else if(lastOne == 3)
			{

				neighbor = lowDen.generateNeighbor();
			}
			//High Density Residential
			else if(lastOne == 4)
			{
				neighbor = highDen.generateNeighbor();
			}
			//Industrial
			else if(lastOne == 5)
			{
				neighbor = industrial.generateNeighbor();
			}
			//Recreation Space
			else if(lastOne == 6)
			{
				neighbor = recreation.generateNeighbor();
			}
			return neighbor;
		}
	}
		
	@Override
	public void render(GameContainer container, Graphics painter) throws SlickException 
	{
		int xPos = 0;
		int yPos = 0;
		
		boolean isFirstTime = true;
		for(int y = 0; y < this.zone.length; y++)
		{
			
			for(int x = 0; x < this.zone[y].length; x++)
			{

				if(types[y][x] == 1 ) 
				{
					//Commercial DRAWING
					commercial.drawSelf(xPos, yPos, painter,pixWidth,pixHeight);
					
				}
				else if(types[y][x] == 2)
				{
					//Average Density Residential DRAWING
					averageDen.drawSelf(xPos, yPos, painter,pixWidth,pixHeight);
				}
				else if(types[y][x] == 3)
				{
					//Low Density Residential DRAWING
					lowDen.drawSelf(xPos, yPos, painter,pixWidth,pixHeight);
				}
				else if(types[y][x] == 4)
				{
					//High Density Residential DRAWING
					highDen.drawSelf(xPos, yPos, painter,pixWidth,pixHeight);
				}
				else if(types[y][x] == 5)
				{
					//Industrial DRAWING
					industrial.drawSelf(xPos, yPos, painter,pixWidth,pixHeight);
				}
				else if(types[y][x] == 6)
				{
					//Recreation Space DRAWING
					recreation.drawSelf(xPos, yPos, painter,pixWidth,pixHeight);
				}
				xPos += pixWidth;
				isFirstTime = false; //this sets to false in order to never randomly generate a zone without taking the neighbor into consideration
			}
			
			xPos = 0;
			yPos += pixHeight;
			
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException 
	{
		int xPos = 0;
		int yPos = 0;
			
		boolean isFirstTime = true;
		int lastOne = 1;
	
			for(int y = 0; y < this.zone.length; y++)
			{
				
				for(int x = 0; x < this.zone[y].length; x++)
				{
					
					int temp = lastOne;
					lastOne = decision(temp, isFirstTime);
					if(lastOne == 1) 
					{
						//SETTING TYPE AT THIS INDEX TO Commercial 
						types[y][x] = 1;
						this.zone[y][x] = new Commercial();
						//System.out.print("C");
						
					}
					else if(lastOne == 2)
					{
						//SETTING TYPE AT THIS INDEX TO Average Density Residential
						types[y][x] = 2;
						this.zone[y][x] = new AverageDenResidential();
						//System.out.print("A");
					}
					else if(lastOne == 3)
					{
						//SETTING TYPE AT THIS INDEX TO Low Density Residential
						types[y][x] = 3;
						this.zone[y][x] = new LowDenResidential();
						//System.out.print("L");
					}
					else if(lastOne == 4)
					{
						//SETTING TYPE AT THIS INDEX TO High Density Residential
						types[y][x] = 4;
						this.zone[y][x] = new HighDenResidential();
						//System.out.print("H");
					}
					else if(lastOne == 5)
					{
						//SETTING TYPE AT THIS INDEX TO Industrial
						types[y][x] = 5;
						this.zone[y][x] = new Industrial();
						//System.out.print("I");
					}
					else if(lastOne == 6)
					{
						//SETTING TYPE AT THIS INDEX TO Recreation Space
						types[y][x] = 6;
						this.zone[y][x] = new RecreationSpace();
						//System.out.print("R");
					}
					xPos += pixWidth;
					isFirstTime = false;
				}
				//System.out.println();
				xPos = 0;
				yPos += pixHeight;
			}		
		this.pixWidth = container.getWidth() / this.width;
		this.pixHeight = container.getHeight() / this.height;
		
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {}

}
