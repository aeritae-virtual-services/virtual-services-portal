<!-- Include AE StyleSheet -->
<link rel="stylesheet" type="text/css" href="/vsportal/src/main/webapp/resources/css/vsportal.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

<!-- Include JSTL Functions/Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Include jQuery 2.2.0 -->
<script src="/vsportal/src/main/webapp/resources/js/jquery-2.2.0.min.js"></script>

<!-- Include Bootstrap 3.3.6 -->
<script src="/vsportal/src/main/webapp/resources/js/bootstrap-3.3.6.min.js"></script>
<link rel="stylesheet" type="text/css" href="/vsportal/src/main/webapp/resources/css/bootstrap-3.3.6.css">
<link rel="stylesheet" type="text/css" href="/vsportal/src/main/webapp/resources/css/bootstrap-theme-3.3.6.css">

<!-- Include Bootstrap Date-Time Picker -->
<script src="/vsportal/src/main/webapp/resources/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="/vsportal/src/main/webapp/resources/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript">
	//Apply Date/Time Picker to Appropriate Fields
	$(document).ready(function() {
		//Apply Date Pickers
		$('.datepicker').datetimepicker({
			language: 'en',
			pickTime: false
		});
		//Apply Future Date Pickers
		$('.future-datepicker').datetimepicker({
			language: 'en',
			pickTime: false,
			startDate: now()
		});
		//Apply Date Time Pickers
		$('.datetimepicker').datetimepicker({
			language: 'en'
		});
		//Apply Future Date Time Pickers
		$('.future-datetimepicker').datetimepicker({
			language: 'en',
			startDate: now()
		});
	});
</script>

<!-- Include FontAwesome Icons 4.5.0 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- Include TinyMCE 4 -->
<script src="/vsportal/src/main/webapp/resources/js/tinymce.min.js"></script>
<script type="text/javascript">
	//Apply HTML Editor to Appropriate Fields
	$(document).ready(function() {
		tinymce.init({
			selector: '.html-editor'
		});
	});
</script>

<!-- Include Form Validation -->
<script src="/vsportal/src/main/webapp/resources/js/form-validation.js"></script>