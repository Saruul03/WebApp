<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Admin</title>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<script src="//cdn.ckeditor.com/4.11.4/standard/ckeditor.js"></script>
</head>
<body>

	<div class="container" style="max-width: 300px; margin-top: 50px;">
	
		<c:if test="${hasError}">
			<div class="alert alert-danger" role="alert">
			  Хэрэглэгчийн нэр эсвэл нууц үг буруу байна!
			</div>
		</c:if>
		<form action="login" method="POST">
			<div class="form-group">
				<label for="username">Хэрэглэгчийн нэр</label> 
				<input type="text" autofocus class="form-control" id="username" name="username">
			</div>
			<div class="form-group">
				<label for="password">Нууц үг</label> 
				<input type="password" class="form-control" id="password" name="password">
			</div>
			<button type="submit" class="btn btn-primary">Нэвтрэх</button>
		</form>
	</div>


</body>
</html>

