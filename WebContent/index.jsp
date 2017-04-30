<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter" %>
<html>
	<head>
		<title>
			Welcome Page
		</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
		
	</head>
	<body>
	
			<%
			HttpSession session1 = request.getSession(false);
	  		String var = (String) session1.getAttribute("myId");
	  		response.setContentType("text/html");  
			PrintWriter out2 = response.getWriter();  
			System.out.println(var);
			%>
				
				<% if(var != null) {
					out2.print("<form action= \"logout.jsp\" method=\"post\"><input type = \"submit\" style=\"margin-left : 1100px;\" name=\"logout\"  class= \"but\" value= \"Logout\"/></form>");
				}
				else{out2.print("<form action= \"login\" method=\"post\"><input type = \"submit\" style=\"margin-left : 1100px;\" name=\"login\" class= \"but\" value= \"Login\"/></form>");
				}
				
				%>
	
				<form action="register.jsp" method="post">
					<input type="submit" class="button" style="margin-left:1200px; margin-top :-25px;" value="Signup"/>
				</form>
				
				<div id="logo">
					<h1 class ="yo" style ="font-family:Avant Garde ;margin-left : 400px; margin-top :-580px;">
						Online Market Place
					</h1>
				</div>	
				
				
				<div style="margin-left:28px; margin-top:25px;width:100%">
				<form action="Search" method="post"><input type="text" placeholder="Search Products" name="ab" class="abc" size="80" /><select name="cat"> <option value=" ">Search by category</option>   <option value="car">Car</option> <option value="book">Book</option><option value="furn">Furniture</option><option value="mobile">Mobiles</option>  </select><input type="submit" value="Search"  style="height:25px; width:80px"/></form>
			
			<div id="nav" style=" margin-top:-80px; width:1300px;">
					<ul>
						<li class="first">
							<a href="MobileS"><img src="images/mobile-phone.png" alt="" height="30" width="30"  /></a>
						</li>
						
						<li>
							<a href="BooksS"><img src="images/book.png" alt="" height="30" width="30"  /></a>
						</li>
						<li>
							<a href="FurnitureS"><img src="images/sofa.png" alt="" height="30" width="30"  /></a>
						</li>
						
						<li>
							<a href="CarS"><img src="images/car.png" alt="" height="40" width="30"  /></a>
						</li>
					</ul><br class="clear" />
				</div>
			</div>
		
		<br>
		<br>
			<div id="banner" style="margin-top:-20px;margin-left:30px; ">
				
				<img src="images/2.jpg" alt="" height="500" width="1300" />
			
			</div>

<div>
	
			
					<h4 class="go" style="margin-left:500px; ">Copyright 2012 All rights reserved.</h4>
						
			

</div>
	</body>
</html>