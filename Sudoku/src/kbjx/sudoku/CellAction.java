package kbjx.sudoku;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class CellAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	private int[][] pole;
	private JButton[][] cell;

	public CellAction(int[][] pole, JButton[][] cell) {
		this.cell = cell;
		this.pole = pole;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (source == cell[i][j]) {
					if (pole[i][j] < 9) {
						++pole[i][j];
						cell[i][j].setText("" + pole[i][j]);
					} else {
						pole[i][j] = 0;
						cell[i][j].setText("");
					}
				}
			}
	}

}
