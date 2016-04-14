INSERT INTO `Client`	(created_by, updated_by, client_nme, primary_contact, url, address, q_manager, test_migration_req, prod_migration_req, client_po_req, primary_analyst_group)
VALUES					(1,1,'Magic Client',1,'http://example.com/','100 The Moon Drive',1,'1','1','1',1),
						(1,1,'Another Client',2,'http://secondwebsite.com/','9001 Power Level Street',2,'1','1','1',2)
						(1,1,'Client 3',2,'http://thirdexampe.com/','9002 Power Level Street',2,'1','1','1',2)
						(1,1,'Client 3',2,'http://fourthwebsite.com/','4 Power Level Street',2,'1','1','1',2)
;

INSERT INTO `Contract`	(created_by,
						updated_by,
						client_id,
						tier_id,
						start_date,
						end_date,
						final_completion_date,
						contract_status,
						expiration_notification_days_1,
						expiration_notification_days_2,
						expiration_notification_days_3,
						expiration_notification_days_4,
						status_id,
						total_contracted_hours,
						ccpm,
						contract_contact,
						current_balanace,
						expiration_notification_date_1,
						expiration_notification_date_2,
						expiration_notification_date_3,
						expiration_notification_date_4,
						send_low_balance_notification,
						low_balance_threshold_1,
						low_balance_threshold_2,
						low_balance_threshold_3)
VALUES					(1,
						1,
						1,
						3,
						'2016-01-10',
						'2016-04-30',
						'2016-05-07',
						6,
						30,
						20,
						10,
						5,
						6,
						100,
						0,
						3,
						5000,
						30,
						20,
						10,
						5,
						1,
						2000,
						1000,
						250),
						(1,1,1,3,'2016-04-30','2016-07-30','2016-08-07',6,30,20,10,5,6,100,0,3,5000,30,20,10,5,1,2000,1000,250),
						(1,1,2,3,'2016-01-19','2016-05-02','2016-05-17',6,30,20,10,5,6,100,0,4,5000,30,20,10,5,1,2000,1000,250),
						(1,1,3,3,'2016-02-19','2016-06-02','2016-06-17',6,30,20,10,5,6,100,0,6,5000,30,20,10,5,1,2000,1000,250),
						(1,1,4,3,'2016-03-19','2016-07-02','2016-07-05',6,30,20,10,5,6,100,0,7,5000,30,20,10,5,1,2000,1000,250)
;
INSERT INTO `User`		(created_by, updated_by, user_id, first_name, last_name, full_name, phone_number, email, client_id, role_id, profile_image,passwd)
VALUES					(1,1,'aaa','Admin','Admin','Admin Admin','000-000-0000','admin@admin.com','',0,'',''),
						(1,1,'bbb','Beta','Beta','Beta Beta','111-111-1111','beta@beta.com','',0,'',''),
						(1,1,'mcu','Magic','User','Magic User','222-222-2222','magic@client.com',1,1,'',''),
						(1,1,'acu','Another','User','Another User','333-333-3333','another@client.com',2,1,'',''),
						(1,1,'vsa','VS','Analyst','VS Analyst','444-444-4444','vs@analyst.com','',2,'',''),
						(1,1,'tau','Thrid','Client','Third Client','333-333-3333','another@client.com',3,1,'','')
						(1,1,'fau','Foruth','Client','Third Client','333-333-3333','another@client.com',4,1,'','')
;

INSERT INTO `User_Group`	(created_by, updated_by,user_group_nme)
VALUES						(0,0,'Magic Clients Analyst Group'),
							(0,0,'Another Clients Analyst Group')
;

INSERT INTO `Role`	(created_by, updated_by, role_name, role_value)
VALUES				(1,1,'Admin',0),
					(1,1,'ESS',1),
					(1,1,'VS Analyst',2),
					(1,1,'Service Line Leader',3)
;

INSERT INTO `Status`	(created_by, updated_by, label, status_value, table_nme)
VALUES					(1,1,'New',0,''),
						(1,1,'On Hold',1,''),
						(1,1,'Developing',2,''),
						(1,1,'Closed',3,''),
						(1,1,'Cancelled',4,''),
						(1,1,'Completed',5,''),
						(1,1,'Active',6,''),
						(1,1,'Inactive',7,''),
						(1,1,'More Info',8,'')
;

INSERT INTO `Priority`	(created_by, updated_by, label, priority_value, table_nme)
VALUES					(1,1,'Critical',0,''),
						(1,1,'High',1,''),
						(1,1,'Medium',2,''),
						(1,1,'Low',3,'')
;

INSERT INTO `Request_Type`	(created_by, updated_by,req_type_name,description,first_workflow_step)
VALUES						(1,1,'ServiceNow New Ticket Development','Creation of a new ServiceNow item',1),
							(1,1,'ServiceNow Updates','Updates to ServiceNow instance',2),
							(1,1,'ServiceNow Ticket Update','Updates that add onto preivously completed tickets',3),
							(1,1,'ServiceNow Removal','Removal of something unwanted on an existing servicenow item',4)
