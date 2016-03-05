<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Workflow Steps</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
<script>
	function saveWorkflowStepForm() {
		document.getElementById('workflow_step_form').submit();
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
							<span>New Workflow Step</span>
						</c:if>
						<c:if test='${operation eq "update"}'>
							<span>${workflowStep.id}</span>
						</c:if>
					</div>
					<div class="form-actions-right">
						<a onclick="saveWorkflowStepForm();" data-toggle="tooltip" title="Save Workflow Step" data-placement="bottom">
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
					<form action="<%=formAction%>" method="POST" id="workflow_step_form">
						<div class="half-form row">
							<input type="hidden" name="id" value='${operation eq "update" ? workflowStep.id : ""}' />
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">				
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'operation'}" />
									<jsp:param name="fieldLabel" value="${'Operation'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.operation.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'success_next_step'}" />
									<jsp:param name="fieldLabel" value="${'Success next step'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.successNextStep.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'fail_next_step'}" />
									<jsp:param name="fieldLabel" value="${'Fail next step'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.failNextStep.id : ""}' />
								</jsp:include>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'email_template'}" />
									<jsp:param name="fieldLabel" value="${'Email Template'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.emailTemplate.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'assignment_group'}" />
									<jsp:param name="fieldLabel" value="${'Assignment Group'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.assignmentGroup.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'new_status'}" />
									<jsp:param name="fieldLabel" value="${'New Status'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.newStatus.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/checkbox.jsp">
									<jsp:param name="fieldName" value="${'write_metric'}" />
									<jsp:param name="fieldLabel" value="${'Write Metric'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.writeMetric : ""}' />
								</jsp:include>
							</div>
						</div>
						<div class="full-form row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'instructions'}" />
									<jsp:param name="fieldLabel" value="${'Instructions'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.instructions : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/textarea.jsp">
									<jsp:param name="fieldName" value="${'description'}" />
									<jsp:param name="fieldLabel" value="${'Description'}" />
									<jsp:param name="value" value='${operation eq "update" ? workflowStep.description : ""}' />
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