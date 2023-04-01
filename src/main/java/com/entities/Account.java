package com.entities;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
@Id
private int id;
private String name;
private int age;
private long mNo;
private String email;
private String pass;
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public int getAge() {
	return age;
}
public long getmNo() {
	return mNo;
}
public String getEmail() {
	return email;
}
public String getPass() {
	return pass;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setAge(int age) {
	this.age = age;
}
public void setmNo(long mNo) {
	this.mNo = mNo;
}
public void setEmail(String email) {
	this.email = email;
}
public void setPass(String pass) {
	this.pass = pass;
}
Random r=new Random();
public Account( String name, int age, long mNo, String email, String pass) {
	super();
	this.id = r.nextInt(10000);
	this.name = name;
	this.age = age;
	this.mNo = mNo;
	this.email = email;
	this.pass = pass;
}
public Account() {
	super();
}




}
