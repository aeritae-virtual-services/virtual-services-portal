<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fieldset class="form-group">
	<label for="${param.fieldName}">
		${param.fieldLabel}
	</label>
	<div>
		<c:if test='${param.value ne ""}'>
			<div class="col-lg-2">
				<img width="50px" src="${param.value}"/>
				<a style="margin-left: -10px; cursor: pointer;" onclick="markRemove('remove-img-${param.fieldName}')">
					<i class="fa fa-times icon-cancel"></i>
				</a>
				<input type="hidden" name="remove-image-${param.fieldName}"/>
			</div>
			<div class="col-lg-10">
				<input name="${param.fieldName}" type="file" class="form-control file-upload"></input>
			</div>
		</c:if>
	</div>
</fieldset>