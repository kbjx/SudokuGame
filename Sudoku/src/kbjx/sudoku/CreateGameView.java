package kbjx.sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class CreateGameView extends JPanel {

	private static final long serialVersionUID = 1L;

	private final String NAME = "CreateGameView";
	private JPanel sudokuBoard = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	// create game view constructor
	public CreateGameView(GameFrame gameFrame) {

		int[][] sudoku = new int[9][9];

		Buttons gameButtons = new Buttons(sudoku, buttonPanel);
		GoToButtons goTo = new GoToButtons(gameFrame, buttonPanel);

		sudokuBoard.setLayout(null);
		sudokuBoard.setPreferredSize(new Dimension(460, 460));

		buttonPanel.setPreferredSize(new Dimension(460, 50));
		buttonPanel.setLayout(new GridLayout(0, 3));

		gameButtons.createSudokuButtons(sudokuBoard);

		goTo.menuButton();
		goTo.helpButton();
		goTo.exitButton();

		this.add(sudokuBoard);
		gameButtons.createButton(this);
		this.add(buttonPanel);

		this.setBackground(Color.WHITE);
		this.setName(NAME);
		this.setBorder(BorderFactory.createTitledBorder("Create your own Sudoku"));
		this.setVisible(true);
	}

	public String getNAME() {
		return NAME;
	}

}