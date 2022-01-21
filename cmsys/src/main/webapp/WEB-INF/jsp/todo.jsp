<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="form-group">
			<form:label path="mobile">Mobile</form:label>
			<form:input path="mobile" type="text" class="form-control" required="required"/>
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control" required="required"/>
		</fieldset>
		<button type="submit" class="btn btn-success">Add</button>
		
	</form:form>
</div>
	<%--<div class="container">
	
	 <form:form method="post" modelAttribute="todo">
			<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="desc">ID</form:label> 
				<form:input path="desc" type="text"
					class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Mobile</form:label> 
				<form:input path="targetDate" type="text"
					class="form-control" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>--%>
<%@include file="common/footer.jspf" %>
