package Product;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Books_etc {
 
	Connection conn = null;
	PreparedStatement insertbk = null;
	ResultSet resultset = null;
	 public  Books_etc() throws ClassNotFoundException {
			
		    
	 		try{
	 			 Class.forName("com.mysql.jdbc.Driver");
	 		    	String url = "jdbc:mysql://localhost:3306/Movie_Rating";
	 		    	String username ="root";
	 		    	String password = "livefree";
	 		    	
	 			conn = (Connection) DriverManager.getConnection(url,username,password);
	 			insertbk = (PreparedStatement) conn.prepareStatement("INSERT INTO book (title, descr, sname ,phone_no , city,price) "+"VALUES(?,?,?,?,?,?)");
	 		}catch(SQLException e){
	 			e.printStackTrace();
	 		}
	 	}
	 public int setbkk(String title,String desc,String sname,String phone_no,String city,String price){
	 		int result=0;
	 		
	 		try{
	 			
					insertbk.setString(1,title);
	 			insertbk.setString(2,desc);
	 			insertbk.setString(3,sname);
	 			insertbk.setString(4,phone_no);
	 			insertbk.setString(5,city);
	 			insertbk.setString(6, price);
	 			result = insertbk.executeUpdate();
	 		}catch(SQLException e){
	 			e.printStackTrace();
	 		}
	 		return result;
	 	}
}
