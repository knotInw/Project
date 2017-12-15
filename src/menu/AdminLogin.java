package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminLogin {

	private JFrame frmTicketingMachineadmin;
	private JTextField idField;
	private String id;
	private String password;
	private JTextField passwordField;
	static String dataAdmin = "src\\data\\admin_ID.txt";
	static ArrayList<String> listID = new ArrayList<>();
	static ArrayList<String> listPass = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					readAdminFile();
					window.frmTicketingMachineadmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void readAdminFile() {
		try {
			Scanner reader = new Scanner(new File(dataAdmin));
			while(reader.hasNextLine()) {
				String[] tempfile = reader.nextLine().replaceAll(";", "  ").split("  ");
				if(!tempfile[0].isEmpty()) {
					listID.add(tempfile[0]);
					listPass.add(tempfile[1]);
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
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketingMachineadmin = new JFrame();
		frmTicketingMachineadmin.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\picture\\Untitled-1.jpg"));
		frmTicketingMachineadmin.setTitle("Ticketing Machine (Admin mode)");
		frmTicketingMachineadmin.setResizable(false);
		frmTicketingMachineadmin.setBounds(0, 0, 1280, 720);
		frmTicketingMachineadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmTicketingMachineadmin.getContentPane().setLayout(springLayout);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		springLayout.putConstraint(SpringLayout.WEST, lblAdminLogin, 10, SpringLayout.WEST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAdminLogin, -10, SpringLayout.EAST, frmTicketingMachineadmin.getContentPane());
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Bangna New", Font.PLAIN, 30));
		frmTicketingMachineadmin.getContentPane().add(lblAdminLogin);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Bangna New", Font.PLAIN, 22));
		frmTicketingMachineadmin.getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.WEST, lblId, 89, SpringLayout.WEST, lblPassword);
		springLayout.putConstraint(SpringLayout.SOUTH, lblId, -20, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.EAST, lblId, 0, SpringLayout.EAST, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 351, SpringLayout.WEST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, -798, SpringLayout.EAST, frmTicketingMachineadmin.getContentPane());
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Bangna New", Font.PLAIN, 22));
		frmTicketingMachineadmin.getContentPane().add(lblPassword);
		
		idField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, idField, -3, SpringLayout.NORTH, lblId);
		springLayout.putConstraint(SpringLayout.WEST, idField, 11, SpringLayout.EAST, lblId);
		idField.setFont(new Font("Bangna New", Font.PLAIN, 22));
		frmTicketingMachineadmin.getContentPane().add(idField);
		idField.setColumns(10);
		
		passwordField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 11, SpringLayout.EAST, lblPassword);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -323, SpringLayout.EAST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, idField, 0, SpringLayout.EAST, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblPassword);
		passwordField.setFont(new Font("Bangna New", Font.PLAIN, 22));
		passwordField.setColumns(10);
		frmTicketingMachineadmin.getContentPane().add(passwordField);
		
		JLabel label_1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblAdminLogin, 166, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 10, SpringLayout.NORTH, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_1, 10, SpringLayout.WEST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_1, -967, SpringLayout.EAST, frmTicketingMachineadmin.getContentPane());
		label_1.setIcon(new ImageIcon("src\\picture\\back_bt.png"));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTicketingMachineadmin.setVisible(false);
				Menu.main(null);
			}
		});
		
		JLabel Status = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, Status, 297, SpringLayout.NORTH, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, Status, 10, SpringLayout.WEST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, Status, -17, SpringLayout.NORTH, idField);
		springLayout.putConstraint(SpringLayout.EAST, Status, -20, SpringLayout.EAST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAdminLogin, -6, SpringLayout.NORTH, Status);
		Status.setHorizontalAlignment(SwingConstants.CENTER);
		Status.setFont(new Font("Bangna New", Font.PLAIN, 30));
		frmTicketingMachineadmin.getContentPane().add(Status);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Bangna New", Font.PLAIN, 18));
		frmTicketingMachineadmin.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, lblPassword, -25, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label, 351, SpringLayout.WEST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -323, SpringLayout.EAST, frmTicketingMachineadmin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label, -158, SpringLayout.SOUTH, frmTicketingMachineadmin.getContentPane());
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				id = idField.getText();
				password = passwordField.getText();
				for(int i=0; i<listID.size(); i++) {
					if(id.equals(listID.get(0))&&password.equals(listPass.get(0))) {
						Data.main(null);
						frmTicketingMachineadmin.setVisible(false);
					}
					else {
						Status.setText("Wrong ID/Password try again.");
					}
				}
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src\\picture\\login_bt.png"));
		frmTicketingMachineadmin.getContentPane().add(label);
	}
}
