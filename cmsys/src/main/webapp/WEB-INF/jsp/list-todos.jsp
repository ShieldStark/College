
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Person Id</th>
					<th>Mobile</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="todo">
	
				<tr>
					<td>${todo.id }</td>
					<td>${todo.mobile}</td>
					<td>${todo.name }</td>
					<%-- <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id }">Update</a></td>--%>
					<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id }">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<br>
		<div><a class="button" href="/contact/save">Add a Todo</a></div>
	</div>
<%@include file="common/footer.jspf" %>