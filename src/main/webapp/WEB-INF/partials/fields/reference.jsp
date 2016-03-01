<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<input id="${param.fieldName}" name="${param.fieldName}" type="hidden"></input>
	<div class="input-group">
		<input id="display-${param.fieldName}" type="text" class="form-control reference"></input>
		<span class="input-group-addon" style="cursor: pointer;" data-toggle="modal" data-target="#${param.fieldName}-modal">
			<i class="fa fa-crosshairs"></i>
		</span>
	</div>
</fieldset>

<div id="${param.fieldName}-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">
					<i class="fa fa-times"></i>
				</a>
				<h4 class="modal-title"><i class="fa fa-crosshairs"></i>Select ${param.fieldLabel}</h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Full Name</th>
							<th>Client</th>
							<th>Select</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Charlie Biegel</td>
							<td>Blue Cross Blue Shield</td>
							<td>
								<a class="icon-save list-action" onclick="selectThisOption(1, 'Charlie Biegel');" data-dismiss="modal">
									<i class="fa fa-check"></i>
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
	function selectThisOption(id, label) {
		$('#${param.fieldName}').val(id + '');
		$('#display-${param.fieldName}').val(label + '');
	}
</script>