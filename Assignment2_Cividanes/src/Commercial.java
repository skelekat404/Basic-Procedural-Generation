import java.util.Random;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
/*
 * Author: Morgan Cividanes
 * Date: 02/23/2021
 * Description: The Commercial Class -
 *20% - HighDenResidential
 *20% - AverageDenResidential
 *5% - LowDenResidential
 *30% - Commercial
 *20% - Industrial
 *5% - RecreationSpace
 * Should be green in color
 */
public class Commercial extends Zone
{
	private int width;
	private int height;
	private Color color;
	public Commercial() //Constructor
	{
		this.width = width;
		this.height = height;
		this.color = color.green;
	}

	@Override
	public void drawSelf(int xPos, int yPos, Graphics painter, int pixWidth, int pixHeight) 
	{
		painter.setColor(color.green);//Setting the color
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
		if(randomConv < 21)
		{
			neighbor = 4; //high den
		}
		else if(randomConv > 20 && randomConv < 41)
		{
			neighbor = 2; //average den
		}
		else if(randomConv > 40 && randomConv < 46)
		{
			neighbor = 3; //low den
		}
		else if(randomConv > 45 && randomConv < 76)
		{
			neighbor = 1; //commerical
		}
		else if(randomConv > 75 && randomConv < 96)
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
