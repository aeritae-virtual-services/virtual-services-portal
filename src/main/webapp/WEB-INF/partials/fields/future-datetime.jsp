<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<div class="input-group future-datetime">
		<input name="${param.fieldName}" type="text" class="form-control" value="${param.value}"></input>
		<span class="input-group-addon" style="cursor: pointer;">
			<i class="fa fa-calendar"></i>
		</span>
	</div>
</fieldset>