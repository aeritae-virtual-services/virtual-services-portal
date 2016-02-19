<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="fa fa-usd"></i>
		</span>
		<input name="${param.fieldName}" type="text" class="form-control currency" placeholder="0000.00" pattern="\d+(\.\d{2})?"></input>
	</div>
</fieldset>