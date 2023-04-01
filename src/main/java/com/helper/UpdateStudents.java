package com.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Students;


@WebServlet("/updatestudents")
public class UpdateStudents extends HttpServlet{
   /**
	 * 
	 */
	private static final long serialVersionUID = 4L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   
	   
	   
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
	   EntityManager em=emf.createEntityManager();
	   PrintWriter pw=resp.getWriter();
	 
	  try
	  {
		  int rollno=Integer.parseInt(req.getParameter("rollno"));
		  Students s=em.find(Students.class, rollno);
	   if(s!=null)
	   {
		   HttpSession hs=req.getSession();
		   hs.setAttribute("student", s);
		   
		 
		  
		    pw.println("<a href='UpdateStudents1'>"+"click here"+"</a>");
		    RequestDispatcher rd=req.getRequestDispatcher("UpdateStudents1.jsp");
			  
			 rd.forward(req, resp);
			 resp.setContentType("text/html");
		   pw.close();
		   
		   
	   }
	   else
	   {
		  
		   RequestDispatcher rd=req.getRequestDispatcher("UpdateStudents.jsp");
		   pw.println("<h5 style=color:red>"+"not found"+"</h5>");
			 rd.include(req, resp);
			 resp.setContentType("text/html");
		   
	   }
	  }
	  catch(Exception e)
	  {
		  RequestDispatcher rd=req.getRequestDispatcher("UpdateStudents.jsp");
		   pw.println("<h5 style=color:red>"+"Field cannot be Empty"+"</h5>");
			 rd.include(req, resp);
			 resp.setContentType("text/html");
	  }
	   
	  
}
}
