package scape;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StartGame extends JFrame
{
	private final static int	SLEEP	= 25;	// repaints every 25 milliseconds
	private static Scape		scape;
	private static MapCreator	mapCreator;
	
	
	public StartGame(String title)
	{
		super(title);
	}
	
	
	public void addComponentToPane(Container pane)
	{
		JTabbedPane tabbedPane = new JTabbedPane();
		
		scape = new Scape();
		JScrollPane scrollableScape = new JScrollPane(scape);
		scrollableScape.setViewportView(scape);
		scrollableScape.getVerticalScrollBar().setUnitIncrement(25);
		scrollableScape.getHorizontalScrollBar().setUnitIncrement(25);
		tabbedPane.addTab("Scape", scrollableScape);
		
		
		mapCreator = new MapCreator();
		JScrollPane scrollableMapCreator = new JScrollPane(mapCreator);
		scrollableMapCreator.setViewportView(mapCreator);
		scrollableMapCreator.getVerticalScrollBar().setUnitIncrement(25);
		scrollableMapCreator.getHorizontalScrollBar().setUnitIncrement(25);
		tabbedPane.addTab("Map Creator", scrollableMapCreator);
		
		
		
		ChangeListener changeListener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent changeEvent)
			{
				JTabbedPane sourceTabbedPane = (JTabbedPane)changeEvent.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				// System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
				(sourceTabbedPane.getComponent(index)).setFocusable(true);
				(sourceTabbedPane.getComponent(index)).requestFocusInWindow();
				
//				if(sourceTabbedPane.getTitleAt(index).equals(ARENA_BUTTON) == true)
//				{
//					Arena temp = (Arena)sourceTabbedPane.getComponent(index);
//					temp.pause_game(true);
//				}
			}
		};
		tabbedPane.addChangeListener(changeListener);
		
		
		pane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) throws Exception
	{
		StartGame frame = new StartGame("Game");
		frame.addComponentToPane(frame.getContentPane());
		
		frame.setSize(1000, 800);
		// game.setMinimumSize(new Dimension(1000, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		
		
		JTabbedPane tabs = (JTabbedPane)frame.getContentPane().getComponent(0);
		int index = tabs.getSelectedIndex();
		tabs.getComponent(index).setFocusable(true);
		tabs.getComponent(index).requestFocusInWindow();
		
		while(true)// while the programs running (infinite loop)
		{
			frame.repaint();
			Thread.sleep(SLEEP);
		}
	}
}
