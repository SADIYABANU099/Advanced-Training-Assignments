package com.sadiyaapp.servlets;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sadiyaapp.dao.EBookDAO;
import com.sadiyaapp.dao.EBookDAOImpl;
import com.sadiyaapp.dbutil.DBUtil;
import com.sadiyaapp.model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private  EBookDAO DAO;
	
	@Override
	public void init() throws ServletException {
		super.init();

		ServletContext ctx = this.getServletContext();
	    DBUtil dbUtil = (DBUtil) ctx.getAttribute("db");
	    DAO = new EBookDAOImpl(dbUtil);

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	   response.sendRedirect("./Login.jsp?flag5="+request.getParameter("flag5"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = DAO.validateLogin(username, password);
		
		request.setAttribute("flag1", false);
		
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", user.getId());
			response.sendRedirect("./dashboard");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("./Login.jsp");
		
		request.setAttribute("flag1", true);
		rd.forward(request, response);
		
	}

}
