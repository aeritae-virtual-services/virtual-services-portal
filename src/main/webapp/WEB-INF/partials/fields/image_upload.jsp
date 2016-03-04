<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fieldset class="form-group">
	<label for="${param.fieldName}"> ${param.fieldLabel} </label>
	<div>
		<c:if test='${param.value ne ""}'>
			<div>
				<a id="${param.fieldName}-link" class="image-file-upload-container">
					<img id="${param.fieldName}-img" class="image-file-upload-image" width="110px" src="${param.value}">
				</a>
				<input id="${param.fieldName}-delete" type="checkbox" style="display: none;"/>
				<input id="${param.fieldName}" type="file" accept="image/*" style="display: none;"/>
				<ul id="${param.fieldName}-contextMenu" class="dropdown-menu image-file-context-menu">
				    <li><a href="" onclick="return deleteImage('${param.fieldName}');">Delete Image</a></li>
				    <li><a href="" onclick="return uploadImage('${param.fieldName}');">Upload New Image</a></li>
				    <li class="divider"></li>
				    <li><a href="" onclick="return hideMenu('${param.fieldName}');">Cancel</a></li>
				</ul>
			</div>
		</c:if>
	</div>
</fieldset>
<script>
	$('#${param.fieldName}-link').click(function() {
		$('#${param.fieldName}-contextMenu').show();
	});
	
	function uploadImage(field) {
		$('#' + field).click();
		return false;
	}
	
	function deleteImage(field) {
		$('#' + field + '-delete').prop('checked', true);
		$('#${param.fieldName}-img').fadeTo(200, 1);
		$('#${param.fieldName}').val('');
		$('#' + field + '-img').attr('src', '${pageContext.servletContext.contextPath}/resources/images/no-user-img.png');
		hideMenu(field);
		return false;
	}
	
	function hideMenu(field) {
		$('#' + field + '-contextMenu').hide();
		return false;
	}
	
	$('#${param.fieldName}').change(function() {
		if($(this).val() + '' == '' && $('#${param.fieldName}-delete').is(':checked')) {
			$('#${param.fieldName}-img').attr('src', '${pageContext.servletContext.contextPath}/resources/images/no-user-img.png');
			hideMenu('${param.fieldName}');
		} else if($(this).val() + '' == '') {
			$('#${param.fieldName}-img').fadeTo(200, 1);
			hideMenu('${param.fieldName}');
		} else {
			$('#${param.fieldName}-img').attr('src', '${param.value}');
			$('#${param.fieldName}-delete').prop('checked', false);
			$('#${param.fieldName}-img').fadeTo(200, .3);
			hideMenu('${param.fieldName}');
		}
	});
</script>