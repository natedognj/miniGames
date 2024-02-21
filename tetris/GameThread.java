package tetris;

public class GameThread extends Thread{
	
	private GameArea gameArea;
	private GameForm gameForm;
	private int score;
	private int level =1;
	private int scorePerLevel = 30;
	
	private int pause = 1000;
	private int speedUpPerLevel = 100;
	
	public GameThread(GameArea gameArea, GameForm gameForm) {
		this.gameArea = gameArea;
		this.gameForm = gameForm;
		
		gameForm.updateLevel(level);
		gameForm.updateScore(score);
	}
	
	public void run() {
		
		while(true) {
			gameArea.spawnBlock();
			while(gameArea.moveBlockDown()) {
				try {
					
					
					Thread.sleep(pause);
					
				} catch (InterruptedException e) {
					return;
				}
//				if(gameArea.isBlockOutOfBounds() && !gameArea.moveBlockDown()) {
//					System.out.println("Game Over");
//					return;
//				}
				score += gameArea.clearLines() * 10;
				gameForm.updateScore(score);
				
				int lvl = score / scorePerLevel + 1;
				if(lvl > level) {
					level = lvl;
					gameForm.updateLevel(level);
					pause -= speedUpPerLevel;
				}
		}
			try{
				gameArea.moveBlockToBackground();
			}catch(ArrayIndexOutOfBoundsException end) {
				Tetris.gameOver(score);
				return;
			}
			
		}
		
}
	
	

}
