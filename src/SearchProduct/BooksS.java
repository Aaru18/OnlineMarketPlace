package SearchProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BooksS
 */
@WebServlet("/BooksS")
public class BooksS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
	
		
	try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
		            "jdbc:mysql://localhost:3306/Movie_Rating","root","livefree");  
      
            PreparedStatement ps=con.prepareStatement("select * from book");
            ResultSet rs=ps.executeQuery();  
            out.println("<a href=\"index.jsp\"><img src=\"images/m.png\" height=\"80\" width=\"80\" style=\"margin-left:10px;\" /></a>");
            while(rs.next())
            {
            	out.print("<br><b>Name:</b><a href=\"extra \">"+rs.getString(1)+
          	    	  "</a><br><b>Description:</b>"+rs.getString(2)+
            	    	  "<br><b>Price:</b>"+rs.getString(6)+"<br>");
            }
       
           
		}
	catch(Exception e){System.out.println(e);}
	finally{
		out.close();
	}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
}
