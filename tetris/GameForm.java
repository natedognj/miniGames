package tetris;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class GameForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GameArea gameArea;
	private GameThread gameThread;
	public int score = 0;
	
	public JLabel scoreLabel;
	public JLabel levelLabel;

	void setContentPane() {
	}
	
	public GameForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);
		
		JPanel gameAreaPlaceholder = new JPanel();
		gameAreaPlaceholder.setBorder(new LineBorder(new Color(0, 0, 0)));
		gameAreaPlaceholder.setBounds(120, 50, 200, 300);
		getContentPane().add(gameAreaPlaceholder);
		
		
		gameAreaPlaceholder.setVisible(false);
		
		gameArea = new GameArea(gameAreaPlaceholder, 10);
		getContentPane().add(gameArea);
		
		JButton btnMenu = new JButton("Main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gameThread.interrupt();
				setVisible(false);
				Tetris.showMenu();
			}
			});
		btnMenu.setFocusable(false);
		btnMenu.setBounds(10, 20, 100, 25);
		getContentPane().add(btnMenu);
		 
		
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scoreLabel.setBounds(335, 27, 115, 14);
		getContentPane().add(scoreLabel);
		
		levelLabel = new JLabel("Level: 1");
		levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		levelLabel.setBounds(335, 71, 115, 14);
		getContentPane().add(levelLabel);

		initControls();
		
		

		
	}
	private void initControls() {
		InputMap im = this.getRootPane().getInputMap();
		ActionMap am = this.getRootPane().getActionMap();
		
		im.put(KeyStroke.getKeyStroke("D"), "right");
		im.put(KeyStroke.getKeyStroke("A"), "left");
		im.put(KeyStroke.getKeyStroke("W"), "up");
		im.put(KeyStroke.getKeyStroke("S"), "down");
		
		am.put("right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameArea.moveBlockRight();
			}
		});
		am.put("left", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameArea.moveBlockLeft();
			}
		});
		am.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameArea.rotateBlock();
			}
		});
		am.put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameArea.dropBlock();
			}
		});
		
		
	}
	
	public void startGame() {
		gameArea.initBackgroundArray();
		gameThread = new GameThread(gameArea, this);
		gameThread.start();
	}
	
	public void updateScore(int score) {
		
		scoreLabel.setText("Score: " + score);
	}
	
	public void updateLevel(int level) {
		levelLabel.setText("Level " + level);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameForm frame = new GameForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
