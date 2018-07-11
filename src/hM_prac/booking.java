package hM_prac;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.ImageIcon;

public class booking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtYyyymmdd;
	private JTextField txtYyyymmdd_1;
	static booking frame; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new booking();
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
	ResultSet rs,rs1,rs2,rs4;
	PreparedStatement ps;
	/**
	 * Create the frame.
	 */
	public booking() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 643, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookRoom = new JLabel("Book Room");
		lblBookRoom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBookRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookRoom.setBounds(231, 11, 164, 40);
		contentPane.add(lblBookRoom);
		
		JLabel lblNewLabel = new JLabel("Customer NAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(146, 84, 159, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(330, 81, 118, 20);
		contentPane.add(textField);
		textField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(146, 132, 146, 17);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(330, 129, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Room No. :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(146, 184, 146, 17);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setBounds(330, 181, 118, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("From:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(146, 233, 119, 14);
		contentPane.add(lblNewLabel_3);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtYyyymmdd.setText("yyyy-mm-dd");
		txtYyyymmdd.setBounds(330, 227, 118, 28);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("TO :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(146, 269, 119, 17);
		contentPane.add(lblNewLabel_4);
		
		
		
		JButton btnCheckAvailabity = new JButton("Check Availabity");
		btnCheckAvailabity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckAvailabity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.setvisible(false);
				setVisible(false);
				new checkA().setVisible(true);;
				//contentPane.setvisible(true);
			}
		});
		btnCheckAvailabity.setBounds(458, 181, 159, 23);
		contentPane.add(btnCheckAvailabity);
	
		
		txtYyyymmdd_1 = new JTextField();
		txtYyyymmdd_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtYyyymmdd_1.setText("yyyy-mm-dd");
		txtYyyymmdd_1.setToolTipText("yyyy-mm-dd");
		txtYyyymmdd_1.setBounds(330, 266, 118, 28);
		contentPane.add(txtYyyymmdd_1);
		txtYyyymmdd_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New Customer?");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new customerBase().setVisible(true);
				//contentPane.setVisible(true);
			}
		});
		btnNewButton.setBounds(458, 129, 159, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String room,custN,custID,from,to;
				room=textField_2.getText();
			    custN=textField.getText();
				custID=textField_1.getText();
				from=txtYyyymmdd.getText();
				to=txtYyyymmdd_1.getText();
			
				try
				   {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
				
				LocalDate tooD=null,next=null;
             	int x=0;
				int c=Integer.parseInt(room);
				ps=con.prepareStatement("select releasedate,next_book_date from room where roomno=?");   
				ps.setInt(1,c);
				int flag=0;
				rs1=ps.executeQuery();
				while(rs1.next())
				{
				java.sql.Date nbd = null;
				nbd=rs1.getDate("next_book_date");
			    next=nbd.toLocalDate();
			    tooD=tooD.parse(to);
			    Period diff = Period.between(tooD,next);
			    if (diff.getYears()>=1 || diff.getMonths()>=1 || diff.getDays()>=1)
			    {
			    	ps=con.prepareStatement("update room set next_book_date=? where roomno=? ");
			    	ps.setDate(1,java.sql.Date.valueOf(from));
					ps.setInt(2,Integer.parseInt(room));
					int r2=ps.executeUpdate();
					if(r2>0)
					{   flag=1;
						ps=con.prepareStatement("insert into booking(custid,roomno,from_,to_) values(?,?,?,?) ");   
						ps.setString(1,custID);
						ps.setString(2,room);
						ps.setDate(3,java.sql.Date.valueOf(from));
						ps.setDate(4,java.sql.Date.valueOf(to));
						int r=ps.executeUpdate();
						if(r>0)
						{
							flag=1;
							ps=con.prepareStatement("select bookid from booking where roomno=? and custid=? and from_=? and to_=?");   
							ps.setString(1,room);
							ps.setString(2,custID);
							ps.setDate(3,java.sql.Date.valueOf(from));
							ps.setDate(4,java.sql.Date.valueOf(to));
							rs4=ps.executeQuery();
							if(rs4.next())
							{ flag=1;
								x=rs4.getInt("bookId");
							}
							else
							{
								flag=0;
							}
						}
						else
						{
							flag=0;
						}
						}
					}
					else
					{
				         flag=0;
				    	JOptionPane.showMessageDialog(contentPane,"Can't set this date","Ok",JOptionPane.ERROR_MESSAGE);
						//contentPane.disable();
						//frame.setVisible(false);
				    }
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(contentPane,"Booking ID:"+x+" ","Ok",JOptionPane.INFORMATION_MESSAGE);
					contentPane.disable();
					frame.setVisible(false);
					setVisible(false);
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(contentPane,"Error","Ok",JOptionPane.ERROR_MESSAGE);
				    contentPane.disable();
				    frame.setVisible(false);
				    setVisible(false);
				}	
				}catch(Exception w)
					{
					w.printStackTrace();
					}
			}});			
		btnSubmit.setBounds(262, 337, 103, 40);
		contentPane.add(btnSubmit);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 627, 449);
		label.setIcon(resizeIcon(new ImageIcon(booking.class.getResource("/images/booking-direct.jpg")),
				label.getWidth() - label.getInsets().left, label.getHeight() - label.getInsets().left));
			
		contentPane.add(label);
				
			}
}









