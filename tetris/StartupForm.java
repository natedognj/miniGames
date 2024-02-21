package tetris;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartupForm extends JFrame {
	private static StartupForm frame;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StartupForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartupForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start Game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				setVisible(false);
				
				Tetris.start();
			}
		});
		btnStart.setBounds(113, 77, 204, 23);
		contentPane.add(btnStart);
		
		JButton btnGameMenu = new JButton("Game Menu");
		btnGameMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameHub.GameHub.main(null);
			}
		});
		btnGameMenu.setBounds(10, 11, 115, 23);
		contentPane.add(btnGameMenu);
		
		JButton btnLeaderboard = new JButton("Leaderboard");
		btnLeaderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Tetris.showLeaderboard();
			}
		});
		btnLeaderboard.setBounds(113, 111, 204, 23);
		contentPane.add(btnLeaderboard);
		
		JButton btnQuit = new JButton("Quit Game");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(113, 191, 204, 23);
		contentPane.add(btnQuit);
	}
}
