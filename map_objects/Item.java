package map_objects;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;
import java.awt.event.*;
import javax.swing.Timer;

public abstract class Item extends Spot
{
	
	@Override
	public abstract void draw(Graphics g);
	
	
	@Override
	public abstract void performAction();
	
	
	@Override
	public abstract String toString();
	
}
