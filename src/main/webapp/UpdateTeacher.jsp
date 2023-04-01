<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Teachers</title>
   <link href="css/style1.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body style="background-color:#180148 ">
   <div class="container">
   
   <nav class="navbar navbar-expand-lg navbar-dark navbar">
  <div class="container-fluid">
    <a class="navbar-brand  href="#"><img src="img/education.png" height =50px> <b> Update Teacher</b></a>
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
  
 <form action="updateteacher" method="post">
  <div class="contain1" >
    <label for="exampleInputEmail1" class="form-label"> Teacher Id :</label>
    <input type="number" class="form-control" name="id" aria-describedby="emailHelp" placeholder="Enter ID of Teacher">
    <br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
   </div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>