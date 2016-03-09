<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Statuses</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
<script>
	function saveStatusForm() {
		document.getElementById('status_form').submit();
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/partials/portal_header.jsp"%>
	<div id="wrapper">
		<%@ include file="/WEB-INF/partials/portal_navigator.jsp"%>
		<div class="body">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="form-actions-left">
						<a href="" onclick="window.history.back(); return false;"
							data-toggle="tooltip" title="Go Back" data-placement="bottom">
							<i class="fa fa-arrow-circle-o-left"></i>
						</a>
					</div>
					<div class="form-label">
						<c:if test='${operation eq "new"}'>
							<span>New Status</span>
						</c:if>
						<c:if test='${operation eq "update"}'>
							<span>${status.id}</span>
							<span><i>${status.label}</i></span>
						</c:if>
					</div>
					<div class="form-actions-right">
						<a onclick="saveStatusForm();" data-toggle="tooltip" title="Save Status" data-placement="bottom">
								<i class="fa fa-floppy-o icon-save"></i>
						</a>
					</div>
				</div>
				<div class="panel-form">
					<!-- Error Messages UI -->
					<div id="error-container" width="100%"></div>
					<%
						//Get form action based upon URI
						String formAction = request.getAttribute("javax.servlet.forward.request_uri").toString();
						formAction = formAction.substring(formAction.lastIndexOf('/') + 1);
					%>
					<form action="<%=formAction%>" method="POST" id="status_form">
						<div class="half-form row">
							<input type="hidden" name="id" value='${operation eq "update" ? status.id : ""}' />
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'label'}" />
									<jsp:param name="fieldLabel" value="${'Label'}" />
									<jsp:param name="value" value='${operation eq "update" ? status.label : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'table'}" />
									<jsp:param name="fieldLabel" value="${'Table'}" />
									<jsp:param name="value" value='${operation eq "update" ? status.table : ""}' />
								</jsp:include>				
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/number.jsp">
									<jsp:param name="fieldName" value="${'value'}" />
									<jsp:param name="fieldLabel" value="${'Value'}" />
									<jsp:param name="value" value='${operation eq "update" ? status.value : ""}' />
								</jsp:include>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/partials/portal_footer.jsp"%>
</body>
</html>