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
import model.Student;

public class StudentDao {

	Session session = HibernateUtil.getConnection(); 
	Transaction t = session.beginTransaction();

	public void addStudent(HttpServletRequest request, HttpServletResponse response, String studentname, String studentemail) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		Student student = new Student();
		student.setStudent_name(studentname);
		student.setStudent_email(studentemail);
		
		session.save(student); 
		t.commit();
		session.close();
		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>");
		out.println("<a href='studentmgmt.jsp'>STUDENT MANAGEMENT</a></br></br>");
		out.println("<a href='logoutservlet'>LOGOUT</a></br></br>");
		out.println("<p style='color:green'>");
		out.println("Student added successfully..!!!");
		out.println("</p></center>");
	}
	
	public void showStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("header.html").include(request, response);
		TypedQuery query = session.createQuery("from Student");
		List<Student> list1 = query.getResultList(); 
		
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>");
		out.println("<a href='studentmgmt.jsp'>STUDENT MANAGEMENT</a></br></br>");
		out.println("<a href='logoutservlet'>LOGOUT</a></br>");
		out.println("<h2>Student Data</h2>");
		out.println("<table border='2' cellpadding='10'>");
		out.println("<tr>");
		out.println("<th>Student Id</th>");
		out.println("<th>Student Name</th>");
		out.println("<th>Student Email</th>");
		out.println("</tr>");
		for(Student s : list1)
		{
			out.println("<tr>");
			out.println("<td>"+s.getId()+"</td>");
			out.println("<td>"+s.getStudent_name()+"</td>");
			out.println("<td>"+s.getStudent_email()+"</td>"); 
			out.println("</tr>");
		}
		out.println("</table></center>");
		session.close();
	}
}
