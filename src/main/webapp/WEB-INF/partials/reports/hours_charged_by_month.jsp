<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.vsportal.utils.ReportingHelper" %>
<%
	ReportingHelper rh = new ReportingHelper();
	String encodedJSON = rh.getHoursChargedByMonthFor(request.getParameter("client_id"), 6);
%>
<div id="hours-charged-by-month"></div>
<script>
	var encodedJson = '<%= encodedJSON%>';
	var hrsChrgedByMonth = c3.generate(JSON.parse(encodedJson));
</script>