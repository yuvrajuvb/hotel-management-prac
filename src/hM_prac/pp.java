package hM_prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class pp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*LocalDate endofCentury = LocalDate.parse("2014-07-11");
		LocalDate now = LocalDate.now();
		 
		Period diff = Period.between(endofCentury, now);

		System.out.printf("Difference is %d years, %d months and %d days old",
		  
		                   diff.getYears(), diff.getMonths(), diff.getDays());
	
	
	int[] a={1,2,3};
	String[] s=Arrays.toString(a).split("[\\[\\]]")[1].split(", "); 
	int i=s.length;
	i=i-1;
	while (i>0){
	System.out.println(s[i]);
	i--;
	}
	*/
		/*

		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		try
		   {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hm","hm");
		ps=con.prepareStatement("select roomno from room where releasedate<=? and next_book_date>=? and Floor=?");
		ps.setDate(1, java.sql.Date.valueOf("2018-07-10"));
		ps.setDate(2, java.sql.Date.valueOf("2018-07-12"));
		ps.setInt(3,2);
		rs=ps.executeQuery();
		int flag=0,i=0;
		while(rs.next())
		{ flag=1;
		//roomAva[i]=
		System.out.println(rs.getInt("roomno"));
		i++;
		//show avaiable rooms
		}
		if(flag==0){
			//JOptionPane.showMessageDialog(contentPane,"No Rooms Available","Ok",JOptionPane.ERROR_MESSAGE);
		}
		else if(flag==1){
			//new roomAva(roomAva);
		//	contentPane.remove(btnNewButton);
			//JOptionPane.showMessageDialog(contentPane,"Rooms Available","Ok",JOptionPane.ERROR_MESSAGE);
			//contentPane.add(btnBook);
		}	
	}catch (Exception w){
		w.printStackTrace();
	}
*/   	LocalDate rd = null,nbd = null,tooD=null,fromD=null;

	   // rd=	LocalDate.parse((CharSequence));
	  //  nbd=LocalDate.parse((CharSequence) rs.getDate(2));
	}

}
