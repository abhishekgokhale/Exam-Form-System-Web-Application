package com.vwits.model;

public class Teacher {

	private int id, phno;
	private static int count = 100;
	private String name, password, email;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, String password, String email, int phno) {
		count++;
		this.id = count;
		this.phno = phno;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public Teacher(int id, String name, String password, String email, int phno) {
		
		this.id = id;
		this.phno = phno;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	/*public void setId(int id) {
		this.id = id;
	}*/

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + phno;
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
		Teacher other = (Teacher) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phno != other.phno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", phno=" + phno + ", name=" + name + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	
}