;

INSERT INTO `Request`		(created_by, updated_by,requester,req_nbr,short_description,description,client_req_nbr,req_status,requested_completion_date,priority,update_set,request_loe,estimated_loe,hours_consumed,request_type,contract_id,tier,resume_to,client_id)
VALUES						(1,1,3,'111','Create form','Create a new form for onboarding','13',1,'2016-04-30',1,'AEVS1','0','',0,1,1,1,1,1),
							(1,1,4,'222','Update','Update SN to newest patch','97',3,'2016-04-30',3,'AEVS999',1,3,1,2,2,2,1,2),
							(1,1,4,'333','Create form','Create a new form for onboarding','13',1,'2016-04-30',1,'AEVS2','0','',0,1,2,1,1,2),
							(1,1,3,'444','Update','Update SN to newest patch','97',3,'2016-04-30',3,'AEVS1000',1,3,1,2,1,2,1,1),
							(1,1,6,'555','Create form','Create a new form for onboarding','13',1,'2016-04-30',1,'AEVS2','0','',0,1,4,1,1,3),
							(1,1,6,'666','Update','Update SN to newest patch','97',3,'2016-04-30',3,'AEVS1000',1,3,1,2,4,2,1,3),
							(1,1,7,'555','Create form','Create a new form for onboarding','13',1,'2016-04-30',1,'AEVS2','0','',0,1,5,1,1,4),
							(1,1,7,'666','Update','Update SN to newest patch','97',3,'2016-04-30',3,'AEVS1000',1,3,1,2,5,2,1,4),
							(7,7,7,'123','Remove colors','Remove colors on offboarding form','12321',1,'2016-04-23',2,'AEVS3421',0,0,0,4,5,1,0,4)
;

INSERT INTO `Task_Type`		(created_by, updated_by, label)
VALUES						(1,1,'TypeA'),
							(1,1,'TypeB'),
							(1,1,'TypeC')
;

INSERT INTO `Task`			(created_by, updated_by, request_id,assignment_group,assigned_to,instructions,task_status,task_nbr,task_hours_consumed,poked_analyst,poked_date,poked_by,client_id)
VALUES						(1,1,1,0,5,'Show visual design for new form',1,'123',0,0,'',1),
							(1,1,2,0,5,'Check requirements for transition to new version',8,'321',0,0,'',2),
							(1,1,3,0,5,'Show visual design for new form',1,'123',0,0,'',2),
							(1,1,4,0,5,'Check requirements for transition to new version',8,'321',0,0,'',1),
							(1,1,5,0,5,'Show visual design for new form',1,'123',0,0,'',3),
							(1,1,6,0,5,'Check requirements for transition to new version',8,'321',0,0,'',3),
							(1,1,7,0,5,'Show visual design for new form',1,'123',0,0,'',4),
							(1,1,8,0,5,'Check requirements for transition to new version',8,'321',0,0,'',4),
							(1,1,9,0,5,'Page is full with color, review with client which they would like removed',2,'321',0,0,'',4)
;

INSERT INTO `Watch_List`	(created_by, updated_by, request_id, email_address)
VALUES						(1,1,1,'creaform@clientone.com'),
							(1,1,2,'update@clienttwo.com'),
							(1,1,3,'createform@clientwo.com'),
							(1,1,4,'update@clientone.com'),
							(1,1,5,'creatform@clientthree.com'),
							(1,1,6,'update@clientthree.com'),
							(1,1,7,'createform@clientfour.com'),
							(1,1,8,'update@clientfour.com'),
							(1,1,9,'removecolors@clientfour.com')
;

INSERT INTO `Comments`		(created_by, updated_by, request_id, comment)
VALUES						(1,1,1,'1:Ticket Created Manually Via SQL'),
							(1,1,2,'2:Ticket Created Manually Via SQL'),
							(1,1,3,'3:Ticket Created Manually Via SQL'),
							(1,1,4,'4:Ticket Created Manually Via SQL'),
							(1,1,5,'5:Ticket Created Manually Via SQL'),
							(1,1,6,'6:Ticket Created Manually Via SQL'),
							(1,1,7,'7:Ticket Created Manually Via SQL'),
							(1,1,8,'8:Ticket Created Manually Via SQL'),
							(1,1,9,'9:Ticket Created Manually Via SQL')
;

INSERT INTO `Tier`	(created_by,updated_by,tier_name,tier_description)
VALUES				(1,1,'Tier 1','Description of Tier 1'),
					(1,1,'Tier 2','Description of Tier 2'),
					(1,1,'Tier 3','Description of Tier 3'),
					(1,1,'Tier 4','Description of Tier 4')
;