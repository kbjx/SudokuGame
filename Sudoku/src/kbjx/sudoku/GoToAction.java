package kbjx.sudoku;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

class GoToAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String key;
	private GameFrame gameFrame;

	public GoToAction(String name, String key, GameFrame gameFrame) {
		super(name);

		this.key = key;
		this.gameFrame = gameFrame;

	}

	// change view after action performed
	public void actionPerformed(ActionEvent e) {
		gameFrame.showCard(key);
	}
}
