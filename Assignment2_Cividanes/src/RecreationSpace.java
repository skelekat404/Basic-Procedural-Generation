import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
/*
 * Author: Morgan Cividanes
 * Date: 02/23/2021
 * Description: The RecreationSpace Class -
 *5% - HighDenResidential
 *10% - AverageDenResidential
 *25% - LowDenResidential
 *15% - Commercial
 *0% - Industrial
 *45% - RecreationSpace
 * Should be blue in color
 */
public class RecreationSpace extends Zone
{
	private int width;
	private int height;
	private Color color;
	public RecreationSpace() //Constructor
	{
		this.width = width;
		this.height = height;
		this.color = color.blue;
	}

	@Override
	public void drawSelf(int xPos, int yPos, Graphics painter, int pixWidth, int pixHeight) 
	{	
		painter.setColor(color.blue); //Setting the color
		painter.drawRect(xPos * pixWidth, yPos * pixHeight, pixWidth, pixHeight); //Drawing the rectangle
		painter.fillRect(xPos, yPos, pixWidth, pixHeight);//Fill the Rectangle with color
	}

	@Override
	public int generateNeighbor() //GENERATES NEXT RANDOM NEIGHBOR BASED ON PROBABILITIES LISTED IN DESCRIPTION
	{
		//Creating new random integer from 1-100
		Random random = new Random();
		int randomConv = random.nextInt(100) + 1; 
		int neighbor = 0;
		if(randomConv < 6)
		{
			neighbor = 4; //high den
		}
		else if(randomConv > 5 && randomConv < 16)
		{
			neighbor = 2; //average den
		}
		else if(randomConv > 15 && randomConv < 41)
		{
			neighbor = 3; //low den
		}
		else if(randomConv > 40 && randomConv < 56)
		{
			neighbor = 1; //commerical
		}
//		else if(randomConv > 55 && randomConv < 81)
//		{
//			neighbor = 5; //industrial
//		}
		else if(randomConv > 55)
		{
			neighbor = 6; //rec space
		}
		return neighbor;
	}

}
