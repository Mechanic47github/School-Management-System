package com.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Teachers;

/**
 * Servlet implementation class SearchTeacher
 */
public class SearchTeacher extends HttpServlet {
	private static final long serialVersionUID = 5L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("lollita");
		   EntityManager em=emf.createEntityManager();
		   PrintWriter pw=resp.getWriter();
		   try
		   {
			   int id=Integer.parseInt(req.getParameter("id"));
		   
		   Teachers t=em.find(Teachers.class, id);
		   if(t!=null)
		   {
			   HttpSession hs=req.getSession();
			   hs.setAttribute("teacher", t);
			   
			 
			  
			    pw.println("<a href='UpdateTeacher1'>"+"click here"+"</a>");
			    RequestDispatcher rd=req.getRequestDispatcher("UpdateTeacher1.jsp");
				  
				 rd.forward(req, resp);
				 resp.setContentType("text/html");
			   pw.close();
			   
			   
		   }
		   else
		   {
			  
			   RequestDispatcher rd=req.getRequestDispatcher("Teachers.jsp");
			   pw.println("<h5 style=color:red>"+"not found"+"</h5>");
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			   
		   }
		   }
		   catch(Exception e)
		   {
			   RequestDispatcher rd=req.getRequestDispatcher("Teachers.jsp");
			   pw.println("<h5 style=color:red>"+"Field cannot be Empty"+"</h5>");
				 rd.include(req, resp);
				 resp.setContentType("text/html");
			   
		   }
		   
		  
	
	}

		
		
		
	}


