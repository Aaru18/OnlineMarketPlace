<%@page import = "java.sql.* "%>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
      HttpSession session1 = request.getSession();
		String var = (String) session1.getAttribute("myId");
	    System.out.println(var);
		String var1 = (String) session1.getAttribute("myph");
	    System.out.println(var1);
      %>
     <form action ="Prod" method = "post">
     Ad Title:<input type="text" name="userTitle"><br/><br/>
     <label>Category:</label>  
     <select name="category">
         <option value=" ">Select</option>
         <option value="cars">Cars</option>
         <option value="mobiles">Mobile</option>
         <option value="books">Books,sports and Hobbies</option>
           <option value="furniture">Furniture</option>
     </select>
     <br></br>
     <label>Add Description:</label>
     <textarea rows = "10"
                  cols = "80" name = "Description"> 
                  Your text here</textarea>
      Ad Name:<input type="text" name="usname" value="<%=var%>" ><br/><br/>
      Ad Phone:<input type="text" name="usphone" value="<%=var1 %>"><br/><br/>
      Ad Price:<input type="text" name="price" ><br/><br/>
      Ad City:<input type="text" name="city"><br/><br/>
      <form action="index.jsp" method="post">
      <input type="submit" value="Submit" name ="sub"/>
      </form>
      
      </form>
     
</body>
</html>