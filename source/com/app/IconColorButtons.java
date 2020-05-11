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
			setVisible(true);

		}

	}

	static class MyPanel extends JPanel{

		private ActionColor actRed = new ActionColor("Red", new ImageIcon("com/app/resources/red.png"),Color.red);
		private ActionColor actYellow = new ActionColor("Yellow", new ImageIcon("com/app/resources/yellow.png"),Color.yellow);
		private ActionColor actGreen = new ActionColor("Green", new ImageIcon("com/app/resources/green.png"),Color.green);

		public MyPanel(){

			add(new JButton(actRed));
			add(new JButton(actYellow));
			add(new JButton(actGreen));
		}
	}

	static class ActionColor extends AbstractAction{

		public ActionColor(String name, Icon icon, Color color_b){

			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Changing background color to " + name);
			putValue("background_color", color_b);

		}

		public void actionPerformed(ActionEvent e){

		}


	}

}