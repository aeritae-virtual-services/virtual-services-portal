<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Requests</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/partials/portal_header.jsp"%>
	<div id="wrapper">
		<%@ include file="/WEB-INF/partials/portal_navigator.jsp"%>
		<div class="body">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="form-actions-left">
						<a href="" onclick="window.history.back(); return false;"data-toggle="tooltip" title="Go Back" data-placement="bottom">
							<i class="fa fa-arrow-circle-o-left"></i>
						</a>
					</div>
					<div class="form-label">
						<span>SR0000111:</span>
						<span><i>Blue Cross Blue Shield</i></span>
					</div>
					<div class="form-actions-right">
						<a data-toggle="tooltip" title="Save Request" data-placement="bottom" >
							<i class="fa fa-floppy-o icon-save"></i>
						</a>
						<a data-toggle="tooltip" title="Place on Hold" data-placement="bottom" >
							<i class="fa fa-pause-circle-o icon-hold"></i>
						</a>
						<a data-toggle="tooltip" title="Cancel Request" data-placement="bottom" >
							<i class="fa fa-ban icon-cancel"></i>
						</a>
						<span class="form-action-break"></span>
						<a data-toggle="tooltip" title="Manage Attachments" data-placement="bottom">
							<span data-toggle="modal" data-target="#attachments-modal">
								<i class="fa fa-paperclip icon-attachments"></i>
								<span id="attachment-count" class="badge orange-badge badge-overlap">1</span>
							</span>
						</a>
						<a data-toggle="tooltip" title="View Comments" data-placement="bottom" >
							<span data-toggle="modal" data-target="#comments-modal">
								<i class="fa fa-comment-o icon-comments"></i>
								<span id="comment-count" class="badge orange-badge badge-overlap">1</span>
							</span>
						</a>
					</div>
				</div>
				<%@ include file="/WEB-INF/partials/request_progress_banner.jsp"%>
				<div class="panel-form">
				<!-- Error Messages UI -->
					<div id="error-container" width="100%"></div>
					<div class="third-form row">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<jsp:include page="../partials/fields/text.jsp">
								<jsp:param name="fieldName" value="${'client_request_number'}"/>
								<jsp:param name="fieldLabel" value="${'Client Request Number'}"/>
							</jsp:include>
							<jsp:include page="../partials/fields/dropdown.jsp">
								<jsp:param name="fieldName" value="${'request_type'}"/>
								<jsp:param name="fieldLabel" value="${'Request Type'}"/>
								<jsp:param name="optionList" value="${'requestTypeList'}"/>
							</jsp:include>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<jsp:include page="../partials/fields/reference.jsp">
								<jsp:param name="fieldName" value="${'requester'}"/>
								<jsp:param name="fieldLabel" value="${'Requester'}"/>
							</jsp:include>
							<jsp:include page="../partials/fields/checkbox.jsp">
								<jsp:param name="fieldName" value="${'request_loe'}"/>
								<jsp:param name="fieldLabel" value="${'Request Level of Effort'}"/>
							</jsp:include>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<jsp:include page="../partials/fields/future-date.jsp">
								<jsp:param name="fieldName" value="${'requested_completion_date'}"/>
								<jsp:param name="fieldLabel" value="${'Requested Completion Date'}"/>
							</jsp:include>
						</div>
					</div>
					<div class="half-form row">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<jsp:include page="../partials/fields/dropdown.jsp">
								<jsp:param name="fieldName" value="${'priority'}"/>
								<jsp:param name="fieldLabel" value="${'Priority'}"/>
								<jsp:param name="optionList" value="${'prioritiesList'}"/>
							</jsp:include>
							<jsp:include page="../partials/fields/text.jsp">
								<jsp:param name="fieldName" value="${'update_set'}"/>
								<jsp:param name="fieldLabel" value="${'Update Set'}"/>
							</jsp:include>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<jsp:include page="../partials/fields/number.jsp">
								<jsp:param name="fieldName" value="${'estimated_loe'}"/>
								<jsp:param name="fieldLabel" value="${'Estimated LOE'}"/>
							</jsp:include>
							<jsp:include page="../partials/fields/number.jsp">
								<jsp:param name="fieldName" value="${'hours_consumed'}"/>
								<jsp:param name="fieldLabel" value="${'Hours Consumed'}"/>
							</jsp:include>
						</div>
					</div>
					<div class="full-form row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<jsp:include page="../partials/fields/text.jsp">
								<jsp:param name="fieldName" value="${'short_description'}"/>
								<jsp:param name="fieldLabel" value="${'Short Description'}"/>
							</jsp:include>
							<jsp:include page="../partials/fields/textarea.jsp">
								<jsp:param name="fieldName" value="${'description'}"/>
								<jsp:param name="fieldLabel" value="${'Description'}"/>
							</jsp:include>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/partials/attachments_modal.jsp"%>
	<%@ include file="/WEB-INF/partials/comments_modal.jsp"%>
	<%@ include file="/WEB-INF/partials/portal_footer.jsp"%>
</body>
</html>