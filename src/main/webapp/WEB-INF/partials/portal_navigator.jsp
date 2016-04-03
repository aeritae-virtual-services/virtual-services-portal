<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar-wrapper">
	<div id="sidebar-profile">
		<table>
			<tbody>
				<tr>
					<td>
						<c:if test="${empty sessionUser.image}">
							<i class="fa fa-user"></i>
						</c:if>
						<c:if test="${not empty sessionUser.image}">
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
					<!-- c:if test="${sessionUser.role.id eq 1}"-->
						<!-- End User: My Open Requests -->
						<li>		
							<a href="request_list?query=Request.requester=${sessionUser.id}^reqstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								<i class="fa fa-chevron-right"></i>
								My Open Requests
							</a>
						</li>
					<!-- /c:if -->
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My More Info Requests -->
						<li>		
							<a href="request_list?query=Request.requester=${sessionUser.id}^reqstatus.label='More Info'">
								My More Info Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My On Hold Requests -->
						<li>		
							<a href="request_list?query=Request.requester=${sessionUser.id}^reqstatus.label='On Hold'">
								My On Hold Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Closed/Cancelled Requests -->
						<li>		
							<a href="request_list?query=Request.requester=${sessionUser.id}}^reqstatus.label IN ('Closed','Cancelled')">
								My Closed/Cancelled Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: Recent Request Comments -->
						<li>		
							<a href="comment_list?query=requestid.requester=${sessionUser.id}^((Now()-Comment.created)<=7)">
								Recent Request Comments
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): Open Requests -->
						<li>		
							<a href="request_list?query=reqstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								Open Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Requests -->
						<li>		
							<a href="request_list?query=">
								All Requests
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Pending Pokes -->
						<li>		
							<a href="task_list?query=Task.poked_analyst IS NOT NULL">
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
							<a href="task_list?query=Task.assigned_to=${sessionUser.id}^taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
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
							<a href="task_list?query=Task.assigned_to IS NULL ^taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								All Unassigned Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: All Open Tasks -->
						<li>		
							<a href="task_list?query=taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								All Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Open Poked Tasks -->
						<li>		
							<a href="task_list?query=Task.poked_analyst=${sessionUser.id}^taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								My Open Poked Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Recent Comments -->
						<li>		
							<a href="comment_list?query=((Now()-Comment.created)<=7)^requestid.id IN (SELECT RequestGrab.id FROM Task LEFT JOIN Request As RequestGrab ON Task.request_id = RequestGrab.id LEFT JOIN Status As TaskStatus ON Task.task_status = TaskStatus.id WHERE Task.assigned_to = ${sessionUser.id} AND TaskStatus.label NOT IN ('On Hold','More Info', 'Completed', 'Cannceled'))">
								My Recent Comments
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My On Hold Tasks -->
						<li>		
							<a href="task_list?query=Task.assigned_to=${sessionUser.id}^taskstatus.label='On Hold'">
								My On Hold Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My More Info Tasks -->
						<li>		
							<a href="task_list?query=Task.assigned_to=${sessionUser.id}^taskstatus.label='More Info'">
								My More Info Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Open Assigned Tasks -->
						<li>		
							<a href="task_list?query=Task.assigned_to=${sessionUser.id}^taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
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
							<a href="task_list?query=Task.assigned_to IS NULL ^taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								All Unassigned Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: All Open Tasks -->
						<li>		
							<a href="task_list?query=taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								All Open Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Open Poked Tasks -->
						<li>		
							<a href="task_list?query=Task.poked_analyst=${sessionUser.id}^taskstatus.label NOT IN ('On Hold','More Info','Closed','Cancelled')">
								My Open Poked Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Recent Comments -->
						<li>		
							<a href="comment_list?query=((Now()-Comment.created)<=7)^requestid.id IN (SELECT RequestGrab.id FROM Task LEFT JOIN Request As RequestGrab ON Task.request_id = RequestGrab.id LEFT JOIN Status As TaskStatus ON Task.task_status = TaskStatus.id WHERE Task.assigned_to = ${sessionUser.id} AND TaskStatus.label NOT IN ('On Hold','More Info', 'Completed', 'Cannceled'))">
								My Recent Comments
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My On Hold Tasks -->
						<li>		
							<a href="task_list?query=Task.assigned_to=${sessionUser.id}^taskstatus.label='On Hold'">
								My On Hold Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My More Info Tasks -->
						<li>		
							<a href="task_list?query=Task.assigned_to=${sessionUser.id}^taskstatus.label='More Info'">
								My More Info Tasks
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Pending Pokes -->
						<li>		
							<a href="task_list?query=Task.poked_analyst IS NOT NULL^Task.poked_by=${sessionUser.id}">
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
							<a href="contract_list?query=Contract.client_id=${sessionUser.client_id.id}">
								My Contracts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My User Contacts -->
						<li>		
							<a href="user_list?query=User.client_id=${sessionUser.client_id.id}">
								My User Contacts
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- End User: My Client Information -->
						<li>		
							<a href="client_list?query=Client.id=${sessionUser.client_id.id}">
								My Client Information
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: All Client Contacts -->
						<li>		
							<a href="user_list?query=client_id IS NOT NULL">
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
							<a href="user_list?query=client_id IS NOT NULL">
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
							<a href="client_list?query=">
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
							<a href="group_list?query=">
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
							<a href="client_lsit?query=">
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
							<a href="contract_list?query=">
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
							<a href="availability_list?query=Availability.analyst_id=${sessionUser.id}">
								Update My Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- VS Analyst: My Recent Time Entries -->
						<li>		
							<a href="time_entry_list?query=TimeEntry.created_by=${sessionUser.id}^((Now()-TimeEntry.created)<=7)">
								My Recent Time Entries
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: Update My Availability -->
						<li>		
							<a href="availability_list?query=Availability.analyst_id=${sessionUser.id}">
								Update My Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: My Recent Time Entries -->
						<li>		
							<a href="time_entry_list?query=TimeEntry.created_by=${sessionUser.id}^((Now()-TimeEntry.created)<=7)">
								My Recent Time Entries
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Q Manager: View All Availability -->
						<li>		
							<a href="avaliablity_list?query=">
								View All Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Groups -->
						<li>		
							<a href="group_list?query=">
								All Groups
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Users -->
						<li>		
							<a href="user_list?query=">
								All Users
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): Update My Availability -->
						<li>		
							<a href="availability_list?query=Availability.analyst_id=${sessionUser.id}">
								Update My Availability
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Service Line Leader (SLL): All Tiers -->
						<li>		
							<a href="tier_list?query=">
								All Tiers
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Email Log -->
						<li>		
							<a href="email_log_list?query=">
								Email Log
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Email Template -->
						<li>		
							<a href="email_template_list?query=">
								Email Template
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Workflow Operations -->
						<li>		
							<a href="workflow_operation_list?query=">
								Workflow Operations
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Workflow Steps -->
						<li>		
							<a href="workflow_step_list?query=">
								Workflow Steps
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Roles -->
						<li>		
							<a href="role_list?query=">
								Roles
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Request Types -->
						<li>		
							<a href="request_type_list?query=">
								Request Types
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Priorities -->
						<li>		
							<a href="priority_list?query=">
								Priorities
							</a>
						</li>
					</c:if>
					<c:if test="${sessionUser.role.id eq 1}">
						<!-- Admin: Status -->
						<li>		
							<a href="status_list?query=">
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