package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Station extends Menu {

	private JFrame frmTicketingMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Station window = new Station();
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
	public Station() {
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
		
		JRadioButton rdbtnHuaLamphong = new JRadioButton("");
		rdbtnHuaLamphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirm.getStationName("Hua Lamphong");
				Confirm.getPrice(61.75);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		rdbtnHuaLamphong.setBounds(129, 703, 20, 21);
		rdbtnHuaLamphong.setHorizontalAlignment(SwingConstants.CENTER);
		frmTicketingMachine.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Select your station");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bangna New", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(0, 34, 1280, 34);
		frmTicketingMachine.getContentPane().add(lblNewLabel_1);
		frmTicketingMachine.getContentPane().add(rdbtnHuaLamphong);
		
		JLabel lblNewLabel = new JLabel("Kamphaeng Phet");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblNewLabel.setBounds(80, 146, 171, 21);
		frmTicketingMachine.getContentPane().add(lblNewLabel);
		
		JLabel lblLatPhrao = new JLabel("Lat Phrao");
		lblLatPhrao.setHorizontalAlignment(SwingConstants.LEFT);
		lblLatPhrao.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblLatPhrao.setBounds(453, 147, 95, 21);
		frmTicketingMachine.getContentPane().add(lblLatPhrao);
		
		JLabel lblRatchadaphosek = new JLabel("Ratchadaphosek");
		lblRatchadaphosek.setHorizontalAlignment(SwingConstants.LEFT);
		lblRatchadaphosek.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblRatchadaphosek.setBounds(748, 146, 165, 21);
		frmTicketingMachine.getContentPane().add(lblRatchadaphosek);
		
		JLabel lblPhraRam = new JLabel("Phra Ram9");
		lblPhraRam.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhraRam.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblPhraRam.setBounds(1101, 146, 104, 21);
		frmTicketingMachine.getContentPane().add(lblPhraRam);
		
		JLabel lblSukhumvit = new JLabel("Sukhumvit");
		lblSukhumvit.setHorizontalAlignment(SwingConstants.LEFT);
		lblSukhumvit.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblSukhumvit.setBounds(1013, 379, 118, 21);
		frmTicketingMachine.getContentPane().add(lblSukhumvit);
		
		JLabel lblLumphini = new JLabel("Lumphini");
		lblLumphini.setHorizontalAlignment(SwingConstants.LEFT);
		lblLumphini.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblLumphini.setBounds(936, 605, 104, 21);
		frmTicketingMachine.getContentPane().add(lblLumphini);
		
		JLabel lblSiLorm = new JLabel("Si lorm");
		lblSiLorm.setHorizontalAlignment(SwingConstants.LEFT);
		lblSiLorm.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblSiLorm.setBounds(615, 605, 68, 21);
		frmTicketingMachine.getContentPane().add(lblSiLorm);
		
		JLabel lblSamYan = new JLabel("Sam Yan");
		lblSamYan.setHorizontalAlignment(SwingConstants.LEFT);
		lblSamYan.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblSamYan.setBounds(271, 605, 84, 21);
		frmTicketingMachine.getContentPane().add(lblSamYan);
		
		JLabel lblHuaLamphong = new JLabel("Hua Lamphong");
		lblHuaLamphong.setHorizontalAlignment(SwingConstants.LEFT);
		lblHuaLamphong.setFont(new Font("Bangna New", Font.PLAIN, 18));
		lblHuaLamphong.setBounds(180, 380, 139, 21);
		frmTicketingMachine.getContentPane().add(lblHuaLamphong);
		
		JLabel lblYoureHere = new JLabel("You're here");
		lblYoureHere.setHorizontalAlignment(SwingConstants.LEFT);
		lblYoureHere.setFont(new Font("Bangna New", Font.PLAIN, 14));
		lblYoureHere.setBounds(448, 236, 104, 21);
		frmTicketingMachine.getContentPane().add(lblYoureHere);
		
		JLabel KamphaengPhetButton = new JLabel("");
		KamphaengPhetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("KamphaengPhet");
				Confirm.getPicture("src\\picture\\Kamphaeng_Phet.png");
				Confirm.getPrice(45.00);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		KamphaengPhetButton.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		KamphaengPhetButton.setBounds(115, 170, 55, 55);
		frmTicketingMachine.getContentPane().add(KamphaengPhetButton);
		
		JLabel LatPhraoButton = new JLabel("");
		LatPhraoButton.setIcon(new ImageIcon("src\\picture\\Untitled-4.jpg"));
		LatPhraoButton.setBounds(461, 170, 55, 55);
		frmTicketingMachine.getContentPane().add(LatPhraoButton);
		
		JLabel RatchadaphisekButton = new JLabel("");
		RatchadaphisekButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("Ratchadaphisek");
				Confirm.getPicture("src\\picture\\Ratchadaphisek.png");
				Confirm.getPrice(45.00);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		RatchadaphisekButton.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		RatchadaphisekButton.setBounds(790, 170, 55, 55);
		frmTicketingMachine.getContentPane().add(RatchadaphisekButton);
		
		JLabel PharaRam9Button = new JLabel("");
		PharaRam9Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("PhraRam9");
				Confirm.getPicture("src\\picture\\Phra_Ram9.png");
				Confirm.getPrice(47.00);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		PharaRam9Button.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		PharaRam9Button.setBounds(1118, 170, 55, 55);
		frmTicketingMachine.getContentPane().add(PharaRam9Button);
		
		JLabel SukhumvitButton = new JLabel("");
		SukhumvitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("Sukhumvit");
				Confirm.getPicture("src\\picture\\Sukhumvit.png");
				Confirm.getPrice(50.00);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		SukhumvitButton.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		SukhumvitButton.setBounds(1118, 361, 55, 55);
		frmTicketingMachine.getContentPane().add(SukhumvitButton);
		
		JLabel LumphiniButton = new JLabel("");
		LumphiniButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("Lumphini");
				Confirm.getPicture("src\\picture\\Lumphini.png");
				Confirm.getPrice(52.25);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		LumphiniButton.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		LumphiniButton.setBounds(940, 539, 55, 55);
		frmTicketingMachine.getContentPane().add(LumphiniButton);
		
		JLabel SiLormButton = new JLabel("");
		SiLormButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("Si lorm");
				Confirm.getPicture("src\\picture\\Si_Lorm.png");
				Confirm.getPrice(55.50);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		SiLormButton.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		SiLormButton.setBounds(615, 540, 55, 55);
		frmTicketingMachine.getContentPane().add(SiLormButton);
		
		JLabel SamYan = new JLabel("");
		SamYan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("Sam Yan");
				Confirm.getPicture("src\\picture\\Sam_Yan.png");
				Confirm.getPrice(60.00);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		SamYan.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		SamYan.setBounds(283, 540, 55, 55);
		frmTicketingMachine.getContentPane().add(SamYan);
		
		JLabel HuaLamphongButton = new JLabel("");
		HuaLamphongButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Confirm.getStationName("Hua Lamphong");
				Confirm.getPicture("src\\picture\\Hua_Lamphong.png");
				Confirm.getPrice(61.75);
				Confirm.main(null);
				frmTicketingMachine.setVisible(false);
			}
		});
		HuaLamphongButton.setIcon(new ImageIcon("src\\picture\\Untitled-2.png"));
		HuaLamphongButton.setBounds(115, 361, 55, 55);
		frmTicketingMachine.getContentPane().add(HuaLamphongButton);
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon("src\\picture\\Untitled-2.jpg"));
		BG.setBounds(0, 0, 1280, 700);
		frmTicketingMachine.getContentPane().add(BG);
	}
}
