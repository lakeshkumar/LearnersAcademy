package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassRoomDao;
import dao.SubjectDao;

public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddSubject() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String subjectname = request.getParameter("subjectname");
		
		SubjectDao subjectdao = new SubjectDao();
		subjectdao.addSubject(request, response, subjectname); 	
	}
}
