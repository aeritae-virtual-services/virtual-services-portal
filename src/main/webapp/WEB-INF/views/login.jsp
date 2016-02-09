<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Virtual Services | Login</title>
	<%@ include file="/WEB-INF/partials/include_libraries.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/partials/portal_header.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<div class="login_header">
				<div class="login_header_left">
					<h3>
						Aeritae Virtual Services
					</h3>
					<p>
						Enter your username and password to log on.
					</p>
				</div>
				<div class="login_header_right">
					<img class="login_header_logo" src="/vsportal/src/main/webapp/resources/images/ae_icon_white.png" />
				</div>
			</div>
			<div class="login_body">
				<form role="form" action="site_login" method="post" class="login_form">
					<fieldset class="form-group">
						<span class="input-group-addon" id="basic-addon1">
							<i class="fa fa-user"></i>
						</span>
						<input type="text" name="user_name" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
					</fieldset>
					<fieldset class="form-group">
						<span class="input-group-addon" id="basic-addon1">
							<i class="fa fa-lock"></i>
						</span>
						<input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
					</fieldset>
					<input class="btn btn-primary" role="button" type="submit" value="Login" />
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/partials/portal_footer.jsp" %>
</body>
</html>