package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import map_objects.Spot;
import scape.Map;

public class FileHandler
{
	private final String		MAP_LEVELS_FILENAME			= "mapLevels.txt";
	private final String		CUSTOM_MAP_LEVELS_FILENAME	= "customMapLevels.txt";
	private final char			COMMENT						= '*';
	private final SpotFactory	SPOT_FACTORY				= new SpotFactory();
	
	private Map					map;
	private ArrayList<String>	levelInformation			= new ArrayList<String>();
	
	
	public Map loadLevel(int levelNumber)
	{
		return loadLevel(Integer.toString(levelNumber));
	}
	
	
	public Map loadLevel(String levelName)
	{
		if(isLevelAvailable(levelName, MAP_LEVELS_FILENAME))
		{
			map = loadLevelFromFile(levelName, MAP_LEVELS_FILENAME);
			return map;
		}
		else if(isLevelAvailable(levelName, CUSTOM_MAP_LEVELS_FILENAME))
		{
			map = loadLevelFromFile(levelName, CUSTOM_MAP_LEVELS_FILENAME);
			return map;
		}
		else
		{
			return new Map("Default Level");
		}
	}
	
	
	public void saveLevel(String levelName, Map scapeMap)
	{
		// TODO
	}
	
	
	public boolean isLevelAvailable(String levelName, String fileName)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			boolean locatedLevel = false;
			String line = "";
			while(fileReader.hasNextLine())
			{
				line = fileReader.nextLine();
				if(line.charAt(0) == COMMENT)// comment character. skip
				{
					continue;
				}
				else if(line.indexOf("level") == 0)
				{
					String name = line.split(" ")[1];
					if(levelName.equalsIgnoreCase(name) == true)
					{
						return true;
					}
				}
			}
			return false;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found. " + e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Problem reading file" + e.getMessage());
		}
		
		return false;
	}
	
	
	public Map loadLevelFromFile(String levelName, String fileName)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			String line = "";
			while(fileReader.hasNextLine())
			{
				line = fileReader.nextLine();
				if(line.charAt(0) == COMMENT)
				{
					continue;
				}
				else if(line.indexOf("level") == 0)
				{
					String name = line.split(" ")[1];
					if(levelName.equalsIgnoreCase(name) == true)
					{
						map = scanLevel(fileReader);
						map.setLevelName(name);
						return map;
					}
				}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found. " + e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Problem reading file" + e.getMessage());
		}
		
		return new Map("Default Level");
	}
	
	
	public Map scanLevel(Scanner fileReader)
	{
		map = new Map();
		try
		{
			String line = fileReader.nextLine();
			map.setXSize(Integer.parseInt(line.split(" ")[0]));
			map.setYSize(Integer.parseInt(line.split(" ")[1]));
			map.setComment(fileReader.nextLine());
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Level not completed in file.  " + e.getMessage());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Could not extract level size from file.  " + e.getMessage());
		}
		
		String line = "";
		levelInformation = new ArrayList<String>();
		while(fileReader.hasNextLine())
		{
			line = fileReader.nextLine();
			if((line.charAt(0) == COMMENT) || (line.equals("") == true) || (line.equals("\n") == true))
			{
				continue;
			}
			else if(line.indexOf("level") == 0)
			{
				break;
				// return map;// hit the end of the level in the file. Scanning done.
			}
			else
			{
				levelInformation.add(line);
			}
//			else if(isLineStartOfSpot(line))
//			{
//				ArrayList<String> spotDetails = gatherSpotDetails(fileReader,line);
//				Spot spot = SPOT_FACTORY.createSpotObject(line);
//				map.addSpot(spot);
//			}
		}
		
		return createMap(map, levelInformation);
	}
	
	
	private Map createMap(Map gameMap, ArrayList<String> levelInfo)
	{
		
		return gameMap;
	}
	
	
	
	private ArrayList<String> gatherSpotDetails(Scanner fileReader, String firstLine)
	{
		ArrayList<String> spotDetails = new ArrayList<String>();
		spotDetails.add(firstLine);
		while(fileReader.hasNext())
		{	
			
		}
		return spotDetails;
	}
	
	
	private boolean isLineStartOfSpot(String line)
	{
		ArrayList<String> lineParts = new ArrayList<String>(Arrays.asList(line.split(" ")));
		if(lineParts.size() < 1)
		{
			return false;
		}
		else
		{
			for(String spotType: Spot.AVAILABLE_SPOTS)
			{
				if(spotType.equalsIgnoreCase(lineParts.get(2)))
				{
					return true;
				}
			}
			return false;
		}
		
	}
}
