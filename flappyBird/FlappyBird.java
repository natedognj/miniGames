package flappyBird;

import javax.swing.JOptionPane;

public class FlappyBird {
	private static LeaderboardForm leaderboardForm;
	private static FlappyBirdMenu flappyBirdMenu;
	private static FlappyBirdGame flappyBirdGame;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				flappyBirdMenu = new FlappyBirdMenu();
				leaderboardForm = new LeaderboardForm();
				flappyBirdGame = new FlappyBirdGame();
				flappyBirdMenu.setVisible(true);
			}
		});
	}
	public static void showLeaderboard() {
		leaderboardForm.setVisible(true);
	}
	public static void showMenu() {
		flappyBirdMenu.setVisible(true);
	}
	public static void startGame() {
		flappyBirdGame = new FlappyBirdGame();
		flappyBirdGame.setVisible(true);
	}
	public static void endGame(int score) {
		flappyBirdGame.setVisible(false);
		flappyBirdGame.dispose();
		
		String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name.");
		leaderboardForm.addPlayer(playerName, score);
	}
}
