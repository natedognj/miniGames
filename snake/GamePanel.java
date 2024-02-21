package snake;

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

public class GamePanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final int screenWidth = 600;
	private final int screenHeight = 600;
	private final int unitSize = 30;
	private final int gameUnits = (screenWidth * screenHeight)/unitSize;
	private final int delay = 150;
	
	private int foodX;
	private int foodY;
	private int score;
	private boolean isRunning = false;
	Timer timer;
	Random random = new Random();
	private int bodyParts;
	int x[];
	int y[];
	private char direction;
	boolean gamePaused = false;
	
	public GamePanel() {
		this.setBackground(Color.BLACK);
		this.setBounds(0, 0, screenWidth, screenHeight);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		
		bodyParts = 4;
		score = 0;
		x = new int[gameUnits];
		y = new int[gameUnits];
		direction = 'R';
		
		spawnFood();
		isRunning = true;
		timer = new Timer(delay, this);
		timer.start();
	
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);	
	}
	public void draw(Graphics g) {
		if(isRunning) {
			for(int i =0; i<screenHeight/unitSize;i++) {
				g.drawLine(i*unitSize, 0, i*unitSize, screenHeight);
				g.drawLine(0, i*unitSize,screenWidth, i*unitSize);
			}		
			for(int i =0; i <bodyParts; i++) {
				if(i ==0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], unitSize, unitSize);
				}
				else {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i], unitSize, unitSize);
				}
			}
			if(gamePaused) {
				pauseMenu(g);
				timer.stop();
			}
			g.setColor(Color.red);
			g.fillOval(foodX, foodY, unitSize, unitSize);
			
			g.setFont(new Font("Ink Free",Font.BOLD, 20));
			g.setColor(Color.red);
			g.drawString("Score: " + score, 500,20);
		}
		else {
			timer.stop();
			gameOver(g);
		}
	}
	public void spawnFood() {
		boolean spawn = false;		
		while(!spawn) {
			foodX = random.nextInt((int)(screenWidth/unitSize))*unitSize;
			foodY = random.nextInt((int)(screenHeight/unitSize))*unitSize;
		
		for(int i = bodyParts;i>0;i--){
			if(foodX == x[i] && foodY == y[i] && i == bodyParts) {
				break;
			}
			else if(i == bodyParts) {
				spawn = true;
			}
		}
		}
		
		
	}
	public void checkEat() {
		//checks for head collision with food
		if(x[0] == (foodX) && y[0] == (foodY)) {
			bodyParts++;
			score++;
			spawnFood();	
		}
	}	
	public void checkCollision() {	
		//checks for head collides with body
		for(int i = bodyParts;i>0;i--) {
			if (x[i] == x[0] && y[i] == y[0]) {
				isRunning = false;
				break;
			}
		}	
		//checks for head collides with border
		if(x[0] < 0 || x[0] > screenWidth || y[0] < 0 || y[0] > screenHeight) {
			isRunning = false;
		}
		
	}
	
	public void move() {
		for(int i = bodyParts;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
			switch(direction) {
			case 'U':
				y[0] -= unitSize;
				break;
			case 'D':
				y[0] += unitSize;
				break;
			case 'L':
				x[0] -= unitSize;
				break;
			case 'R':
				x[0] += unitSize;
			}
		
	}
	
	public void pauseMenu(Graphics g) {	
		g.setFont(new Font("Ink Free",Font.BOLD, 60));
		g.setColor(Color.yellow);
		g.drawString("Pause", screenWidth/2-80, screenHeight/2);
	}
	
	public void gameOver(Graphics g) {
		g.setFont(new Font("Ink Free",Font.BOLD, 80));
		g.setColor(Color.red);
		g.drawString("Game Over", 100, screenHeight/3);
		g.setColor(Color.green);
		g.drawString("Score: " + score, 150, screenHeight/2+85);
		
		Snake.gameOver(score);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(isRunning) {
			move();
			checkEat();
			checkCollision();
		}
		repaint();
	}
	
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
	        switch (keyCode) {
	            case KeyEvent.VK_W:
	            	if(direction != 'D') {
	            		direction = 'U';
	            	}
	                break;
	            case KeyEvent.VK_S:
	            	if(direction != 'U') {
	            		direction = 'D';
	            	}
	                break;
	            case KeyEvent.VK_A:
	            	if(direction != 'R') {
	            		direction = 'L';
	            	}
	                break;
	            case KeyEvent.VK_D:
	            	if(direction != 'L') {
	            		direction = 'R';
	            	}
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
}
