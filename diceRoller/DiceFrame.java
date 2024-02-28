package diceRoller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gameHub.GameHub;

public class DiceFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rollResultText;
	private JTextField resultSum;
	private Random random;
	private ArrayList<Integer> list;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceFrame frame = new DiceFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void rollDice(int diceNum, int d) {
		random = new Random();
		list = new ArrayList<>();
		int sum = 0;
		
		for(int i = diceNum; i>0; i--) {
			int temp = random.nextInt(d)+1;
			list.add(temp);
			sum += temp;
		}
		rollResultText.setText(list.toString());
		resultSum.setText(Integer.toString(sum));
	}

	public DiceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1D4 = new JButton("1D4");
		btn1D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(1,4);
			}
		});
		btn1D4.setBounds(10, 11, 89, 23);
		contentPane.add(btn1D4);
		
		JButton btn1D6 = new JButton("1D6");
		btn1D6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(1,6);
			}
		});
		btn1D6.setBounds(10, 45, 89, 23);
		contentPane.add(btn1D6);
		
		JButton btn1D8 = new JButton("1D8");
		btn1D8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(1,8);
			}
		});
		btn1D8.setBounds(10, 79, 89, 23);
		contentPane.add(btn1D8);
		
		JButton btn1D10 = new JButton("1D10");
		btn1D10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(1,10);
			}
		});
		btn1D10.setBounds(10, 113, 89, 23);
		contentPane.add(btn1D10);
		
		JButton btn1D12 = new JButton("1D12");
		btn1D12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(1,12);
			}
		});
		btn1D12.setBounds(10, 147, 89, 23);
		contentPane.add(btn1D12);
		
		JButton btn1D20 = new JButton("1D20");
		btn1D20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(1,20);
			}
		});
		btn1D20.setBounds(10, 181, 89, 23);
		contentPane.add(btn1D20);
		
		JButton btn2D4 = new JButton("2D4");
		btn2D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(2,4);
			}
		});
		btn2D4.setBounds(109, 11, 89, 23);
		contentPane.add(btn2D4);
		
		JButton btn3D4 = new JButton("3D4");
		btn3D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(3,4);
			}
		});
		btn3D4.setBounds(208, 11, 89, 23);
		contentPane.add(btn3D4);
		
		JButton btn4D4 = new JButton("4D4");
		btn4D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(4,4);
			}
		});
		btn4D4.setBounds(307, 11, 89, 23);
		contentPane.add(btn4D4);
		
		JButton btn2D6 = new JButton("2D6");
		btn2D6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(2,6);
			}
		});
		btn2D6.setBounds(109, 45, 89, 23);
		contentPane.add(btn2D6);
		
		JButton btn3D6 = new JButton("3D6");
		btn3D6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(3,6);
			}
		});
		btn3D6.setBounds(208, 45, 89, 23);
		contentPane.add(btn3D6);
		
		JButton btn4D6 = new JButton("4D6");
		btn4D6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(4,6);
			}
		});
		btn4D6.setBounds(307, 45, 89, 23);
		contentPane.add(btn4D6);
		
		JButton btn2D8 = new JButton("2D8");
		btn2D8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(2,8);
			}
		});
		btn2D8.setBounds(109, 79, 89, 23);
		contentPane.add(btn2D8);
		
		JButton btn3D8 = new JButton("3D8");
		btn3D8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(3,8);
			}
		});
		btn3D8.setBounds(208, 79, 89, 23);
		contentPane.add(btn3D8);
		
		JButton btn4D8 = new JButton("4D8");
		btn4D8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(4,8);
			}
		});
		btn4D8.setBounds(307, 79, 89, 23);
		contentPane.add(btn4D8);
		
		JButton btn2D10 = new JButton("2D10");
		btn2D10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(2,10);
			}
		});
		btn2D10.setBounds(109, 113, 89, 23);
		contentPane.add(btn2D10);
		
		JButton btn3D10 = new JButton("3D10");
		btn3D10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(3,10);
			}
		});
		btn3D10.setBounds(208, 113, 89, 23);
		contentPane.add(btn3D10);
		
		JButton btn4D10 = new JButton("4D10");
		btn4D10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(4,10);
			}
		});
		btn4D10.setBounds(307, 113, 89, 23);
		contentPane.add(btn4D10);
		
		JButton btn2D12 = new JButton("2D12");
		btn2D12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(2,12);
			}
		});
		btn2D12.setBounds(109, 147, 89, 23);
		contentPane.add(btn2D12);
		
		JButton btn3D12 = new JButton("3D12");
		btn3D12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(3,12);
			}
		});
		btn3D12.setBounds(208, 147, 89, 23);
		contentPane.add(btn3D12);
		
		JButton btn4D12 = new JButton("4D12");
		btn4D12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(4,12);
			}
		});
		btn4D12.setBounds(307, 147, 89, 23);
		contentPane.add(btn4D12);
		
		JButton btn2D20 = new JButton("2D20");
		btn2D20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(2,20);
			}
		});
		btn2D20.setBounds(109, 181, 89, 23);
		contentPane.add(btn2D20);
		
		JButton btn3D20 = new JButton("3D20");
		btn3D20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(3,20);
			}
		});
		btn3D20.setBounds(208, 181, 89, 23);
		contentPane.add(btn3D20);
		
		JButton btn4D20 = new JButton("4D20");
		btn4D20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice(4,20);
			}
		});
		btn4D20.setBounds(307, 181, 89, 23);
		contentPane.add(btn4D20);
		
		rollResultText = new JTextField();
		rollResultText.setBounds(10, 230, 150, 20);
		contentPane.add(rollResultText);
		rollResultText.setColumns(10);
		
		resultSum = new JTextField();
		resultSum.setBounds(310, 230, 86, 20);
		contentPane.add(resultSum);
		resultSum.setColumns(10);
		
		JLabel lblDiceRolls = new JLabel("Dice Rolls");
		lblDiceRolls.setBounds(18, 215, 67, 14);
		contentPane.add(lblDiceRolls);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(317, 215, 46, 14);
		contentPane.add(lblResult);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameHub.GameHub.main(null);
			}
		});
		btnMenu.setBounds(407, 11, 67, 23);
		contentPane.add(btnMenu);
	}
}

