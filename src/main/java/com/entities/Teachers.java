package com.entities;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
public class Teachers {
	@Id
	private int id;
	private String name;
	private String teachSubject;
	private int age;
	private double salary;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTeachSubject() {
		return teachSubject;
	}
	public int getAge() {
		return age;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTeachSubject(String teachSubject) {
		this.teachSubject = teachSubject;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	Random r=new Random();
	public Teachers( int id,String name, String teachSubject, int age, double salary) {
		
		this.id =id;
		this.name = name;
		this.teachSubject = teachSubject;
	  this.age = age;
		this.salary = salary;
	}
	public Teachers() {
		super();
	}
	
	
	
	

}
