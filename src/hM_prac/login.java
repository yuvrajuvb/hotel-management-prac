package hM_prac;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit; 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.border.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.sql.*;

public class login extends JFrame implements ActionListener {

private JPanel contentPane;
private JTextField txtUsername;
private JPasswordField pwdwhatever;
JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
JButton btnForgotPassword ,btnSignUp,btnLogin;

	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
	PreparedStatement ps;
	ResultSet rs;
	/**
	 * Create the frame.
	 */
	public login() {
		super("LOGIN");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1368,768);
		//setBounds(100, 100, 465, 300);
		/*setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2
				);
		*/
		
		contentPane = new JPanel();
		/*{
		public void paintComponent(Graphics g) {  
			                     Image img = Toolkit.getDefaultToolkit().getImage(  
			                                login.class.getResource("/hotel management prac/src/images/Welcome-Image.jpg"));  
			                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			                 }  
			            };  
		
		*/
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Welcome to MYHOTEL");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		lblNewLabel.setBounds(380, 28, 585, 202);
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setText("");
		txtUsername.setBounds(681, 334, 142, 23);
		contentPane.add(txtUsername);
		txtUsername.setColumns(20);
		
		lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_1.setLabelFor(txtUsername);
		lblNewLabel_1.setBounds(514, 314, 135, 59);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_2.setBounds(514, 373, 135, 20);
		contentPane.add(lblNewLabel_2);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 16));
		btnLogin.setBounds(623, 405, 94, 39);
		contentPane.add(btnLogin);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSignUp.setBounds(752, 456, 135, 43);
		contentPane.add(btnSignUp);
		
		btnForgotPassword = new JButton("Forgot password");
		btnForgotPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		btnForgotPassword.setBounds(476, 456, 173, 43);
		contentPane.add(btnForgotPassword);
		
		pwdwhatever = new JPasswordField();
		pwdwhatever.setText("");
		pwdwhatever.setBounds(681, 374, 142, 20);
		contentPane.add(pwdwhatever);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(-111, 0, 1463, 729);
		label_1.setIcon(resizeIcon(new ImageIcon(login.class.getResource("/images/Welcome-Image.jpg")),
		label_1.getWidth() - label_1.getInsets().left, label_1.getHeight() - label_1.getInsets().left));
		contentPane.add(label_1);
		
		btnLogin.addActionListener(this);
        btnSignUp.addActionListener(this);
        btnForgotPassword.addActionListener(this);
	}
    	@Override
public void actionPerformed(ActionEvent ae) {
    		// TODO Auto-generated method stub
    		
Object o=ae.getSource();
if(o==btnLogin)
{				
String uname,pass;
uname=txtUsername.getText();
pass=pwdwhatever.getText();	
	try
       {
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
ps=con.prepareStatement("select * from account where username=? and password=?");
ps.setString(1,uname);
ps.setString(2,pass);
rs=ps.executeQuery();
if(rs.next())
{
System.out.println("Valid User.");
JOptionPane.showMessageDialog(this,"Valid User","Done",JOptionPane.INFORMATION_MESSAGE);
this.dispose();
rs.close();
ps.close();
new home().setVisible(true);
}
else
{
JOptionPane.showMessageDialog(this,"Incorrect","Error",JOptionPane.ERROR_MESSAGE);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
if(o==btnSignUp)
{
//this.dispose();
new sign_up().setVisible(true);
}   
if(o==btnForgotPassword)
{
//this.dispose();
new forgot().frame.setVisible(true);
}
}
}


