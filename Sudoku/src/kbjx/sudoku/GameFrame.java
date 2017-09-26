package kbjx.sudoku;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

class GameFrame extends JPanel {

	private static final long serialVersionUID = 1L;

	// game size
	private int PREF_W = 550;
	private int PREF_H = 600;

	private CardLayout cardLayout = new CardLayout();
	// views
	private MenuView menuView;
	private CreateGameView createGameView;
	private SelectView selectView;
	private NewGameView newGameView;

	// add views
	public GameFrame() {
		menuView = new MenuView(this);
		createGameView = new CreateGameView(this);
		selectView = new SelectView(this);
		newGameView = new NewGameView(this);
		this.setLayout(cardLayout);
		this.setBackground(Color.WHITE);
		this.add(menuView, menuView.getNAME());
		this.add(createGameView, createGameView.getNAME());
		this.add(selectView, selectView.getNAME());
		this.add(newGameView, newGameView.getNAME());
	}

	// set size of window
	public Dimension getPreferredSize() {
		if (isPreferredSizeSet()) {
			return super.getPreferredSize();
		} else {
			return new Dimension(PREF_W, PREF_H);
		}
	}

	// show view
	public void showCard(String key) {
		cardLayout.show(this, key);
	}
}