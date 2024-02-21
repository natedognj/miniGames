package gameHub;

public class GameHub {
	private static GameHubMenu gameHubMenu;
	
	
	public static void showSnakeMenu() {
		snake.Snake.main(null);

	}
	
	public static void showTetrisMenu() {
		tetris.Tetris.main(null);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {				
				gameHubMenu = new GameHubMenu();
				gameHubMenu.setVisible(true);
				
			}
		});

	}
}
