$.fn.aeValidate = function(formDefinition) {
	$('#' + formDefinition.formId).ready(function() {
		applyRules(formDefinition);
	});
	
	$('#' + formDefinition.formId).submit(function() {
		validateRules(formDefinition);
	});
	
	function applyRules(formDefinition) {
		//Apply Role Base Rules
		var role = sessionUser.role;
		var fieldRules = formDefinition.rules;
		
		for(var rule in fieldRules) {
			 if(fieldRules.hasOwnProperty(rule)) {
				 
			 }
		}
		
	}
};