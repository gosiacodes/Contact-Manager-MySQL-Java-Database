package a.Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			String table = request.getParameter("table");
	        String nameContact = request.getParameter("nameContact");
	        String email = request.getParameter("email");
	        String address = request.getParameter("address");
	        String phone = request.getParameter("phone");	              
	          
	        if(checkEmpty(nameContact)) {
	        	out.println("<h2> You have to enter name! </h2>");		
			}
	        else if(checkEmpty(email)) {
	        	out.println("<h2> You have to enter email! </h2>");		
			}
	        else if(checkEmpty(address)) {
	        	out.println("<h2> You have to enter address! </h2>");		
			}
	        else if(checkEmpty(phone)) {
	        	out.println("<h2> You have to enter phone! </h2>");		
			}
	        else {
	        	aBean.setTable(table.trim());
	  	        aBean.setConName(nameContact.trim());
	  	        aBean.setEmail(email.trim());
	  	        aBean.setAddress(address.trim());
	  	        aBean.setPhone(phone.trim());
	        }
	      
			  
		    if(MySQLConnection.connectSQL()) {
		    	MySQLConnection.stateSQL();
			}
	        
		    if (table.equals("contact") || table.equals("customer")) {
		        out.println("<h1> Registered new contact to " + aBean.getTable() + "</h1>");
		        out.println("<p> Name: " + " " + aBean.getConName() + "</p>");
		        out.println("<p> E-mail: " + " " + aBean.getEmail() + "</p>");
		        out.println("<p> Address: " + " " + aBean.getAddress() + "</p>");
		        out.println("<p> Phone: " + " " + aBean.getPhone() + "</p>");
		    }
		    else {
		    	out.println("<h2> You have to choose table to register new contact (contact or customer)! </h2>");
		    }
				         
			} catch (Exception e) {
				System.out.println(e);
			}
		
		aBean.setTable("");
	    aBean.setConName("");
	    aBean.setEmail("");
	    aBean.setAddress("");
	    aBean.setPhone("");
		
		out.close();
		
	}
		
		 public static boolean checkEmpty(String value){
			    if(!(value==null))
			       return value.isEmpty();
			    return true;
		 }
  

}
