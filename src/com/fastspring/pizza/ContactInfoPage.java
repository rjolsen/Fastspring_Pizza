package com.fastspring.pizza;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeliveryInfo
 */
@WebServlet("/ContactInfoPage")
public class ContactInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactInfoPage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title> Contact Info </title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h2> Enter your contact information </h2>");
		
		// Get Order ID from session:
		HttpSession session = request.getSession();
		int orderId = (Integer)session.getAttribute("OrderID");
		writer.print("<h3> Order number : "+orderId+"</h3>");
		writer.print("<form name='frm' method='post'>");
		writer.print("<table>");
		writer.print("<tr>");
		writer.print("<td> Name :</td>");
		writer.print("<td>");
		writer.print("<input type=\"text\" name=\"name\" placeholder=\"Enter Name\" required>");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("<tr>");
		writer.print("<td> Phone number: </td>");
		writer.print("<td>");
		writer.print("<input type=\"number\" name=\"mobile\" placeholder=\"Enter Phone Number\" min=\"0\" required>");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("<tr>");
		writer.print("<td>Address :</td>");
		writer.print("<td>");
		writer.print("<textarea name=\"address\" required></textarea>");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("</table>");
		writer.print("<br/><br/>");
		writer.print("<input type=\"submit\" value=\"Place Order\">");
		writer.print("</form>");
		writer.print("</body>");
		writer.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String name, address;
		long phoneNo;
		
		//Mandatory fields, will never be null:
		name = request.getParameter("name");
		address = request.getParameter("address");
		phoneNo = Long.parseLong(request.getParameter("mobile"));
		
		User usr = new User();
		usr.setAddress(address);
		usr.setName(name);
		usr.setPhoneNumber(phoneNo);
		
		HttpSession session = request.getSession();
		Order ord = (Order)session.getAttribute("Order");
		usr.setCurrentOrder(ord);
	
		// Add order to database :
		PendingOrders.insertOrder(ord.getOrderId(), usr);
		// Get rid of session
		session.invalidate(); 
		
		response.sendRedirect("TrackingPage?orderID="+ord.getOrderId());
	}
}