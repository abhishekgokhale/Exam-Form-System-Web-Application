package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Question;

public class QuestionDAO {
	
	MyDBConnection db = new MyDBConnection();
	
	public void insertQuestion(Question q) {
		PreparedStatement ps = db.getPreparedStatement("insert into exam values(?,?,?,?,?,?,?)");
		
		try {
			ps.setInt(1, q.getQuestionid());
			ps.setString(2, q.getQuestion());
			ps.setString(3, q.getOption1());
			ps.setString(4, q.getOption2());
			ps.setString(5, q.getOption3());
			ps.setString(6, q.getOption4());
			ps.setString(7, q.getCorrectoption());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
	}
	
	public void updateQuestion(Question q) {
		
		PreparedStatement ps = db.getPreparedStatement("update exam set question=?, option1=?, option2=?, option3=?, option4=?, correctoption=? where questionid=?");
		
		try {
			ps.setString(1, q.getQuestion());
			ps.setString(2, q.getOption1());
			ps.setString(3, q.getOption2());
			ps.setString(4, q.getOption3());
			ps.setString(5, q.getOption4());
			ps.setString(6, q.getCorrectoption());
			ps.setInt(7, q.getQuestionid());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
	}
	
	public List<Question> getAllQuestions() {
		Statement st = db.getStatement();
		List<Question> questions = new ArrayList<Question>();
		Question q = null;
		
		try {
			ResultSet rs = st.executeQuery("select * from exam");
			
			while(rs.next()) {
				q = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				questions.add(q);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questions;
	}
	
}
