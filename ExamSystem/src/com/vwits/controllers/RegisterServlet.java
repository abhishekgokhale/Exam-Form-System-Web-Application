package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.db.MyDBConnection;
import com.vwits.db.StudentDAO;
import com.vwits.db.TeacherDAO;
import com.vwits.model.Student;
import com.vwits.model.Teacher;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		MyDBConnection db = new MyDBConnection();
		
		String name = request.getParameter("txtName");
		String pass = request.getParameter("txtPassword");
		String email = request.getParameter("txtEmail");
		int phno = Integer.parseInt(request.getParameter("txtPhone"));
		String type = request.getParameter("type");
		
		PreparedStatement ps = null;
		
		if(type.equals("Student")) {
			StudentDAO sdao = new StudentDAO();
			Student s = new Student(name, pass, email, phno);
			sdao.insert(s);
		}
		else if(type.equals("Teacher")) {
			TeacherDAO tdao = new TeacherDAO();
			Teacher t = new Teacher(name, pass, email, phno);
			tdao.insert(t);
		}
		
		RequestDispatcher r = request.getRequestDispatcher("register.jsp");
		request.setAttribute("message", "Registration Successful!");
		r.forward(request, response);
		
	}

}
