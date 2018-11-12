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
 * Servlet implementation class TrackOrder
 */
@WebServlet("/TrackOrder")
public class TrackOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackOrder() {
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
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>Track Order</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h2>Enter Tracking ID</h2>");
		writer.print("<body>");
		writer.print("<form method='post'>");
		writer.print("<table>");
		writer.print("<tr>");
		writer.print("<td>Tracking ID: </td>");
		writer.print("<td>");
		writer.print("<input type='number' name='orderID' min=\"1\" required >");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("</table>");
		writer.print("</br>");
		writer.print("<input type=\"submit\" value=\"Track\" >");
		writer.print("</form>");
		writer.print("</body>");
		writer.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.sendRedirect("TrackingPage?orderID="+request.getParameter("orderID"));
	}
}