package kbjx.sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MenuView extends JPanel {

	private static final long serialVersionUID = 1L;

	private final String NAME = "MenuView";

	// constructor for main menu
	public MenuView(GameFrame gameFrame) {

		JPanel logo = new JPanel();
		JPanel menu = new JPanel();

		// set logo size and add image
		logo.setBackground(Color.WHITE);
		logo.setPreferredSize(new Dimension(540, 250));
		
		BufferedImage logoImage = null;
		try {
			logoImage = ImageIO.read(new File("logos.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(logoImage));
		logo.add(picLabel);

		// set menu size and add buttons
		menu.setPreferredSize(new Dimension(400, 250));
		menu.setLayout(new GridLayout(0, 1));

		GoToButtons goTo = new GoToButtons(gameFrame, menu);
		goTo.resumeButton();
		goTo.selectGameButton();
		goTo.createGameButton();
		goTo.helpButton();
		goTo.exitButton();

		// set MenuView look and add panels
		this.setName(NAME);
		this.setBorder(BorderFactory.createTitledBorder("Main menu"));
		this.setBackground(Color.WHITE);

		this.add(logo);
		this.add(menu);
	}

	public String getNAME() {
		return NAME;
	}
}