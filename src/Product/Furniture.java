package Product;

import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Furniture {

	Connection conn = null;
	PreparedStatement insertfurn = null;
	ResultSet resultset = null;
	 public  Furniture() throws ClassNotFoundException {
		
	    
	    		try{
	    			 Class.forName("com.mysql.jdbc.Driver");
	    		    	String url = "jdbc:mysql://localhost:3306/Movie_Rating";
	    		    	String username ="root";
	    		    	String password = "livefree";
	    		    	
	    			conn = (Connection) DriverManager.getConnection(url,username,password);
	    			insertfurn = (PreparedStatement) conn.prepareStatement("INSERT INTO furn (title, descr, sname ,phone_no , city,price) "+"VALUES(?,?,?,?,?,?)");
	    		}catch(SQLException e){
	    			e.printStackTrace();
	    		}
	    	}
	    	public int setfurnn(String title,String desc,String sname,String phone_no,String city,String price){
	    		int result=0;
	    		
	    		try{
	    			
					insertfurn.setString(1,title);
	    			insertfurn.setString(2,desc);
	    			insertfurn.setString(3,sname);
	    			insertfurn.setString(4,phone_no);
	    			insertfurn.setString(5,city);
	    			insertfurn.setString(6,price);
	    			result = insertfurn.executeUpdate();
	    		}catch(SQLException e){
	    			e.printStackTrace();
	    		}
	    		return result;
	    	}
	    	
	    }

