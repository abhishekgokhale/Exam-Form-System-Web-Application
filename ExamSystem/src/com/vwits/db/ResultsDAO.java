package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Results;

public class ResultsDAO {

	MyDBConnection db = new MyDBConnection();
	
	public void insert(Results r) {
		
		PreparedStatement ps = db.getPreparedStatement("insert into results values(?,?,?)");
		
		try {
			ps.setInt(1, r.getStudentid());
			ps.setInt(2, r.getExamid());
			ps.setInt(3, r.getMarks());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
	}
	
	public List<Results> getResults(int id) {
		List<Results> list = new ArrayList<Results>();
		Statement st = db.getStatement();
		
		try {
			ResultSet rs = st.executeQuery("select * from results where studentid="+id);
			
			while(rs.next()) {
				list.add(new Results(rs.getInt(2), rs.getInt(1), rs.getInt(3)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
		return list;
		
	}
	
	public List<Results> getAll() {
		List<Results> list = new ArrayList<Results>();
		Statement st = db.getStatement();
		
		try {
			ResultSet rs = st.executeQuery("select * from results");
			
			while(rs.next()) {
				list.add(new Results(rs.getInt(2), rs.getInt(1), rs.getInt(3)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
		return list;
	}
	
}
