package menu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Confirm extends Menu {

	private static String name = "[Station Name]";
	
	private static double price = 0;
	
	private static String PicName = "src\\picture";
	
	private JFrame frmTicketingMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm window = new Confirm();
					window.frmTicketingMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String getStationName(String Name) {
		name = Name;
		return name;
	}
	
	public static double getPrice(double Price) {
		price = Price;
		return price;
	}
	
	public static String getPicture(String picName) {
		PicName = picName;
		return PicName;
	}
	
	/**
	 * Create the application.
	 */
	public Confirm() {
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
		
		JLabel lblNewLabel = new JLabel(name);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 237, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 81, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		lblNewLabel.setFont(new Font("Bangna New", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmTicketingMachine.getContentPane().add(lblNewLabel);
		
		JLabel lblStation = new JLabel("Destination: ");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -24, SpringLayout.NORTH, lblStation);
		springLayout.putConstraint(SpringLayout.NORTH, lblStation, 312, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblStation, 91, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		lblStation.setFont(new Font("Bangna New", Font.PLAIN, 24));
		frmTicketingMachine.getContentPane().add(lblStation);
		
		JLabel lblDestination = new JLabel(name);
		springLayout.putConstraint(SpringLayout.NORTH, lblDestination, 1, SpringLayout.NORTH, lblStation);
		springLayout.putConstraint(SpringLayout.WEST, lblDestination, 6, SpringLayout.EAST, lblStation);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDestination, 0, SpringLayout.SOUTH, lblStation);
		lblDestination.setFont(new Font("Bangna New", Font.PLAIN, 24));
		frmTicketingMachine.getContentPane().add(lblDestination);
		
		JLabel lblNewLabel_1 = new JLabel("Price: ");
		springLayout.putConstraint(SpringLayout.EAST, lblStation, -71, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 354, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 171, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblStation, -6, SpringLayout.NORTH, lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Bangna New", Font.PLAIN, 24));
		frmTicketingMachine.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel(String.format("%.2f", price)+" Baht");
		springLayout.putConstraint(SpringLayout.NORTH, label, 354, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 249, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 65, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 0, SpringLayout.SOUTH, label);
		label.setFont(new Font("Bangna New", Font.PLAIN, 24));
		frmTicketingMachine.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -234, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 49, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_1, -495, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label_1, -82, SpringLayout.SOUTH, frmTicketingMachine.getContentPane());
		label_1.setIcon(new ImageIcon(PicName));
		springLayout.putConstraint(SpringLayout.EAST, label_1, -10, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		frmTicketingMachine.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, label_2, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label_2, -60, SpringLayout.SOUTH, frmTicketingMachine.getContentPane());
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Station.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		label_2.setIcon(new ImageIcon("src\\picture\\back_bt.png"));
		frmTicketingMachine.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, label, -181, SpringLayout.NORTH, label_3);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 450, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_3, -513, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Payment.getStation(name);
				Payment.getPrice(price);
				Payment.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 571, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		label_3.setIcon(new ImageIcon("src\\picture\\next_bt.png"));
		springLayout.putConstraint(SpringLayout.SOUTH, label_3, 0, SpringLayout.SOUTH, label_2);
		frmTicketingMachine.getContentPane().add(label_3);
	}
}
