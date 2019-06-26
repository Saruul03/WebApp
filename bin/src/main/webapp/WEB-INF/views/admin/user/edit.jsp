<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="modal-content">
	<div class="modal-header">
		<h5 class="modal-title" id="exampleModalLabel">Шинэ ангилал</h5>
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div class="modal-body">
	
		<form:form modelAttribute="jspForm">
			<form:hidden path="oldUsername" />
		
			<div class="form-group">
				<label for="ner">Хэрэглэгчийн нэр</label>
				<form:input path="username" class="form-control" cssErrorClass="form-control is-invalid" />
				<form:errors path="username" class="invalid-feedback" element="div"/>
			</div>

			<div class="form-group">
				<label for="enabled">Идэвхтэй</label>
				<form:checkbox path="enabled" class="form-control" />
			</div>
		</form:form>

	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary" data-dismiss="modal">Болих</button>
		<button type="button" class="btn btn-primary" onclick="sendForm()">Хадгалах</button>
	</div>
</div>

<script>
function sendForm() {
	$.post('/admin/user/update', $('#jspForm').serialize()).done(function(){
		
		$('#exampleModal').modal('hide');
		loadList();
		
	})
}

</script>