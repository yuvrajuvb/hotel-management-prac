package hM_prac;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame implements ActionListener {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	JButton btnNewButton,btnNewButton_1,btnNewButton_2;
	private JLabel lblNewBooking;
	private JLabel lblRoomsAvailable;
	private JLabel lblCheckOut;
	private JLabel lblNewLabel_1;
	private JButton btnAddNewCustomer;
	private JButton btnLogout;
	/**
	 * Create the frame.
	 */
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1368, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new login().setVisible(true);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Dialog", Font.BOLD, 18));
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setBounds(760, 167, 288, 31);
		contentPane.add(btnLogout);
		
		btnAddNewCustomer = new JButton("ADD NEW CUSTOMER");
		btnAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customerBase().setVisible(true);
				
			}
		});
		btnAddNewCustomer.setBackground(Color.LIGHT_GRAY);
		btnAddNewCustomer.setForeground(Color.WHITE);
		btnAddNewCustomer.setFont(new Font("Dialog", Font.BOLD, 18));
		btnAddNewCustomer.setBounds(333, 167, 288, 31);
		contentPane.add(btnAddNewCustomer);
		
		JLabel lblNewLabel = new JLabel("Welcome  ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 12, 1350, 143);
		lblNewLabel.setFont(new Font("Perpetua", Font.BOLD, 36));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("");
		btnNewButton.setToolTipText("NEW BOOKING");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(52, 280, 379, 351);
		contentPane.add(btnNewButton);
		//int offset =btnNewButton.getInsets().left;
	     btnNewButton.setIcon(resizeIcon(new ImageIcon(home.class.getResource("/images/36532168-black-circle-vintage-style-hotel-or-apartment-booking-sign-icon-sticker-or-label-isolated-on-white-b.jpg"))
		,btnNewButton.getWidth() - btnNewButton.getInsets().left, btnNewButton.getHeight() - btnNewButton.getInsets().left));
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(506, 277, 364, 354);
		btnNewButton_1.setToolTipText("Check availablity");
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setIcon(resizeIcon(new ImageIcon(home.class.getResource("/images/index.jpg"))
		,btnNewButton.getWidth() - btnNewButton.getInsets().left, btnNewButton.getHeight() - btnNewButton.getInsets().left));
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("CheckOut");
		btnNewButton_2.setBounds(955, 277, 352, 351);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setIcon(resizeIcon(new ImageIcon(home.class.getResource("/images/check-out-counter-service-accommodation-377258ebd4bea820-512x512.jpg"))
		,btnNewButton.getWidth() - btnNewButton.getInsets().left, btnNewButton.getHeight() - btnNewButton.getInsets().left));
		
		lblNewBooking = new JLabel("NEW BOOKING !!");
		lblNewBooking.setForeground(Color.WHITE);
		lblNewBooking.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewBooking.setBounds(52, 663, 379, 31);
		contentPane.add(lblNewBooking);
		
		lblRoomsAvailable = new JLabel("Rooms AVAILABLE!!");
		lblRoomsAvailable.setForeground(Color.WHITE);
		lblRoomsAvailable.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRoomsAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomsAvailable.setBounds(506, 663, 364, 31);
		contentPane.add(lblRoomsAvailable);
		
		lblCheckOut = new JLabel("CHECK OUT!!");
		lblCheckOut.setForeground(Color.WHITE);
		lblCheckOut.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCheckOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOut.setBounds(955, 663, 352, 25);
		contentPane.add(lblCheckOut);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 1352, 729);
		lblNewLabel_1.setIcon(resizeIcon(new ImageIcon(login.class.getResource("/images/images.jpg")),
		lblNewLabel_1.getWidth() - lblNewLabel_1.getInsets().left, lblNewLabel_1.getHeight() - lblNewLabel_1.getInsets().left));
		contentPane.add(lblNewLabel_1);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
if(o==btnNewButton){
//	this.dispose();
	new booking().setVisible(true);;
}
else if(o==btnNewButton_1)
{
	new checkA().setVisible(true);;
}
else if(o==btnNewButton_2){
	new checkOut().setVisible(true);;
}

		// TODO Auto-generated method stub
		
		
	}
}
