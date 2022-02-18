package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassRoomDao;
import dao.StudentDao;

public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String studentname = request.getParameter("studentname");
		String studentemail = request.getParameter("studentemail");
		
		StudentDao studentdao = new StudentDao();
		studentdao.addStudent(request, response, studentname, studentemail); 	
	}
}
