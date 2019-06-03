<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>ID</th>
			<th>Нэр</th>
			<th>Тайлбар</th>
			<th style="width: 1px"></th>
			<th style="width: 1px"></th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach items="${angilluud}" var="angilal">			
			<tr>
				<td>${angilal.id}</td>
				<td>${angilal.name}</td>
				<td>${angilal.description}</td>
				<td><button class="btn btn-light" onclick="showEditForm(${angilal.id})">Засах</button></td>
				<td><button class="btn btn-danger" onclick="deleteCategory(${angilal.id})">Устгах</button></td>
			</tr>
		</c:forEach>		
		
	</tbody>
</table>