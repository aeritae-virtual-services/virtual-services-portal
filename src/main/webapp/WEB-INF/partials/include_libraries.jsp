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

<!-- Include Moment.js -->
<script src="${pageContext.servletContext.contextPath}/resources/js/moment.js?<%= new java.util.Date() %>"></script>

<!-- Include Bootstrap Date-Time Picker -->
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-datepicker.js?<%= new java.util.Date() %>"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-datepicker.css?<%= new java.util.Date() %>">

<!-- Include FontAwesome Icons 4.5.0 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- Include TinyMCE 4 -->
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>

<!-- Include Masked Inputs -->
<script src="${pageContext.servletContext.contextPath}/resources/js/masked-input.js?<%= new java.util.Date() %>"></script>

<!-- Include Form Validation -->
<script src="${pageContext.servletContext.contextPath}/resources/js/form-validation.js?<%= new java.util.Date() %>"></script>

<!-- Include Navigation Bar CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/simple-sidebar.css?<%= new java.util.Date() %>">

<!-- Include Reporting Capabilities -->
<script src="${pageContext.servletContext.contextPath}/resources/js/reporting-d3.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/reporting-c3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/reporting-c3.min.css">

<!-- Include AE Features -->
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/vsportal.css?<%= new java.util.Date() %>">
<link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>
<script src="${pageContext.servletContext.contextPath}/resources/js/global-scripts.js?<%= new java.util.Date() %>"></script>

<!-- Set Shortcut Icon -->
<link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/ae_icon_white.png">