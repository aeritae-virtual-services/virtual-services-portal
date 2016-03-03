<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<div class="input-group">
		<input name="${param.fieldName}" type="text" class="form-control phone-number"></input>
		<span class="input-group-addon" onclick="callThis(this); return false;" style="cursor: pointer;" data-toggle="tooltip" title="Dial Number" data-placement="bottom">
			<i class="fa fa-phone"></i>
		</span>
	</div>
</fieldset>