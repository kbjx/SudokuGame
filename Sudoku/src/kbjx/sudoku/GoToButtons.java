package kbjx.sudoku;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GoToButtons {

	private GameFrame gameFrame;
	private JPanel panel;
	private HelpView helpView;
	
	public GoToButtons(GameFrame gameFrame, JPanel panel) {
		this.gameFrame = gameFrame;
		this.panel = panel;
	}

	// goto ResumeView
	public void resumeButton() {
		Data data = new Data();
		if (data.saveExist()) {
			Action goToAction = new GoToAction("Resume game", "NewGameView", gameFrame);
			JButton game = new JButton(goToAction);
			goToButtonLook(game);
			panel.add(game);
		}
	}

	// goto MenuView
	public void menuButton() {
		Action goToAction = new GoToAction("Main menu", "MenuView", gameFrame);
		JButton menu = new JButton(goToAction);
		goToButtonLook(menu);
		panel.add(menu);
	}

	// goto HelpView
	public void helpButton() {
		helpView = new HelpView();
		JButton help = new JButton();
		help.setText("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				helpView.setVisibleFrame();
			}
		});
		goToButtonLook(help);
		panel.add(help);
	}

	// goto SelectView
	public void selectGameButton() {
		JButton select = new JButton();
		select.setText("Start new game");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectView selectGameView = new SelectView(gameFrame);
				gameFrame.add(selectGameView, "SelectView");
				gameFrame.showCard("SelectView");
			}
		});
		goToButtonLook(select);
		panel.add(select);
	}

	// goto CreateGameView
	public void createGameButton() {
		Action goToAction = new GoToAction("Create new game", "CreateGameView", gameFrame);
		JButton create = new JButton(goToAction);
		goToButtonLook(create);
		panel.add(create);
	}

	// exit game button
	public void exitButton() {
		JButton exit = new JButton();
		goToButtonLook(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(panel, "Do you really want to Exit?", "Exit",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		exit.setText("Exit Game");
		panel.add(exit);
	}

	private void goToButtonLook(JButton goToButton) {
		goToButton.setFocusPainted(false);
		goToButton.setFont(new Font("Arial", Font.PLAIN, 15));
	}
}
