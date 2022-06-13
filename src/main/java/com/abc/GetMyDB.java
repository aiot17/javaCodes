package com.abc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Servlet implementation class GetMyDB
 */
public class GetMyDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyDB() {
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
		Connection conn = (Connection) context.getAttribute("conn");
		try {
			PreparedStatement ps = conn.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			HashMap<String, String> myDic = new HashMap<String, String>(); 
			while(rs.next()) {
				myDic.put(rs.getString(1), rs.getString(2));
//				out.print("<br>"+rs.getString(1)+" "+rs.getString(2));
			}conn.close();
			HttpSession session = request.getSession();
			session.setAttribute("myList", myDic);
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllDB.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
