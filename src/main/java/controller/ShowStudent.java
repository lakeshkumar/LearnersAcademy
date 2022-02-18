package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassRoomDao;
import dao.StudentDao;

public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StudentDao studentdao = new StudentDao(); 
		studentdao.showStudent(request, response);	
	}
}
