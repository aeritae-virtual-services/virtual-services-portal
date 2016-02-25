<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Login</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/partials/portal_header.jsp"%>
	<div class="body">
		<%@ include file="/WEB-INF/partials/progress_bar.jsp"%>
		<div class="jumbotron">
			<div class="login_header">
				<h3>Aeritae Virtual Services</h3>
				<p>Enter your username and password to log on.</p>
			</div>
			<div class="login_body">
				<c:if test='${not empty errmsg}'>
					<div class="alert alert-danger" role="alert">
						${errmsg} <i class="fa fa-times alert-close"></i>
					</div>
				</c:if>
				<form role="form" action="login" method="post" class="login_form">
					<fieldset class="form-group">
						<div class="input-group">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> <input type="text" name="username" class="form-control"
								placeholder="Username" aria-describedby="basic-addon1">
						</div>
					</fieldset>
					<fieldset class="form-group">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"> <i
								class="fa fa-lock"></i>
							</span> <input type="password" name="password" class="form-control"
								placeholder="Password" aria-describedby="basic-addon1">
						</div>
					</fieldset>
					<input type="hidden" name="redirectTo" value="${redirectTo}" /> <input
						class="btn btn-primary btn-float-right" role="button"
						type="submit" value="Login" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>