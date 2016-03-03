<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<div class="input-group">
		<input name="${param.fieldName}" type="text" class="form-control email" value="${param.value}"></input>
		<span class="input-group-addon" onclick="emailThis(this); return false;" style="cursor: pointer;" data-toggle="tooltip" title="Send Email" data-placement="bottom">
			<i class="fa fa-envelope-o"></i>
		</span>
	</div>
</fieldset>