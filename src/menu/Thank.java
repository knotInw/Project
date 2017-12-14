package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Thank {

	private JFrame frmTicketingMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thank window = new Thank();
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
	public Thank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketingMachine = new JFrame();
		frmTicketingMachine.setResizable(false);
		frmTicketingMachine.getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmTicketingMachine.setVisible(false);
				Menu.main(null);
			}
		});
		frmTicketingMachine.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\picture\\Untitled-1.jpg"));
		frmTicketingMachine.setTitle("Ticketing Machine");
		frmTicketingMachine.setBounds(0, 0, 1280, 720);
		frmTicketingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmTicketingMachine.getContentPane().setLayout(springLayout);
		
		JLabel label = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, label, 46, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src\\picture\\Untitled-1.jpg"));
		frmTicketingMachine.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Thank you for purchase.");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 439, SpringLayout.NORTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -183, SpringLayout.SOUTH, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frmTicketingMachine.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, label, -40, SpringLayout.NORTH, lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bangna New", Font.PLAIN, 30));
		frmTicketingMachine.getContentPane().add(lblNewLabel);
	}

}
