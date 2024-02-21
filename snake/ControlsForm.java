package snake;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ControlsForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMoveLeft;
	private JTextField txtMoveRight;
	private JTextField txtMoveUp;
	private JTextField txtMoveDown;
	private JTextField txtPause;
	private JTextField txtA;
	private JTextField txtD;
	private JTextField txtW;
	private JTextField txtS;
	private JTextField txtEscape;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlsForm frame = new ControlsForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ControlsForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Snake.showMainMenu();
			}
		});
		btnBack.setBounds(350, 0, 80, 23);
		contentPane.add(btnBack);
		
		txtMoveLeft = new JTextField();
		txtMoveLeft.setText("move left");
		txtMoveLeft.setBounds(10, 11, 86, 20);
		contentPane.add(txtMoveLeft);
		txtMoveLeft.setColumns(10);
		
		txtMoveRight = new JTextField();
		txtMoveRight.setText("move right");
		txtMoveRight.setBounds(10, 42, 86, 20);
		contentPane.add(txtMoveRight);
		txtMoveRight.setColumns(10);
		
		txtMoveUp = new JTextField();
		txtMoveUp.setText("move up");
		txtMoveUp.setBounds(10, 73, 86, 20);
		contentPane.add(txtMoveUp);
		txtMoveUp.setColumns(10);
		
		txtMoveDown = new JTextField();
		txtMoveDown.setText("move down");
		txtMoveDown.setBounds(10, 104, 86, 20);
		contentPane.add(txtMoveDown);
		txtMoveDown.setColumns(10);
		
		txtPause = new JTextField();
		txtPause.setText("pause");
		txtPause.setBounds(10, 135, 86, 20);
		contentPane.add(txtPause);
		txtPause.setColumns(10);
		
		txtA = new JTextField();
		txtA.setText("a");
		txtA.setBounds(190, 11, 86, 20);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtD = new JTextField();
		txtD.setText("d");
		txtD.setBounds(190, 42, 86, 20);
		contentPane.add(txtD);
		txtD.setColumns(10);
		
		txtW = new JTextField();
		txtW.setText("w");
		txtW.setBounds(190, 73, 86, 20);
		contentPane.add(txtW);
		txtW.setColumns(10);
		
		txtS = new JTextField();
		txtS.setText("s");
		txtS.setBounds(190, 104, 86, 20);
		contentPane.add(txtS);
		txtS.setColumns(10);
		
		txtEscape = new JTextField();
		txtEscape.setText("escape");
		txtEscape.setBounds(190, 135, 86, 20);
		contentPane.add(txtEscape);
		txtEscape.setColumns(10);
	}

}
