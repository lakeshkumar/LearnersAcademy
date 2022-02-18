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

import model.Teacher;


public class TeacherDao { 

	Session session = HibernateUtil.getConnection();  
	Transaction t = session.beginTransaction();

	public void addTeacher(HttpServletRequest request, HttpServletResponse response, String teachername, String teacheremail) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		Teacher teacher = new Teacher();
		teacher.setTeacher_name(teachername);		
		teacher.setTeacher_email(teacheremail);
		
		session.save(teacher);
		t.commit();
		session.close();
		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>");
		out.println("<a href='teachermgmt.jsp'>TEACHER MANAGEMENT</a></br></br>");
		out.println("<a href='logoutservlet'>LOGOUT</a></br></br>");
		out.println("<p style='color:green'>");
		out.println("Teacher added successfully..!!!");
		out.println("</p></center>");
	}
	
	public void showTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("header.html").include(request, response);
		TypedQuery query = session.createQuery("from Teacher"); 
		List<Teacher> list1 = query.getResultList(); 
		
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>");
		out.println("<a href='teachermgmt.jsp'>TEACHER MANAGEMENT</a></br></br>");
		out.println("<a href='logoutservlet'>LOGOUT</a></br>");
		out.println("<h2>Teacher Data</h2>");
		out.println("<table border='2' cellpadding='10'>");
		out.println("<tr>");
		out.println("<th>Teacher Id</th>");
		out.println("<th>Teacher Name</th>");
		out.println("<th>Teacher Email</th>");
		out.println("</tr>");
		for(Teacher t : list1)
		{
			out.println("<tr>");
			out.println("<td>"+t.getId()+"</td>");
			out.println("<td>"+t.getTeacher_name()+"</td>");
			out.println("<td>"+t.getTeacher_email()+"</td>"); 
			out.println("</tr>");
		}
		out.println("</table></center>");
		session.close();
	}	
}
