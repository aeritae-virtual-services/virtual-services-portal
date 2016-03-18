<div id="sidebar-wrapper">
	<div id="sidebar-profile">
		<table>
			<tbody>
				<tr>
					<td>
						<i class="fa fa-user"></i>
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
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#list1" aria-expanded="false" aria-controls="list1" onclick="rotateChevron(this);">
				<span>Requests</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="list1" class="collapse">
				<ul>
					<li>
						My Open Requests
					</li>
					<li>
						My Closed Requests
					</li>
					<li>
						All Open Requests
					</li>
					<li>
						All Closed Requests
					</li>
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