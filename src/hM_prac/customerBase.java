package hM_prac;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class customerBase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static customerBase frame ;
	/**
	 * Launch the application.
	 */

private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new customerBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	/**
	 * Create the frame.
	 */
	public customerBase() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblBookRoom = new JLabel("New Customer");
		lblBookRoom.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblBookRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookRoom.setBounds(162, 11, 280, 40);
		contentPane.add(lblBookRoom);
		
		JLabel lblNewLabel = new JLabel("Customer NAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(162, 113, 134, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(314, 113, 128, 26);
		contentPane.add(textField);
		textField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(162, 167, 108, 17);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(314, 164, 128, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Unique ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(162, 219, 108, 17);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setBounds(314, 219, 128, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contact:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(162, 265, 81, 20);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setBounds(314, 265, 128, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton btnCheckAvailabity = new JButton("Register");
		btnCheckAvailabity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckAvailabity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name,address,uid,contact;
				name=textField.getText();
				address=textField_1.getText();
				uid=textField_2.getText();
				contact=textField_3.getText();			
				
				try
				   {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
				ps=con.prepareStatement("insert into  cust_det(cust_name,address,uniqueId,contact) values(?,?,?,?)");   
				ps.setString(1,name);
				ps.setString(2,address);
				ps.setString(3,uid);
				ps.setString(4,contact);
				int r=ps.executeUpdate();
				int flag=0;
				if(r>0)
				{ flag=1;
				JOptionPane.showMessageDialog(contentPane,"Customer registered","Ok",JOptionPane.INFORMATION_MESSAGE);
				//contentPane.disable();
				//frame.setVisible(false);
				setVisible(false);
				
				}
				if(flag==0){
					JOptionPane.showMessageDialog(contentPane,"Error","Ok",JOptionPane.ERROR_MESSAGE);
				}
				}catch (Exception w)
				{w.printStackTrace();}
				
				
			}
		});
		btnCheckAvailabity.setBounds(233, 328, 120, 40);
		contentPane.add(btnCheckAvailabity);
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 604, 474);
		label.setIcon(resizeIcon(new ImageIcon(customerBase.class.getResource("/images/CRM-Customer-Loyalty.png")),
		label.getWidth() - label.getInsets().left, label.getHeight() - label.getInsets().left));
		contentPane.add(label);
	}

}
