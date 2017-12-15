package menu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Payment {

	private JFrame frmTicketingMachine;
	private JTextField textField;
	private String ID;
	private JLabel label;
	private static String name = "[name]";
	private static double price = 0;
	private JLabel TicketPrice;
	private JLabel mass_1;
	private JLabel mass_2;
	private JLabel confirm_bt;
	static String dataMember = "src\\data\\member_Detail.txt";
	static String dataOrder = "src\\data\\Order_Detail.txt";
	static ArrayList<Object> listMname = new ArrayList<>();
	static ArrayList<Double> listMpocket = new ArrayList<>();
	static ArrayList<String> listMid = new ArrayList<>();
	static ArrayList<Object> formatMember = new ArrayList<>();
	
	static int numid = 10000000 ;
	static String station;
	static ArrayList<Object> listid = new ArrayList<>();
	private JLabel cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
					readmemberFile();
					readOrderFile();
					window.frmTicketingMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String getName(String Name) {
		name = Name;
		return name;
	}
	
	public static String getStation(String Station) {
		station = Station;
		return station;
	}
	
	public static double getPrice(Double Price) {
		price = Price;
		return price;
	}
	
	public static void readmemberFile() {
		try {
			Scanner reader = new Scanner(new File(dataMember));

			while(reader.hasNextLine()) {
				String[] tempfile = reader.nextLine().replaceAll(";", "  ").split("  ");
				if(!tempfile[0].isEmpty()) {
					listMid.add(tempfile[0]);
					listMname.add(tempfile[1]);
					listMpocket.add(Double.parseDouble(tempfile[2]));
				}
			}
			reader.close();
		}

		catch(FileNotFoundException e) {
			System.out.println("File not found!!");
		}
	}
	
	public static void readOrderFile(){
		try {
			Scanner reader = new Scanner(new File(dataOrder));

			while(reader.hasNextLine()) {
				String[] tempfile = reader.nextLine().replaceAll(";", "  ").split("  ");
				if(!tempfile[0].isEmpty()) {
					listid.add(Integer.parseInt(tempfile[0]));
					listMname.add(tempfile[2]);
				}
			}
			reader.close();
		}

		catch(FileNotFoundException e) {
			System.out.println("File not found!!");
		}
	}
	
	public static void writeorderFile(){
		
			try {
				Path file = Paths.get(dataOrder);
				BufferedWriter writerOrder = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

				for (int i = 0; i < listMid.size(); i++) {
						writerOrder.write("" + listid.get(i+1000000000) + ";" + station + ";" + listMname.get(i) + ";" + price );
						writerOrder.newLine();
						break;
				}
				writerOrder.close();
			}
			catch (IOException e) {
				System.out.println("Cannot writefile!!");
			}
		
	}
	
	public static void writememberFile() {
		try {
			Path file = Paths.get(dataMember);
			BufferedWriter writerMember = Files.newBufferedWriter(file, StandardCharsets.UTF_8);

			for (int i = 0; i < listMid.size(); i++) {
				writerMember.write("" + listMid.get(i) + ";" + listMname.get(i) + ";" + Double.toString(listMpocket.get(i)));
				writerMember.newLine();
			}
			writerMember.close();
		}
		catch (IOException e) {
			System.out.println("Cannot writefile!!");
		}
	}
	
	/**
	 * Create the application.
	 */
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketingMachine = new JFrame();
		frmTicketingMachine.setResizable(false);
		frmTicketingMachine.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\picture\\Untitled-1.jpg"));
		frmTicketingMachine.setTitle("Ticketing Machine");
		frmTicketingMachine.setBounds(0, 0, 1280, 720);
		frmTicketingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmTicketingMachine.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Enter your card ID");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 33, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bangna New", Font.PLAIN, 26));
		frmTicketingMachine.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID:");
		springLayout.putConstraint(SpringLayout.NORTH, lblId, 117, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -21, SpringLayout.NORTH, lblId);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Bangna New", Font.PLAIN, 22));
		frmTicketingMachine.getContentPane().add(lblId);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblId, -7, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 117, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 140, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 386, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -328, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		textField.setToolTipText("Enter your card ID here");
		textField.setFont(new Font("Bangna New", Font.PLAIN, 18));
		frmTicketingMachine.getContentPane().add(textField);
		textField.setColumns(10);
		
		label = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -20, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Bangna New", Font.PLAIN, 18));
		frmTicketingMachine.getContentPane().add(label);
		
		TicketPrice = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, TicketPrice, 231, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, TicketPrice, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, TicketPrice, -395, SpringLayout.SOUTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, TicketPrice, -20, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label, 33, SpringLayout.SOUTH, TicketPrice);
		TicketPrice.setHorizontalAlignment(SwingConstants.CENTER);
		TicketPrice.setFont(new Font("Bangna New", Font.PLAIN, 22));
		frmTicketingMachine.getContentPane().add(TicketPrice);
		
		mass_1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, mass_1, 431, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, mass_1, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mass_1, -20, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label, -37, SpringLayout.NORTH, mass_1);
		mass_1.setHorizontalAlignment(SwingConstants.CENTER);
		mass_1.setFont(new Font("Bangna New", Font.PLAIN, 22));
		frmTicketingMachine.getContentPane().add(mass_1);
		
		mass_2 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, mass_2, 517, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, mass_2, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mass_2, -20, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, mass_1, -21, SpringLayout.NORTH, mass_2);
		springLayout.putConstraint(SpringLayout.SOUTH, mass_2, -111, SpringLayout.SOUTH, frmTicketingMachine.getContentPane());
		mass_2.setHorizontalAlignment(SwingConstants.CENTER);
		mass_2.setFont(new Font("Bangna New", Font.PLAIN, 24));
		frmTicketingMachine.getContentPane().add(mass_2);
		
		confirm_bt = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, confirm_bt, -6, SpringLayout.NORTH, TicketPrice);
		confirm_bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ID = textField.getText();
				int i=-1;
				for(int a=0; a<listMid.size(); a++) {
					if(ID.equals(listMid.get(a))){
						System.out.println(a);
						i=a;
					}
				}
				if(i!=-1) {
					if(ID.equals(listMid.get(i))) {
						label.setText("Hello "+listMname.get(i));
						TicketPrice.setText("Ticket price: "+String.format("%.2f", price)+" Baht");
						
						if(listMpocket.get(i)<price) {
							mass_1.setText("Your money not enough");
							mass_2.setText("Please contact Staff");
						}
						else {
							double balanceCard = listMpocket.get(i)-price;
							listMpocket.set(i, balanceCard);
							while(listid.contains(numid))
							{
								numid++ ;
							}
							mass_1.setText("Balance in card: "+String.format("%.2f", balanceCard)+"Baht");
							mass_2.setIcon(new ImageIcon("src\\picture\\next_bt.png"));
							
							mass_2.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									Thank.main(null);
									frmTicketingMachine.setVisible(false);
									writememberFile();
									writeorderFile();
								}
							});
						}
					}
				}
					else {
						label.setText("Wrong ID try again.");
					}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, confirm_bt, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, confirm_bt, 10, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		confirm_bt.setIcon(new ImageIcon("src\\picture\\confirm_bt.png"));
		confirm_bt.setHorizontalAlignment(SwingConstants.CENTER);
		frmTicketingMachine.getContentPane().add(confirm_bt);
		
		cancel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, cancel, -73, SpringLayout.SOUTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cancel, 297, SpringLayout.WEST, lblNewLabel);
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Station.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		cancel.setIcon(new ImageIcon("src\\picture\\cancel_bt.png"));
		springLayout.putConstraint(SpringLayout.WEST, cancel, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, cancel, -10, SpringLayout.SOUTH, frmTicketingMachine.getContentPane());
		frmTicketingMachine.getContentPane().add(cancel);
	}
}
