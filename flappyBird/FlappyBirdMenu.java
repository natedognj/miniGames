package flappyBird;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FlappyBirdMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlappyBirdMenu frame = new FlappyBirdMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FlappyBirdMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameHub.GameHub.main(null);
			}
		});
		btnMainMenu.setBounds(120, 11, 113, 23);
		contentPane.add(btnMainMenu);
		
		JButton btnLeaderboard = new JButton("Leaderboard");
		btnLeaderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FlappyBird.showLeaderboard();
			}
		});
		btnLeaderboard.setBounds(120, 45, 113, 23);
		contentPane.add(btnLeaderboard);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FlappyBird.startGame();
			}
		});
		btnStart.setBounds(120, 79, 113, 23);
		contentPane.add(btnStart);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(120, 143, 113, 23);
		contentPane.add(btnQuit);
	}
	
}
