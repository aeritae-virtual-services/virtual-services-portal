<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<select name="${param.fieldName}" class="form-control dropdown">
		<c:forEach var="option" items="${param.optionList}">
			<option value="${option.value}">
				${option.label}
			</option>
		</c:forEach>
	</select>
</fieldset>