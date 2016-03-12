$.fn.aeValidate = function(formDefinition) {
	$('#' + formDefinition.actionId).ready(function() {
		attachRules(formDefinition);
		applyRules(formDefinition);
	});

	function attachRules(formDefinition) {
		var fieldRules = formDefinition.rules;

		$.each(fieldRules, function(index, rule) {
			var fieldEl = $('[name="' + rule.fieldId + '"]');

			// Check if field exists
			if(fieldEl.length) {
				if(fieldEl.is('input')) {
					if(fieldEl.attr('type') == 'checkbox' || fieldEl.attr('type') == 'file' || fieldEl.attr('type') == 'hidden') {
						// Checkboxes/Files/Reference
						fieldEl.change(applyRules(formDefinition));
					} else {
						// Text Entries
						fieldEl.keyup(applyRules(formDefinition));
					}
				} else if(fieldEl.is('select')) {
					// Dropdowns
					fieldEl.change(applyRules(formDefinition));
				} else if(fieldEl.hasClass('html-editor')) {
					// HTML editor
					fieldEl.on('onKeyUp', applyRules(formDefinition));
				} else if(fieldEl.is('textarea')) {
					fieldEl.keyup(applyRules(formDefinition));
				}
			} else {
				// Radio Buttons
				$('input[name="' + rule.fieldId + '"]:radio').each(
					function() {
						$(this).change(applyRules(formDefinition));
					});
			}
		});
	}

	function applyRules(formDefinition) {
		//var role = sessionUser.role;

		var fieldRules = formDefinition.rules;

		$.each(fieldRules, function(index, rule) {
			var fieldEl = $('input[name="' + rule.fieldId + '"]:radio').first();
			if(fieldEl.length) {} else {
				// If element not found, it is not a radio button
				fieldEl = $('[name="' + rule.fieldId + '"]');
			}

			// Check if field exists
			if(fieldEl.length) {
				/*
				 * Apply Role Based Access To Field
				 */
				if ($.inArray(sessionUser.role, rule.role.read.split(',')) == -1) {
							// User does not have listed role, restrict visibility
							fieldEl.closest('fieldset').addClass('role_hidden');
							fieldEl.closest('fieldset').hide();
						} else {
							// User does have listed role, don't restrict visibility
							fieldEl.closest('fieldset').removeClass('role_hidden');
							fieldEl.closest('fieldset').show();
						}
	
						if ($.inArray(sessionUser.role, rule.role.write.split(',')) == -1) {
							// User does not have listed role, restrict write access
							fieldEl.closest('fieldset').addClass('role_no_write');
							fieldEl.closest('fieldset').prop('disabled', true);
						} else {
							// User does have listed role, don't restrict write
							// access
							fieldEl.closest('fieldset')
									.removeClass('role_no_write');
							fieldEl.closest('fieldset').prop('disabled', false);
						}

				/*
				 * Check Visible
				 */
				if(eval(rule.visible)) {
					if(!fieldEl.closest('fieldset').hasClass('role_hidden')) {
						fieldEl.closest('fieldset').show();
					}
				} else {
					fieldEl.closest('fieldset').hide();
				}

				/*
				 * Check Read-Only
				 */
				if(eval(rule.readonly)) {
					// Make read only
					fieldEl.closest('fieldset').attr('disabled', 'true');
				} else {
					// Readonly set to false
					if(!fieldEl.closest('fieldset').hasClass('role_no_write') && !fieldEl.closest('fieldset').hasClass('role_hidden')) {
						fieldEl.closest('fieldset').removeAttr('disabled');
					}
				}

				/*
				 * Check Mandatory
				 */
				if(eval(rule.mandatory)) {
					if(fieldEl.closest('fieldset').attr('disabled') != 'true' && !fieldEl.closest('fieldset').hasClass('role_hidden')) {
						fieldEl.closest('fieldset').attr('mandatory', 'true');
						if(fieldEl.closest('fieldset').find('.icon-mandatory').length) {
						} else {
							fieldEl.closest('fieldset').prepend('<i class="fa fa-asterisk icon-mandatory"></i>');
						}
					} else {
						fieldEl.closest('fieldset').removeAttr('mandatory');
						fieldEl.closest('fieldset').find('.icon-mandatory').remove();
					}
				} else {
					fieldEl.closest('fieldset').removeAttr('mandatory');
					fieldEl.closest('fieldset').find('.icon-mandatory').remove();
				}
			}
		});
	}
};

function validateRules(formDefinition) {
	var isValid = true;
	$('[mandatory="true"]').each(function() {
		var elName = $(this).find('label').attr('for') + '';
		var value = $('[name="' + elName + '"]').val() + '';
		if(value == '') {
			isValid = false;
		}
	});
	return isValid;
}