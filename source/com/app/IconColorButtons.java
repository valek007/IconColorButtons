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

		private JButton bRed = new JButton("Red");
		private JButton bYellow = new JButton("Yellow");
		private JButton bGreen = new JButton("Green");

		public MyPanel(){

			add(bRed);
			add(bYellow);
			add(bGreen);
		}
	}

}