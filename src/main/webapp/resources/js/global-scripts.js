//Provide ability to close alerts
$(document).ready(function() {
	$('.alert-close').click(function() {
		$(this).parent().hide();
	});
});

//Navigate to URL from Click
function openLink(el) {
	var url = $(el).parent().find('.hyperlink').val() + '';
	window.open(url,'_blank');
}

//Call Phone Number from Click
function callThis(el) {
	var phone = $(el).parent().find('.phone-number').val() + '';
	window.location.href = "tel://" + phone;
}

//Send Email from Click
function emailThis(el) {
	var email = $(el).parent().find('.email').val() + '';
	window.location.href = "mailto:" + email;
	
}
//Add Tooltip Functionality
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip({
        trigger : 'hover'
    });
});

//Apply Datetimepicker Functionality
$(document).ready(function () {
    $('.date').datetimepicker({
    	icons: {
    		time: "fa fa-clock-o",
			date: "fa fa-calendar",
			up: "fa fa-chevron-up",
			down: "fa fa-chevron-down",
			previous: "fa fa-chevron-left",
			next: "fa fa-chevron-right",
			today: "fa fa-calendar-check-o",
			clear: "fa fa-trash-o",
			close: "fa fa-times"
        },
        showTodayButton: true,
        format: 'MM/DD/YYYY'
    });
    
    $('.datetime').datetimepicker({
    	icons: {
    		time: "fa fa-clock-o",
			date: "fa fa-calendar",
			up: "fa fa-chevron-up",
			down: "fa fa-chevron-down",
			previous: "fa fa-chevron-left",
			next: "fa fa-chevron-right",
			today: "fa fa-calendar-check-o",
			clear: "fa fa-trash-o",
			close: "fa fa-times"
        },
        showTodayButton: true
    });
    
    $('.future-date').each(function() {
    	var now = new Date();
    	var enteredDate = new Date($(this).val());
    	
    	if($(this).val() == '' || enteredDate > now) {
    		//If no date already selected, future date from now
    		$(this).datetimepicker({
		    	icons: {
		    		time: "fa fa-clock-o",
					date: "fa fa-calendar",
					up: "fa fa-chevron-up",
					down: "fa fa-chevron-down",
					previous: "fa fa-chevron-left",
					next: "fa fa-chevron-right",
					today: "fa fa-calendar-check-o",
					clear: "fa fa-trash-o",
					close: "fa fa-times"
		        },
		        minDate: now,
		        showTodayButton: true,
		        format: 'MM/DD/YYYY'
		    });
    	} else {
    		//If date already selected, future date from previously selected date
    		$(this).datetimepicker({
    	    	icons: {
    	    		time: "fa fa-clock-o",
    				date: "fa fa-calendar",
    				up: "fa fa-chevron-up",
    				down: "fa fa-chevron-down",
    				previous: "fa fa-chevron-left",
    				next: "fa fa-chevron-right",
    				today: "fa fa-calendar-check-o",
    				clear: "fa fa-trash-o",
    				close: "fa fa-times"
    	        },
    	        minDate: enteredDate,
    	        showTodayButton: true,
    	        format: 'MM/DD/YYYY'
    	    });
    	}
    });
    
    $('.future-datetime').each(function() {
    	var now = new Date();
    	var enteredDate = new Date($(this).val());
    	
    	if($(this).val() == '' || enteredDate > now) {
    		//If no datetime already selected, future datetime from now
    		$(this).datetimepicker({
		    	icons: {
		    		time: "fa fa-clock-o",
					date: "fa fa-calendar",
					up: "fa fa-chevron-up",
					down: "fa fa-chevron-down",
					previous: "fa fa-chevron-left",
					next: "fa fa-chevron-right",
					today: "fa fa-calendar-check-o",
					clear: "fa fa-trash-o",
					close: "fa fa-times"
		        },
		        minDate: now,
		        showTodayButton: true
		    });
    	} else {
    		//If datetime already selected, future datetime from previously selected date
    		$(this).datetimepicker({
    			icons: {
		    		time: "fa fa-clock-o",
					date: "fa fa-calendar",
					up: "fa fa-chevron-up",
					down: "fa fa-chevron-down",
					previous: "fa fa-chevron-left",
					next: "fa fa-chevron-right",
					today: "fa fa-calendar-check-o",
					clear: "fa fa-trash-o",
					close: "fa fa-times"
		        },
		        minDate: enteredDate,
		        showTodayButton: true
    		});
    	}
    });
});

//Masked Fields: Currency, Phone Number
$(document).ready(function() {
	$('.currency').mask('000,000,000,000,000.00', {reverse: true});
	$('.phone-number').mask('0-000-000-0000',{reverse: true});
});

//HTML Fields
//Apply HTML Editor to Appropriate Fields
$(document).ready(function() {
	tinymce.init({
		selector: '.html-editor',
		menubar: false
	});
});

//Poke Toggle
function togglePokes() {
	$('#poke-view').toggle('fast');
	if($('#notification-view').is( ":visible" )) {
		$('#notification-view').toggle('fast');
	}
	return false;
}

//Notification Toggle
function toggleNotifications() {
	if($('#poke-view').is( ":visible" )) {
		$('#poke-view').toggle('fast');
	}
	$('#notification-view').toggle('fast');
	return false;
}