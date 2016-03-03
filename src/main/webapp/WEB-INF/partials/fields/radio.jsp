<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<c:forEach var="option" items="${param.optionList}">
		<input name="${param.fieldName}" type="radio" class="form-control radio" value="${option.value}">
			${option.label}
		</input>
	</c:forEach>
</fieldset>