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
						<!-- End User: My More Info Requests -->
						<li>		
							<a href="">
								My More Info Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My On Hold Requests -->
						<li>		
							<a href="">
								My On Hold Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Closed/Cancelled Requests -->
						<li>		
							<a href="">
								My Closed/Cancelled Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: Recent Request Comments -->
						<li>		
							<a href="">
								Recent Request Comments
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): Open Requests -->
						<li>		
							<a href="">
								Open Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Requests -->
						<li>		
							<a href="">
								All Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Pending Pokes -->
						<li>		
							<a href="">
								All Pending Pokes
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#approvalslist" aria-expanded="false" aria-controls="approvalslist" onclick="rotateChevron(this);">
				<span>Approvals</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="approvalslist" class="collapse">
				<ul>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Pending Approvals -->
						<li>		
							<a href="">
								My Pending Approvals
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#tasklist" aria-expanded="false" aria-controls="tasklist" onclick="rotateChevron(this);">
				<span>Task</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="tasklist" class="collapse">
				<ul>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Open Assigned Tasks -->
						<li>		
							<a href="">
								My Open Assigned Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Clients Unassigned Open Tasks -->
						<li>		
							<a href="">
								My Clients Unassigned Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: All My Clients Open Tasks -->
						<li>		
							<a href="">
								All My Clients Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: All Unassigned Open Tasks -->
						<li>		
							<a href="">
								All Unassigned Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: All Open Tasks -->
						<li>		
							<a href="">
								All Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Open Poked Tasks -->
						<li>		
							<a href="">
								My Open Poked Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Recent Comments -->
						<li>		
							<a href="">
								My Recent Comments
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My On Hold Tasks -->
						<li>		
							<a href="">
								My On Hold Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My More Info Tasks -->
						<li>		
							<a href="">
								My More Info Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Open Assigned Tasks -->
						<li>		
							<a href="">
								My Open Assigned Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Clients Unassigned Open Tasks -->
						<li>		
							<a href="">
								My Clients Unassigned Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All My Clients Open Tasks -->
						<li>		
							<a href="">
								All My Clients Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All Unassigned Open Tasks -->
						<li>		
							<a href="">
								All Unassigned Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All Open Tasks -->
						<li>		
							<a href="">
								All Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Open Poked Tasks -->
						<li>		
							<a href="">
								My Open Poked Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Recent Comments -->
						<li>		
							<a href="">
								My Recent Comments
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My On Hold Tasks -->
						<li>		
							<a href="">
								My On Hold Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My More Info Tasks -->
						<li>		
							<a href="">
								My More Info Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Pending Pokes -->
						<li>		
							<a href="">
								My Pending Pokes
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Availability for Today -->
						<li>		
							<a href="">
								All Availability for Today
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#clientinformationlist" aria-expanded="false" aria-controls="clientinformationlist" onclick="rotateChevron(this);">
				<span>Client Information</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="clientinformationlist" class="collapse">
				<ul>
										<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Contracts -->
						<li>		
							<a href="">
								My Contracts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My User Contacts -->
						<li>		
							<a href="">
								My User Contacts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Client Information -->
						<li>		
							<a href="">
								My Client Information
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: All Client Contacts -->
						<li>		
							<a href="">
								All Client Contacts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: All Client Environment Information -->
						<li>		
							<a href="">
								All Client Environment Information
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All Client Contacts -->
						<li>		
							<a href="">
								All Client Contacts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All Client Environment Information -->
						<li>		
							<a href="">
								All Client Environment Information
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All Clients -->
						<li>		
							<a href="">
								All Clients
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Clients Current Contracts -->
						<li>		
							<a href="">
								My Clients Current Contracts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All My Clients Contracts -->
						<li>		
							<a href="">
								All My Clients Contracts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Clients -->
						<li>		
							<a href="">
								My Clients
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All Groups -->
						<li>		
							<a href="">
								All Groups
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Active Clients -->
						<li>		
							<a href="">
								All Active Clients
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Clients -->
						<li>		
							<a href="">
								All Clients
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Current Contracts -->
						<li>		
							<a href="">
								All Current Contracts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Contracts -->
						<li>		
							<a href="">
								All Contracts
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#usermanagementlist" aria-expanded="false" aria-controls="usermanagementlist" onclick="rotateChevron(this);">
				<span>User Management</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="usermanagementlist" class="collapse">
				<ul>
					<!-- TODO -->
				</ul>
			</div>
		</div>
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#reportinglist" aria-expanded="false" aria-controls="reportinglist" onclick="rotateChevron(this);">
				<span>Reporting</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="reportinglist" class="collapse">
				<ul>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Reports -->
						<li>		
							<a href="">
								My Reports
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Reports -->
						<li>		
							<a href="">
								My Reports
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): My Reports -->
						<li>		
							<a href="">
								My Reports
							</a>
						</li>
					</c:if>

				</ul>
			</div>
		</div>
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#administrationlist" aria-expanded="false" aria-controls="administrationlist" onclick="rotateChevron(this);">
				<span>Administration</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="administrationlist" class="collapse">
				<ul>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: Update My Availability -->
						<li>		
							<a href="">
								Update My Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Recent Time Entries -->
						<li>		
							<a href="">
								My Recent Time Entries
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: Update My Availability -->
						<li>		
							<a href="">
								Update My Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Recent Time Entries -->
						<li>		
							<a href="">
								My Recent Time Entries
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: View All Availability -->
						<li>		
							<a href="">
								View All Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Groups -->
						<li>		
							<a href="">
								All Groups
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Users -->
						<li>		
							<a href="">
								All Users
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): Update My Availability -->
						<li>		
							<a href="">
								Update My Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Tiers -->
						<li>		
							<a href="">
								All Tiers
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Email Log -->
						<li>		
							<a href="">
								Email Log
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Email Template -->
						<li>		
							<a href="">
								Email Template
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Workflow Operations -->
						<li>		
							<a href="">
								Workflow Operations
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Workflow Steps -->
						<li>		
							<a href="">
								Workflow Steps
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Roles -->
						<li>		
							<a href="">
								Roles
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Request Types -->
						<li>		
							<a href="">
								Request Types
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Priorities -->
						<li>		
							<a href="">
								Priorities
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Status -->
						<li>		
							<a href="">
								Status
							</a>
						</li>
					</c:if>
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