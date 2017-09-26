package kbjx.sudoku;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class SelectGameAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	private int numberOfGames;
	private JButton[] selectGame;
	private GameFrame gameFrame;

	public SelectGameAction(int numberOfGames, JButton[] selectGame, GameFrame gameFrame) {
		this.numberOfGames = numberOfGames;
		this.selectGame = selectGame;
		this.gameFrame = gameFrame;
	}

	public void actionPerformed(ActionEvent e) {
		int selectedGame = 0;
		Object source = e.getSource();
		for (int j = 1; j <= numberOfGames; j++) {
			if (source == selectGame[j]) {
				selectedGame = j;
			}
		}
		// show selected game
		NewGameView newGameView = new NewGameView(gameFrame, selectedGame);
		gameFrame.add(newGameView, "NewGameView");
		gameFrame.showCard("NewGameView");
	}
}
