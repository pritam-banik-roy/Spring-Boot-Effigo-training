<%@ include file= "common/header.jspf" %>
<%@ include file= "common/navigation.jspf" %>
	<div class="container">

		<hr>
		<h1>Your Todos</h1>
		</hr>

		<table class= "table">
			<thead>
				<tr>
					<th>id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id }</td>
						<td>${todo.description }</td>
						<td>${todo.targetDate }</td>
						<td>${todo.done}</td>
						<td><a href = "delete-todo?id=${todo.id}" class = "btn btn-warning">DELETE</a></td>
						<td><a href = "update-todo?id=${todo.id}" class = "btn btn-success">UPDATE</a></td>
					</tr>

				</c:forEach>

			</tbody>


		</table>
		
		<a href = "add-todo" class = "btn btn-success">Add Todo</a>

	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script
</body>
</html>