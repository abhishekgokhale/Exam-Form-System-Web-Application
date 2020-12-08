package com.vwits.model;

public class Results {
	private int examid, studentid, marks;
	private static int count=1000;

	public Results() {
		// TODO Auto-generated constructor stub
	}
	
	public Results(int studentid, int marks) {
		count++;
		this.examid = count;
		this.studentid = studentid;
		this.marks = marks;
	}
	
	public Results(int examid, int studentid, int marks) {
		
		this.examid = examid;
		this.studentid = studentid;
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examid;
		result = prime * result + marks;
		result = prime * result + studentid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Results other = (Results) obj;
		if (examid != other.examid)
			return false;
		if (marks != other.marks)
			return false;
		if (studentid != other.studentid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Results [examid=" + examid + ", studentid=" + studentid + ", marks=" + marks + "]";
	}

	public int getExamid() {
		return examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}
