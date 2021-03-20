import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;
import java.util.*;

/*
 * Author: Morgan Cividanes
 * Date: 02/23/2021
 * Description: The Zone Class -
 * Abstract base class that other zones will use
 */

public abstract class Zone 
{
	
	private int width;
	private int height;
	private Color color;
	
	/**
	 * 
	 *
	 */
	public Zone() //Constructor
	{
		this.width = width;
		this.height = height;
		this.color = color.white;
	}
	
	public abstract void drawSelf(int xPos, int yPos, Graphics painter, int pixWidth, int pixHeight);
	
	public abstract int generateNeighbor();

}
