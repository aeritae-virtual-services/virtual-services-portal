<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Error</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/partials/portal_header.jsp"%>
	<div id="wrapper" class="toggled">
		<%@ include file="/WEB-INF/partials/portal_navigator.jsp"%>
		<div class="body">
			<div class="jumbotron">
				<h1 style="text-align: center;">
					<i class="fa fa-frown-o"></i>
					<strong><i>Uh Oh!</i></strong>
				</h1>
				<div style="text-align: center; padding-left: 20px;">
					<h2 style="margin-bottom: 0px;">
						<strong>${status_code}</strong>
					</h2>
					<h3 style="font-weight: normal; margin-top: 0px;">${message}</h3>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/partials/portal_footer.jsp"%>
</body>
</html>