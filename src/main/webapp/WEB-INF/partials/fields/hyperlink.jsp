<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<div class="input-group">
		<input name="${param.fieldName}" type="text" class="form-control hyperlink" value="${param.value}"></input>
		<span class="input-group-addon" onclick="openLink(this); return false;" style="cursor: pointer;" data-toggle="tooltip" title="Go to Site" data-placement="bottom">
			<i class="fa fa-share"></i>
		</span>
	</div>
</fieldset>