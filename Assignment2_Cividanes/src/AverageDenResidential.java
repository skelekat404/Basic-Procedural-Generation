import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
/*
 * Author: Morgan Cividanes
 * Date: 02/23/2021
 * Description: The AverageDenResidential Class -
 *20% - HighDenResidential
 *30% - AverageDenResidential
 *5% - LowDenResidential
 *20% - Commercial
 *5% - Industrial
 *20% - RecreationSpace
 * Should be gray in color
 */
public class AverageDenResidential extends Zone
{
	private int width;
	private int height;
	private Color color;
	public AverageDenResidential() //Constructor
	{
		this.width = width;
		this.height = height;
		this.color = color.gray;
	}

	@Override
	public void drawSelf(int xPos, int yPos, Graphics painter, int pixWidth, int pixHeight) 
	{
		painter.setColor(color.gray);//Setting the color
		painter.drawRect(xPos * pixWidth, yPos * pixHeight, pixWidth, pixHeight);//Drawing the rectangle
		painter.fillRect(xPos, yPos, pixWidth, pixHeight);//Fill the Rectangle with color
	}

	@Override
	public int generateNeighbor() //GENERATES NEXT RANDOM NEIGHBOR BASED ON PROBABILITIES LISTED IN DESCRIPTION
	{
		//Creating new random integer from 1-100
		Random random = new Random();
		int randomConv = random.nextInt(100) + 1; 
		int neighbor = 0;
//		painter.setColor(color);
//		painter.fillRect(x1, y1, width, height);
		if(randomConv < 21)
		{
			neighbor = 4; //high den
		}
		else if(randomConv > 20 && randomConv < 51)
		{
			neighbor = 2; //average den
			
		}
		else if(randomConv > 50 && randomConv < 56)
		{
			neighbor = 3; //low den
		}
		else if(randomConv > 55 && randomConv < 76)
		{
			neighbor = 1; //commerical
		}
		else if(randomConv > 75 && randomConv < 81)
		{
			neighbor = 5; //industrial
		}
		else if(randomConv > 80)
		{
			neighbor = 6; //rec space
		}
		return neighbor;
		
	}

}
