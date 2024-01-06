<%@page import="com.app.entity.Thought"%>
<%@page import="com.app.utils.HibernateUtils"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="jsp_bootstrap_css.jsp" %>
</head>
<body>
	<div class="container">
   <%@ include file="navigationbar.jsp" %>
		<h1>Edit your Thought</h1>
		<br>

		<%
			Long thoughtId = Long.parseLong(request.getParameter("thought_id").trim());
			Session s = HibernateUtils.getFactory().openSession();
			Thought t =  s.get(Thought.class, thoughtId);
		%>
		<form action="UpdateServlet" method="post">
			<input value="<%=t.getId()%>" name="thoughtId" type="hidden" />
			<div class="form-group">
				<label for="title">thought title</label> <input name="title" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here"
					value="<%=t.getTitle()%>" />
			</div>
			<div class="form-group">
				<label for="content">thought Content</label>
				<textarea name="content" required id="content"
					placeholder="Enter your content here" class="form-control"
					style="height: 300px;"><%=t.getContent()%>
					</textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Save your
					thought</button>
			</div>
		</form>

	</div>
</body>
</html>