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
			},
			decision_date: {
				fieldId: 'decision_date',
				role: {
					read: '1,2,3,4,5',
					write: ''
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'true'
			},
			request_id: {
				fieldId: 'request_id',
				role: {
					read: '1,2,3,4,5',
					write: ''
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'true'
			},
			description: {
				fieldId: 'description',
				role: {
					read: '1,2,3,4,5',
					write: ''
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'true'
			},
			decision: {
				fieldId: 'decision',
				role: {
					read: '1,2,3,4,5',
					write: ''
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'true'
			},
			approval_type: {
				fieldId: 'approval_type',
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
	
	var add_client = {
			formId: 'add_client',
			rules: {
				client_id: {
					fieldId: 'client_nme',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				
				primary_contact: {
					fieldId: 'primary_contact',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
			},
				url: {
					fieldId: 'url',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
			},
			address: {
				fieldId: 'address',
				role: {
					read: '1,2,3,4,5',
					write: '4,5'
				},
				mandatory: 'true',
				visible: 'true',
				readonly: 'false'
			},
			q_manager: {
				fieldId: 'q_manager',
				role: {
					read: '3,4,5',
					write: '4,5'
				},
				mandatory: 'true',
				visible: 'true',
				readonly: 'false'
			},
			test_migration_req: {
				fieldId: 'test_migration_req',
				role: {
					read: '1,2,3,4,5',
					write: '3,4,5'
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'false'
			},
			prod_migration_req: {
				fieldId: 'prod_migration_req',
				role: {
					read: '1,2,3,4,5',
					write: '3,4,5'
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'false'
			},
			client_po_req: {
				fieldId: 'client_po_req',
				role: {
					read: '4,5',
					write: '4,5'
				},
				mandatory: 'false',
				visible: 'true',
				readonly: 'false'
			},
			primary_analyst_group: {
				fieldId: 'primary_analyst_group',
				role: {
					read: '3,4,5',
					write: '4,5'
				},
				mandatory: 'true',
				visible: 'true',
				readonly: 'false'
			}
		}
	};
		
	var update_client = add_client;
	update_client.formId = 'update_client';
	
	var add_contract = {
			formId: 'add_contract',
			rules: {
				client_id: {
					fieldId: 'client_id',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				
				tier_id: {
					fieldId: 'tier_id',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
					},
							
				start_date: {
					fieldId: 'start_date',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				end_date: {
					fieldId: 'end_date',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				final_completion_date: {
					fieldId: 'final_completion_date',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				status: {
					fieldId: 'status',
					role: {
						read: '1,2,3,4,5',
						write: ''
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				total_consumed_hours: {
					fieldId: 'total_consumed_hours',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				ccpm: {
					fieldId: 'ccpm',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				contract_contact: {
					fieldId: 'contract_contact',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				current_balance: {
					fieldId: 'current_balance',
					role: {
						read: '1,2,3,4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				expiration_notification_days_1: {
					fieldId: 'expiration_notification_days',
					role: {
						read: '4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'false',
					readonly: 'false'
				},
				expiration_notification_days_2: {
					fieldId: 'expiration_notification_days',
					role: {
						read: '4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'false',
					readonly: 'false'
				},
				expiration_notification_days_3: {
					fieldId: 'expiration_notification_days',
					role: {
						read: '4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'false',
					readonly: 'false'
				},
				send_low_balance_notification: {
					fieldId: 'send_low_balance_notification',
					role: {
						read: '4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'false',
					readonly: 'false'
				},
				low_balance_thresholds_1: {
					fieldId: 'low_balance_thresholds_1',
					role: {
						read: '4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'false',
					readonly: 'false'
				},
				low_balance_thresholds_2: {
					fieldId: 'low_balance_thresholds_2',
					role: {
						read: '4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'false',
					readonly: 'false'
				},
				low_balance_thresholds_3: {
					fieldId: 'low_balance_thresholds_3',
					role: {
						read: '4,5',
						write: '4,5'
					},
					mandatory: 'true',
					visible: 'false',
					readonly: 'false'
				},
			}
		};	
	
	var update_contract = add_ontract;
	update_contract.formId = 'update_oontract';

	var add_email_log = {
			formId: 'add_email_log',
			rules: {
				client_id: {
					fieldId: 'email_direction',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_from: {
					fieldId: 'email_from',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_recipient: {
					fieldId: 'email_recipient',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_subject: {
					fieldId: 'email_subject',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_template_id: {
					fieldId: 'email_template_id',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_body: {
					fieldId: 'email_body',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_table: {
					fieldId: 'email_table',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_table_rec_id: {
					fieldId: 'email_table_rec_id',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				email_status: {
					fieldId: 'email_status',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				client_id: {
					fieldId: 'client_id',
					role: {
						read: '3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_email_log = add_email_log;
	update_email_log.formId = 'update_email_log';
	
	var add_email_template = {
			formId: 'add_email_template',
			rules: {
				email_to: {
					fieldId: 'email_to',
					role: {
						read: '2,3,4,5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				email_subject: {
					fieldId: 'email_subject',
					role: {
						read: '2,3,4,5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				email_body: {
					fieldId: 'email_body',
					role: {
						read: '2,3,4,5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_email_template = add_email_template;
	update_email_template.formId = 'update_email_template';
	
	var add_group = {
			formId: 'add_group',
			rules: {
				user_group_nme: {
					fieldId: 'user_group_nme',
					role: {
						read: '2,3,4,5',
						write: '3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_group = add_group;
	update_group.formId = 'update_group';	
	
	var add_priority = {
			formId: 'add_priority',
			rules: {
				user_group_nme: {
					fieldId: 'label',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_priority = add_priority;
	update_priority.formId = 'update_priority';
	
	var add_request = {
			formId: 'add_request',
			rules: {
				requester: {
					fieldId: 'requester',
					role: {
						read: '1,5',
						write: '1,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				short_description: {
					fieldId: 'short_description',
					role: {
						read: '1,5',
						write: '1,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				description: {
					fieldId: 'description',
					role: {
						read: '1,5',
						write: '1,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				client_req_nbr: {
					fieldId: 'client_req_nbr',
					role: {
						read: '1,5',
						write: '1,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				requested_completion_date: {
					fieldId: 'requested_completion_date',
					role: {
						read: '1,5',
						write: '1,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				priority: {
					fieldId: 'priority',
					role: {
						read: '1,5',
						write: '1,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				update_set: {
					fieldId: 'update_set',
					role: {
						read: '',
						write: ''
					},
					mandatory: 'false',
					visible: 'false',
					readonly: 'false'
				},
				request_loe: {
					fieldId: 'request_loe',
					role: {
						read: '1,5',
						write: '1,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				estimated_loe: {
					fieldId: 'estimated_loe',
					role: {
						read: '',
						write: ''
					},
					mandatory: 'false',
					visible: 'false',
					readonly: 'false'
				},
				hours_consumed: {
					fieldId: 'hours_consumed',
					role: {
						read: '',
						write: ''
					},
					mandatory: 'false',
					visible: 'false',
					readonly: 'false'
				},
				request_type: {
					fieldId: 'request_type',
					role: {
						read: '',
						write: ''
					},
					mandatory: 'false',
					visible: 'false',
					readonly: 'false'
				},
				tier: {
					fieldId: 'ter',
					role: {
						read: '',
						write: ''
					},
					mandatory: 'false',
					visible: 'false',
					readonly: 'false'
				}
			}
		};
		
	var update_request = {
			formId: 'update_request',
			rules: {
				requester: {
					fieldId: 'requester',
					role: {
						read: '1,2,3,4,5',
						write: ''
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				short_description: {
					fieldId: 'short_description',
					role: {
						read: '1,2,3,4,5',
						write: ''
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				description: {
					fieldId: 'description',
					role: {
						read: '1,2,3,4,5',
						write: ''
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				client_req_nbr: {
					fieldId: 'client_req_nbr',
					role: {
						read: '1,2,3,4,5',
						write: '1'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				requested_completion_date: {
					fieldId: 'requested_completion_date',
					role: {
						read: '1,2,3,4,5',
						write: '1,3,4,5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				priority: {
					fieldId: 'priority',
					role: {
						read: '1,2,3,4,5',
						write: '1,3,4,5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				update_set: {
					fieldId: 'update_set',
					role: {
						read: '1,2,3,4,5',
						write: '2,3,4,5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				request_loe: {
					fieldId: 'request_loe',
					role: {
						read: '1,2,3,4,5',
						write: '3,4,5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				estimated_loe: {
					fieldId: 'estimated_loe',
					role: {
						read: '1,2,3,4,5',
						write: '2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				hours_consumed: {
					fieldId: 'hours_consumed',
					role: {
						read: '1,2,3,4,5',
						write: ''
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				request_type: {
					fieldId: 'request_type',
					role: {
						read: '1,2,3,4,5',
						write: ''
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				tier: {
					fieldId: 'ter',
					role: {
						read: '1,2,3,4,5',
						write: ''
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};

	var add_request_type = {
			formId: 'add_request_type',
			rules: {
				req_type_name: {
					fieldId: 'req_type_name',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				description: {
					fieldId: 'description',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				first_workflow_step: {
					fieldId: 'first_workflow_step',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_request_type = add_request_type;
	update_request_type.formId = 'update_request_type';
	
	var add_role = {
			formId: 'add_role',
			rules: {
				role_name: {
					fieldId: 'role_name',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				role_value: {
					fieldId: 'role_value',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_role = add_role;
	update_role.formId = 'update_role';
	
	var add_status = {
			formId: 'add_status',
			rules: {
				label: {
					fieldId: 'label',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				status_value: {
					fieldId: 'status_value',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_status = add_status;
	update_status.formId = 'update_status';

	var add_task = {
			formId: 'add_task',
			rules: {
				request_id: {
					fieldId: 'request_id',
					role: {
						read: '2,3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				assignment_group: {
					fieldId: 'assignment_group',
					role: {
						read: '2,3,4,5',
						write: '2,3,4,5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				assigned_to: {
					fieldId: 'assigned_to',
					role: {
						read: '2,3,4,5',
						write: '2,3,4,5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				instructions: {
					fieldId: 'instructions',
					role: {
						read: '2,3,4,5',
						write: '2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				task_status: {
					fieldId: 'task_status',
					role: {
						read: '2,3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				poked_analyst: {
					fieldId: 'poked_analyst',
					role: {
						read: '2,3,4,5',
						write: '3,4,5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				client_id: {
					fieldId: 'client_id',
					role: {
						read: '2,3,4,5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_task = add_task;
	update_task.formId = 'update_task';

	var add_user = {
			formId: 'add_user',
			rules: {
				first_nme: {
					fieldId: 'first_nme',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				last_nme: {
					fieldId: 'last_nme',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				full_nme: {
					fieldId: 'full_nme',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				phone_number: {
					fieldId: 'phone_number',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				email: {
					fieldId: 'email',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				client_id: {
					fieldId: 'client_id',
					role: {
						read: '1,2,3,4,5',
						write: '2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				role_id: {
					fieldId: 'role_id',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				user_id: {
					fieldId: 'user_id',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				profile_image: {
					fieldId: 'profile_image',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				passwd: {
					fieldId: 'passwd',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
			}
		};

	
	var update_user = {
			formId: 'update_user',
			rules: {
				first_nme: {
					fieldId: 'first_nme',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				last_nme: {
					fieldId: 'last_nme',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				full_nme: {
					fieldId: 'full_nme',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				phone_number: {
					fieldId: 'phone_number',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				email: {
					fieldId: 'email',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				client_id: {
					fieldId: 'client_id',
					role: {
						read: '1,2,3,4,5',
						write: '2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				role_id: {
					fieldId: 'role_id',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				user_id: {
					fieldId: 'user_id',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				profile_image: {
					fieldId: 'profile_image',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				passwd: {
					fieldId: 'passwd',
					role: {
						read: '1,2,3,4,5',
						write: '1,2,3,4,5'
					},
					mandatory: 'true',
					visible: 'true', //This user record is the session user or session user role == 5
					readonly: 'false'
				},
			}
		};
		
	var add_workflow_operation_status = {
			formId: 'add_workflow_operation_status',
			rules: {
				operation_nme: {
					fieldId: 'operation_nme',
					role: {
						read: '5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				description: {
					fieldId: 'description',
					role: {
						read: '5',
						write: ''
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_workflow_operation_status = add_workflow_operation_status;
	update_workflow_operation_status.formId = 'update_workflow_operation_status';

	var add_add_workflow_step = {
			formId: 'add_add_workflow_step',
			rules: {
				operation_id: {
					fieldId: 'operation_id',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				success_next_step: {
					fieldId: 'success_next_step',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				fail_next_step: {
					fieldId: 'fail_next_step',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				description: {
					fieldId: 'description',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				email_template_id: {
					fieldId: 'email_template_id',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'false',
					visible: 'true',
					readonly: 'false'
				},
				assignment_group_id: {
					fieldId: 'assignment_group_id',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'false',
					visible: 'true', //if operation == Gen Task
					readonly: 'false'
				},
				instructions: {
					fieldId: 'instructions',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true', //if operation == Gen Task
					readonly: 'false'
				},
				new_status: {
					fieldId: 'new_status',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true', //if operation == Gen Task
					readonly: 'false'
				},
				write_metric: {
					fieldId: 'write_metric',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'false',
					visible: 'true', //if operation == Gen Task
					readonly: 'false'
				},
				task_type: {
					fieldId: 'task_type',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true', //if operation == Gen Task
					readonly: 'false'
				},
			}
		};
		
	var update_workflow_step = add_workflow_workflow_step;
	update_workflow_step.formId = 'update_workflow_step';
	
	var add_metric = {
			formId: 'add_metric',
			rules: {
				task_type: {
					fieldId: 'task_type',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				task_id: {
					fieldId: 'task_id',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				status: {
					fieldId: 'status',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				start_date: {
					fieldId: 'start_date',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				end_date: {
					fieldId: 'end_date',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				duration: {
					fieldId: 'duration',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				request_id: {
					fieldId: 'request_id',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				},
				client_id: {
					fieldId: 'client_id',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_metric = add_metric;
	update_metric.formId = 'update_metric';

	var add_task_type = {
			formId: 'add_ask_type',
			rules: {
				label: {
					fieldId: 'label',
					role: {
						read: '5',
						write: '5'
					},
					mandatory: 'true',
					visible: 'true',
					readonly: 'false'
				}
			}
		};
		
	var update_task_type = add_task_type;
	update_task_type.formId = 'task_type';

	return eval(formName);
}