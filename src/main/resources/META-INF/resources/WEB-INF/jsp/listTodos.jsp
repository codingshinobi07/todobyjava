<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html lang="en">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<link href="/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.css" rel="stylesheet" >

<head>
   
    <title>List Todo's</title>
</head>
<body>


<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" href="https://www.linkedin.com/in/varun-pandey-26556722a/" >About</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>


















<div class="container">

<hr>
<div><h1 class="heading">Your ToDo Are</h1></div>
<table class="table">
<thead>

</thead>
<tr>

<th>Description</th>
<th>Target Date</th>
<th>Status</th>
<th>Delete</th>
<th>Update</th>
</tr>
<tbody>

   <c:forEach items="${todos}"  var="todo">
   
   <tr>


    <td>${todo.description}</td>
     <td>${todo.target}</td>
      <td>${todo.done}</td>
      <td  > <a href="delete-todo?id=${todo.id }" class="btn btn-warning" >Delete</a></td>
        <td  > <a href="update?id=${todo.id }" class="btn btn-success" >Update</a></td>
  
   
   </tr>
   
   </c:forEach>
</tbody>
   
  
  
   </table>
   <a href="add-todo"  class="btn btn-success">Add todo</a>
   </div>
   <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</body>
</html>
