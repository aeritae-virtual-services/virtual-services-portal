<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//Generate URL for Links
	String formAction = request.getAttribute("javax.servlet.forward.request_uri").toString();
	formAction = formAction.substring(formAction.lastIndexOf('/') + 1);
	formAction = formAction.replace("_list", "");
%>
<div class="panel panel-default">
	<div class="panel-heading">
		<div class="form-actions-left">
			<a href="" onclick="window.history.back(); return false;"
				data-toggle="tooltip" title="Go Back" data-placement="bottom"> <i
				class="fa fa-arrow-circle-o-left"></i>
			</a>
		</div>
		<div class="form-label">
			<span> ${label} </span>
		</div>
	</div>
	<div class="panel-form">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th />
						<c:forEach var="column" items="${columnList}">
							<th>${column.columnLabel}</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${recordList}">
						<tr>
							<td>
								<a href="update_<%=formAction%>?id=${record.id}">
									<i	class="fa fa-arrow-circle-o-right"></i>
								</a>
							</td>
							<c:forEach var="cell" items="${columnList}">
								<td>
									${record.getClass().getField(cell.columnName).get(record)}
								</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>