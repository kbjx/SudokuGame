package kbjx.sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class NewGameView extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String NAME = "NewGameView";
	private Data data = new Data();
	private JPanel sudokuBoard = new JPanel();
	private JPanel buttonPanel = new JPanel();

	// new game constructor
	public NewGameView(GameFrame gameFrame, int game) {

		try {
			data.newGame(game);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		setGameView(data.getPole(), gameFrame);
		this.setBorder(BorderFactory.createTitledBorder("Sudoku n." + game));
	}

	// constructor for resume/load current game
	public NewGameView(GameFrame gameFrame) {

		int[][] loadPole = new int[9][9];

		try {
			loadPole = data.load();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		setGameView(loadPole, gameFrame);
		this.setBorder(BorderFactory.createTitledBorder("Resumed game"));
	}

	// set look of newGameView
	private void setGameView(int[][] sudoku, GameFrame gameFrame) {
		Buttons gameButtons = new Buttons(sudoku, buttonPanel);
		GoToButtons goTo = new GoToButtons(gameFrame, buttonPanel);

		sudokuBoard.setLayout(null);
		sudokuBoard.setPreferredSize(new Dimension(460, 460));
		
		buttonPanel.setPreferredSize(new Dimension(460, 50));
		buttonPanel.setLayout(new GridLayout(0, 4));

		gameButtons.createSudokuButtons(sudokuBoard);

		goTo.menuButton();
		gameButtons.saveButton();
		goTo.helpButton();
		goTo.exitButton();

		this.add(sudokuBoard);
		gameButtons.winGameButton(this);
		this.add(buttonPanel);
		this.setName(NAME);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
	}

	public String getNAME() {
		return NAME;
	}

}