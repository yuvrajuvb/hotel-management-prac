package hM_prac;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class checkA extends JFrame {

	private JPanel contentPane;
	private JTextField txtYyyymmdd;
	private JTextField txtYyyymmdd_1;
	static checkA frame ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new checkA();
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
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	/**
	 * Create the frame.
	 */
	public checkA() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAvailabilty = new JLabel("Availabilty");
		lblAvailabilty.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAvailabilty.setBounds(140, 11, 139, 35);
		contentPane.add(lblAvailabilty);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(84, 75, 76, 29);
		contentPane.add(lblNewLabel);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtYyyymmdd.setText("yyyy-mm-dd");
		txtYyyymmdd.setBounds(216, 72, 127, 32);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(84, 113, 76, 29);
		contentPane.add(lblNewLabel_1);
		
		txtYyyymmdd_1 = new JTextField();
		txtYyyymmdd_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtYyyymmdd_1.setText("yyyy-mm-dd");
		txtYyyymmdd_1.setBounds(216, 110, 127, 32);
		contentPane.add(txtYyyymmdd_1);
		txtYyyymmdd_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JComboBox comboBox ;
		
		btnNewButton.setBounds(157, 224, 89, 23);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Deluxe", "Semi Deluxe", "Normal"}));
		comboBox.setBounds(216, 153, 127, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Room type:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(84, 146, 94, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(checkA.class.getResource("/images/indexchaa.jpg")));
		label.setBounds(0, 0, 419, 305);
		label.setIcon(resizeIcon(new ImageIcon(checkA.class.getResource("/images/indexchaa.jpg")),
		label.getWidth() - label.getInsets().left, label.getHeight() - label.getInsets().left));
		contentPane.add(label);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(171, 189, 89, 23);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.disable();
				frame.setVisible(false);
				setVisible(false);
				new booking().setVisible(true);
			}});
		//contentPane.add(btnBook);
		int[] roomAva=new int[20];
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from,to;
				//String[] roomAva=new String[20];
				int[] roomAva=new int[20];
				int x=0;
				from=txtYyyymmdd.getText();
				to=txtYyyymmdd_1.getText();
				x=(comboBox.getSelectedIndex()+1);
				try
				   {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
				ps=con.prepareStatement("select roomno from room where releasedate<=? and next_book_date>=? and Floor=?");
				ps.setDate(1, java.sql.Date.valueOf(from));
				ps.setDate(2, java.sql.Date.valueOf(to));
				ps.setInt(3,x);
				rs=ps.executeQuery();
				int flag=0,i=0;
				while(rs.next())
				{ flag=1;
				roomAva[i]=rs.getInt("roomno");
				i++;
				//show avaiable rooms
				}
				if(flag==0){
					JOptionPane.showMessageDialog(contentPane,"No Rooms Available","Ok",JOptionPane.ERROR_MESSAGE);
				}
				else if(flag==1){
					new roomAva(roomAva).setVisible(true);
					contentPane.remove(btnNewButton);
					//JOptionPane.showMessageDialog(contentPane,"Rooms Available","Ok",JOptionPane.ERROR_MESSAGE);
					contentPane.add(btnBook);
				}	
			}catch (Exception w){
				w.printStackTrace();
			}
		}});
	
	
	}
}
