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
import com.entities.Teachers;
@WebServlet("/removestudents")
public class RemoveStudents extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

       EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
       EntityManager em=emf.createEntityManager();
       EntityTransaction et=em.getTransaction();
       PrintWriter pw=resp.getWriter();
       String rollno1=req.getParameter("rollno");
       
	 try
	 {
		
		
		 if(rollno1!=null)
		 {
			 int rollno=Integer.parseInt(rollno1);
			 
			 Students s=em.find(Students.class, rollno);
			   et.begin();
			   em.remove(s);
			   et.commit();
			   
			   pw.println("<h5 style=color:green>"+"Student removed Successfully"+"</h5>");
				RequestDispatcher rd=req.getRequestDispatcher("RemoveStudents.jsp");
				  
					 rd.include(req, resp);
					 resp.setContentType("text/html");
			  	 
		 }
		 
		 else 
			{
				pw.println("<h5 style=color:red>"+"Teacher Id is not found  "+"</h5>");
				RequestDispatcher rd=req.getRequestDispatcher("RemoveStudents.jsp");
				  
					 rd.include(req, resp);
					 resp.setContentType("text/html");
				
			}
			  
		 
		 
		 
	 }
	 catch(Exception e)
	 {
		 pw.println("<h5 style=color:red>"+"Field cannot be Empty "+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("RemoveStudents.jsp");
			  
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			
	 }
}
}
