package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
	@Id
	private int rollno;
	private String name;
	private int Std;
	public int getRollno() {
		return rollno;
	}
	public String getName() {
		return name;
	}
	public int getStd() {
		return Std;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStd(int std) {
		Std = std;
	}
	public Students(int rollno, String name, int std) {
		super();
		this.rollno = rollno;
		this.name = name;
		Std = std;
	}
	public Students() {
		super();
	}
	
	

}
