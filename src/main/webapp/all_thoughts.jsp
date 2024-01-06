<%@page import="com.app.dao.ThoughtDaoImpl"%>
<%@page import="com.app.dao.ThoughtDao"%>
<%@page import="com.app.entity.Thought"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Thoughts</title>
<%@ include file="jsp_bootstrap_css.jsp"%>

</head>
<body> 
	<div class="container-fluid p-0 m-2">
		<%@ include file="navigationbar.jsp"%>
		<br>
		<h1 class="text-uppercase">All Notes:</h1>
		<div class="row">
			<div class="col-12">
				<%
				ThoughtDao dao = new ThoughtDaoImpl();
				List<Thought> list = dao.getThoughts();
				for (Thought t : list) {
				%>
				<div class="card mt-3" >
					<img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="img/Image.png" alt="your thought">
					<div class="card-body px-5">
						<h5 class="card-title"><%= t.getTitle() %></h5>
						<p class="card-text"><%= t.getContent() %></p>
						<p ><b class="text-primary"><%= t.getTimestamp()  %></b></p>
						<div class="container text-center mt-2">
						<a href="DeleteServlet?thought_id=<%= t.getId() %>" class="btn btn-danger">Delete</a>
						<a href="edit.jsp?thought_id=<%= t.getId() %>" class="btn btn-primary">Update</a>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>