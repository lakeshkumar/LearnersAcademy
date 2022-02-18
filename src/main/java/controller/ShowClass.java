package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassRoomDao;

public class ShowClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClassRoomDao classroomdao = new ClassRoomDao(); 
		classroomdao.showClassRoom(request, response);
	}
}
