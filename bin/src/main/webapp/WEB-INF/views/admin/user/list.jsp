<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-bordered">
	<thead>
		<tr>		
			<th>Нэр</th>			
			<th style="width: 1px"></th>
			<th style="width: 1px"></th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach items="${list}" var="user">			
			<tr>			
				<td>${user.username}</td>				
				<td><button class="btn btn-light" onclick="showEditForm('${user.username}')">Засах</button></td>
				<td><button class="btn btn-danger" onclick="deleteCategory('admin')">Устгах</button></td>
			</tr>
		</c:forEach>		
		
	</tbody>
</table>