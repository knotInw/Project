package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;

public class Data extends JFrame{

	private JFrame frmTicketingMachine;
	
	Object[][] data = {{}};
	
	String[] columnNames = {"Order ID", "Destination", "Customer Name", "Price"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data window = new Data();
					window.frmTicketingMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketingMachine = new JFrame();
		frmTicketingMachine.setResizable(false);
		frmTicketingMachine.setTitle("Ticketing Machine");
		frmTicketingMachine.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\picture\\Untitled-1.jpg"));
		frmTicketingMachine.setBounds(0, 0, 1280, 720);
		frmTicketingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmTicketingMachine.getContentPane().setLayout(springLayout);
		
		JLabel label = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, label, 616, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Menu.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		label.setIcon(new ImageIcon("src\\picture\\back_bt.png"));
		frmTicketingMachine.getContentPane().add(label);
		
		JTable table = new JTable();
		springLayout.putConstraint(SpringLayout.WEST, table, 6, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 1244, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, table, 10, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 616, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		table.setEnabled(false);
		table.setFont(new Font("Bangna New", Font.PLAIN, 15));
		frmTicketingMachine.getContentPane().add(table);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addColumn("Order ID");
		model.addColumn("Destination");
		model.addColumn("Customer Name");
		model.addColumn("Price");
		
		for(int i=0; i<=50; i++) {
			model.addRow(new Object[0]);
			model.setValueAt(i+1000000, i, 0);
			model.setValueAt("Test"+(i+1), i, 1);
			model.setValueAt("Name"+i, i, 2);
			model.setValueAt("Price", i, 3);
		}
	}
}
