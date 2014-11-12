package scape;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Player
{
	private int		lives;
	private Point	location;
	
	
	public Player()
	{	
		
	}
	
	
	public void set_lives(int l)
	{
		lives = l;
	}
	
	
	public int get_lives()
	{
		return lives;
	}
	
	
	public void set_location(Point loc)
	{
		location = loc;
	}
	
	
	public Point get_location()
	{
		return location;
	}
	
	
	public void draw(Graphics g)
	{	
		
	}
}