/*try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
ps=con.prepareStatement("insert into booking(custid,roomno,from_,to_) values(?,?,?,?) ");   
ps.setString(1,custID);
ps.setString(2,room);
ps.setDate(3,java.sql.Date.valueOf(from));
ps.setDate(4,java.sql.Date.valueOf(to));
int r=ps.executeUpdate();
int flag=0;
if(r>0)
{ flag=1;

LocalDate tooD=null,fromD=null,next=null;
int x=0;
int c=Integer.parseInt(room);
ps=con.prepareStatement("select releasedate,next_book_date from room where roomno=?");   
ps.setInt(1,c);
rs1=ps.executeQuery();
while(rs1.next())
{	java.sql.Date nbd = null;
//rd =rs.getDate("releasedate");
nbd=rs1.getDate("next_book_date");
next=nbd.toLocalDate();
tooD=tooD.parse(to);
// fromD=fromD.parse(from);
Period diff = Period.between(tooD,next);
if (diff.getYears()>=1 || diff.getMonths()>=1 || diff.getDays()>=1)
{
	ps=con.prepareStatement("update room set next_book_date=? where roomno=? ");
	ps.setDate(1,java.sql.Date.valueOf(from));
	ps.setInt(2,Integer.parseInt(room));
	int r2=ps.executeUpdate();
	if(r2>0){
		flag=1;
		ps=con.prepareStatement("select bookid from booking where roomno=? and custid=? and from_=? and to_=?");   
		ps.setString(1,room);
		ps.setString(2,custID);
		ps.setDate(3,java.sql.Date.valueOf(from));
		ps.setDate(4,java.sql.Date.valueOf(to));
		rs4=ps.executeQuery();
		if(rs4.next()){
			x=rs4.getInt("bookId");
		}
		else{
			flag=0;
		}
	}
	else{
		flag=0;
	}
}else{
flag=0;
	JOptionPane.showMessageDialog(contentPane,"Can't set this date","Ok",JOptionPane.ERROR_MESSAGE);
	contentPane.disable();
}
}
if(flag==1){
JOptionPane.showMessageDialog(contentPane,"Booking ID:"+x+" ","Ok",JOptionPane.INFORMATION_MESSAGE);
contentPane.disable();
}
}
if(flag==0){
	JOptionPane.showMessageDialog(contentPane,"Error","Ok",JOptionPane.ERROR_MESSAGE);
 contentPane.disable();
}	
}catch(Exception w)
{w.printStackTrace();
}}} );

*/
		

