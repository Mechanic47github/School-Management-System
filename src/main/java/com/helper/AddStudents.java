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

import com.entities.Students;
import com.entities.Teachers;

@WebServlet("/students")
public class AddStudents extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID =2L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String rollno1=req.getParameter("rollno");
		String name=req.getParameter("name");
		String std1=req.getParameter("std");
		
		
		
		
		try
		{
			if(rollno1 !=null && name !=null&& std1 !=null)
			{
				int rollno=Integer.parseInt(rollno1);
				int std=Integer.parseInt(std1);
				
				
			 Students s1=em.find(Students.class,rollno);
			 
			  
			  if(rollno1.equals(((Integer)s1.getRollno()).toString()))
			  {    PrintWriter pw=resp.getWriter();
				  pw.println("<h5 style=color:red;>"+"Student Roll no is Already Present"+"</h5>");
					RequestDispatcher rd=req.getRequestDispatcher("AddStudents.jsp");
					 rd.include(req, resp);
					 resp.setContentType("text/html");
					 pw.close();
				 
		
			  }
			  else
			  {
				 
				  PrintWriter pw=resp.getWriter();
				  Students s=new Students(rollno,name,std);
					et.begin();
					em.persist(s);
					et.commit();
					
					pw.println("<h5 style=color:green>"+"Added Successfully"+"</h5>");
					RequestDispatcher rd=req.getRequestDispatcher("AddStudents.jsp");
					 rd.include(req, resp);
					 resp.setContentType("text/html");
				    
				  
			  
			}
			
			}
			else
			{
				
				PrintWriter pw=resp.getWriter();
				pw.println("<h5 style=color:red;>"+"Data is not filled properly"+"</h5>");
				RequestDispatcher rd=req.getRequestDispatcher("AddTeachers.jsp");
				 rd.include(req, resp);
				 resp.setContentType("text/html");
				
				
			}
			
		}
		catch(NullPointerException ne)
		{
			int rollno=Integer.parseInt(rollno1);
			int std=Integer.parseInt(std1);
			
			 PrintWriter pw=resp.getWriter();
			 Students s=new Students(rollno,name,std);
				et.begin();
				em.persist(s);
				et.commit();
				
				pw.println("<h5 style=color:green>"+"Added Successfully"+"</h5>");
				RequestDispatcher rd=req.getRequestDispatcher("AddStudents.jsp");
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			    
			  	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			PrintWriter pw=resp.getWriter();
			pw.println("<h5 style=color:red;>"+"Data is not filled properly"+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("AddStudents.jsp");
			 rd.include(req, resp);
			 resp.setContentType("text/html");
		}
	}
}

