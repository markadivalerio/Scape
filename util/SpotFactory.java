package util;

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import map_objects.Bomb;
import map_objects.ExtraLife;
import map_objects.Finish;
import map_objects.Gate;
import map_objects.GravityShift;
import map_objects.Spot;
import map_objects.Start;
import map_objects.Switch;
import map_objects.Teleporter;
import map_objects.Wall;
import scape.Map;

public class SpotFactory
{
	
	
	/*
	 * [unique id #] [SpotType] [gridxcol] [gridyrow] [gridxsize] [gridysize] ...
	 * [unique id #] [option1]
	 * [unique id #] [option2] ...
	 * 
	* options: LINK, TIME, PATH, DISPLAY, AREA, VALUE, REFRESH, REUSE, ACTION, INVERTED
	* LINK[uid#, #, #]: linked to another object on the map with the given unique ids',
	* TIME[1,5,9]: timer needed for this spot (i.e. bomb when it explodes)...numbers can range from 1 to 64.
	* TIME[start#-stop#]
	* PATH[x,y,time]: position and time when (1-64) a spot/object moves (must be in order)
	* DISPLAY[invisible/illusion]: special display options if the spot is hidden or a fake
	* AREA[xwidth, yheight]: Area the spot affects outside its own location (i.e. gravity well), with location at center
	* AREA[leftWidth, rightWidth, topHeight, bottomHeight]: Custom area spot affects with spot's location at center.
	* VALUE[#]: specific value associated with an item or quantity
	* REFRESH[yes/no]: for items and gates and obsticals, does it reset on player's death?
	* REUSE[#]: for switches or teleports, can you activate spot more than once?
	* ACTION[enters, exits, invertedEnters, invertedExits]: for switches/teleports/bombs, when to perform the spot's action
	* INVERTED[yes/no]: inverts the default action of a spot (GravityWell=pushes, Switch=default is ON, etc)
	 */
	
	
	public SpotFactory()
	{	
		
	}
	
	
	public Spot createSpotObject(String stringCode)
	{
		Spot spot = null;
		
		ArrayList<String> code = new ArrayList<String>(Arrays.asList(stringCode.split(" ")));
		int uid = Integer.parseInt(code.get(0));
		
		spot = generateSpot(code.get(1));
		spot.setUid(uid);
		
		Point location = new Point(Integer.parseInt(code.get(2)), Integer.parseInt(code.get(3)));
		spot.setGridLocation(location);
		
		Point size = new Point(Integer.parseInt(code.get(4)), Integer.parseInt(code.get(5)));
		spot.setSize(size);
		
//		String options = stringCode.substring(stringCode.indexOf(code[5]));
//		options = options.substring(options.indexOf(" "));
		
		
		return spot;
	}
	
	
	public Spot generateSpot(String spotType)
	{
		//@formatter: off
		String type = spotType.toUpperCase();
		
		
		if(type.equals("BOMB"))
		{
			return new Bomb();
		}
		else if(type.equals("EXTRA_LIFE"))
		{
			return new ExtraLife();
		}
		else if(type.equals("FINISH"))
		{
			return new Finish();
		}
		else if(type.equals("GATE"))
		{
			return new Gate();
		}
		else if(type.equals("GRAVITY_SHIFT"))
		{
			return new GravityShift();
		}
		else if(type.equals("START"))
		{
			return new Start();
		}
		else if(type.equals("SWITCH"))
		{
			return new Switch();
		}
		else if(type.equals("TELEPORTER"))
		{
			return new Teleporter();
		}
		else if(type.equals("WALL"))
		{
			return new Wall();
		}
		
		else
		{
			return null;
		}
		//@formatter: on
	}
	
	
	private Spot configureSpotOptions(Spot spot, ArrayList<String> options)
	{
		
		return spot;
	}
	
	
	private Spot configureLink(Spot spot, String details)
	{
		// LINK[uid#, #, #]: linked to another object on the map with the given unique ids',
		return spot;
	}
	
	
	private Spot configureTime(Spot spot, String details)
	{
		// TIME[1,5,9]: timer needed for this spot (i.e. bomb when it explodes)...numbers can range from 1 to 64.
		// TIME[start#-stop#]
		return spot;
	}
	
	
	private Spot configurePath(Spot spot, String details)
	{
		// PATH[x,y,time]: position and time when (1-64) a spot/object moves (must be in order)
		return spot;
	}
	
	
	private Spot configureDisplay(Spot spot, String details)
	{
		// DISPLAY[invisible/illusion]: special display options if the spot is hidden or a fake
		return spot;
	}
	
	
	private Spot configureArea(Spot spot, String details)
	{
		// AREA[xwidth, yheight]: Area the spot affects outside its own location (i.e. gravity well), with location at
		// center
		// AREA[leftWidth, rightWidth, topHeight, bottomHeight]: Custom area spot affects with spot's location at
		// center.
		return spot;
	}
	
	
	private Spot configureValue(Spot spot, String details)
	{
		// VALUE[#]: specific value associated with an item or quantity
		return spot;
	}
	
	
	private Spot configureRefresh(Spot spot, String details)
	{
		// REFRESH[yes/no]: for items and gates and obsticals, does it reset on player's death?
		return spot;
	}
	
	
	private Spot configureReuse(Spot spot, String details)
	{
		// REUSE[#]: for switches or teleports, can you activate spot more than once?
		return spot;
	}
	
	
	private Spot configureAction(Spot spot, String details)
	{
		// ACTION[enters, exits, invertedEnters, invertedExits]: for switches/teleports/bombs, when to perform the
		// spot's action
		return spot;
	}
	
	
	private Spot configureInverted(Spot spot, String details)
	{
		// INVERTED[yes/no]: inverts the default action of a spot (GravityWell=default is pull inward, Switch=default is
		// ON, etc)
		return spot;
	}
}
