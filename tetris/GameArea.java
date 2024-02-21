package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import tetrisblocks.IShape;
import tetrisblocks.JShape;
import tetrisblocks.LShape;
import tetrisblocks.OShape;
import tetrisblocks.SShape;
import tetrisblocks.TShape;
import tetrisblocks.ZShape;

public class GameArea extends JPanel{
	
	private int gridRows;
	private int gridColumns;
	private int gridCellSize;
	private Color[][] background;
	private TetrisBlock[] blocks;
	
	private  TetrisBlock block;
	
	public GameArea(JPanel placeholder, int columns) {
		this.setBounds(placeholder.getBounds());
		this.setBackground(placeholder.getBackground());
		this.setBorder(placeholder.getBorder());
		
		gridColumns = columns;
		gridCellSize = this.getBounds().width / gridColumns;
		gridRows = this.getBounds().height / gridCellSize;
		
		
		
		blocks = new TetrisBlock[] {new IShape(),new JShape(), new LShape(), new OShape(), new SShape(), new TShape(), new ZShape()};
		
	}
	
	public void initBackgroundArray() {
		background = new Color[gridRows][gridColumns];
	}
	
	public void spawnBlock() {
		Random randy = new Random();
		
		block = blocks[randy.nextInt(blocks.length)];
		
		block.spawn(gridColumns);
		
	}
	
	public boolean isBlockOutOfBounds() {
		if(block.getY() <0) {
			block = null;
			return true;
		}
		return false;
	}
	public boolean moveBlockDown() {
		
		if(checkBottom() == false) {
						
			return false;
		}
		else {
		block.moveDown();
		repaint();
		return true;
		}
	}
	
	public void moveBlockRight() {
		if(block == null) return;
		
		if(checkRight() == false) {
			return;
		}
		block.moveRight();
		repaint();
	}

	public void moveBlockLeft() {
		if(block == null) return;
		
		if(checkLeft() == false) {
			return;
		}
		block.moveLeft();
		repaint();
	}
	
	public void dropBlock() {
		if(block == null) return;
		
		while(checkBottom()) {
			block.moveDown();
		}
	}
	
	public void rotateBlock() {
		if(block == null) return;
		
		block.rotate();
		
		if(block.getLeftEdge() < 0) block.setX(0);
		if(block.getRightEdge() >= gridColumns) block.setX(gridColumns - block.getWidth());
		if(block.getBottomEdge() >= gridRows) block.setY(gridRows - block.getHeight());
		
		
		if(!checkLeft()) block.setX(block.getX() + 1);
		if(!checkRight()) block.setX(block.getX() - 1);
		if(!checkBottom()) block.setY(block.getY() - 1);
		
		repaint();
	}	
	
	private boolean checkBottom() {
		if(block.getBottomEdge() == gridRows) {
			return false;
		}
		int[][]shape = block.getShape();
		int w = block.getWidth();
		int h = block.getHeight();
		
		for(int col =0; col<w; col++) {
			for(int row = h-1; row>=0; row--) {
				if(shape[row][col] !=0) {
					int x = col + block.getX();
					int y = row + block.getY() + 1;
					if(y<0) break;
					if(background[y][x] != null) return false;
					break;
				}
			}
		}
		
		return true;
	}
	
	private boolean checkLeft() {
		if(block.getLeftEdge() == 0) {
			return false;
		}
		int[][]shape = block.getShape();
		int w = block.getWidth();
		int h = block.getHeight();
		
		for(int row =0; row<h; row++) {
			for(int col = 0; col<w; col++) {
				if(shape[row][col] !=0) {
					int x = col + block.getX() - 1;
					int y = row + block.getY();
					if(y<0) break;
					if(background[y][x] != null) return false;
					break;
				}
			}
		}
		return true;
	}
	
	private boolean checkRight() {
		if(block.getRightEdge() == gridColumns) {
			return false;
		}
		int[][]shape = block.getShape();
		int w = block.getWidth();
		int h = block.getHeight();
		
		for(int row =0; row<h; row++) {
			for(int col = w-1; col>=0; col--) {
				if(shape[row][col] !=0) {
					int x = col + block.getX() + 1;
					int y = row + block.getY();
					if(y<0) break;
					if(background[y][x] != null) return false;
					break;
				}
			}
		}
		return true;
	}
	
	public int clearLines() {
		
		boolean lineFilled;
		int linesCleared = 0;
		
		for(int r = gridRows-1; r >= 0; r--) {
			lineFilled = true;
			for(int c = 0; c < gridColumns; c++) {
				if(background[r][c] == null) {
					lineFilled = false;
					break;
				}
			}
			if(lineFilled) {
				linesCleared++;
				clearLine(r);
				shiftDown(r);
				clearLine(0);
				
				r++;
				repaint();
			}
		}
		if(linesCleared > 0) {
			Tetris.playClear();
		}
		
		return linesCleared;
	}
	
	private void clearLine(int r) {
		for(int i = 0; i< gridColumns; i++) {
			background[r][i] = null;
		}
	}
	private void shiftDown(int r){
		for(int row = r; row>0; row--) {
			for(int col = 0; col < gridColumns; col++) {
				background[row][col] = background[row-1][col];
			}
		}
	}
	
	
	public void moveBlockToBackground() {
		int[][]shape = block.getShape();
		int h = block.getHeight();
		int w = block.getWidth();
		
		int xPos = block.getX();
		int yPos = block.getY();
		
		Color color = block.getColor();
		
		for(int r =0; r < h; r++) {
			for(int c = 0; c<w; c++){
				if(shape[r][c] == 1) {
					background[r + yPos][c + xPos] = color;
				}
			}
		}
	}
	
	
	private void drawBlock(Graphics g) {
		
		int height = block.getHeight();
		int width = block.getWidth();
		Color color = block.getColor();
		int[][] shape = block.getShape();
		
		for(int row =0; row<height; row++) {
			for(int col =0; col< width; col++) {
				if(shape[row][col] == 1) {
					
					int x = (block.getX() + col) * gridCellSize;;
					int y = (block.getY() + row) * gridCellSize;
					
					drawGridSquare(g, color, x, y);
				}
			}
		}
	}
	
	private void drawBackground(Graphics g) {
		Color color;
		for(int r = 0; r< gridRows; r++) {
			for(int c =0; c<gridColumns; c++) {
				color = background[r][c];
				
				if(color != null) {
					int x = c * gridCellSize;
					int y = r * gridCellSize;
					
					drawGridSquare(g, color, x, y);
				}
			}
		}
	}
	
	private void drawGridSquare(Graphics g, Color color, int x, int y) {
		
		g.setColor(color);
		g.fillRect(x, y, gridCellSize, gridCellSize);
		g.setColor(Color.black);
		g.drawRect(x, y, gridCellSize, gridCellSize);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		drawBackground(g);
		drawBlock(g);
		
	}
}
