package snake;

import javax.swing.JOptionPane;

public class Snake {
	private static GameForm gameForm;
	private static GamePanel gamePanel;
	private static MainMenu mainMenu;
	private static ControlsForm controlsForm;
	private static LeaderboardForm leaderboardForm;
	
	
	public static void start() {
		gameForm = new GameForm();
		leaderboardForm.setVisible(false);
		gameForm.setVisible(true);
		gamePanel.startGame();
		
	}
	public static void showControls() {
		controlsForm.setVisible(true);
	}
	public static void showMainMenu() {
		mainMenu.setVisible(true);
	}
	public static void showLeaderboard() {
		leaderboardForm.setVisible(true);
	}
	public static void gameOver(int score) {
		String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name.");
		gameForm.setVisible(false);
		leaderboardForm.addPlayer(playerName, score);
		
		
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				mainMenu = new MainMenu();
				
				gamePanel = new GamePanel();
				controlsForm = new ControlsForm();
				leaderboardForm = new LeaderboardForm();
				
				mainMenu.setVisible(true);
			}
		});
		
	}

}
