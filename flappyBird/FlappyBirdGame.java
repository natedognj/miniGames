package flappyBird;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FlappyBirdGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FlappyBirdPanel flappyBirdPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlappyBirdGame frame = new FlappyBirdGame();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FlappyBirdGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,835, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel placeholder = new JPanel();
		placeholder.setBounds(10, 10, 800, 600);
		placeholder.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		flappyBirdPanel = new FlappyBirdPanel(placeholder);
		contentPane.add(flappyBirdPanel);

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
