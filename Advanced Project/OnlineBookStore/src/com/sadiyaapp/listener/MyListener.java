package com.sadiyaapp.listener;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sadiyaapp.dbutil.DBUtil;


@WebListener
public class MyListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	 ServletContext sc = sce.getServletContext();
    	 
    	 String url = "jdbc:mysql://localhost:3306/ebooks";
    	 String userName = "root";
    	 
    	 
    	 DBUtil db = new DBUtil(url , userName , null);
    	 
    	 sc.setAttribute("db", db);
   }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	((DBUtil)sce.getServletContext().getAttribute("db")).closeConnection();
    }

	
   
}
