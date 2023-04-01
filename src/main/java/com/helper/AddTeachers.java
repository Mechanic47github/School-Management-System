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

import com.entities.Teachers;

@WebServlet("/teachers")
public class AddTeachers extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID =2L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String id1=req.getParameter("id");
		String age1=req.getParameter("age");
		String salary1=req.getParameter("salary");
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		
		
		
		try
		{
			if(id1 !=null && age1 !=null&& salary1 !=null && name!=null && subject!=null)
			{
				int id=Integer.parseInt(id1);
				int age=Integer.parseInt(id1);
				double salary=Double.parseDouble(salary1);
				
			  Teachers t1=em.find(Teachers.class,id);
			 
			  
			  if(id1.equals(((Integer)t1.getAge()).toString()))
			  {    PrintWriter pw=resp.getWriter();
				  pw.println("<h5 style=color:red;>"+"Teacher Id is Already Present"+"</h5>");
					RequestDispatcher rd=req.getRequestDispatcher("AddTeachers.jsp");
					 rd.include(req, resp);
					 resp.setContentType("text/html");
					 pw.close();
				 
		
			  }
			  else
			  {
				  PrintWriter pw=resp.getWriter();
				  Teachers t=new Teachers(id,name,subject,age,salary);
					et.begin();
					em.persist(t);
					et.commit();
					
					pw.println("<h5 style=color:green>"+"Added Successfully"+"</h5>");
					RequestDispatcher rd=req.getRequestDispatcher("AddTeachers.jsp");
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
			int id=Integer.parseInt(id1);
			int age=Integer.parseInt(id1);
			double salary=Double.parseDouble(salary1);
			 PrintWriter pw=resp.getWriter();
			  Teachers t=new Teachers(id,name,subject,age,salary);
				et.begin();
				em.persist(t);
				et.commit();
				
				pw.println("<h5 style=color:green>"+"Added Successfully"+"</h5>");
				RequestDispatcher rd=req.getRequestDispatcher("AddTeachers.jsp");
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			    
			  	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			PrintWriter pw=resp.getWriter();
			pw.println("<h5 style=color:red;>"+"Data is not filled properly"+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("AddTeachers.jsp");
			 rd.include(req, resp);
			 resp.setContentType("text/html");
		}
	}
}
