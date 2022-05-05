package com.sadiyaapp.servlets;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sadiyaapp.dao.EBookDAO;
import com.sadiyaapp.dao.EBookDAOImpl;
import com.sadiyaapp.dbutil.DBUtil;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EBookDAO DAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		ServletContext ctx = this.getServletContext();
	    DBUtil dbUtil = (DBUtil) ctx.getAttribute("db");
	    DAO = new EBookDAOImpl(dbUtil);

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    response.sendRedirect("./Registration.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("fullname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Timestamp registrationDate = new Timestamp(new Date().getTime());
		
		int result = DAO.registerUsers(name, address, email, username, password, registrationDate);
		
		if(result>0) {
			
			response.sendRedirect("./Login.jsp?regflag="+true);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("./Home.jsp");
		rd.include(request, response);
		response.getWriter().println("<center><p style='color:red'>Sorry can't register Something wen't wrong !!</p></center>");
		
		
		
	}

}

