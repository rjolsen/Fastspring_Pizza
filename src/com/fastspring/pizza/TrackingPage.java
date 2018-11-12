package com.fastspring.pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrackingPage
 */
@WebServlet("/TrackingPage")
public class TrackingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackingPage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trackingID;
		try {
			trackingID = (Integer)request.getAttribute("orderID");
		} catch (Exception e) {
			trackingID=-1;
		}
		
		if (trackingID == -1) {
			try {
				trackingID = Integer.parseInt(request.getParameter("orderID"));
			} catch(Exception e) {
				System.out.println("Exception in getting trackingID.");
			}
		}
		
		//Work with this OrderID and show status
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>");
		writer.println("Track Order");
		writer.println("</title>");
		writer.println("</head>");
		writer.println("<body>");		
		
		// If tracking Id exists
		if (PendingOrders.getOrder(trackingID) != null && trackingID != -1) 
		{ 
			User currUser = PendingOrders.getOrder(trackingID);
			Order currOrder = currUser.getCurrentOrder();
			int state = currOrder.getState();
			NumberFormat formatter = new DecimalFormat("#0.00");   
			
			writer.println("<h2> Order number : "+trackingID+" </h2>");
			writer.println("<h3> Total price - $"+formatter.format(currOrder.getTotalPrice())+"</h3>");
			writer.println("<h3> Progress : </h3>");
			writer.println("<ul>");
			writer.println("<li>");
			
			if (state > 0) {
				writer.println("<b>");
				writer.println("Order Placed");
				writer.println("</b>");
			} else {
				writer.println("Order Placed");
			}
			writer.println("</li>");
			writer.println("<li>");
			if (state > 1) {
				writer.println("<b>");
				writer.println("Preparation");
				writer.println("</b>");
			} else {
				writer.println("Preparation");
			}
			writer.println("</li>");
			writer.println("<li>");
			if (state > 2) {
				writer.println("<b>");
				writer.println("Baking");
				writer.println("</b>");
			} else {
				writer.println("Baking");
			}
			writer.println("</li>");
			writer.println("<li>");
			if (state > 3) {
				writer.println("<b>");
				writer.println("Out for Delivery");
				writer.println("</b>");
			} else {
				writer.println("Out for Delivery");
			}
			writer.println("</li>");
			writer.println("<li>");
			if (state > 4) {
				writer.println("<b>");
				writer.println("Delivered");
				writer.println("</b>");
			} else {
				writer.println("Delivered");
			}
			writer.println("</li>");
			writer.println("</ul>");
		} else {
			writer.println("Order with this tracking ID not placed yet");
		}
		writer.println("</body>");
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.sendRedirect("TrackingPage?orderID="+request.getParameter("orderID"));
	}

}