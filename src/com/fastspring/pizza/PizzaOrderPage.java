package com.fastspring.pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PizzaOrderPage
 */
@WebServlet("/PizzaOrderPage")
public class PizzaOrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrderPage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Set OrderID
		HttpSession session=request.getSession();
		int orderId = PendingOrders.getNumOrders();
		PendingOrders.incNumOrders();
		session.setAttribute("OrderID", orderId+1);
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Build it</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Select your pizza(s) </h2>");
		writer.println("<h3> Order number : "+(orderId+1)+"</h3>");
		writer.println("<form method='post'>");	
		
		Pizza p = new Pizza();
		ArrayList<String> pizzaList = p.getPizzaList();	
		ArrayList<String> pizzaSizes = p.getPizzaSizes();
		ArrayList<String> pizzaToppings = p.getPizzaToppings();
		
		for (int i = 0; i < pizzaList.size(); i++)
		{
			String pizza = pizzaList.get(i);
			writer.println("<table>");	
			writer.println("<tr>");
			writer.println("<td>");
			writer.println("<input type=\"checkbox\" name='pizza"+pizza+"'/>");
			writer.println(pizza);
			writer.println("</td>");
			writer.println("<td>Size : ");
			writer.println("<select name='size"+pizza+"'>");
			for (int j = 0; j < pizzaSizes.size(); j++)
			{
				String size = pizzaSizes.get(j);
				writer.println("<option value=\""+size.toLowerCase()+"\">"+size+"</option>");
			}
			writer.println("</select>");
			writer.println("</td>");
			writer.println("<td>Quantity : ");
			writer.println("<input type='number' name='quantity"+pizza+"' value=\"1\" min=\"1\"/>");
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("</table>");
			
			writer.println("<table>");
			writer.println("<tr>");
			
			writer.println("<h3>Extra Toppings</h3>");
			writer.println("<div class='section group'>");
			writer.println("<ul>");
			for ( int k=0; k<pizzaToppings.size(); k++) 
			{
				writer.println("<li class='li_2'>");					
				writer.println("<input type='checkbox' name='toppings"+pizza+"' value='"+pizzaToppings.get(k)+"'/>");
				writer.println(pizzaToppings.get(k));
				writer.println("</li>");
			}
			writer.println("</ul>");
			writer.println("</div>");
			writer.println("</br>");
		}
		writer.println("</br>");
		writer.println("<input type=\"submit\" value=\"Checkout\" name=\"submit\"/>");
		writer.println("<input type=\"reset\" value=\"Reset\" name=\"reset\"/>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order ord = new Order();
		boolean bOrderCreated = false;
		ArrayList<String> pizzas = new ArrayList<String>();
		ArrayList<String> sizes = new ArrayList<String>();
		ArrayList<Integer> quantities = new ArrayList<Integer>();
		ArrayList<String> toppings = new ArrayList<String>();
		double totalPrice = 0.00;
		
		Pizza p = new Pizza();
		ArrayList<String> pizzaList = p.getPizzaList();
		
		for (int i = 0; i < pizzaList.size(); i++)
		{
			String pizza = pizzaList.get(i);
			double price = 0.00;
			if (request.getParameter("pizza"+pizza) != null)
			{
				// Pizza price
				price = p.getPizzas().get(pizza);
				pizzas.add(pizza);
				
				// Size price
				String size = request.getParameter("size"+pizza);
				sizes.add(size);
				if (size.equalsIgnoreCase("Medium"))
				{
					price += 2.00;
				} else if (size.equalsIgnoreCase("Large")) {
					price += 3.00;
				}
				
				// Quantity price
				int pizzaNum = Integer.parseInt(request.getParameter("quantity"+pizza));
				quantities.add(pizzaNum);
				price = price * pizzaNum;
				
				// Toppings price
				if (request.getParameterValues("toppings"+pizza) != null)
				{
					String[] pizzaToppings = request.getParameterValues("toppings"+pizza);
					
					for (int j = 0; j < pizzaToppings.length; j++)
					{
						toppings.add(pizzaToppings[j]);
					}
					price += toppings.size() * 1.25;
				}
				
				// Total price for pizza
				totalPrice += price;
				
				bOrderCreated = true;
			}
		}	
		
		HttpSession session=request.getSession();
		int orderID = (Integer)session.getAttribute("OrderID");
		
		if (bOrderCreated)
		{
			ord.setPizzas(pizzas);
			ord.setSizes(sizes);
			ord.setQuantities(quantities);
			ord.setToppings(toppings);
			ord.setTotalPrice(totalPrice);
			
			// Uses last used order ID, increments it and puts it in OrderID of current order
			ord.setOrderId(orderID);
			ord.setState(1);
			
			// Adding pizza order to session for being used in the next page
			session.setAttribute("Order", ord);
			response.sendRedirect("ContactInfoPage");
		}	
		else
		{
			// No oder created try again
			PendingOrders.decNumOrders();
			response.sendRedirect("PizzaOrderPage");
		}
	}
}