package com.abc;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class VistorCount
 */
public class VistorCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistorCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		String name = request.getParameter("uname");
		// SessionListener一定要有一個session事件觸發才會啟動,所以下面兩行是必要的動作,若無,SessionListener無法自行啟動
		HttpSession session = request.getSession();
		session.setAttribute("user", name);
		// end of key explain
		int total = (int) context.getAttribute("totalUsers");
		int current = (int) context.getAttribute("currentUsers");
		out.print("<p>"+"total visitors are: "+total+"</p><br>");
		out.print("<p>"+"you are visitor "+total+" now"+"</p><br>");
		out.print("<a href='LogOut'>logOut</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
