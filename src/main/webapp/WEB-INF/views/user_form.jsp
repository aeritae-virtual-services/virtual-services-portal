<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Users</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
<script>
	function saveUserForm() {
		document.getElementById('user_form').submit();
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
							<span>New User</span>
						</c:if>
						<c:if test='${operation eq "update"}'>
							<span>${user.fullName}</span>
							<span><i>${user.client.name}</i></span>
						</c:if>
					</div>
					<div class="form-actions-right">
						<a onclick="saveUserForm();" data-toggle="tooltip" title="Save User" data-placement="bottom">
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
					<form action="<%=formAction%>" method="POST" id="user_form">
						<div class="half-form row">
							<input type="hidden" name="id" value='${operation eq "update" ? user.id : ""}' />
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'first_name'}" />
									<jsp:param name="fieldLabel" value="${'First Name'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.firstName : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'last_name'}" />
									<jsp:param name="fieldLabel" value="${'Last Name'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.lastName : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/text.jsp">
									<jsp:param name="fieldName" value="${'username'}" />
									<jsp:param name="fieldLabel" value="${'User Name'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.username : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/reference.jsp">
									<jsp:param name="fieldName" value="${'client'}" />
									<jsp:param name="fieldLabel" value="${'Client'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.client.id : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/image_upload.jsp">
									<jsp:param name="fieldName" value="${'image'}" />
									<jsp:param name="fieldLabel" value="${'Image'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.image : "https://www.wpclipart.com/signs_symbol/icons_oversized/male_user_icon.png"}' />
								</jsp:include>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<jsp:include page="../partials/fields/phonenumber.jsp">
									<jsp:param name="fieldName" value="${'phone_number'}" />
									<jsp:param name="fieldLabel" value="${'Phone Number'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.phone : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/email.jsp">
									<jsp:param name="fieldName" value="${'email'}" />
									<jsp:param name="fieldLabel" value="${'Email'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.email : ""}' />
								</jsp:include>
								<jsp:include page="../partials/fields/dropdown.jsp">
									<jsp:param name="fieldName" value="${'role'}" />
									<jsp:param name="fieldLabel" value="${'Role'}" />
									<jsp:param name="value" value='${operation eq "update" ? user.role.id : ""}' />
									<jsp:param name="optionList" value="${'rolesList'}" />
								</jsp:include>
								<jsp:include page="../partials/fields/password.jsp">
									<jsp:param name="fieldName" value="${'password'}" />
									<jsp:param name="fieldLabel" value="${'Password'}" />
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