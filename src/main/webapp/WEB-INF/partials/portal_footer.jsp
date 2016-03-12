<footer class="portal-footer">
	<div class="aeritae-services hidden-xs">
		<div class="row">
			<div class="col-sm-3">
				<div class="thumbnail">
					<h4>
						<i class="fa fa-cog"></i>
					</h4>
					<h4>Strategic Services</h4>
					<div class="thumbnail-body">
						Assessments<br>
						Systems Development Life Cycle (SDLC)<br>
						Program Management<br>
						Organizational Development<br>
						Interim Leadership<br>
						IT Financial Management<br>
						Strategy Development<br>
						Enterprise Architecture
					</div>
					<div class="thumbnail-footer">
						<a href="http://aeritae.com/what-we-do/strategic-services/" target="_blank">Learn More<i class="fa fa-caret-right"></i></a>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="thumbnail">
					<h4>
						<i class="fa fa-lightbulb-o"></i>
					</h4>
					<h4>Service Innovation</h4>
					<div class="thumbnail-body">
						Platform Services<br>
						Expert Services<br>
						Virtual Services<br>
						Customer Solutions<br>
						Custom Applications
					</div>
					<div class="thumbnail-footer">
						<a href="http://aeritae.com/what-we-do/service-innovation/" target="_blank">Learn More<i class="fa fa-caret-right"></i></a>
					</div>
				</div>
			</div>	
			<div class="col-sm-3">			
				<div class="thumbnail">
					<h4>
						<i class="fa fa-cloud"></i>
					</h4>
					<h4>Technical Services</h4>
					<div class="thumbnail-body">
						Application Performance Management (APM)<br>
						Security Operations<br>
						Data Center Services<br>
						Cloud Architecture<br>
					</div>
					<div class="thumbnail-footer">
						<a href="http://aeritae.com/what-we-do/technical-services/" target="_blank">Learn More<i class="fa fa-caret-right"></i></a>
					</div>
				</div>
			</div>
			<div class="col-sm-3">		
				<div class="thumbnail">
					<h4>
						<i class="fa fa-user"></i>
					</h4>
					<h4>Talent Services</h4>
					<div class="thumbnail-body">
						Interim CIO Placement<br>
						Senior Leadership Placement<br>
						Staff Augmentation<br>
						Leadership Development<br>
					</div>
					<div class="thumbnail-footer">
						<a href="http://aeritae.com/what-we-do/talent-services/" target="_blank">Learn More<i class="fa fa-caret-right"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<section class="container footer-in">
		<div class="col-md-6">
			<div class="widget">
				<div class="textwidget">
					<p class="hidden-xs" style="padding-top: 5px; cursor: pointer;"
						onclick="toggleServicesWindow();">About Aeritae</p>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="widget">
				<div class="textwidget">
					<p align="right" style="padding-top: 5px">
						Copyright <i class="fa fa-copyright"></i> 2016 Aeritae. All rights
						reserved.
					</p>
				</div>
			</div>
		</div>
	</section>
</footer>
<script>
	$('#aeritae-services-carousel').carousel({
		interval: 1000 * 10
	});
	function toggleServicesWindow() {
		$('.aeritae-services').toggle('fast');
	}
</script>