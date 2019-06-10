<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/WEB-INF/views/include.jsp"%>

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
	
		<c:forEach items="${blogs.content}" var="blog">			
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


<c:if test="${blogs.totalPages gt 1}">
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  	<c:if test="${not blogs.first}">
	  		<li class="page-item"><a class="page-link" href="#" onclick="loadList(${blogs.number-1});">Өмнөх</a></li>
	  	</c:if>
	  	
	  	<c:forEach var="i" begin="1" end="${blogs.totalPages}">
	  		<li class="page-item <c:if test="${blogs.number == i-1}">active</c:if>"><a class="page-link" href="#" onclick="loadList(${i-1});">${i}</a></li>
	  	</c:forEach>  	       
	    
	    <c:if test="${not blogs.last}">
	    	<li class="page-item"><a class="page-link" href="#" onclick="loadList(${blogs.number+1});">Дараах</a></li>
	    </c:if>   
	  </ul>
	</nav>
</c:if>

