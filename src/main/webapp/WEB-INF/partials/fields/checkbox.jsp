<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fieldset class="form-group">
		<label for="${param.fieldName}">
			${param.fieldLabel}
		</label>
		<input name="${param.fieldName}" type="checkbox" class="form-control checkbox" <c:if test="${param.value=='true'}">checked</c:if>>
</fieldset>