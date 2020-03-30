<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Desc</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Button</th>
					<th>Update</th>
				</tr>

			</thead>
			<tbody>

				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div>
			<a class="button" href="/add-todo"> Add a todo</a>
		</div>

<%@ include file = "common/footer.jspf" %>