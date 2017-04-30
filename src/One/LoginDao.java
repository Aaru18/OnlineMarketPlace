package One;

import java.sql.*;  

public class LoginDao extends Check {  

	public static boolean validate(String name,String phone,String pass){  
    boolean status=false;  
         try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
		            "jdbc:mysql://localhost:3306/Movie_Rating","root","livefree");  
      
            PreparedStatement ps=con.prepareStatement(  
            "select * from MyAccount where name=? and phone_no=? and pass=?");  
         ps.setString(1,name);  
         ps.setString(2,pass);  
         ps.setString(3, phone);
         Check c = new Check();
         c.Check(phone);
      
      ResultSet rs=ps.executeQuery();  
      status=rs.next();  
          }catch(Exception e){System.out.println(e);}  
             return status;  
            }  
 }  