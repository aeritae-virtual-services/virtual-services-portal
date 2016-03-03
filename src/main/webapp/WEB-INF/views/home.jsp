<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.vsportal.user.*" %>
<%@ page import="com.vsportal.role.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Services | Home</title>
<%@ include file="/WEB-INF/partials/include_libraries.jsp"%>
<script src="${pageContext.servletContext.contextPath}/resources/js/reporting-d3.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/reporting-c3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/reporting-c3.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/partials/portal_header.jsp"%>
	<div id="wrapper">
		<%@ include file="/WEB-INF/partials/portal_navigator.jsp"%>
		<div class="body">
		<div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
          My Approvals</a> <span class="badge orange-badge">3</span>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Request Number</th>
                <th>Task</th>
                <th>Client</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1156423</td>
                <td>Create Catalog Item</td>
                <td>Blue Cross</td>
              </tr>
              <tr>
                <td>8656544</td>
                <td>Change email Notification</td>
                <td>Buffalo wild Wings</td>
              </tr>
              <tr>
                <td>1235643</td>
                <td>Create new client script</td>
                <td>Buffalo Wild Wings</td>
              </tr>
            </tbody>
          </table>


        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
          More Information Requests</a>
          <span class="badge orange-badge">2</span>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Request Number</th>
                <th>Task</th>
                <th>Client</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1156423</td>
                <td>Create Catalog Item</td>
                <td>Blue Cross</td>
              </tr>
              <tr>
                <td>8656544</td>
                <td>Change email Notification</td>
                <td>Buffalo wild Wings</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
          Recent Comments</a>
          
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
          <label>You have no new comments at this time</label>
        </div>
      </div>
    </div>
        <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">
          Open Requests</a>
          <span class="badge orange-badge">3</span>
        </h4>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>Request Number</th>
                <th>Task</th>
                <th>Client</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1156423</td>
                <td>Create Catalog Item</td>
                <td>Blue Cross</td>
              </tr>
              <tr>
                <td>8656544</td>
                <td>Change email Notification</td>
                <td>Buffalo wild Wings</td>
              </tr>
              <tr>
                <td>1235643</td>
                <td>Create new client script</td>
                <td>Buffalo Wild Wings</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
		</div>
	</div>
	<%@ include file="/WEB-INF/partials/portal_footer.jsp"%>
</body>
</html>