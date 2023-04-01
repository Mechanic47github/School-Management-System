<!doctype html>
<%@page import="com.entities.Students"%>
<%@page import="java.io.PrintWriter"%>


<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Students</title>
   <link href="css/style1.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body style="background-color:#180148 ">
   <div class="container">
   
   <nav class="navbar navbar-expand-lg navbar-dark navbar">
  <div class="container">
    <a class="navbar-brand  href="#"><img src="img/education.png" height =50px> <b> Update Teachers</b></a>
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
<form action="updatestudents2" method="post">
<div class="container">

 
 <div class="contain">
  <div class="row">
 <% 
PrintWriter pw=response.getWriter();

HttpSession hs=request.getSession(false);
Students s=(Students)hs.getAttribute("student");

HttpSession hs1=request.getSession();
hs1.setAttribute("rollno", s.getRollno());

pw.print("<a href='UpdateStudents2'></a>");

%>
 
 
  <div class=col-lg-6>
   <div class="card" style="background-color:#180148 ">
   
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name :</label>
    <input type="text" class="form-control" name="name" aria-describedby="emailHelp" value="<%=s.getName()%>">
      </div>
  
 
   <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Standard :</label>
    <input type="number" class="form-control" name="std"  value="<%=s.getStd()%>">
  </div>
  
  
  </div>
  </div>
  <div class="col-lg-2">
  </div>
  
  <div class="col-lg-4">
<div class="card border-primary" >
<div class="card-body" style="background-color:#180148">
<h5 class="card-title text-danger" style="text-align:center;">Current Data</h5>

      <div class="tables">
      <table  style="color:#c0c0c0">
      <tr>
      <th>Rollno</th> <th>: <%=s.getRollno() %></th>
      </tr>
   
      <tr>
      
     <th>Name</th> <th>: <%= s.getName()%></th>
     </tr>
    
    <tr>
    <th>Standard</th> <th>: <%= s.getStd()%></th>
     </tr>
    
</table>    
</div>  

</div>


</div>
  
  </div>
  </div>
  


 

 
  <button type="submit" class="btn btn-primary">Update</button>
</form>
 





  
   
 
   
    
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>