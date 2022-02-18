package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.TeacherDao;

public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddTeacher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String teachername = request.getParameter("teachername");
		String teacheremail = request.getParameter("teacheremail");
		
		TeacherDao teacherdao = new TeacherDao();
		teacherdao.addTeacher(request, response, teachername, teacheremail); 
	}
}
