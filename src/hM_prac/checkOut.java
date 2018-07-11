package hM_prac;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class checkOut extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static checkOut frame ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new checkOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	Connection con;
	ResultSet rs;
	PreparedStatement ps;

private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
}

	/**
	 * Create the frame.
	 */
	public checkOut() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCheckOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOut.setBounds(96, 29, 414, 27);
		contentPane.add(lblCheckOut);
		
		JLabel lblNewLabel = new JLabel("Booking Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(136, 107, 138, 17);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(328, 107, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pay Amount:");
		lblNewLabel_1.setBounds(108, 161, 79, 20);
		//contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(222, 164, 86, 20);
		//contentPane.add(textField_1);
		textField_1.setColumns(10);
		JButton btnPay = new JButton("Pay");
		
		int b=0;
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid=textField.getText();
				
			try
			   {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
			ps=con.prepareStatement("select amount from vw_book where Bookid=? "
					//+ "and status=? "
					+ "");   
			ps.setInt(1,Integer.parseInt(bid));
		//	ps.setString(2,"not paid");
			rs=ps.executeQuery();
			int flag=0;
			while(rs.next())
			{ flag=1;
			int  amt=rs.getInt("amount");
			JOptionPane.showMessageDialog(contentPane,"Amount to be paid:"+amt+" ","Ok",JOptionPane.INFORMATION_MESSAGE);
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField_1);
			contentPane.add(btnPay);
			revalidate();
			repaint();
			}
			if(flag==0){
				JOptionPane.showMessageDialog(contentPane,"Error","Ok",JOptionPane.ERROR_MESSAGE);
			}	
	
			}catch(Exception w)
			{w.printStackTrace();
		}}} );
		btnSubmit.setBounds(249, 150, 108, 27);
		contentPane.add(btnSubmit);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 619, 380);
		label.setIcon(resizeIcon(new ImageIcon(checkOut.class.getResource("/images/cha.jpg")),
		label.getWidth() - label.getInsets().left, label.getHeight() - label.getInsets().left));
		contentPane.add(label);
		
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pay=textField_1.getText();
				String room=textField.getText();
				try
				   {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
				ps=con.prepareStatement("update booking set status='paid' where Bookid=? ");   
				//ps.setString(1,"paid");
				ps.setInt(1,Integer.parseInt(room));
				int r=0;
				r=ps.executeUpdate();
				int flag=0;
				if(r>0)
				{ flag=1;
				JOptionPane.showMessageDialog(contentPane,"Checked Out","Ok",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				setVisible(false);
				}
				if(flag==0){
					JOptionPane.showMessageDialog(contentPane,"Error","Ok",JOptionPane.ERROR_MESSAGE);
				
				}
				}catch (Exception w)
				{w.printStackTrace();}
				}});
		btnPay.setBounds(156, 199, 89, 23);
		
		//contentPane.add(btnPay);
	}

}
