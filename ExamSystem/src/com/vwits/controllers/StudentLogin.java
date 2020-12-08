package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.db.MyDBConnection;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyDBConnection db = new MyDBConnection();
		PrintWriter out = response.getWriter();
		String user = request.getParameter("txtUsername");
		String pass = request.getParameter("txtPassword");
		int flag = 0;
		
		Statement st = db.getStatement();
		
		HttpSession sess = request.getSession(false);
		if(sess == null) {
			sess = request.getSession(true);
			System.out.println("Going to login");
			response.sendRedirect("studLogin.jsp");
			return;
		}
		
		String name = (String) sess.getAttribute("name");
		System.out.println("Sess name is = " + name);
		if(name != null) {
			user = name;
			flag = 1;
		}
		else {
			user = request.getParameter("txtUsername");
			pass = request.getParameter("txtPassword");
		}
		
		System.out.println("Final Username = " + user);
			
		try {
			ResultSet rs = st.executeQuery("select password from student where name='"+ user +"'");
			
			while(rs.next()) {
				if(rs.getString(1).equals(pass)) {
					flag = 1;
					break;
				}
			}
				
			if(flag == 1) {
				sess.setAttribute("name", user);
				response.sendRedirect("studProfile.jsp");
			}
			else {
				RequestDispatcher r = request.getRequestDispatcher("studLogin.jsp");
				request.setAttribute("errorMessage", "Invalid Username or Password!!");
				System.out.println("here");
				r.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
