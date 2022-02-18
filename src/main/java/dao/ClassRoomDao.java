package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.ClassRoom;

public class ClassRoomDao {
	
	Session session = HibernateUtil.getConnection(); 
	Transaction t = session.beginTransaction();

	public void addClassRoom(HttpServletRequest request, HttpServletResponse response, String classname) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		ClassRoom classroom = new ClassRoom();
		classroom.setClass_name(classname);
		
		session.save(classroom);
		t.commit();
		session.close();
		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>");
		out.println("<a href='classmgmt.jsp'>CLASS MANAGEMENT</a></br></br>");  
		out.println("<a href='logoutservlet'>LOGOUT</a></br></br>");
		out.println("<p style='color:green'>");
		out.println("Class added successfully..!!!");
		out.println("</p></center>");
	}
	
	public void showClassRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("header.html").include(request, response);
		TypedQuery query = session.createQuery("from ClassRoom");
		List<ClassRoom> list1 = query.getResultList(); 
		
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>");
		out.println("<a href='classmgmt.jsp'>CLASS MANAGEMENT</a></br></br>");
		out.println("<a href='logoutservlet'>LOGOUT</a></br>");
		out.println("<h2>Class Data</h2>");
		out.println("<table border='2' cellpadding='10'>");
		out.println("<tr>");
		out.println("<th>Class Id</th>");
		out.println("<th>Class Name</th>");
		out.println("</tr>");
		for(ClassRoom c : list1)
		{
			out.println("<tr>");
			out.println("<td>"+c.getId()+"</td>");
			out.println("<td>"+c.getClass_name()+"</td>");
			out.println("</tr>");
		}
		out.println("</table></center>");
		session.close();
	}	
}
