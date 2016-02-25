<div id="sidebar-wrapper">
	<div id="sidebar-profile">
		<table>
			<tbody>
				<tr>
					<td>
						<i class="fa fa-user"></i>
					</td>
					<td width="100%">
						<h5>Welcome, <strong>VSUser</strong></h5>
						<h6><i>Aeritae Consulting Group, Ltd.</i></h6>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="sidebar-nav">
		<div class="sidebar-section">
			<div class="sidebar-section-header" data-toggle="collapse" data-target="#list1" aria-expanded="false" aria-controls="list1" onclick="rotateChevron(this);">
				<span>Section 1</span>
				<i class="fa fa-chevron-circle-right"></i>
			</div>
			<div id="list1" class="collapse">
				<ul>
					<li>
						Item 1
					</li>
					<li>
						Item 2
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