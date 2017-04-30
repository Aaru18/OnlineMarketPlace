package Pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DebitServlet
 */
@WebServlet("/DebitServlet")
public class DebitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DebitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      HttpSession session1 = request.getSession();
			String debit_amount = (String) session1.getAttribute("prodt_price");
			String my_name = (String) session1.getAttribute("myId");
			 String slr_name = (String) session1.getAttribute("slname");
			
			PrintWriter out2 = response.getWriter();
			out2.print("<form action=\"test1\" method=\"post\"><input type=\"submit\" name=\"return_back\" value=\" Back \"></form>");
			  //out2.print("<form action= \"DebitServlet2\" method=\"post\"><input type = \"submit\" name=\"confirm\" value= \"Confirm\"/></form>");
			out2.println("<p>Your account has been debited of rupees  : "+debit_amount+" .</p>");
			try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            Connection con=DriverManager.getConnection(  
			            "jdbc:mysql://localhost:3306/Movie_Rating","root","livefree"); 
	             //Connection con1=DriverManager.getConnection(  
			           // "jdbc:mysql://localhost:3306/Movie_Rating","root","livefree"); 
	      
	           PreparedStatement ps1=con.prepareStatement("update bankAccount set acctBal=acctBal- "+debit_amount+" where uID='"+my_name+"' and acctBal>"+debit_amount);
	            PreparedStatement ps2=con.prepareStatement("update bankAccount set acctBal=acctBal+ "+debit_amount+" where uID='"+slr_name+"'");
	            ps1.executeUpdate();
	          	            ps2.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out2.close();
			}
	}

}
