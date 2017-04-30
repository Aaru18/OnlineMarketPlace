package Product;


import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Mobile {
	Connection conn = null;
	PreparedStatement insertmob = null;
	ResultSet resultset = null;
	 public  Mobile() throws ClassNotFoundException {
			
		    
	 		try{
	 			 Class.forName("com.mysql.jdbc.Driver");
	 		    	String url = "jdbc:mysql://localhost:3306/Movie_Rating";
	 		    	String username ="root";
	 		    	String password = "livefree";
	 		    	
	 			conn = (Connection) DriverManager.getConnection(url,username,password);
	 			insertmob = (PreparedStatement) conn.prepareStatement("INSERT INTO mobile (title, descr, sname ,phone_no , city,price) "+"VALUES(?,?,?,?,?,?)");
	 		}catch(SQLException e){
	 			e.printStackTrace();
	 		}
	 	}
	 public int setmob(String title,String desc,String sname,String phone_no,String city,String price){
	 		int result=0;
	 		
	 		try{
	 			
					insertmob.setString(1,title);
	 			insertmob.setString(2,desc);
	 			insertmob.setString(3,sname);
	 			insertmob.setString(4,phone_no);
	 			insertmob.setString(5,city);
	 			insertmob.setString(6, price);
	 			result = insertmob.executeUpdate();
	 		}catch(SQLException e){
	 			e.printStackTrace();
	 		}
	 		return result;
	 	}
}
