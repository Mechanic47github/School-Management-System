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

import com.entities.Teachers;
@WebServlet("/removeteacher")
public class RemoveTeacherSearch extends HttpServlet {
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
       String id1=req.getParameter("id");
       
	 try
	 {
		
		
		 if(id1!=null)
		 {
			 int id=Integer.parseInt(id1);
			 
			 Teachers t=em.find(Teachers.class, id);
			   et.begin();
			   em.remove(t);
			   et.commit();
			   
			   pw.println("<h5 style=color:green>"+"Teacher removed Successfully"+"</h5>");
				RequestDispatcher rd=req.getRequestDispatcher("RemoveTeacher.jsp");
				  
					 rd.include(req, resp);
					 resp.setContentType("text/html");
			  	 
		 }
		 
		 else 
			{
				pw.println("<h5 style=color:red>"+"Teacher Id is not found  "+"</h5>");
				RequestDispatcher rd=req.getRequestDispatcher("RemoveTeacher.jsp");
				  
					 rd.include(req, resp);
					 resp.setContentType("text/html");
				
			}
			  
		 
		 
		 
	 }
	 catch(Exception e)
	 {
		 pw.println("<h5 style=color:red>"+"data is not fill properly "+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("RemoveTeacher.jsp");
			  
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			
	 }
}
}
