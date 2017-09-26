package kbjx.sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Buttons {
	private int pole[][];
	private JButton[][] cell = new JButton[9][9];
	private int bX = 10;
	private int bY = 10;
	private JPanel buttonPanel;

	private Data data = new Data();

	public Buttons(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public Buttons(int pole[][], JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
		this.pole = pole;
	}

	// buttons look
	private void ButtonLook(JButton goToButton) {
		goToButton.setFocusPainted(false);
		goToButton.setFont(new Font("Arial", Font.PLAIN, 15));
	}

	// complete button
	public void winGameButton(JPanel panel) {
		Solution solution = new Solution(pole);
		JButton win = new JButton();
		win.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (solution.checkFull()) {

					if (solution.checkColum() && solution.checkRow() && solution.checkSquare()) {
						winGameColor();
						JOptionPane.showMessageDialog(buttonPanel, "Congratulations! You solved this Sudoku!");
					} else {
						JOptionPane.showMessageDialog(buttonPanel, "I am sorry! Wrong solution!");
					}
				} else {
					JOptionPane.showMessageDialog(buttonPanel, "Oops! You are missing some fields!");
				}
			}
		});
		win.setText("Complete");
		win.setPreferredSize(new Dimension(460, 40));
		ButtonLook(win);
		panel.add(win);
	}

	// save button
	public void saveButton() {
		JButton save = new JButton();

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					data.save(pole);
					JOptionPane.showMessageDialog(buttonPanel, "Game saved!");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		save.setText("Save game");
		ButtonLook(save);
		buttonPanel.add(save);
	}

	// create button
	public void createButton(JPanel panel) {
		JButton create = new JButton();

		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					data.create(pole);
					JOptionPane.showMessageDialog(buttonPanel,
							"New game n." + data.countGames() + " was succesfully created");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		create.setText("Create new Sudoku");
		create.setPreferredSize(new Dimension(460, 40));
		ButtonLook(create);
		panel.add(create);
	}

	// make cells green
	public void winGameColor() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (pole[i][j] > 0) {
					cell[i][j].setBackground(Color.GREEN);
				}
			}
		}
	}

	// count position of cells
	private void cellPosition(int a, int b) {
		if (bX > 350) {
			bX = 10;
			if (a == 2 || a == 5)
				bY += 50;
			else
				bY += 48;
		} else {
			if (b == 2 || b == 5)
				bX += 50;
			else
				bX += 48;
		}
	}

	// set look of cells
	private void setCellLook(JButton cell) {
		cell.setFocusPainted(false);
		cell.setBorder(new LineBorder(Color.BLACK, 2));
		cell.setFont(new Font("Arial", Font.PLAIN, 40));
		cell.setBackground(Color.WHITE);
		cell.setBounds(bX, bY, 50, 50);
		cell.setForeground(Color.BLACK);
	}

	// create sudoku cells
	public void createSudokuButtons(JPanel gamePanel) {
		// change text color of disabled buttons
		UIManager.put("Button.disabledText", Color.red);

		Action cellAction = new CellAction(pole, cell);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				// create buttons with cellAction
				cell[i][j] = new JButton(cellAction);
				setCellLook(cell[i][j]);

				// set text of cell buttons
				if (pole[i][j] >= 0) {
					if (pole[i][j] != 0) {
						cell[i][j].setText("" + pole[i][j]);
					}
					cell[i][j].setEnabled(true);

				} else {
					cell[i][j].setText("" + Math.abs(pole[i][j]));
					cell[i][j].setEnabled(false);
				}

				// add buttons to panel
				gamePanel.add(cell[i][j]);
				cellPosition(i, j);

			}
		}
	}

}