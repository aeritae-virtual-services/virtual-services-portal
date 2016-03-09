<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Approvals</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
<script>
	function saveApprovalForm() {
		document.getElementById('approval_form').submit();
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
							<span>New Approval</span>
						</c:if>
						<c:if test='${operation eq "update"}'>
							<span>${approval.id}</span>
							<span><i>${approval.name}</i></span>
						</c:if>
					</div>
					<div class="form-actions-right">
						<a onclick="saveApprovalForm();" data-toggle="tooltip" title="Save Approval" data-placement="bottom">
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
					<form action="<%=formAction%>" method="POST" id="approval_form">
						<div class="half-form row">
							<input type="hidden" name="id" value='${operation eq "update" ? approval.id : ""}' />
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'client'}" />
									<jsp:param name="fieldLabel" value="${'Client'}" />
									<jsp:param name="value" value='${operation eq "update" ? approval.client.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'request'}"/>
									<jsp:param name="fieldLabel" value="${'Request'}"/>
									<jsp:param name="value" value='${operation eq "update" ? approval.request.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'approval_type'}"/>
									<jsp:param name="fieldLabel" value="${'Approval Type'}"/>
									<jsp:param name="value" value='${operation eq "update" ? approval.approvalType : ""}' />
								</jsp:include>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'approved_by'}"/>
									<jsp:param name="fieldLabel" value="${'Approved By'}"/>
									<jsp:param name="value" value='${operation eq "update" ? approval.approvedBy.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/date.jsp">
									<jsp:param name="fieldName" value="${'decision_date'}" />
									<jsp:param name="fieldLabel" value="${'Decision Date'}" />
									<jsp:param name="value" value='${operation eq "update" ? approval.decisionDate : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'decision'}"/>
									<jsp:param name="fieldLabel" value="${'Decision'}"/>
									<jsp:param name="value" value='${operation eq "update" ? approval.decision : ""}' />
								</jsp:include>	
							</div>
						</div>
						<div class="full-form row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'description'}"/>
									<jsp:param name="fieldLabel" value="${'Description'}"/>
									<jsp:param name="value" value='${operation eq "update" ? approval.description : ""}' />
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