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
import javax.servlet.http.HttpSession;

import com.entities.Students;

@WebServlet("/updatestudents2")
public class UpdateStudents2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		PrintWriter pw=resp.getWriter();
		try
		{
		

		HttpSession hs=req.getSession(false);
		int rollno=(int)hs.getAttribute("rollno");
		
		String name=req.getParameter("name");
		String std1=req.getParameter("std");
		
		
		if(name!=null && std1!=null )
		{
			int std=Integer.parseInt(std1);
			
		Students s=new Students(rollno,name,std);
		et.begin();
		em.merge(s);
		et.commit();
		 pw.println("<h5 style=color:green>"+"data updated"+"</h5>");
		RequestDispatcher rd=req.getRequestDispatcher("UpdateStudents.jsp");
		  
			 rd.include(req, resp);
			 resp.setContentType("text/html");
		}
		else 
		{
			pw.println("<h5 style=color:red>"+"data is not fill properly "+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateStudents1.jsp");
			  
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			
		}
		}
		catch(Exception e)
		{
			pw.println("<h5 style=color:red>"+"data is not fill properly "+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateStudents1.jsp");
			  
				 rd.include(req, resp);
				 resp.setContentType("text/html");
		}
		
	}

}
