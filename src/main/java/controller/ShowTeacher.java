package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.TeacherDao;

public class ShowTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowTeacher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TeacherDao teacherdao = new TeacherDao(); 
		teacherdao.showTeacher(request, response);
	}
}
