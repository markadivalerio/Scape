package map_objects;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;
import java.awt.event.*;
import javax.swing.Timer;

public abstract class Spot implements Cloneable
{
	/*
	 * [unique id #] [Spot] [gridxrow] [gridycol] [gridxsize] [gridysize] [option1] [option2] ...
	* options: LINK, TIME, PATH, DISPLAY, AREA, VALUE, REFRESH, REUSE, ACTION, INVERTED
	* LINK[uid#, #, #]: linked to another object on the map with the given unique ids',
	* TIME[1,5,9]: timer needed for this spot (i.e. bomb when it explodes)...numbers can range from 1 to 64.
	* TIME[start#-stop#]
	* PATH[x,y,time]: position and time when (1-64) a spot/object moves (must be in order)
	* DISPLAY[invisible/illusion]: special display options if the spot is hidden or a fake
	* AREA[xwidth, yheight]: Area the spot affects outside its own location (i.e. gravity well), with location at center
	* VALUE[#]: specific value associated with an item or quantity
	* REFRESH[yes/no]: for items and gates and obsticals, does it reset on player's death?
	* REUSE[#]: for switches or teleports, can you activate spot more than once?
	* ACTION[enters, exits, invertedEnters, invertedExits]: for switches/teleports/bombs, when to perform the spot's action
	* INVERTED[yes/no]: inverts the default action of a spot (GravityWell=pushes, Switch=default is ON, etc)
	 */
	
	public static final ArrayList<String>	AVAILABLE_SPOTS		= new ArrayList<String>(Arrays.asList("BOMB",
																	"EXTRA_LIFE", "FINISH", "GATE", "GRAVITY_SHIFT",
																	"START", "SWITCH", "TELEPORTER", "WALL"));
	
	public static final ArrayList<String>	AVAILABLE_OPTIONS	= new ArrayList<String>(Arrays.asList("LINK", "TIME",
																	"PATH", "DISPLAY", "AREA", "VALUE", "REFRESH",
																	"REUSE", "ACTION", "INVERTED"));
	
	private int								uid					= -1;
	private Point							xyPos				= new Point(-1, -1);
	private Point							gridLocation		= new Point(-1, -1);
	private Point							size				= new Point(6, 6);
	private Rectangle						bounds				= new Rectangle();
	private boolean							displayInvisible	= false;
	private boolean							displayIllusion		= false;
	private ArrayList<Point>				pathwayLocations	= new ArrayList<Point>();
	private ArrayList<Integer>				pathwayTimeStamps	= new ArrayList<Integer>();
	private boolean							refreshOnDeath		= false;
	private ArrayList<Point>				coveringArea		= new ArrayList<Point>();
	
	
	
	public Spot()
	{
//		location = new Point(-1, -1);
//		size = new Point(6, 6);
//		bounds = null;
	}
	
	
//	
//	
//	public Spot(Point gridLoc, boolean passable) // on the grid
//	{
//		location = gridLoc;
//		this.setBounds();
//	}
//	
//	
//	public Spot(int xPos, int yPos) // off of the grid (on menu)
//	{
//		this.gridLocation = new Point(-1, -1);
//		this.passable = false;
//		this.setBounds();
//	}
	
	public int getUid()
	{
		return uid;
	}
	
	
	public void setUid(int uid)
	{
		this.uid = uid;
	}
	
	
	public Point getXYPos()
	{
		return xyPos;
	}
	
	
	public void setXYPos(Point xyPos)
	{
		this.xyPos = xyPos;
	}
	
	
	public Point getGridLocation()
	{
		return gridLocation;
	}
	
	
	public void setGridLocation(Point location)
	{
		this.gridLocation = location;
	}
	
	
	public Point getSize()
	{
		return size;
	}
	
	
	public void setSize(Point size)
	{
		this.size = size;
	}
	
	
	public boolean isInvisible()
	{
		return displayInvisible;
	}
	
	
	public void setInvisible(boolean invisible)
	{
		this.displayInvisible = invisible;
	}
	
	
	public boolean isIllusion()
	{
		return displayIllusion;
	}
	
	
	public void setIllusion(boolean illusion)
	{
		this.displayIllusion = illusion;
	}
	
	
	public ArrayList<Integer> getTimeStamp()
	{
		return pathwayTimeStamps;
	}
	
	
	public void setTimeStamp(ArrayList<Integer> timeStamp)
	{
		this.pathwayTimeStamps = timeStamp;
	}
	
	
	public boolean isRefreshOnDeath()
	{
		return refreshOnDeath;
	}
	
	
	public void setRefreshOnDeath(boolean refreshOnDeath)
	{
		this.refreshOnDeath = refreshOnDeath;
	}
	
	
	public ArrayList<Point> getCoveringArea()
	{
		return coveringArea;
	}
	
	
	public void setCoveringArea(ArrayList<Point> coveringArea)
	{
		this.coveringArea = coveringArea;
	}
	
	
	
	public Rectangle getBounds()
	{
		return bounds;
	}
	
	
	private void setBounds()
	{
		bounds = new Rectangle();
		bounds.setBounds(gridLocation.x, gridLocation.y, size.x, size.y);
	}
	
	
	
	public Point getXYPosFromLoc(Point gridLoc)
	{
		if((gridLoc.x < 0) || (gridLoc.y < 0))
		{
			return new Point(-1, -1);
		}
		else
		{
			return new Point((20 + 6 * gridLoc.x), (20 + 6 * gridLoc.y));
		}
	}
	
	
	
	public abstract void draw(Graphics g);
	
	
	public abstract void performAction();
	
	
	@Override
	public abstract String toString();
	
	
	@Override
	public Spot clone()
	{
		try
		{
			return (Spot)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			return null;
		}
	}
}
