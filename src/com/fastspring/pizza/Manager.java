package com.fastspring.pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
    }
    
    HashMap<Integer, String> statusList = new HashMap<Integer, String>();
    {
    	statusList.put(1, "Order Placed");
    	statusList.put(2, "Preparation");
    	statusList.put(3, "Baking");
    	statusList.put(4, "Out for delivery");
    	statusList.put(5, "Delivered");
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Pending Orders</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Orders </h2>");
		writer.println("<table>");
		writer.println("<form method='post'>");
		
		HashMap<Integer, User> orderMap = PendingOrders.getOrders();
		
		for (Integer x : orderMap.keySet())
		{
			Order order = orderMap.get(x).getCurrentOrder();
			
			writer.println("<tr>");
			writer.println("<td>");
			writer.println(x);
			writer.println("</td>");
			writer.println("<td>");
			writer.println(statusList.get(order.getState()));
			writer.println("</td>");
			writer.println("<td>");
			
			ArrayList<String> pizzas = order.getPizzas();
			ArrayList<Integer> quantities = order.getQuantities();
			ArrayList<String> sizes = order.getSizes();
			
			for (int z = 0; z < pizzas.size(); z++)
			{
				writer.println("("+quantities.get(z)+"-"+sizes.get(z)+") "+pizzas.get(z)+" pizza");
				writer.println("</br>");
			}
			
			User usr = orderMap.get(x);
			writer.println("<td>");
			writer.println(usr.getName());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(usr.getAddress());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(usr.getPhoneNumberFormatted());
			writer.println("</td>");
			writer.println("<td>");
			writer.println("<input type=\"submit\" name=\""+x+"\" value=\"Update\"/>");
			writer.println("</td>");
			writer.println("</tr>");
		}
			
		writer.println("</form>");
		writer.println("</table>");
		
		writer.println("</br></br>");
		writer.println("<form action=\"UpdateToppings\" method=\"get\">");
		writer.println("<input type=\"submit\" value=\"UpdateToppings\"/>");
		writer.println("</form>");

		writer.println("</body>");
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for (String strOrder : request.getParameterMap().keySet())
		{
			PendingOrders.changeOrder(Integer.parseInt(strOrder));
		}
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Pending Orders</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Orders </h2>");
		writer.println("<table>");
		writer.println("<form method='post'>");
		
		HashMap<Integer, User> orderMap = PendingOrders.getOrders();
		
		if (orderMap != null && !orderMap.isEmpty())
		{
			for (Integer x : orderMap.keySet())
			{
				Order order = orderMap.get(x).getCurrentOrder();
	
				writer.println("<tr>");
				writer.println("<td>");
				writer.println(x);
				writer.println("</td>");
				writer.println("<td>");
				writer.println(statusList.get(order.getState()));
				writer.println("</td>");
				writer.println("<td>");
				
				ArrayList<String> pizzas = order.getPizzas();
				ArrayList<Integer> quantities = order.getQuantities();
				ArrayList<String> sizes = order.getSizes();
				
				for (int z = 0; z < pizzas.size(); z++)
				{
					writer.println("("+quantities.get(z)+"-"+sizes.get(z)+") "+pizzas.get(z)+" pizza");
					writer.println("</br>");
				}
				
				User usr = orderMap.get(x);
				writer.println("<td>");
				writer.println(usr.getName());
				writer.println("</td>");
				writer.println("<td>");
				writer.println(usr.getAddress());
				writer.println("</td>");
				writer.println("<td>");
				writer.println(usr.getPhoneNumberFormatted());
				writer.println("</td>");
				writer.println("<td>");
				writer.println("<input type=\"submit\" name=\""+x+"\" value=\"Update\"/>");
				writer.println("</td>");
				writer.println("</tr>");
			}
		} else {
			writer.println("<h4> No orders pending at this time. </h4>");
		}
		writer.println("</form>");
		writer.println("</table>");
		
		writer.println("</br></br>");
		writer.println("<form action=\"UpdateToppings\" method=\"get\">");
		writer.println("<input type=\"submit\" value=\"UpdateToppings\"/>");
		writer.println("</form>");
		
		writer.println("</body>");
		writer.println("</html>");
	}
}