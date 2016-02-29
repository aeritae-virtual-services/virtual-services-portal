<div class="progress-wrapper">
	<div class="progress btn-group btn-group-justified">
		<a class="btn progress-bar-past progress-bar-first"> Submitted </a>
		<a class="btn progress-bar-past"> Requirements </a>
		<a class="btn progress-bar-current"> Assessing LOE </a>
		<a class="btn progress-bar-future"> Designing </a>
		<a class="btn progress-bar-future"> Developing </a>
		<a class="btn progress-bar-future"> Testing </a>
		<a class="btn progress-bar-future progress-bar-last"> Complete </a>
	</div>
	<script>
		//Progress Resizing
		$(window).load(function() {
			resizeProgressBanner();
		});
		$(window).resize(function() {
			resizeProgressBanner();
		});

		function resizeProgressBanner() {
			if ($(window).width() < 768) {
				$('.progress').removeClass('btn-group');
				$('.progress').removeClass('btn-group-justified');
				$('.progress').addClass('btn-group-vertical');
			} else {
				$('.progress').removeClass('btn-group-vertical');
				$('.progress').addClass('btn-group');
				$('.progress').addClass('btn-group-justified');
			}
		}
	</script>
</div>