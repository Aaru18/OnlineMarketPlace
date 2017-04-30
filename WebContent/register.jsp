<%@page import="java.sql.*" %>

<%Class.forName("com.mysql.jdbc.Driver"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>  
    <style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

.yo {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 10%;
    border-radius: 50%;
}

.container {
    padding: 16px;
    margin-left:480px;
    width:25%;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
    <body> 
    <%! 
    public class User {
    	String url = "jdbc:mysql://localhost:3306/Movie_Rating";
    	String username ="root";
    	String password = "livefree";
    	Connection conn = null;
    	PreparedStatement insertActors = null;
    	ResultSet resultset = null;
    	public User (){
    		try{
    			conn = DriverManager.getConnection(url,username,password);
    			insertActors = conn.prepareStatement("INSERT INTO MyAccount (name,pass,phone_no) "+"VALUES(?,?,?)");
    		}catch(SQLException e){
    			e.printStackTrace();
    		}
    	}
    	public int setActors(String name,String pass,String number){
    		int result=0;
    		
    		try{
    			insertActors.setString(1,name);
    			insertActors.setString(2,pass);
    			insertActors.setString(3,number);
    			result = insertActors.executeUpdate();
    		}catch(SQLException e){
    			e.printStackTrace();
    		}
    		return result;
    	}
    	
    			
    }
    
    %>  
    <%
   int result = 0;
   if(request.getParameter("submit")!=null){
   String uname = new String() ;
   String password = new String();
   String number = new String();
   if(request.getParameter("userName")!=null){
	   uname = request.getParameter("userName");
   }
   if(request.getParameter("userPass")!=null){
	   password = request.getParameter("userPass");
   }
   if(request.getParameter("userph")!=null){
	   number=request.getParameter("userph");
	   System.out.printf(number);
   }
   
   User actor = new User();
   result = actor.setActors(uname, password,number);
   }
   %> 
    
    
      <h2>SignUp Form</h2>

<form action="register.jsp" method="POST">
  <div class="imgcontainer">
    <img src="images/avatar2.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="userName"  required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="userPass"  required>
    
    <label><b>Mobile Number</b></label>
    <input type="text" placeholder="Enter Mobile Number" name="userph"  required>
        
    <input type="submit" class="yo" name="submit" value="Register"/>
    
  </div>

  <div class="container" >
    
    <a href="${pageContext.request.contextPath}/" class="cancelbtn">Cancel</a>
    
  </div>
</form>

</body>
</html>
    