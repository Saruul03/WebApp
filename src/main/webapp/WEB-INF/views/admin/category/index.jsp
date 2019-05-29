<%@ page contentType="text/html; charset=UTF-8"%>

<div class="container mt-5" style="max-width: 500px;">
	<div class="d-flex justify-content-between mb-5">
		<h1>Ангилал</h1>
		<button class="btn btn-primary" onclick="showNewForm();">Шинэ</button>
	</div>

	<div id="list"></div>

	<script>
	
		/* $.ajax({url : "/admin/category/list"}).done(function(data) {
			$('#list').html(data);
		});
 		*/
 
		$.get("/admin/category/list").done(function(data) {
			$('#list').html(data);
		});
		
		/* $.post("/admin/category/save").done(function(data) {
			console.log(data);
		});
		 */
		
		function showNewForm(){
			$('#exampleModal').modal('show');
			
			$.ajax({url : "/admin/category/new"}).done(function(data) {
				$('#modalNew').html(data);
			});
		}
		
		function showEditForm(id){
			$('#exampleModal').modal('show');
			
			$.ajax({url : "/admin/category/edit?id=" + id}).done(function(data) {
				$('#modalNew').html(data);
			});
		}
	</script>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm" role="document" id="modalNew">
			
		</div>
	</div>

</div>