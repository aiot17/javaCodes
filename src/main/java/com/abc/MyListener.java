package com.abc;

import java.sql.*;
import jakarta.servlet.*;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent ev)  { 
        String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false"; 
    	String jdbcUser = "root";
    	String jdbcPwd = "12345678";
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPwd);
			ServletContext ctx = ev.getServletContext();
			ctx.setAttribute("conn", conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
