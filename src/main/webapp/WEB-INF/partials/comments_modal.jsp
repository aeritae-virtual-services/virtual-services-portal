<div id="comments-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">
					<i class="fa fa-times"></i>
				</a>
				<h4 class="modal-title"><i class="fa fa-comment-o icon-comments"></i>Comments</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
						<div class="new-comment-actions">
							<a class="icon-save" style="padding: 7px;" onclick="addAComment();" data-toggle="tooltip" title="Add a Comment" data-placement="bottom">
								<i class="fa fa-plus"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<textarea id="comment" name="comment" class="form-control" style="visibility: hidden;" placeholder="Enter new comment..."></textarea>
					</div>
					<div class="col-lg-1 caol-md-1 col-sm-1 col-xs-1">
						<input id="public-comment" name="public" type="checkbox" style="visibility: hidden;" class="form-control checkbox" data-toggle="tooltip" title="Mark Public" data-placement="bottom"/>
					</div>
					<div class="col-lg-1 caol-md-1 col-sm-1 col-xs-1">
						<div class="new-comment-actions">
							<a id="save-comment" class="icon-save" style="padding-right: 7px; visibility: hidden;" onclick="saveComment();" data-toggle="tooltip" title="Save Comment" data-placement="bottom">
								<i class="fa fa-floppy-o"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th width="100%">Comment</th>
							<th>By</th>
							<th>Date</th>
							<th>Public</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>This is the comment that was left.</td>
							<td>nzitzer</td>
							<td>11/12/15</td>
							<td>Yes</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function addAComment() {
		$('#comment').css({visibility: 'visible'});
		$('#public-comment').css({visibility: 'visible'});
		$('#save-comment').css({visibility: 'visible'});
	}
	
	$(document).ready(function() {
		//Remove comment info when modal is hidden
		$("#comments-modal").on('hidden.bs.modal', function(){
		    clearComments();
		});
	});
	
	function clearComments() {
		$('#comment').css({visibility: 'hidden'});
		$('#comment').val("");
		$('#public-comment').css({visibility: 'hidden'});
		$('#public-comment').prop("checked", false);
		$('#save-comment').css({visibility: 'hidden'});
	}
	
	function saveComment() {
		$.ajax({
			url: "add_comment",
			type: "POST",
			data: ({
				comment: $('#comment').val() + '',
				pub: $('#public-comment').is(":checked") + ''
			}),
			success: function() {
				saveCommentSuccess();
			},
			error: function() {
				alert('Comment failed. Please try saving again');
			}
		});
	}
	
	function saveCommentSuccess() {
		//Close Modal
		$("#comments-modal").modal('toggle');
		//Increment Comment Counter
		
		//TODO Refresh Comments Table
	}
</script>