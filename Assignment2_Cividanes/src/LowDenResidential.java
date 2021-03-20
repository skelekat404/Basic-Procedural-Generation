import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
/*
 * Author: Morgan Cividanes
 * Date: 02/23/2021
 * Description: The LowDenResidential Class -
 *0% - HighDenResidential
 *20% - AverageDenResidential
 *40% - LowDenResidential
 *5% - Commercial
 *0% - Industrial
 *35% - RecreationSpace
 * Should be light gray in color
 */
public class LowDenResidential extends Zone
{
	private int width;
	private int height;
	private Color color;
	public LowDenResidential() //Constructor
	{
		this.width = width;
		this.height = height;
		this.color = color.lightGray;
	}

	@Override
	public void drawSelf(int xPos, int yPos, Graphics painter, int pixWidth, int pixHeight) 
	{
		painter.setColor(color.green);//Setting the color
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
//		if(randomConv < 21)
//		{
//			neighbor = 4; //high den
//		}
		if(randomConv < 21)
		{
			neighbor = 2; //average den
		}
		else if(randomConv > 20 && randomConv < 61)
		{
			neighbor = 3; //low den
		}
		else if(randomConv > 60 && randomConv < 66)
		{
			neighbor = 1; //commerical
		}
//		else if(randomConv > 65 && randomConv < 81)
//		{
//			neighbor = 5; //industrial
//		}
		else if(randomConv > 65)
		{
			neighbor = 6; //rec space
		}
		return neighbor;
	}

}
