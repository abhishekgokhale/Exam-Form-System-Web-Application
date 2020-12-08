package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.db.QuestionDAO;
import com.vwits.model.Question;

@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String question = request.getParameter("txtQuestion");
		String option1 = request.getParameter("txtOption1");
		String option2 = request.getParameter("txtOption2");
		String option3 = request.getParameter("txtOption3");
		String option4 = request.getParameter("txtOption4");
		String optionCorrect = request.getParameter("txtOptionCorrect");
		
		QuestionDAO q = new QuestionDAO();
		Question ques = new Question(question, option1, option2, option3, option4, optionCorrect);
		q.insertQuestion(ques);
		
		RequestDispatcher r = request.getRequestDispatcher("addQuestion.jsp");
		request.setAttribute("message", "Question Inserted!");
		r.forward(request, response);
	}

}
