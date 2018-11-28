package edu.neu.csye6200.ww;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.util.StatusBar;
import gov.nasa.worldwindx.examples.LayerPanel;

public class WorldWindApp {

	private JFrame frame; // Application frame
	private WorldWindowGLCanvas wwd = null;
	private StatusBar statusBar; // A location/network status bar
	private boolean hasStatusBar = true; // Set true to enable status bar
	private LayerPanel layerPanel; // Layer section panel - An example pane frm example section
	private boolean hasLayerPanel = true;

	public WorldWindApp() {
		frame = new JFrame(); // It's a swing App!!
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button closes app
		frame.setResizable(true); // We can resize
		frame.setLayout(new BorderLayout());

		wwd = new WorldWindowGLCanvas(); // Our global canvas
		wwd.setPreferredSize(new Dimension(1000, 800));
		wwd.setModel(new BasicModel()); // Selection model

		frame.getContentPane().add(wwd, BorderLayout.CENTER); // Add a globe
		if (hasStatusBar) {
			statusBar = new StatusBar(); // Create WW status bar
			frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
			statusBar.setEventSource(wwd); // Hood the canvas as the data source
		}
		//Create a layer selection panel and place on the west side
		if (hasLayerPanel) {
			layerPanel = new LayerPanel(wwd); //Let the selection panel affect the globe
			frame.getContentPane().add(layerPanel, BorderLayout.WEST);
		}

		frame.pack(); // Recalculate the window size based on the content

	}

	public JFrame getFrame() {
		return frame;
	}

	public static void main(String[] args) {
		WorldWindApp wwApp = new WorldWindApp();

		// Anonymous inner class - running later on GUI thread
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				wwApp.getFrame().setVisible(true); // Let the UI thread start it
			}
		});
	}

}
