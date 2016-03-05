<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Email Logs</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
<script>
	function saveEmailLogForm() {
		document.getElementById('email_log_form').submit();
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
							<span>New Email Log</span>
						</c:if>
						<c:if test='${operation eq "update"}'>
							<span>${emailLog.id}</span>
						</c:if>
					</div>
					<div class="form-actions-right">
						<a onclick="saveEmailLogForm();" data-toggle="tooltip" title="Save Email Log" data-placement="bottom">
								<i class="fa fa-floppy-o icon-save"></i>
						</a>
					</div>
				</div>
				<div class="panel-form">
					<%
						//Get form action based upon URI
						String formAction = request.getAttribute("javax.servlet.forward.request_uri").toString();
						formAction = formAction.substring(formAction.lastIndexOf('/') + 1);
					%>
					<form action="<%=formAction%>" method="POST" id="email_log_form">
						<div class="half-form row">
							<input type="hidden" name="id" value='${operation eq "update" ? approval.id : ""}' />
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'direction'}"/>
									<jsp:param name="fieldLabel" value="${'Direction'}"/>
									<jsp:param name="value" value='${operation eq "update" ? emailLog.direction : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'template'}" />
									<jsp:param name="fieldLabel" value="${'Template'}" />
									<jsp:param name="value" value='${operation eq "update" ? emailLog.template.id : ""}' />
								</jsp:include>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'table_id'}" />
									<jsp:param name="fieldLabel" value="${'Table ID'}" />
									<jsp:param name="value" value='${operation eq "update" ? emailLog.table : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/number.jsp">
									<jsp:param name="fieldName" value="${'table_id'}" />
									<jsp:param name="fieldLabel" value="${'Table ID'}" />
									<jsp:param name="value" value='${operation eq "update" ? emailLog.tableId : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'status'}" />
									<jsp:param name="fieldLabel" value="${'Status'}" />
									<jsp:param name="value" value='${operation eq "update" ? emailLog.status.id : ""}' />
								</jsp:include>
							</div>
						</div>
						<div class="full-form row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'recipient'}"/>
									<jsp:param name="fieldLabel" value="${'Recipient'}"/>
									<jsp:param name="value" value='${operation eq "update" ? emailLog.recipient : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'from'}"/>
									<jsp:param name="fieldLabel" value="${'From'}"/>
									<jsp:param name="value" value='${operation eq "update" ? emailLog.from : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'subject'}"/>
									<jsp:param name="fieldLabel" value="${'Subject'}"/>
									<jsp:param name="value" value='${operation eq "update" ? emailLog.subject : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'body'}"/>
									<jsp:param name="fieldLabel" value="${'Body'}"/>
									<jsp:param name="value" value='${operation eq "update" ? emailLog.body : ""}' />
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