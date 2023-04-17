<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.css" rel="stylesheet" >
<head>
   
    <title>Add Todo </title>
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
<h1>Enter Your Data</h1>
 <form:form method="post"  modelAttribute="dataCollection">
<fieldset class="mb-3">
 <form:label  path="description" > Description:</form:label>

 <form:input type="text" path="description" required="required"/>
 <form:errors type="text" path="description" cssClass="text-warning" />
 </fieldset>
 <fieldset class="mb-3">
 <form:label  path="target" > Target Date:</form:label>

 <form:input  type="text" path="target" reqired="required"/>
 <form:errors path="target" cssClass="text-warning" />
 </fieldset>
  <form:input type="hidden" path="id" required="required"/>
   <form:input type="hidden" path="done" required="required"/>
 <input type="submit"  class="btn btn-success"   >
 
 </form:form>

   </div>
   <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">

$('#target').datepicker({
    format: 'yyyy-mm-dd',
    startDate: '-3d'
});


</script>
</body>
</html>
