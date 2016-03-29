function getValidatorByFormName(formName) {
	
	/*
	 * Approval Forms
	 */
	
	var add_approval = {
		formId: 'add_approval',
		rules: {
			client_id: {
				fieldId: 'client_id',
				role: {
					read: '1,2,3,4,5',
					write: '5'
				},
				mandatory: 'true',
				visible: 'true',
				readonly: 'false'
			},
			
			decision_by: {
				fieldId: 'decision_by',
				role: {
					read: '1,2,3,4,5',
					write: ''
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'true'
			}
		}
	};
	
	var update_approval = add_approval;
	update_approval.formId = 'update_approval';
	
	/*
	 * Client Forms
	 */
	
	var add_client;
	var update_client;
	var add_contract;
	var update_contract;
	var add_email_log;
	var update_email_log;
	var add_email_template;
	var update_email_template;
	var add_group;
	var update_group;
	var add_metric;
	var update_metric;
	var add_priority;
	var update_priority;
	var add_request;
	var update_request;
	var add_request_type;
	var update_request_type;
	var add_role;
	var update_role;
	var add_status;
	var update_status;
	var add_task;
	var update_task;
	var add_task_type;
	var update_task_type;
	var add_tier;
	var update_tier;
	var add_user;
	var update_user;
	var add_workflow_operation;
	var update_workflow_operation;
	var add_workflow_step;
	var update_workflow_step;
	
	return eval(formName);
}