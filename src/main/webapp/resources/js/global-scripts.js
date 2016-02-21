//Provide ability to close alerts
$(document).ready(function() {
	$('.alert-close').click(function() {
		$(this).parent().hide();
	});
});