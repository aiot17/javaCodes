package com.abc;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import jakarta.servlet.ServletContext;

/**
 * Application Lifecycle Listener implementation class SessionListen
 *
 */
public class SessionListen implements HttpSessionListener {
	ServletContext ctx = null;
	static int total = 0,current=0;
    /**
     * Default constructor. 
     */
    public SessionListen() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent ev)  { 
         // TODO Auto-generated method stub
    	total++;
    	current++;
    	ctx = ev.getSession().getServletContext();
    	ctx.setAttribute("totalUsers", total);
    	ctx.setAttribute("currentUsers", current);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent ev)  { 
         // TODO Auto-generated method stub
    	current--;
    	ctx.setAttribute("currentUsers", current);
    }
	
}
