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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

	private JFrame frmTicketingMachine;
	static String dataOrder = "src\\data\\order_Detail.txt";
	static ArrayList<String>orderID = new ArrayList<>();
	static ArrayList<String>destination = new ArrayList<>();
	static ArrayList<String>customerName = new ArrayList<>();
	static ArrayList<String>price = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data window = new Data();
					readDataFile();
					for(int i=0; i<orderID.size(); i++) {
						System.out.println(orderID.get(i)+destination.get(i)+customerName.get(i)+price.get(i));
						}
					window.frmTicketingMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void readDataFile() {
		try {
			Scanner reader = new Scanner(new File(dataOrder));
			while(reader.hasNextLine()) {
				String[] tempfile = reader.nextLine().replaceAll(";", "  ").split("  ");
				if(!tempfile[0].isEmpty()) {
					orderID.add(tempfile[0]);
					destination.add(tempfile[1]);
					customerName.add(tempfile[2]);
					price.add(tempfile[3]);
				}
			}
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!!");
		}
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
		springLayout.putConstraint(SpringLayout.EAST, table, 1264, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		table.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, table, 6, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, table, 10, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 616, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		table.setFont(new Font("Bangna New", Font.PLAIN, 15));
		frmTicketingMachine.getContentPane().add(table);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Data.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.EAST, label_1, 0, SpringLayout.EAST, table);
		label_1.setIcon(new ImageIcon("src\\picture\\ud_bt.png"));
		frmTicketingMachine.getContentPane().add(label_1);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addColumn("Order ID");
		model.addColumn("Destination");
		model.addColumn("Customer Name");
		model.addColumn("Price");

		for(int i=1; i<=orderID.size(); i++) {
			String OrderID = orderID.get(i-1);
			String Destination = destination.get(i-1);
			String Customer = customerName.get(i-1);
			String Price = price.get(i-1);
			double value = Double.parseDouble(Price);
			model.addRow(new Object[0]);
			model.setValueAt(OrderID, i-1, 0);
			model.setValueAt(Destination, i-1, 1);
			model.setValueAt(Customer, i-1, 2);
			model.setValueAt(String.format("%.2f", value), i-1, 3);
		}
	}
}
