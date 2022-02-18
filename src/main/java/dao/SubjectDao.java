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

import model.Subject;


public class SubjectDao {

	Session session = HibernateUtil.getConnection(); 
	Transaction t = session.beginTransaction();

	public void addSubject(HttpServletRequest request, HttpServletResponse response, String subjectname) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		Subject subject = new Subject();
		subject.setSubject_name(subjectname);
		
		session.save(subject);
		t.commit();
		session.close();
		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>"); 
		out.println("<a href='subjectmgmt.jsp'>SUBJECT MANAGEMENT</a></br></br>");
		out.println("<a href='logoutservlet'>LOGOUT</a></br></br>");
		out.println("<p style='color:green'>");
		out.println("Subject added successfully..!!!");
		out.println("</p></center>");
	}
	
	public void showSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("header.html").include(request, response);
		TypedQuery query = session.createQuery("from Subject");
		List<Subject> list1 = query.getResultList(); 
		
		out.println("<center>");
		out.println("<a href='dashboard.jsp'>DASHBOARD</a></br></br>");
		out.println("<a href='subjectmgmt.jsp'>SUBJECT MANAGEMENT</a></br></br>");
		out.println("<a href='logoutservlet'>LOGOUT</a></br>");
		out.println("<h2>Subject Data</h2>");
		out.println("<table border='2' cellpadding='10'>");
		out.println("<tr>");
		out.println("<th>Subject Id</th>");
		out.println("<th>Subject Name</th>");
		out.println("</tr>");
		for(Subject s : list1)
		{
			out.println("<tr>");
			out.println("<td>"+s.getId()+"</td>");
			out.println("<td>"+s.getSubject_name()+"</td>");
			out.println("</tr>");
		}
		out.println("</table></center>");
		session.close();
	}	
}
