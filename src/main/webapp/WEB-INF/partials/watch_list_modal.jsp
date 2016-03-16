<div id="watch-list-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">
					<i class="fa fa-times"></i>
				</a>
				<h4 class="modal-title"><i class="fa fa-users icon-comments"></i>Watch List</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
						<div class="new-watch-list-actions">
							<a class="icon-save" style="padding: 7px;" onclick="addToWatchList();" data-toggle="tooltip" title="Add a Watch List Member" data-placement="bottom">
								<i class="fa fa-plus"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						<input type="text" id="watch-list-email" name="email" class="form-control" style="visibility: hidden;" placeholder="Enter new email address.."></input>
					</div>
					<div class="col-lg-1 caol-md-1 col-sm-1 col-xs-1">
						<div class="new-watch-list-actions">
							<a id="save-watch-list" class="icon-save" style="padding-right: 7px; visibility: hidden;" onclick="saveWatchList();" data-toggle="tooltip" title="Save New Member" data-placement="bottom">
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
							<th width="100%">Email Address</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>nzitzer@aeritae.com</td>
							<td>
								<a onclick="deleteMember('1');" class="icon-cancel list-action" data-toggle="tooltip" title="Remove Member" data-placement="bottom">
									<i class="fa fa-times icon-clear"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function addToWatchList() {
		$('#watch-list-email').css({visibility: 'visible'});
		$('#save-watch-list').css({visibility: 'visible'});
	}
	
	$(document).ready(function() {
		//Remove comment info when modal is hidden
		$("#watch-list-modal").on('hidden.bs.modal', function(){
		    clearWatchList();
		});
	});
	
	function clearWatchList() {
		$('#watch-list-email').css({visibility: 'hidden'});
		$('#watch-list-email').val("");
		$('#save-watch-list').css({visibility: 'hidden'});
	}
	
	function saveWatchList() {
		$.ajax({
			url: "add_watch_list",
			type: "POST",
			data: ({
				email: $('#watch-list-email').val() + '',
				requestId: $('#id').val() + ''
			}),
			success: function() {
				$("#watch-list-modal").modal('toggle');
				//Increment Watch List Counter
				
				//TODO Refresh Watch List Table
			},
			error: function() {
				$("#watch-list-modal").modal('toggle');
				showDangerMessage('Adding new watch list member failed. Please try saving again.');
			}
		});
	}
</script>