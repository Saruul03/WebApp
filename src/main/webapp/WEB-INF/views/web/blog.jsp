<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/main.css"/>
<title>Нүүр</title>
</head>
<body>

<div class="container">

	<header class="menu">
		<a href="/" class="menu__item">Эхлэл</a>
		<c:forEach items="${categories}" var="category">
			<a href="#" class="menu__item">${category.name}</a>
		</c:forEach>	
	</header>
	
	<main>
		<div class="card">
			<h1 class="title">${blog.name}</h1>
			<div class="content">
				${blog.content}
			</div>			
		</div>			
	</main>
</div>

</body>
</html>