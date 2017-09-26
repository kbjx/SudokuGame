package kbjx.sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HelpView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	// constructor help

	public HelpView() {
		helpFrame();
	}

	private void helpFrame() {

		frame = new JFrame("Help");

		JPanel panel = new JPanel();
		JLabel helpText = new JLabel();
		JLabel helpText2 = new JLabel();
		BufferedImage helpImage = null;

		try {
			helpImage = ImageIO.read(new File("help.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(helpImage));

		panel.setPreferredSize(new Dimension(500, 500));
		panel.setBackground(Color.WHITE);

		helpText.setBackground(Color.WHITE);
		helpText.setFont(new Font("Arial", Font.PLAIN, 10));
		helpText.setText("<html>Solving a sudoku puzzle can be rather tricky,"
				+ "but the rules of the game are quite simple.<br><br>"
				+ "A sudoku puzzle is a grid of nine by nine squares or cells,"
				+ "that has been subdivided into nine subgrids<br>"
				+ "or \"regions\" of three by three cells. See the following diagram:<br>" + "</html>");
		helpText2.setBackground(Color.WHITE);
		helpText2.setFont(new Font("Arial", Font.PLAIN, 10));
		helpText2.setText(
				"<html>The objective of sudoku is to enter a digit from 1 through 9 in each cell, in such a way that:<br><br>"
						+ "Each horizontal row (shown in pink) contains each digit exactly once<br>"
						+ "Each vertical column (shown in yellow) contains each digit exactly once<br>"
						+ "Each subgrid or region (shown in green) contains each digit exactly once<br><br>"
						+ "<center>by kbjx</center></html>");

		panel.add(helpText);
		panel.add(picLabel);
		panel.add(helpText2);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.pack();
	}

	public void setVisibleFrame() {
		frame.setVisible(true);
	}
}
