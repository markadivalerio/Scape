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

public class Scape extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
	private boolean		mouseClicked;
	private Point		mousePosition;
	private Point		mouseGrid;
	private int			mouseButton;
	private Timer		timer;
	private Graphics	g;
	
	private Player		player;
	private Map			map;
	private int			game_time	= 0;
	
	
	public Scape()
	{
		this.setPreferredSize(new Dimension(2350, 2350));
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		
		setUp();
		
		this.setFocusable(true);
	}
	
	
	public void setUp()
	{
		player = new Player();
		map = new Map();
		
		ActionListener counter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event)
			{
				game_time++;
//				if(countdown_timer > 0)
//				{
//					countdown_timer--;
//				}
			}
		};
		timer = new Timer(1000, counter);// call method (increments game_time) every second
		
		map.loadLevel(map.level + 1);
		
		timer.start();
		
	}
	
	
	public void loadLevel()
	{	
		
	}
	
	
	
	@Override
	public void paintComponent(Graphics window)
	{
		super.paintComponent(window);
		g = window;
		draw_background();
		draw_map();
		draw_player();
	}
	
	
	public void draw_background()
	{
		map.drawGrid(g);
	}
	
	
	public void draw_map()
	{	
		
	}
	
	
	public void draw_player()
	{	
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e)
	{	
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e)
	{	
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e)
	{	
		
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e)
	{	
		
	}
	
	
	@Override
	public void mouseExited(MouseEvent e)
	{	
		
	}
	
	
	@Override
	public void mouseMoved(MouseEvent e)
	{	
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e)
	{	
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e)
	{	
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e)
	{	
		
	}
	
	
	@Override
	public void keyReleased(KeyEvent e)
	{	
		
	}
}
