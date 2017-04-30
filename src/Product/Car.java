package Product;
import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
public class Car {

	Connection conn = null;
	PreparedStatement insertcar = null;
	ResultSet resultset = null;
	 public  Car() throws ClassNotFoundException {
			
		    
 		try{
 			 Class.forName("com.mysql.jdbc.Driver");
 		    	String url = "jdbc:mysql://localhost:3306/Movie_Rating";
 		    	String username ="root";
 		    	String password = "livefree";
 		    	
 			conn = (Connection) DriverManager.getConnection(url,username,password);
 			insertcar = (PreparedStatement) conn.prepareStatement("INSERT INTO car (title, descr, sname ,phone_no , city,price) "+"VALUES(?,?,?,?,?,?)");
 		}catch(SQLException e){
 			e.printStackTrace();
 		}
 	}
	 public int setcar(String title,String desc,String sname,String phone_no,String city,String price){
 		int result=0;
 		
 		try{
 			
				insertcar.setString(1,title);
 			insertcar.setString(2,desc);
 			insertcar.setString(3,sname);
 			insertcar.setString(4,phone_no);
 			insertcar.setString(5,city);
 			insertcar.setString(6, price);
 			result = insertcar.executeUpdate();
 		}catch(SQLException e){
 			e.printStackTrace();
 		}
 		return result;
 	}
}
