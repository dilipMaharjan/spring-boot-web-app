<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>

<div class="container">
	<button class="btn btn-success">
		<a href="add-todo">Add Todo</a>
	</button>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Completed</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${todos.getClass().getName()=='java.util.ArrayList'}">
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id}"> Delete</a></td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id}"> Update</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${todos.getClass().getName()=='java.util.Optional'}">
				<tr>
					<td>${todos.get().description}</td>
					<td>${todos.get().targetDate}</td>
					<td>${todos.get().done}</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf"%>