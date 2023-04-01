package com.helper;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Students;
import com.entities.Teachers;

/**
 * Servlet implementation class RemoveStudentDisplay
 */
public class RemoveStudentDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStudentDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			try
			{
			int rollno=Integer.parseInt(request.getParameter("studentRollno").trim());
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
		Students s=em.find(Students.class,rollno);
			et.begin();
			em.remove(s);
			et.commit();
			response.sendRedirect("DisplayStudents.jsp");
			
			
		}
		catch(Exception e)
		{
			
			
			
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
