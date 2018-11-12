package com.fastspring.pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateToppings
 */
@WebServlet("/UpdateToppings")
public class UpdateToppings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateToppings() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ArrayList<String> pizzaToppings = Pizza.getPizzaToppings();
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Control Toppings</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Update the toppings available: </h2>");
		writer.println("<form method='post'>");	
		
		writer.println("<div class='section group'>");
		writer.println("<ul>");
		for (int k=0; k<pizzaToppings.size(); k++) 
		{
			writer.println("<li class='li_2'>");					
			writer.println("<input type='checkbox' name='removeTopping' value='"+pizzaToppings.get(k)+"'/>");
			writer.println(pizzaToppings.get(k));
			writer.println("</li>");
		}
		writer.println("</ul>");
		writer.println("</div>");
		writer.println("<input type='submit' value='Remove' name='submit'/>");
		
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>Add topping: </td>");
		writer.println("<td>");
		writer.println("<input type='text' name='addTopping' placeholder='Enter topping name'>");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("<input type='submit' value='Add' name='submit'/>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("</form>");
		
		writer.println("</body>");
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("submit");
		
		if (action.equalsIgnoreCase("Remove")) {
			if (request.getParameterValues("removeTopping") != null)
			{
				String[] pizzaToppings = request.getParameterValues("removeTopping");
				for (int i = 0; i < pizzaToppings.length; i++)
				{
					Pizza.removePizzaTopings(pizzaToppings[i]);
				}
			}
		} 
		if (action.equalsIgnoreCase("Add")) {
			if (request.getParameter("addTopping") != null) 
			{
				String topping = request.getParameter("addTopping");
				Pizza.addPizzaToppings(topping);
			}
		}
		response.sendRedirect("UpdateToppings");
	}

}
