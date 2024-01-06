<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Thought</title>
<%@include file="jsp_bootstrap_css.jsp"%>
</head>
<body>

	<div class="container-fluid p-0 m-2">
		<%@ include file="navigationbar.jsp"%>
	
	
	<h1>Let's Ink your Thought</h1>
		<br>

		<!-- this is add form  -->

		<form action="AddThoughtServlet" method="post">

			<div class="form-group">
				<label for="title">Thought title</label> 
				<input name="title" required type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Title of your Thought" />

			</div>

			<div class="form-group">
				<label for="content">What's Your thought</label>
				<textarea name="content" required id="content" placeholder="Ink your thought here" class="form-control" style="height: 300px;"		
					></textarea>
			</div>
			
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Add</button>
			</div>

		</form>
	</div>

</body>
</html>