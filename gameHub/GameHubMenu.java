package gameHub;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameHubMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameHubMenu frame = new GameHubMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GameHubMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] games = {"None", "Snake", "Tetris"};
		@SuppressWarnings("rawtypes")
		JComboBox gameList = new JComboBox(games);
		gameList.setSelectedIndex(0);
		gameList.addActionListener(this);
		gameList.setBounds(156, 99,100, 22);
		contentPane.add(gameList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = (JComboBox) e.getSource();
		String gameName = (String)comboBox.getSelectedItem();
		
		switch(gameName) {
			case "Snake":
				setVisible(false);
				GameHub.showSnakeMenu();
				break;
			case "Tetris":
				setVisible(false);
				GameHub.showTetrisMenu();
		}
	}
}
