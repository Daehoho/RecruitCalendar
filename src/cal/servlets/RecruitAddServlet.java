package cal.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cal.dao.RecruitDao;
import cal.vo.Recruit;

@WebServlet("/add")
public class RecruitAddServlet extends HttpServlet {
	@Override
	protected void doGet (
			HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/RecruitAdd.jsp");
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
		try {
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection) sc.getAttribute("conn");
			
			RecruitDao recruitDao = new RecruitDao();
			recruitDao.setConnection(conn);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			recruitDao.insert(new Recruit()
					.setKind(request.getParameter("kind"))
					.setName(request.getParameter("name"))
					.setStart(new Date(format.parse(request.getParameter("start")).getTime()))
					.setEnd(new Date(format.parse(request.getParameter("end")).getTime()))
					.setUrl(request.getParameter("url")));
			response.sendRedirect("add");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
