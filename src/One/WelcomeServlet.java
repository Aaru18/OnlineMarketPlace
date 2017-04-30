package One;

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
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/servlet2")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
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
		
		
		PrintWriter out1 = response.getWriter();  
		      
		String n=request.getParameter("userName");  
		
		out1.print("Welcome "+n);  
		    //  out1.print("<form action= "" method="post"><input type = \"submit\" name=\"add_product\" value= \"Submit an ADD\"/></form>");
		     // out1.print("<input type = \"submit\" name=\"buy_product\" value= \"Buy a Product\"/>");
		      
			  RequestDispatcher rd=request.getRequestDispatcher("test1");  
	        rd.include(request,response);      
		    out1.close();  
	}

	}

