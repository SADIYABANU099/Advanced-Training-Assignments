package com.sadiyaapp.servlets;



import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

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


@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
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
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   HttpSession session = request.getSession();
	   
	   if(session.getAttribute("userid")!=null) {
		   
		   String custName = request.getParameter("custname");
		   String address = request.getParameter("address");
		   String phone = request.getParameter("phone");
		   
		   Long bookId = ((Book)session.getAttribute("book")).getId();
		   
		   Timestamp orderDate = new Timestamp(new Date().getTime());
		   
		   int quantity = (Integer)session.getAttribute("quantity");
		   
		   int result = DAO.addOrder(bookId, custName, phone, address, orderDate, quantity);
		   
		   if(result>0) {
			   
			   
			   response.sendRedirect("./Thankyou.jsp");
			   return;
		   }
		   
		   
	   }
	   response.sendRedirect("./Home.jsp");
	}

}

