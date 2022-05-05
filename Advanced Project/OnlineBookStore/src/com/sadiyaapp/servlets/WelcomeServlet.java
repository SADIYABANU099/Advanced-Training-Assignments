package com.sadiyaapp.servlets;



import java.io.IOException;
import java.util.List;

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


@WebServlet("/dashboard")
public class WelcomeServlet extends HttpServlet {
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
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userid") != null) {
			
			List<Book> books = DAO.getAllAvailableBooks();
			session.setAttribute("books", books);
			response.sendRedirect("./Welcome.jsp");
			return;
			
		}
		response.sendRedirect("./Home.jsp");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

