package com.sadiyaapp.servlets;


import java.io.IOException;

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
import com.sadiyaapp.model.Book;


@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {
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
			
		Long bookId = Long.parseLong(request.getParameter("bookid"));
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null) {
			
			Book book = DAO.getBookById(bookId);
			session.setAttribute("book", book);
			
			response.sendRedirect("./Purchase.jsp");
			return;
		}
		
		response.sendRedirect("./Home.jsp");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("userid") != null) {
			
			session.setAttribute("flag2", false);
			
			  int quantity = Integer.parseInt(request.getParameter("quantity"));
			  
			  if(((Book)session.getAttribute("book")).getStocks() >= quantity) {
				  
				  session.setAttribute("quantity", quantity);
				  response.sendRedirect("./Confirm.jsp");
				  return;
			  }
			  session.setAttribute("flag2", true);
			  response.sendRedirect("./dashboard");
			  return;
			
			
		}
		response.sendRedirect("./Home.jsp");
		
	
	}

}

