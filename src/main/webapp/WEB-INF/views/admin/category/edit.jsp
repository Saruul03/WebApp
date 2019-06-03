<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="modal-content">
	<div class="modal-header">
		<h5 class="modal-title" id="exampleModalLabel">Ангилал засах</h5>
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div class="modal-body">

		<form:form modelAttribute="jspForm">
			<form:hidden path="id" />
		
			<div class="form-group">
				<label for="ner">Нэр</label>
				<form:input path="ner" class="form-control" />
			</div>

			<div class="form-group">
				<label for="tailbar">Тайлбар</label>
				<form:input path="tailbar" class="form-control" />
			</div>
		</form:form>

	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary" data-dismiss="modal">Болих</button>
		<button type="button" class="btn btn-primary" onclick="sendForm();">Хадгалах</button>
	</div>
</div>

<script>	
	function sendForm() {
		$.post('/admin/category/update', $('#jspForm').serialize()).done(function(){
			$('#exampleModal').modal('hide');
			loadList();			
		})
	}
</script>