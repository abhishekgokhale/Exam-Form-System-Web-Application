package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Teacher;

public class TeacherDAO {

	MyDBConnection db = new MyDBConnection();
	
	public void insert(Teacher t) {
		
		PreparedStatement ps = db.getPreparedStatement("insert into teacher values(?,?,?,?,?)");
		
		try {
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getEmail());
			ps.setInt(5, t.getPhno());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
	}
	
	public void update(Teacher t) {
		
		PreparedStatement ps = db.getPreparedStatement("update teacher set name=?, password=?, email=?, phno=? where teacherid=?");
		
		try {
			ps.setString(1, t.getName());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getEmail());
			ps.setInt(4, t.getPhno());
			ps.setInt(5, t.getId());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
	}
	
	public Teacher getTeacher(int id) {
		
		Statement st = db.getStatement();
		Teacher s = null;
		
		try {
			ResultSet rs = st.executeQuery("select * from teacher where teacherid="+id);
			
			while(rs.next()) {
				s = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
	
public List<Teacher> getAll() {
		
		List<Teacher> list = new ArrayList<Teacher>();
		Teacher s = null;
		Statement st = db.getStatement();
		
		try {
			ResultSet rs = st.executeQuery("select * from teacher");
			
			while(rs.next()) {
				s = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
