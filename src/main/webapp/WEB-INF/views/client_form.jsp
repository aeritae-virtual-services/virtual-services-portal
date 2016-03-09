<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Clients</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
<script>
	function saveClientForm() {
		document.getElementById('client_form').submit();
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
							<span>New Client</span>
						</c:if>
						<c:if test='${operation eq "update"}'>
							<span>${client.name}</span>
						</c:if>
					</div>
					<div class="form-actions-right">
						<a onclick="saveClientForm();" data-toggle="tooltip" title="Save Client" data-placement="bottom">
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
					<form action="<%=formAction%>" method="POST" id="client_form">
						<div class="half-form row">
							<input type="hidden" name="id" value='${operation eq "update" ? client.id : ""}' />
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'name'}" />
									<jsp:param name="fieldLabel" value="${'Name'}" />
									<jsp:param name="value" value='${operation eq "update" ? client.name : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/hyperlink.jsp">
									<jsp:param name="fieldName" value="${'url'}" />
									<jsp:param name="fieldLabel" value="${'URL'}" />
									<jsp:param name="value" value='${operation eq "update" ? client.url : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'queue_manager'}" />
									<jsp:param name="fieldLabel" value="${'Queue Manager'}" />
									<jsp:param name="value" value='${operation eq "update" ? client.queueManager.id : ""}' />
								</jsp:include>				
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'primary_contact'}" />
									<jsp:param name="fieldLabel" value="${'Primary Contact'}" />
									<jsp:param name="value" value='${operation eq "update" ? client.primaryContact.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'address'}"/>
									<jsp:param name="fieldLabel" value="${'Address'}"/>
									<jsp:param name="value" value='${operation eq "update" ? client.address : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/checkbox.jsp">
									<jsp:param name="fieldName" value="${'migration_required'}"/>
									<jsp:param name="fieldLabel" value="${'Migration Requiered?'}"/>
									<jsp:param name="value" value='${operation eq "update" ? client.migrationRequired : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/checkbox.jsp">
									<jsp:param name="fieldName" value="${'client_po_required'}"/>
									<jsp:param name="fieldLabel" value="${'Client PO Required?'}"/>
									<jsp:param name="value" value='${operation eq "update" ? client.clientPORequired : ""}' />
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