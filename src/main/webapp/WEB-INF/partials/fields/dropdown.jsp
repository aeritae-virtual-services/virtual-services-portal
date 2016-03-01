<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String optionL = request.getParameter("optionList");
	Object optionLi = request.getAttribute(optionL);
%>
<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel} 
	</label>
	<select name="${param.fieldName}" class="form-control dropdown">
		<c:forEach var="option" items="<%=optionLi %>">
			<option value="${option.value}">
				${option.label}
			</option>
		</c:forEach>
	</select>
</fieldset>