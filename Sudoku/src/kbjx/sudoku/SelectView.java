package kbjx.sudoku;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectView extends JPanel {

	private static final long serialVersionUID = 1L;

	private final String NAME = "SelectView";

	private Data data;
	private JPanel selectBoard;
	private JPanel buttonPanel;

	// select your game view
	public SelectView(GameFrame gameFrame) {

		data = new Data();
		selectBoard = new JPanel();
		buttonPanel = new JPanel();

		selectBoard.setPreferredSize(new Dimension(500, 460));
		selectBoard.setLayout(new FlowLayout());

		buttonPanel.setPreferredSize(new Dimension(460, 50));
		buttonPanel.setLayout(new GridLayout(0, 3));

		GoToButtons goTo = new GoToButtons(gameFrame, buttonPanel);
		goTo.menuButton();
		goTo.helpButton();
		goTo.exitButton();

		// count number of games
		try {
			int numberOfgames = data.countGames();
			JLabel selectlabel = new JLabel("You can choose from " + numberOfgames + " games!");
			selectlabel.setFont(new Font("Arial", Font.PLAIN, 20));
			this.add(selectlabel);
			selectYourGame(gameFrame, numberOfgames);

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(selectBoard);
		this.add(buttonPanel);
		setName(NAME);
		setBorder(BorderFactory.createTitledBorder("Choose your game"));
	}

	// create buttons for all games
	private void selectYourGame(GameFrame gameFrame, int numberOfgames) {

		JButton[] select = new JButton[numberOfgames + 1];
		Action selectGameAction = new SelectGameAction(numberOfgames, select, gameFrame);

		for (int i = 1; i <= numberOfgames; i++) {
			select[i] = new JButton(selectGameAction);
			select[i].setText("Game n. " + i);
			select[i].setPreferredSize(new Dimension(95, 30));
			select[i].setFont(new Font("Arial", Font.PLAIN, 10));
			selectBoard.add((select[i]));
		}
	}

	public String getNAME() {
		return NAME;
	}

}
