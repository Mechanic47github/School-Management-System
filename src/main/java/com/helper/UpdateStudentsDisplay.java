package com.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Students;
import com.entities.Teachers;

/**
 * Servlet implementation class UpdateStudentsDisplay
 */
public class UpdateStudentsDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentsDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("studentsRollno"));
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		PrintWriter pw=response.getWriter();
		 Students s=em.find(Students.class, rollno);
		   if(s!=null)
		   {
			   HttpSession hs=request.getSession();
			   hs.setAttribute("student", s);
			   
			 
			  
			  pw.println("<a href='UpdateStudents1'>"+"</a>");
			    RequestDispatcher rd=request.getRequestDispatcher("UpdateStudents1.jsp");
				  
				 rd.forward(request, response);
				 response.setContentType("text/html");
			   pw.close();
			   
			   
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
