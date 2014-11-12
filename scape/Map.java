package scape;

import map_objects.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;
import java.awt.event.*;
import javax.swing.Timer;
import util.SpotFactory;

public class Map
{
	private static final SpotFactory	MAP_FACTORY					= new SpotFactory();
	private static final String			MAP_LEVELS_FILENAME			= "mapLevels.txt";
	private static final String			CUSTOM_MAP_LEVELS_FILENAME	= "customMapLevels.txt";
	
	// default size is 64 spots wide and 64 spots tall (each spot is 6x6 mini spots)
	public static final int				DEFAULT_GRID_XSIZE			= 384;								// 64*6
	public static final int				DEFAULT_GRID_YSIZE			= 384;								// 64*6
																										
																										
	private String						levelName					= "Default Level";
	private String						comment						= "";
	private int							xsize						= DEFAULT_GRID_XSIZE;
	private int							ysize						= DEFAULT_GRID_YSIZE;
	private boolean						showGrid					= true;
	private boolean						showMiniGrid				= true;
	
	
	private ArrayList<Spot>				spots						= new ArrayList<Spot>();
	private ArrayList<Item>				items						= new ArrayList<Item>();
	private ArrayList<MovingObstacle>	obstacles					= new ArrayList<MovingObstacle>();
	
	
	public Map()
	{
		this.levelName = "Default Level";
	}
	
	
	public Map(String levelName)
	{
		this.levelName = levelName;
	}
	
	
	public String getLevelName()
	{
		return levelName;
	}
	
	
	public void setLevelName(String levelName)
	{
		this.levelName = levelName;
	}
	
	
	public String getComment()
	{
		return comment;
	}
	
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	
	public int getXSize()
	{
		return xsize;
	}
	
	
	public void setXSize(int xsize)
	{
		this.xsize = xsize;
	}
	
	
	public int getYSize()
	{
		return ysize;
	}
	
	
	public void setYSize(int ysize)
	{
		this.ysize = ysize;
	}
	
	
	public boolean isShowGrid()
	{
		return showGrid;
	}
	
	
	public void setShowGrid(boolean showGrid)
	{
		this.showGrid = showGrid;
	}
	
	
	public boolean isShowMiniGrid()
	{
		return showMiniGrid;
	}
	
	
	public void setShowMiniGrid(boolean showMiniGrid)
	{
		this.showMiniGrid = showMiniGrid;
	}
	
	
	public void addSpot(Spot spot)
	{
		spots.add(spot);
	}
	
	
	public void addItem(Item item)
	{
		items.add(item);
	}
	
	
	public void addMovingObstacle(MovingObstacle obstacle)
	{
		obstacles.add(obstacle);
	}
	
	
	public void draw(Graphics g)
	{	
		
	}
	
	
	public void drawGrid(Graphics g)
	{
		if(showMiniGrid == true)
		{
			for(int x = 0; x <= xsize; x++)
			{
				g.setColor(Color.LIGHT_GRAY);
				g.drawLine((20 + 6 * x), 20, (20 + 6 * x), (20 + 6 * xsize));
				if(x % 6 == 0)
				{
					g.setColor(Color.GRAY);
					g.drawString("" + x, (20 + 6 * x), 20);
					g.drawLine((20 + 6 * x), 20, (20 + 6 * x), (20 + 6 * xsize));
				}
			}
			for(int y = 0; y <= ysize; y++)
			{
				g.setColor(Color.LIGHT_GRAY);
				g.drawLine(20, (20 + 6 * y), (20 + 6 * ysize), (20 + 6 * y));
				if(y % 6 == 0)
				{
					g.setColor(Color.GRAY);
					g.drawString("" + y, 20, (20 + 6 * y));
					g.drawLine(20, (20 + 6 * y), (20 + 6 * ysize), (20 + 6 * y));
				}
			}
		}
		if(showGrid == true)
		{
			if(showMiniGrid == true)
			{
				g.setColor(Color.GRAY);
			}
			else
			{
				g.setColor(Color.LIGHT_GRAY);
			}
			for(int x = 0; x <= xsize; x++)
			{
				if(x % 6 == 0)
				{
					g.drawLine((20 + 6 * x), 20, (20 + 6 * x), (20 + 6 * xsize));
				}
			}
			for(int y = 0; y <= ysize; y++)
			{
				if(y % 6 == 0)
				{
					g.drawLine(20, (20 + 6 * y), (20 + 6 * ysize), (20 + 6 * y));
				}
			}
		}
		g.setColor(Color.BLACK);
		g.drawRect(20, 20, (6 * xsize), (6 * ysize));// outer-border of grid
	}
	
}
