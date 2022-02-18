package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin@123"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("dashboard.jsp");	
			HttpSession session1 = request.getSession(false); 
		}
		else
		{
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.println("<center> <p style='color:red'>");
			out.println("You have entered wrong username or password. Please try again");
			out.println("</p></center>");  
		} 
		out.close();   
	}
}
