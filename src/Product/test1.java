package Product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class test1
 */
@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test1() {
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
		response.setContentType("text/html");  
		PrintWriter out2 = response.getWriter();
		String myId;
		String n1=request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("myId",n1);
		 String n2=request.getParameter("phno");
			session.setAttribute("myph",n2);
	
	
		out2.print("<form action= \"add.jsp\" method=\"post\"><input type = \"submit\" name=\"add_product\" value= \"Submit an ADD\"/></form>");
	     // out1.print("<input type = \"submit\" name=\"buy_product\" value= \"Buy a Product\"/>");
		//RequestDispatcher rd=request.getRequestDispatcher("add.jsp");  
		
        //rd.forward(request,response);   
		out2.print("<form action=\"Search\" method=\"post\"><input type=\"text\" placeholder=\"Search Products\" name=\"ab\" class=\"abc\" /><select name=\"cat\"> <option value=\" \">Search by category</option>   <option value=\"car\">Car</option> <option value=\"book\">Book</option><option value=\"furn\">Furniture</option><option value=\"mobile\">Mobiles</option> </select><input type=\"submit\" value=\"Search\" /></form> ");
		out2.print("<form action= \"index.jsp\" method=\"post\"><input type = \"submit\" name=\"logout\" value= \"Logout\"/></form>");
		out2.print("<form action= \"credit.jsp\" method=\"post\"><input type = \"submit\" name=\"add_money\" value= \"ADD money in your Account\"/></form>");
		out2.println("<a href=\"index.jsp\"><img src=\"images/m.png\" height=\"80\" width=\"80\" style=\"margin-left:1200px; margin-top:-170px;\" /></a>");
		out2.close();
		doGet(request, response);
	}

}
