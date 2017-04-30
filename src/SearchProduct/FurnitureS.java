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

/**
 * Servlet implementation class FurnitureS
 */
@WebServlet("/FurnitureS")
public class FurnitureS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FurnitureS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
	try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
		            "jdbc:mysql://localhost:3306/Movie_Rating","root","livefree");  
      
            PreparedStatement ps=con.prepareStatement("select * from furn");
            ResultSet rs=ps.executeQuery();  
            out.println("<a href=\"index.jsp\"><img src=\"images/m.png\" height=\"80\" width=\"80\" style=\"margin-left:10px;\" /></a>");
            while(rs.next())
            {
            	out.print("<br><b>Name:</b>"+rs.getString(1)+
          	    	  "<br><b>Description:</b>"+rs.getString(2)+
            	    	  "<br><b>Price:</b>"+rs.getString(6)+"<br>");
            }
            //out.println("<a href=\"index.jsp\"><img src=\"images/m.png\" height=\"80\" width=\"80\" style=\"margin-left:1200px; margin-top:-170px;\" /></a>");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
