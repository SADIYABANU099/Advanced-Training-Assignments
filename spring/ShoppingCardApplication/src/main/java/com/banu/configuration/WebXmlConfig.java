package com.banu.configuration;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		  AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        
          context.register(DBConfig.class,ViewConfig.class);
        
          DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
	        
	        ServletRegistration.Dynamic customDispatcher = servletContext.addServlet("Mydispatcher", dispatcherServlet);
	        
	        customDispatcher.setLoadOnStartup(1);
	        
	        
	        customDispatcher.addMapping("/");
			
	}
	

	
}
    
