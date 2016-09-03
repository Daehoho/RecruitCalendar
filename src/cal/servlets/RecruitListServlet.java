package cal.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cal.dao.RecruitDao;

@WebServlet("/list")
public class RecruitListServlet extends HttpServlet {
	@Override
	protected void doGet (
			HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");
			
			RecruitDao recruitDao = new RecruitDao();
			recruitDao.setConnection(conn);
			
			request.setAttribute("recruits", recruitDao.selectList());
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/RecruitList.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doPost (
			HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}
}
