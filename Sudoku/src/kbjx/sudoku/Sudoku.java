package kbjx.sudoku;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Sudoku {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			createAndShowGui();
		});
	}

	private static void createAndShowGui() {
		GameFrame mainPanel = new GameFrame();
		JFrame frame = new JFrame("Sudoku");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
