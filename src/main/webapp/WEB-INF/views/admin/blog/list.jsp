<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>ID</th>
			<th>Нэр</th>			
			<th>Ангилал</th>
			<th style="width: 1px"></th>
			<th style="width: 1px"></th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach items="${blogs}" var="blog">			
			<tr>
				<td>${blog.blogId}</td>
				<td>${blog.name}</td>
				<td>${blog.category.name}</td>				
				<td><button class="btn btn-light" onclick="showEditForm(${blog.blogId})">Засах</button></td>
				<td><button class="btn btn-danger" onclick="deleteCategory(${blog.blogId})">Устгах</button></td>
			</tr>
		</c:forEach>		
		
	</tbody>
</table>