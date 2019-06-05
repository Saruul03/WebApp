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
				<form:input path="name" class="form-control" />
			</div>

			<div class="form-group">
				<label for="tailbar">Эх бие</label>
				<form:textarea path="content" class="form-control" />
			</div>
			<script>                
                var editor = CKEDITOR.replace( 'content' );
            </script>
		</form:form>

	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary" data-dismiss="modal">Болих</button>
		<button type="button" class="btn btn-primary" onclick="sendForm();">Хадгалах</button>
	</div>
</div>

<script>	
	function sendForm() {		
		$('#content').html(editor.getData())
		
		$.post('/admin/blog/save', $('#jspForm').serialize()).done(function(){
			$('#exampleModal').modal('hide');
			loadList();			
		})
	}
</script>