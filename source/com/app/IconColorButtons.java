package com.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IconColorButtons{

	public static void main(String[] args) {
	
		MyFrame frame = new MyFrame();

	}

	static class MyFrame extends JFrame{

		private MyPanel panel = new MyPanel();
		

		public MyFrame(){

			setTitle("Icon Color Buttons");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(600,200,400,300);
			setResizable(false);
			add(panel);
			setJMenuBar(MyPanel.menuBar);
			setVisible(true);
		}
	}

	static class MyPanel extends JPanel{

		private static JMenuBar menuBar = new JMenuBar();
		private JMenu menu = new JMenu("Color");
		private ActionColor actRed = new ActionColor("Red", new ImageIcon("com/app/resources/red.png"),Color.red);
		private ActionColor actYellow = new ActionColor("Yellow", new ImageIcon("com/app/resources/yellow.png"),Color.yellow);
		private ActionColor actGreen = new ActionColor("Green", new ImageIcon("com/app/resources/green.png"),Color.green);
		private AbstractAction exit = new AbstractAction("Exit", new ImageIcon("com/app/resources/exit.png")){
				
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};

		private JToolBar toolBar = new JToolBar();

		public MyPanel(){

			menu.add(actRed);
			menu.add(actYellow);
			menu.add(actGreen);
			menuBar.add(menu);

			toolBar.add(actRed);
			toolBar.add(actYellow);
			toolBar.add(actGreen);
			toolBar.addSeparator();
			toolBar.add(exit);
			add(toolBar, BorderLayout.NORTH);

			//---------Creating Keys Snippets---------------------------------

			//---Step 1: creating a map entry--------------------
			InputMap entryMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			//---Step 2: Creating a key combination--------------
			KeyStroke redKey = KeyStroke.getKeyStroke("ctrl R");
			KeyStroke yellowKey = KeyStroke.getKeyStroke("ctrl Y");
			KeyStroke greenKey = KeyStroke.getKeyStroke("ctrl G");
			//---Step 3: Add the keys combination in the object--
			entryMap.put(redKey, "red_background");
			entryMap.put(yellowKey, "yellow_background");
			entryMap.put(greenKey, "green_background");
			//---Step 4: Add the object in the action------------
			ActionMap actionMap = getActionMap();
			actionMap.put("red_background",actRed);
			actionMap.put("yellow_background",actYellow);
			actionMap.put("green_background",actGreen);

			//----------------------------------------------------------------
		}

		private class ActionColor extends AbstractAction{

			public ActionColor(String name, Icon icon, Color color_b){

				putValue(Action.NAME, name);
				putValue(Action.SMALL_ICON, icon);
				putValue(Action.SHORT_DESCRIPTION, "Changing background color to " + name);
				putValue("background_color", color_b);

			}

			public void actionPerformed(ActionEvent e){

				Color myColor = (Color) getValue("background_color");
				setBackground(myColor);

			}

		
		}
	}
}