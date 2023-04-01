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

import com.entities.Teachers;

/**
 * Servlet implementation class UpdateTeacherDisplay
 */
public class UpdateTeacherDisplay extends HttpServlet {
	private static final long serialVersionUID = 5L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherId=Integer.parseInt(request.getParameter("teacherId"));
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		PrintWriter pw=response.getWriter();
		 Teachers t=em.find(Teachers.class, teacherId);
		   if(t!=null)
		   {
			   HttpSession hs=request.getSession();
			   hs.setAttribute("teacher", t);
			   
			  System.out.print(teacherId);
			  
			  pw.println("<a href='UpdateTeacher1'>"+"</a>");
			    RequestDispatcher rd=request.getRequestDispatcher("UpdateTeacher1.jsp");
				  
				 rd.forward(request, response);
				 response.setContentType("text/html");
			   pw.close();
			   
			   
		   }}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
	
	}

}
