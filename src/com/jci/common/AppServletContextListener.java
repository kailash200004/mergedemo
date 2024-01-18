package com.jci.common;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class AppServletContextListener implements ServletContextListener{
	ServletContext ctx;
	//List<UserProperties> userPropertiesList=new ArrayList<UserProperties>();


	 Map<String, Integer> activeUsers = new ConcurrentHashMap<>();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed: ");

	}


	@Override
	public void contextInitialized(ServletContextEvent event) {
		/*System.out.println("ServletContextListener started:");
		ctx=arg0.getServletContext();
		ctx.setAttribute("userPropertiesList", userPropertiesList);
		*/System.out.println("ServletContextListener started:");
		 ServletContext context = event.getServletContext();
		context.setAttribute("activeUsers", activeUsers);
	}
}