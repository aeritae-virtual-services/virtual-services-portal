<div id="attachments-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">
					<i class="fa fa-times"></i>
				</a>
				<h4 class="modal-title"><i class="fa fa-paperclip icon-attachments"></i>Attachments</h4>
			</div>
			<div class="modal-body">
				<form id="upload-file-form">
					<input id="upload-file" name="upload_file" type="file" style="display: none;" accept="*" onchange="showFileName(this);"/>
				</form>
				<div class="row">
					<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
						<div class="new-attachment-actions">
							<a id="file-select" class="icon-save" style="padding: 7px;" onclick="triggerUpload();" data-toggle="tooltip" title="Select a File" data-placement="bottom">
								<i class="fa fa-folder-open-o"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<input id="upload-file-shown" type="text" class="form-control input-medium" placeholder="No file selected" disabled>
					</div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<div class="new-attachment-actions">
							<a class="icon-save icon-disabled" onclick="uploadFile(this);" data-toggle="" title="Upload Selected File" data-placement="bottom">
								<i class="fa fa-arrow-up"></i>
							</a>
							<a class="icon-cancel icon-disabled" onclick="clearFile();" data-toggle="" title="Remove Selected File" data-placement="bottom">
								<i class="fa fa-times"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Attachment</th>
							<th>By</th>
							<th>Date</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr id="attachment_1">
							<td>Image.png</td>
							<td>nzitzer</td>
							<td>11/12/15</td>
							<td>
								<a onclick="downloadFile('1');" class="icon-save list-action" data-toggle="tooltip" title="Download Attachment" data-placement="bottom">
									<i class="fa fa-arrow-down icon-download"></i>
								</a>
								<a onclick="deleteFile('1');" class="icon-cancel list-action" data-toggle="tooltip" title="Delete Attachment" data-placement="bottom">
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
	function triggerUpload() {
		$('#upload-file').click();
	}
	
	function showFileName(el) {
		var savedFile = $(el).val() + '';
		if(savedFile != '') {
			savedFile = savedFile.split('\\').pop();
			$('#upload-file-shown').val(savedFile);
			$('.new-attachment-actions').find('a').removeClass("icon-disabled");
			$('.new-attachment-actions').find('a').attr("data-toggle", "tooltip");
		} else {
			clearFile();
		}
	}
	
	$(document).ready(function() {
		//Remove attachment info when modal is hidden
		$("#attachments-modal").on('hidden.bs.modal', function(){
			clearFile();
		});
	});
	
	function clearFile() {
		$('#upload-file').val('');
		$('#upload-file-shown').val('');
		$('.new-attachment-actions').find('a').not('#file-select').addClass("icon-disabled");
		$('.new-attachment-actions').find('a').attr("data-toggle", "");
	}
	
	function uploadFile(el) {
		if(!$(el).hasClass('icon-disabled')) {
			$.ajax({
				url: "upload_attachment",
				type: "POST",
				data: new FormData($('#upload-file-form')[0]),
				enctyp: 'multipart/form-data',
				processData: false,
				contentType: false,
				cache: false,
				success: function() {
					$("#attachments-modal").modal('toggle');
					//Increment Attachment count badge
					var fileCount = parseInt($('#attachment-count').text()) + 1;
					$('#attachment-count').html(fileCount);
					
					//Insert new row into table
					
				},
				error: function() {
					$("#attachments-modal").modal('toggle');
					showDangerMessage('Upload failed. Please try again');
				}
			});
		}
	}
	
	function downloadFile(id) {
		window.location.assign('/download_attachment?id=' + id);
	}
	
	function deleteFile(id) {
		$.ajax({
			url: "delete_attachment",
			type: "POST",
			data: ({
				fileId: id
			}),
			success: function() {
				$("#attachments-modal").modal('toggle');
				//Decrement Attachment count badge
				var fileCount = parseInt($('#attachment-count').text()) - 1;
				$('#attachment-count').html(fileCount);
				//Remove row from table
				$('#attachment_' + id).remove();
			},
			error: function() {
				$("#attachments-modal").modal('toggle');
				showDangerMessage('Comment failed. Please try saving again');
			}
		});
	}
</script>