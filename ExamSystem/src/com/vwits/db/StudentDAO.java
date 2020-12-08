package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Student;

public class StudentDAO {

	MyDBConnection db = new MyDBConnection();
	
	public void insert(Student s) {
		
		PreparedStatement ps = db.getPreparedStatement("insert into student values(?,?,?,?,?)");
		
		try {
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getPassword());
			ps.setString(4, s.getEmail());
			ps.setInt(5, s.getPhno());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
	}
	
	public void update(Student s) {
		
		PreparedStatement ps = db.getPreparedStatement("update student set name=?, password=?, email=?, phno=? where studentid=?");
		
		try {
			ps.setString(1, s.getName());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getEmail());
			ps.setInt(4, s.getPhno());
			ps.setInt(5, s.getId());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
	}
	
	public Student getStudent(String name) {
		
		Statement st = db.getStatement();
		Student s = null;
		
		try {
			ResultSet rs = st.executeQuery("select * from student where name='"+name+"'");
			
			while(rs.next()) {
				s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		return s;
	}
	
	public List<Student> getAll() {
		
		List<Student> list = new ArrayList<Student>();
		Student s = null;
		Statement st = db.getStatement();
		
		try {
			ResultSet rs = st.executeQuery("select * from student");
			
			while(rs.next()) {
				s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(s);
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
