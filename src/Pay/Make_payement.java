package Pay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Make_payement
 */
@WebServlet("/pay")
public class Make_payement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Make_payement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		PrintWriter out2 = response.getWriter();
		String product_title = (String) session1.getAttribute("pID");
		String seller_name = (String) session1.getAttribute("_name");
		String seller_number = (String) session1.getAttribute("_phone");
		String price = (String) session1.getAttribute("_price");
		session1.setAttribute("prodt_price",price);
		session1.setAttribute("slname",seller_name);
		
		
		
	    out2.println("<h1>Title:</h1>"+product_title);
	    out2.println("<h1>Seller Name:</h1>"+seller_name);
	    out2.println("<h1>Contact on:</h1>"+seller_number);
	    out2.println("<h1>Price</h1>"+price);
	    out2.println( "<form action=\"DebitServlet\" method=\"post\"><input type=\"submit\" value=\"Proceed\"/></form>"+"</td></tr>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String prod = request.getParameter("ab");
		//System.out.println(prod);
		doGet(request, response);
	}

}
