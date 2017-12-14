package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Menu {

	private JFrame frmTicketingMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketingMachine = new JFrame();
		frmTicketingMachine.setResizable(false);
		frmTicketingMachine.setFont(new Font("Gobold", Font.PLAIN, 12));
		frmTicketingMachine.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\picture\\Untitled-1.jpg"));
		frmTicketingMachine.setTitle("Ticketing Machine");
		frmTicketingMachine.setBounds(0, 0, 1280, 720);
		frmTicketingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBuyTicket = new JLabel("");
		lblBuyTicket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTicketingMachine.setVisible(false);
				Station.main(null);
			}
		});
		lblBuyTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyTicket.setFont(new Font("Bangna New", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\picture\\Untitled-1.jpg"));
		lblNewLabel.setFont(new Font("Bangna New", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTicketingMachine.setVisible(false);
				AdminLogin.main(null);
			}
		});
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTicketingMachine.setVisible(false);
				Station.main(null);
			}
		});
		label.setIcon(new ImageIcon("src\\picture\\buy_bt.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Bangna New", Font.PLAIN, 18));
		label_1.setIcon(new ImageIcon("src\\picture\\see_bt.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Bangna New", Font.PLAIN, 18));
		
		JLabel lblExit = new JLabel("");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		lblExit.setIcon(new ImageIcon("src\\picture\\exit_bt.png"));
		lblExit.setFont(new Font("Bangna New", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frmTicketingMachine.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblBuyTicket)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(337)
					.addComponent(label))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(337)
					.addComponent(label_1))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 1264, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 1269, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblBuyTicket)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(label)
					.addGap(5)
					.addComponent(label_1)
					.addGap(5)
					.addComponent(lblExit))
		);
		frmTicketingMachine.getContentPane().setLayout(groupLayout);
	}

}
