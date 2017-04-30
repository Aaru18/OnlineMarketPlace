package SearchProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static String xy;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String name_p=request.getParameter("ab");  
		String category=request.getParameter("cat");
		
	
		try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
		            "jdbc:mysql://localhost:3306/Movie_Rating","root","livefree");  
      
            PreparedStatement ps=con.prepareStatement("select * from "+ category +" where title = '"+name_p+"'");  
        // ps.setString(1,name_p);   
            out.print("<table width=50% border=1>");  
            out.print("<caption>Result:</caption>");  
      ResultSet rs=ps.executeQuery();  
      ResultSetMetaData rsmd=rs.getMetaData();  
      int total=rsmd.getColumnCount();  
      out.print("<tr>");  
      for(int i=1;i<=total;i++)  
      {  
      out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
      }  
        
      out.print("</tr>");  
      //xy=rs.getString(1);
     
        

      	rs.next();
  		HttpSession session = request.getSession();
  		session.setAttribute("pID",rs.getString(1));
  		session.setAttribute("_name",rs.getString(3));
  		session.setAttribute("_phone",rs.getString(4));
  		session.setAttribute("_price",rs.getString(6));
    	  out.print("<tr><td> "+rs.getString(1)+
    	  "</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+
    	  "</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+
    	  "</td><td>"+rs.getString(6)+"</td><td>"+"NO ");
    	  HttpSession session1 = request.getSession(false);
  		  String var = (String) session1.getAttribute("myId");
    	  System.out.println(session);
  		  System.out.println(var);
    	  if (var != null) {
    		

    		 out.print( "<form action=\"pay\" method=\"post\"><input type=\"submit\" value=\"BUY\"/></form>"+"</td></tr>");
           }
    	  
    	  else{
    		  out.print( "<form action=\"index.jsp\" method=\"post\"><input type=\"submit\" value=\"BUY\"/></form>"+"</td></tr>");
           }
    	  
    	  	
    	 
       
       if(request.getParameter("p")!=null){
    	   String status = request.getParameter("p");
           out.println(status);
       }
          }catch(Exception e){System.out.println(e);}
		finally{
			out.close();

	    	  if(request.getParameter("buy")!=null){
	    		  System.out.println("smnnkdekff");
	    	  }
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