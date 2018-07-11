package hM_prac;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class sign_up extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtMukesh;
	private JTextField textField;
	private JTextField textField_3;
	JButton btnSubmit,btnCheckAvailablity;
	JComboBox comboBox; 
	JLabel label;
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("yes");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_up frame = new sign_up();
					frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sign_up() {
		//super("login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(382, 186, 127, 20);
		contentPane.add(label);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Verdana", Font.BOLD, 20));
		lblSignUp.setBounds(128, 11, 282, 24);
		contentPane.add(lblSignUp);
		
		txtMukesh = new JTextField();
		txtMukesh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMukesh.setColumns(20);
		txtMukesh.setBounds(281, 120, 228, 20);
		contentPane.add(txtMukesh);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(78, 123, 142, 14);
		contentPane.add(lblName);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(78, 154, 142, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(78, 220, 142, 14);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSecurityQuestion.setBounds(78, 245, 160, 14);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAnswer.setBounds(78, 279, 142, 14);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(20);
		textField.setBounds(281, 151, 228, 20);
		contentPane.add(textField);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(20);
		textField_3.setBounds(281, 276, 228, 20);
		contentPane.add(textField_3);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(214, 322, 107, 31);
		contentPane.add(btnSubmit);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your Birth Place?", "What is your Pet's name?", "What is the name of your first school?"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(281, 245, 228, 20);
		contentPane.add(comboBox);
		
		btnCheckAvailablity = new JButton("Check Availablity");
		btnCheckAvailablity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckAvailablity.setBounds(180, 186, 181, 23);
		contentPane.add(btnCheckAvailablity);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(281, 217, 228, 17);
		contentPane.add(passwordField);
		
		btnBack = new JButton("<-");
		btnBack.setBounds(24, 16, 58, 23);
		contentPane.add(btnBack);
		
		label_1 = new JLabel("");
		label_1.setBounds(0, 0, 538, 461);
		label_1.setIcon(resizeIcon(new ImageIcon(sign_up.class.getResource("/images/signup-new.png")),
				label_1.getWidth() - label_1.getInsets().left, label_1.getHeight() - label_1.getInsets().left));
				
		contentPane.add(label_1);
		btnCheckAvailablity.addActionListener(this);
		btnSubmit.addActionListener(this);
		btnBack.addActionListener(this);
	}
Connection con;
PreparedStatement ps;
ResultSet rs;
private JPasswordField passwordField;
private JButton btnBack;
private JLabel label_1;

public void actionPerformed(ActionEvent ae) {
	// TODO Auto-generated method stub


Object o=ae.getSource();
String uname;

if(o==btnCheckAvailablity)
{				
	uname=textField.getText();	

try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
ps=con.prepareStatement("select * from account where username=? ");
ps.setString(1,uname);
rs=ps.executeQuery();
if(rs.next())
{System.out.println("iop");
label.setText("Unavailable");
getContentPane().add(label);
revalidate();
repaint();
}
else
{System.out.println("op");
label.setText("Available");
getContentPane().add(label);
btnCheckAvailablity.setText("Available");
//revalidate();
//repaint();
}
}
catch(Exception e)
{
System.out.println(e);
}
}

if(o==btnSubmit)
{ String secq,pass,ans,name;
int sec;
secq="error";
name=txtMukesh.getText();
pass=passwordField.getText();
ans=textField_3.getText();
uname=textField.getText();	
sec=comboBox.getSelectedIndex();
switch(sec){
case 0: secq="What is you birth place?";
break;
case 1: secq="What is you pet's name?";
break;
case 2: secq="What is the name of your first school?";
break;
case -1:
JOptionPane.showMessageDialog(this,"Invalid choice","Error",JOptionPane.ERROR_MESSAGE);
default:break;
}
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
ps=con.prepareStatement("insert into account values(?,?,?,?,?)");
//System.out.println(name+"?"+uname+"/"+pass+";"+secq+"]"+ans);
ps.setString(1,name);
ps.setString(2,uname);
ps.setString(3,pass);
ps.setString(4,secq);
ps.setString(5,ans);
rs=ps.executeQuery();
if(rs==null){
JOptionPane.showMessageDialog(this,"Error!!User not created","error",JOptionPane.ERROR_MESSAGE);	
}
else{
JOptionPane.showMessageDialog(this,"User created","done",JOptionPane.INFORMATION_MESSAGE);
this.dispose();
setVisible(false);
}}catch(Exception e){
	e.printStackTrace();
}

}
if(o==btnBack)
{this.dispose();
setVisible(false);
//new login().setVisible(true);
}
}
}
