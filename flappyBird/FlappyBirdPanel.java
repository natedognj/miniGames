package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyBirdPanel extends JPanel implements ActionListener{
	private final int BIRD_SIZE = 36;
	private final int PIPE_DISTANCE = 2000;
	private final int PIPE_WIDTH = 100;
	private final int PIPE_GAP = 150;
	private final int SCREEN_HEIGHT = 600;
	private final int SCREEN_WIDTH = 800;
	private final int BIRD_LEFT_X = 100;
	private final int BIRD_RIGHT_X = (BIRD_LEFT_X + BIRD_SIZE);
	private final int JUMP_HEIGHT = 70;
	private int[] pipesY;
	private int[] pipesLeftX; 
	private int birdY;
	private int pipeNumber = 0;
	private int score;
	
	Timer timer;
	Timer spawnTimer;
	Random random;
	boolean isRunning = false;
	boolean jump = false;
	boolean gamePaused = false;
	boolean pipeSpawn = false;
	private FlappyBird flappyBird;
	private static final long serialVersionUID = 1L;

	public FlappyBirdPanel(JPanel placeholder) {
		this.setBounds(placeholder.getBounds());
		this.setBorder(placeholder.getBorder());
		setFocusable(true);
		addKeyListener(new MyKeyAdapter());
		startGame();
}
	public void startGame() {
		birdY = 0;
		pipesLeftX = new int[500];
		pipesY = new int[500];
		pipesLeftX[0] = SCREEN_WIDTH;
		pipesY[0] = 200;
		isRunning = true;
		
		spawnTimer = new Timer(PIPE_DISTANCE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				pipeNumber++;
				pipesLeftX[pipeNumber] = SCREEN_WIDTH;
				pipesY[pipeNumber] = random.nextInt(200,400);
			}
		});
		spawnTimer.restart();
		timer = new Timer(10, this);
	    timer.restart();	   
	}
	public void movePipes() {
		for(int i = pipeNumber; i>=0; i--) {
			pipesLeftX[i] -= 3; 
		}	
	}
	public void moveBird() {
		if(jump) {
			birdY -= JUMP_HEIGHT;
			
			jump = false;
		}else
		birdY += 2;
	}
	public void checkCollision() {
		for(int i =pipeNumber; i>=0; i--) {
			int pipesRightX = pipesLeftX[i] + PIPE_WIDTH;
			
//			check the collision of left side of top pipe with bird
			if((BIRD_RIGHT_X > pipesLeftX[i] && BIRD_LEFT_X <pipesRightX && birdY < pipesY[i]) || 
//					check the bottom collision of the top pipe with bird
					(birdY < pipesY[i] && BIRD_RIGHT_X < pipesRightX && BIRD_LEFT_X >pipesLeftX[i]) || 
//					check the top collision of the bottom pipe with bird
					(BIRD_RIGHT_X > pipesLeftX[i] && BIRD_LEFT_X < pipesRightX  && (birdY + BIRD_SIZE) > (pipesY[i] + PIPE_GAP))) {
				isRunning= false;	
				timer.stop();
			}
		}
		//check collision of bird with top and bottom of screen
		if(birdY < 0 || birdY > SCREEN_HEIGHT) {
			isRunning= false;	
			timer.stop();
		}
	}
	public void drawBird(Graphics g) {	
		g.setColor(Color.RED);
		g.fillRect(BIRD_LEFT_X, birdY, BIRD_SIZE, BIRD_SIZE);
	}
	public void drawPipes(Graphics g) {
		g.setColor(Color.GREEN);
		for(int j = pipeNumber; j>=0; j--) {
			for(int i =2; i>0; i--) {
				if(i==2) {
					g.fillRect(pipesLeftX[j], 0, PIPE_WIDTH, pipesY[j]);
				}
				else {
					g.fillRect(pipesLeftX[j], pipesY[j] + PIPE_GAP, PIPE_WIDTH, SCREEN_HEIGHT - pipesY[j] - PIPE_GAP);
				}
			}
		}
		score = pipeNumber -1;
		if(score >=0 ) {
			g.setFont(new Font("Ink Free",Font.BOLD, 30));
			g.setColor(Color.red);
			g.drawString("Score: " + score, 670,35);
		}
		else {
			g.setFont(new Font("Ink Free",Font.BOLD, 30));
			g.setColor(Color.red);
			g.drawString("Score: 0", 670,35);
		}
	}
	@SuppressWarnings("static-access")
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBird(g);
		drawPipes(g);
		if(!isRunning) {
			if(score < 0) {
				score = 0;
			}
			flappyBird.endGame(score);
		}
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
	        switch (keyCode) {
	            case KeyEvent.VK_W:
	            	jump = true; 	
	                break;
	            case KeyEvent.VK_ESCAPE:
	            	if(gamePaused) {
	            		gamePaused = false;
	            		timer.start();
	            	}
	            	else {
	            		gamePaused = true;
	            	}
	            	break;
	        }	
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isRunning) {
			checkCollision();
			movePipes();
        	moveBird();
		}	
		removeAll();
		repaint();
	}
}
