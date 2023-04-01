package com.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Account;
@WebServlet("/login")
public class LoginValidate extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	PrintWriter pw=resp.getWriter();
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
	EntityManager em=emf.createEntityManager();
	
	Query q=em.createQuery("select b from Account b where b.email=?1 and b.pass=?2");
	q.setParameter(1, email);
	q.setParameter(2, pass);
	List<Account> l=q.getResultList();
	
	if(l.size()>0)
	{
		RequestDispatcher rd=req.getRequestDispatcher("HomePage.jsp");
		 rd.forward(req, resp);
		 resp.setContentType("text/html");
		
	}
	else
	{
		pw.println("<h3 style=color:red;>"+"Invalid password"+"</h3>");
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		 rd.include(req, resp);
		 resp.setContentType("text/html");
	}
	
	
}
}
