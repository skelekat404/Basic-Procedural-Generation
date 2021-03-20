import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
/*
 * Author: Morgan Cividanes
 * Date: 02/23/2021
 * Description: The AverageDenResidential Class -
 *20% - HighDenResidential
 *5% - AverageDenResidential
 *0% - LowDenResidential
 *20% - Commercial
 *50% - Industrial
 *5% - RecreationSpace
 * Should be red in color
 */
public class Industrial extends Zone 
{
	private int width;
	private int height;
	private Color color;
	public Industrial()//Constructor
	{
		this.width = width;
		this.height = height;
		this.color = color.red;
	}

	@Override
	public void drawSelf(int xPos, int yPos, Graphics painter, int pixWidth, int pixHeight) 
	{
		painter.setColor(color.red); //Setting the color
		painter.drawRect(xPos * pixWidth, yPos * pixHeight, pixWidth, pixHeight); //Drawing the rectangle
		painter.fillRect(xPos, yPos, pixWidth, pixHeight);//Fill the Rectangle with color
	}

	@Override
	public int generateNeighbor()  //GENERATES NEXT RANDOM NEIGHBOR BASED ON PROBABILITIES LISTED IN DESCRIPTION
	{
		//Creating new random integer from 1-100
		Random random = new Random();
		int randomConv = random.nextInt(100) + 1; 
		int neighbor = 0;
		if(randomConv < 21)
		{
			neighbor = 4; //high den
		}
		else if(randomConv > 20 && randomConv < 26)
		{
			neighbor = 2; //average den
		}
//		else if(randomConv > 25 && randomConv < 46)
//		{
//			neighbor = 3; //low den
//		}
		else if(randomConv > 25 && randomConv < 46)
		{
			neighbor = 1; //commercial
		}
		else if(randomConv > 45 && randomConv < 96)
		{
			neighbor = 5; //industrial
		}
		else if(randomConv > 95)
		{
			neighbor = 6; //rec space
		}
		return neighbor;
	}


}
