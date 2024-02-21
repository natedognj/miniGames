package snake;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class LeaderboardForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel tm;
	private String leaderboardFile = "snakeLeaderboard";
	private JTable leaderboard;
	private TableRowSorter<TableModel> sorter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderboardForm frame = new LeaderboardForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void saveLeaderboard() {
		try {
			FileOutputStream fs = new FileOutputStream(leaderboardFile);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(tm.getDataVector());
			
			os.close();
			fs.close();
		}catch(Exception e) {
		}
	}
	
	@SuppressWarnings("unchecked")
	private void initTableData() {
		
		Vector columnId = new Vector();
		columnId.add("Player");
		columnId.add("Score");
		
		tm =(DefaultTableModel) leaderboard.getModel();
		
		try {
			FileInputStream fs = new FileInputStream(leaderboardFile);
			ObjectInputStream os = new ObjectInputStream(fs);
			
			tm.setDataVector((Vector<Vector>)os.readObject(), columnId);
			
			fs.close();
			os.close();
		}catch(Exception e) {
		}
	}
	
	private void initTableSorter() {
		sorter = new TableRowSorter<>(tm);
		leaderboard.setRowSorter(sorter);
		
		ArrayList<SortKey> keys = new ArrayList<>();
		keys.add(new SortKey(1, SortOrder.DESCENDING));
		
		sorter.setSortKeys(keys);
	}

	public void addPlayer(String playerName, int score) {
		tm.addRow(new Object[] {playerName, score});
		sorter.sort();
		saveLeaderboard();
		
		this.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	public LeaderboardForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		leaderboard = new JTable();
		leaderboard.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Player Name", "Score"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			leaderboard.getColumnModel().getColumn(0).setPreferredWidth(299);
			leaderboard.getColumnModel().getColumn(1).setPreferredWidth(322);
		leaderboard.setBounds(10, 42, 414, 208);
		
		initTableData();
		initTableSorter();
		contentPane.add(leaderboard);
		
		JButton btnMainMenu = new JButton("Game Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Snake.showMainMenu();
			}
		});
		btnMainMenu.setBounds(10, 11, 115, 23);
		contentPane.add(btnMainMenu);
	}

}
