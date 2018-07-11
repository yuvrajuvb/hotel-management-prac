package hM_prac;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class forgot extends JFrame implements ActionListener{
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	JButton btnSubmit,btnSubmitAnswer;
	JLabel label,lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("hh");
					forgot window = new forgot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public forgot() {
		//super("login");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 425);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(99, 77, 147, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_5 = new JLabel("Forgot password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(118, 11, 338, 29);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBackground(Color.WHITE);
		textField.setBounds(318, 77, 180, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSubmit = new JButton("Submit ");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(203, 118, 154, 23);
		frame.getContentPane().add(btnSubmit);
		
		label = new JLabel("..");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBackground(Color.BLACK);
		label.setBounds(318, 161, 180, 23);
		//frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(318, 208, 180, 23);
		//frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnSubmitAnswer = new JButton("Submit Answer");
		btnSubmitAnswer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmitAnswer.setBackground(Color.WHITE);
		btnSubmitAnswer.setBounds(201, 245, 166, 23);
		
		lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSecurityQuestion.setBounds(99, 161, 147, 14);
		
		lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAnswer.setBounds(101, 217, 145, 14);
		
		lblNewLabel_3 = new JLabel("New Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(99, 292, 147, 23);
		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(318, 294, 180, 23);
		//frame.getContentPane().add(passwordField);	
		
		
		btnSubmitPassword = new JButton("Submit password");
		btnSubmitPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmitPassword.setBounds(190, 338, 182, 23);
		
		btnSubmit.addActionListener(this);
		btnSubmitAnswer.addActionListener(this);
		
		
		
		/*
		frame.getContentPane().add(lblSecurityQuestion);
		frame.getContentPane().add(label);
		frame.getContentPane().add(lblAnswer);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(btnSubmitAnswer);

		frame.getContentPane().add(lblNewLabel_3);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(lblNewLabel_3);
		frame.getContentPane().add(btnSubmitPassword);
		*/
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(forgot.class.getResource("/images/forgot-bg.jpg")));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(0, 0, 575, 386);
		frame.getContentPane().add(label_1);
		

		
	}


Connection con;
PreparedStatement ps;
ResultSet rs;
private JButton btnSubmitPassword;
private JLabel lblSecurityQuestion;
private JLabel lblAnswer;
private JLabel label_1;

public void actionPerformed(ActionEvent ae) {
Object o=ae.getSource();
String uname;
if(o==btnSubmit)
{System.out.println("ques");		
uname=textField.getText();
try
   {
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
ps=con.prepareStatement("select security_question from account where username=?");
ps.setString(1,uname);
rs=ps.executeQuery();
if(rs.next())
{
	String secq=rs.getString("security_question");
	System.out.println("question"+secq);
	label.setText(secq);
	frame.getContentPane().remove(btnSubmit);
	frame.getContentPane().add(lblSecurityQuestion);
	frame.getContentPane().add(label);
	frame.getContentPane().add(lblAnswer);
	frame.getContentPane().add(textField_1);
	frame.getContentPane().add(btnSubmitAnswer);
	
	frame.getContentPane().revalidate();
	frame.getContentPane().repaint();
	revalidate();
	repaint();
}
else if(rs==null){
	JOptionPane.showMessageDialog(this,"No such user","Error",JOptionPane.ERROR_MESSAGE);
}
else
{
JOptionPane.showMessageDialog(this,"Invalid User","Error",JOptionPane.ERROR_MESSAGE);
}

}
catch(Exception e)
{
System.out.println(e);
}
}
else if(o==btnSubmitAnswer)
{
	//System.out.println("jj");
	String ans;
	uname=textField.getText();
	ans=textField_1.getText();
	try
	   {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
	ps=con.prepareStatement("select * from account where username=? and answer=?");
	ps.setString(1,uname);
	ps.setString(2,ans);
	rs=ps.executeQuery();
	if(rs.next())
	{ revalidate();
	repaint();
	System.out.println("jj");
	
	frame.getContentPane().remove(btnSubmitAnswer);
	frame.getContentPane().add(lblNewLabel_3);
	frame.getContentPane().add(passwordField);
	frame.getContentPane().add(lblNewLabel_3);
	frame.getContentPane().add(btnSubmitPassword);

	btnSubmitPassword.addActionListener(this);
	frame.revalidate();
	frame.repaint();
	pack();
	}
	else{
		JOptionPane.showMessageDialog(this,"Wrong answer","Error",JOptionPane.ERROR_MESSAGE);
	}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
else if(o==btnSubmitPassword){
	String pass;
	uname=textField.getText();
	pass=passwordField.getText();
	try
	   {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
	ps=con.prepareStatement("update account set  password=? where username=?");
	ps.setString(1,pass);
	ps.setString(1,uname);
	System.out.println(pass+uname);
	rs=ps.executeQuery();
	if(rs==null)
	{
		JOptionPane.showMessageDialog(this,"Error","Error",JOptionPane.ERROR_MESSAGE);
	}
	else{
		JOptionPane.showMessageDialog(this,"Password reset","Error",JOptionPane.ERROR_MESSAGE);
		this.dispose();
		setVisible(false);
	}}catch(Exception e){
		e.printStackTrace();
	}
}
}
}
