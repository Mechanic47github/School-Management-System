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

@WebServlet("/updateteacher2")
public class UpdateTeacher2 extends HttpServlet {
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
		int id=(int)hs.getAttribute("id");
		
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String age1= req.getParameter("age");
		String salary1=req.getParameter("salary");
		
		if(name!=null && subject!=null && age1!=null && salary1!=null )
		{
			int age=Integer.parseInt(age1);
			double salary=Double.parseDouble(salary1);
		Teachers t=new Teachers(id,name,subject,age,salary);
		et.begin();
		em.merge(t);
		et.commit();
		 pw.println("<h5 style=color:green>"+"data updated"+"</h5>");
		RequestDispatcher rd=req.getRequestDispatcher("UpdateTeacher1.jsp");
		  
			 rd.include(req, resp);
			 resp.setContentType("text/html");
		}
		else 
		{
			pw.println("<h5 style=color:red>"+"data is not fill properly "+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateTeacher1.jsp");
			  
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			
		}
		}
		catch(Exception e)
		{
			pw.println("<h5 style=color:red>"+"data is not fill properly "+"</h5>");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateTeacher1.jsp");
			  
				 rd.include(req, resp);
				 resp.setContentType("text/html");
		}
		
	}

}
