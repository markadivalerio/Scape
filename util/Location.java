package util;

import java.awt.Point;

public class Location
{
	private int	gridXCol	= -1;
	private int	gridYRow	= -1;
	
	private int	pixelXPos	= -1;
	private int	pixelYPos	= -1;
	
	private int	timeStamp	= 0;
	
	
	public Location()
	{	
		
	}
	
	
	public void setGridLocation(int xcol, int yrow)
	{
		gridXCol = xcol;
		gridYRow = yrow;
	}
	
	
	public void setPixelLocation(int xpos, int ypos)
	{
		pixelXPos = xpos;
		pixelYPos = ypos;
	}
	
	
	public void clearTimeStamp()
	{
		timeStamp = 0;
	}
	
	
	public void setTimeStamp(int time)
	{
		timeStamp = time;
	}
	
	
	public int getTimeStamp()
	{
		return timeStamp;
	}
}
