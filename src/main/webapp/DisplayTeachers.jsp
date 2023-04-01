<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
  <!doctype html>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.entities.Teachers"%>
<%@page import="com.helper.UpdateTeacher"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Display Teachers</title>
   <link href="css/style1.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body style="background-color:#180148 ">
   <div class="container">
   
   <nav class="navbar navbar-expand-lg navbar-dark navbar">
  <div class="container">
    <a class="navbar-brand  href="#"><img src="img/education.png" height =50px> <b> Display Teachers</b></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="HomePage.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Teachers.jsp">Teachers</a>
        </li>
       
        <li class="nav-item">
          <a class="nav-link "  href="Students.jsp">Students</a>
        </li>
      </ul>
      </div>
  </div>
</nav>

</div>
 <div class="contain" >
<div class="row">
<div class="col-12">

		

			<%
				EntityManagerFactory
				emf=Persistence.createEntityManagerFactory("lollita");
				EntityManager em=emf.createEntityManager(); Query
				q=em.createQuery("select b from Teachers b");
				List<Teachers> tl=q.getResultList();
				%>
				
				<% 
				for(Teachers t:tl) {
			
			    %>
			<div class="card mt-3 border-primary" style="background-color:#180148 ">
			<div class="card-body">
			 <h4 class="card-title">Id :<%=t.getId()%></h4>
				 <h4 class="card-title">Name: <%=t.getName()%></h4>
				 <h4 class="card-title">Subject :<%=t.getTeachSubject()%></h4>
				 <h4 class="card-title">Salary :<%=t.getSalary()%></h4>
				<a class="btn btn-primary " href="UpdateTeacherDisplay?teacherId=<%=t.getId()%>">Update</a>
				<a class="btn btn-danger " href="DeleteServletdrct?teacherId=<%= t.getId()%>">Delete</a>
				</div>	
			
			</div>
			</div>
			
			<%}%>


		</div>

</div>



   
   
   
   
   
   
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>