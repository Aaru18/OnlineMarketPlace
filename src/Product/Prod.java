package Product;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Prod
 */
@WebServlet("/Prod")
public class Prod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	   
	    String c=request.getParameter("category");
	    System.out.println(c);
	    int result = 0;
	    String title = new String() ;
	 	   String desc = new String();
	 	   String sname = new String();
	 	   String phone_no = new String();
	 	   String city = new String();
 	       String pr = new String();
 	   if(request.getParameter("sub")!=null){
 	  
 	   if(request.getParameter("userTitle")!=null){
 		   title = request.getParameter("userTitle");
 	   }
 	   if(request.getParameter("Description")!=null){
 		   desc = request.getParameter("Description");
 	   }
 	   if(request.getParameter("usname")!=null){
 		   sname = request.getParameter("usname");
 	   }
 	   if(request.getParameter("usphone")!=null){
 		   phone_no = request.getParameter("usphone");
 		   
 		 
 	   }
 	   if(request.getParameter("city")!=null){
 		   city = request.getParameter("city");
 	   }
 	  if(request.getParameter("price")!=null){
		   pr = request.getParameter("price");
	   }
 	   }
	    if (c.equals("furniture")){
			try {
				Furniture f = new Furniture();
			
	    	   result = f.setfurnn(title, desc, sname, phone_no, city,pr);
	    	   } catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
	         }
	    if (c.equals("cars")){
        	
	    	   
	    	  
			try {
				Car cr = new Car();
			
	    	   result = cr.setcar(title, desc, sname, phone_no, city,pr);
	    	   } catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
	    	
	           }
	    if (c.equals("mobiles")){
        	
			try {
				Mobile mb = new Mobile();
			
	    	   result = mb.setmob(title, desc, sname, phone_no, city,pr);
	    	   } catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
	    	
	        }
	    if (c.equals("books")){
        	
			try {
				Books_etc bok = new Books_etc();
			
	    	   result = bok.setbkk(title, desc, sname, phone_no, city,pr);
	    	   } catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
            }
	    
        }
}
	    	