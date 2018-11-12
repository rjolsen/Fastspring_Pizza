package com.fastspring.pizza;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Pizza Ranch</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Welcome to the Pizza Ranch </h2>");
		writer.println("</br></br>");
		writer.println("<form action=\"PizzaOrderPage\" method=\"get\">");
		writer.println("<input type=\"submit\" value=\"Place Order\"/>");
		writer.println("</form>");
		writer.println("</br></br>");
		writer.println("<form action=\"TrackOrder\" method=\"get\">");
		writer.println("<input type=\"submit\" value=\"Track Order\"/>");
		writer.println("</form>");
		writer.println("</br></br>");
		writer.println("<form action=\"UpdateToppings\" method=\"get\">");
		writer.println("<input type=\"submit\" value=\"Update Toppings\"/>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}