package com.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.EtchedBorder;

import com.entities.Account;
@WebServlet("/create")
public class CreateAccount extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
	long mNo=Long.parseLong(req.getParameter("number"));
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Account a=new Account(name,age,mNo,email,pass);
	et.begin();
	em.persist(a);
	et.commit();
	
	PrintWriter pw=resp.getWriter();
	pw.println("<h3 style=color:red;>"+"Account is created"+"</h3>");
	RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
	 rd.include(req, resp);
	 resp.setContentType("text/html");
		
		
		
		
	}

}
