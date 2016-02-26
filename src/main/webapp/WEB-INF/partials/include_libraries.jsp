<!-- Include JSTL Functions/Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Include Java Util Library -->
<%@page import="java.util.*" %>

<!-- Include jQuery 2.2.0 -->
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.2.0.min.js"></script>

<!-- Include Bootstrap 3.3.6 -->
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-3.3.6.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-3.3.6.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-theme-3.3.6.css">
<script>
	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip({
	        trigger : 'hover'
	    });
	});
</script>

<!-- Include Bootstrap Date-Time Picker -->
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-datepicker.css">
<script type="text/javascript">
	//Apply Date/Time Picker to Appropriate Fields
	$(document).ready(function() {
		//Apply Date Pickers
		$('.datepicker').datepicker();
		//Apply Future Date Pickers
		$('.future-datepicker').datepicker();
	});
</script>

<!-- Include FontAwesome Icons 4.5.0 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- Include TinyMCE 4 -->
<script src="${pageContext.servletContext.contextPath}/resources/js/tinymce.min.js"></script>
<script type="text/javascript">
	//Apply HTML Editor to Appropriate Fields
	$(document).ready(function() {
		tinymce.init({
			selector: '.html-editor'
		});
	});
</script>

<!-- Include Form Validation -->
<script src="${pageContext.servletContext.contextPath}/resources/js/form-validation.js"></script>

<!-- Include Navigation Bar CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/simple-sidebar.css?<%= new java.util.Date() %>">

<!-- Include AE Features -->
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/vsportal.css?<%= new java.util.Date() %>">
<link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>
<script src="${pageContext.servletContext.contextPath}/resources/js/global-scripts.js"></script>

<!-- Set Shortcut Icon -->
<link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/ae_icon_white.png">