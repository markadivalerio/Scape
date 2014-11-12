package map_objects;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Wall extends Spot
{
	
	@Override
	public void draw(Graphics g)
	{
//		g.setColor(Color.BLACK);
//		g.fillRect(this.getXYPosition().x, this.getXYPosition().y, 6, 6);
	}
	
	
	@Override
	public void performAction()
	{	
		
	}
	
	
	@Override
	public String toString()
	{
		String result = "";
		result += this.getClass().getSuperclass().getSimpleName() + " "; // Spot
		result += this.getClass().getSimpleName() + " ";// Wall
		return result;
	}
	
}
