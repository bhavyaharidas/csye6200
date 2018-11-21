package edu.neu.csye6200.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	int ctr = 0;
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		ctr++;
		
		Dimension size = getSize();
		
		if(ctr % 2 == 0) //even
			g2d.setColor(Color.blue);
		else //odd
			g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, size.width, size.height); // Fill the entire panel with blue color
		
		g2d.setColor(Color.red);
		g2d.drawLine(0, 0, size.width, size.height);  //x1,y1,x2,y2
		System.out.println("->");
	}

}
