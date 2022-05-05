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


@WebServlet("/resetpassword")
public class ResetPasswordServlet extends HttpServlet {
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
		
		response.sendRedirect("./ResetPassword.jsp?email="+request.getParameter("email")+"&username="+request.getParameter("username"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
				String email = request.getParameter("email");
				String username = request.getParameter("username");
				String newPassword = request.getParameter("newpass");
				String confirmPassword = request.getParameter("confirmpass");
				
				request.setAttribute("flag5", false);
				request.setAttribute("flag6", false);
		
				if(newPassword.equals(confirmPassword)) {
					 
					int result = DAO.resetPassword(email, username, newPassword);
					
					if(result >0) {
						
						response.sendRedirect("./login?flag5="+true);
						return;
					}
					
		
					return;
				}
				request.setAttribute("flag6", true);
				RequestDispatcher rd = request.getRequestDispatcher("./ResetPassword.jsp?email="+email+"&username="+username);
				rd.forward(request, response);
				
				return;
			
		
	}

}
