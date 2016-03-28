<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar-wrapper">
	<div id="sidebar-profile">
		<table>
			<tbody>
				<tr>
					<td>
						<c:if test="${sessionUser.image empty}">
							<i class="fa fa-user"></i>
						</c:if>
						<c:if test="${sessionUser.image not empty}">
							<img src="${sessionUser.image}" height="20px"/>
						</c:if>
					</td>
					<td width="100%">
						<h5>Welcome, <strong>${sessionUser.full_name}</strong></h5>
						<h6><i>${sessionUser.client.displayValue}</i></h6>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="sidebar-nav">
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#requestlist" aria-expanded="false" aria-controls="requestlist" onclick="rotateChevron(this);">
				<span>Requests</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="requestlist" class="collapse">
				<ul>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Open Requests -->
						<li>		
							<a href="">
								My Open Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Closed Requests -->
						<li>		
							<a href="">
								My Closed Requests
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#list2" aria-expanded="false" aria-controls="list2" onclick="rotateChevron(this);">
				<span>Section 2</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="list2" class="collapse">
				<ul>
					<li>
						Item 3
					</li>
					<li>
						Item 4
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<script>
	function rotateChevron(el) {
		var icon = $(el).find('.fa');
		if(icon.hasClass('fa-chevron-circle-right')) {
			icon.removeClass('fa-chevron-circle-right');
			icon.addClass('fa-chevron-circle-down');
		} else {
			icon.removeClass('fa-chevron-circle-down');
			icon.addClass('fa-chevron-circle-right');
		}
	}
</script>