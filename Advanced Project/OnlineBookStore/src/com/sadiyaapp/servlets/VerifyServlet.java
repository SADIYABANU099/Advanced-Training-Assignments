package com.sadiyaapp.servlets;


import java.io.IOException;

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


@WebServlet("/verify")
public class VerifyServlet extends HttpServlet {
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
		
		response.sendRedirect("./Verify.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			String email = request.getParameter("email");
			String username = request.getParameter("uname");
			request.setAttribute("flag3", false);

			if(DAO.verifyUser(email, username)) {
				
				response.sendRedirect("./resetpassword?email="+email+"&username="+username);
				return;
			}
			
			request.setAttribute("flag3", true);
			RequestDispatcher rd = request.getRequestDispatcher("./Verify.jsp");
			rd.forward(request, response);
			
			
	}
	
}

