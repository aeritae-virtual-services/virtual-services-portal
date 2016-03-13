CREATE table Client
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
client_nme varchar(100),
primary_contact int unsigned,
url varchar(200),
address varchar(500),
q_manager int unsigned,
test_migration_req boolean,
prod_migration_req boolean,
client_po_req boolean,
primary_analyst_group int unsigned,
PRIMARY Key(id)
);
CREATE UNIQUE INDEX Client_index1 ON Client (primary_analyst_group);

CREATE UNIQUE INDEX Client_index2 ON Client (q_manager);

CREATE table User
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
user_id varchar(20) NOT NULL,
first_nme varchar(30) NOT NULL,
last_nme varchar(30) NOT NULL,
full_nme varchar(80),
phone_number varchar(20),
email varchar(50),
client_id int unsigned,
role_id int unsigned,
PRIMARY Key(id)
);

CREATE INDEX User_index1 ON User (user_id);

CREATE INDEX User_index2 ON User (client_id);

CREATE table User_Group
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
user_group_nme varchar(50) NOT NULL,
PRIMARY Key(id)
);

CREATE table Group_Member
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
group_id int unsigned,
user_id int unsigned,
PRIMARY Key(id)
);

CREATE INDEX Group_Member_index1 ON Group_Member (group_id);

CREATE INDEX Group_Member_index2 ON Group_Member (user_id);

CREATE table Role
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
role_name varchar(30),
role_value int unsigned,
PRIMARY Key(id)
);

CREATE INDEX Role_index1 ON Role (role_value);

CREATE table Status
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
label varchar(50),
status_value int unsigned,
table_nme varchar(50),
PRIMARY Key(id)
);

CREATE INDEX Status_index1 ON Status (status_value);

CREATE INDEX Status_index2 ON Status (table_nme);

CREATE table Priority
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
label varchar(40),
priority_value int unsigned,
table_nme varchar(50),
PRIMARY Key(id)
);

CREATE INDEX Priority_index1 ON Priority (priority_value);

CREATE INDEX Priority_index2 ON Priority (table_nme);

CREATE table Request_Type
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
req_type_name varchar(50),
description varchar(100),
first_workflow_step int unsigned,
PRIMARY Key(id)
);

CREATE INDEX Request_Type_index1 ON Request_Type (req_type_name);

CREATE table Request
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
requester int unsigned NOT NULL,
req_nbr varchar(20) NOT NULL,
short_description varchar(100),
description text,
client_req_nbr varchar(30),
req_status int unsigned NOT NULL,
requested_completion_date datetime,
priority int unsigned,
update_set varchar(50),
request_loe boolean,
estimated_loe double,
hours_consumed double,
request_type int unsigned,
contract_id int unsigned,
tier int unsigned,
resume_to int unsigned,
client_id int unsigned,
PRIMARY Key(id)
);

CREATE INDEX Request_index1 ON Request (requester,req_status);

CREATE INDEX Request_index2 ON Request (req_nbr,req_status);

CREATE INDEX Request_index3 ON Request (req_status);

CREATE INDEX Request_index4 ON Request (client_id,req_status,updated);

CREATE table Watch_List
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
request_id int unsigned,
email_address varchar(100),
PRIMARY Key(id)
);

CREATE INDEX Watch_List_index1 ON Watch_List (request_id);

CREATE table Task
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
request_id int unsigned,
assignment_group int unsigned,
assigned_to int unsigned,
instructions varchar(200) NOT NULL,
task_status int unsigned NOT NULL,
task_nbr varchar(20) NOT NULL AUTO_INCREMENT,
task_hours_consumed double,
poked_analyst int unsigned,
poked_date datetime default NOW(),
poked_by int unsigned,
client_id int unsigned,
PRIMARY Key(id)
);

CREATE INDEX Task_index1 ON Task (request_id, task_status);

CREATE INDEX Task_index2 ON Task (assignment_group, task_status);

CREATE INDEX Task_index3 ON Task (task_nbe, task_status);

CREATE INDEX Task_index4 ON Task (client_id, task_status);

CREATE INDEX Task_index5 ON Task (client_id, request_id, task_status);

CREATE INDEX Task_index6 ON Task (poked_analyst);

CREATE INDEX Task_index7 ON Task (poked_by, poked_anlayst);

CREATE table Comments
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
request_id int unsigned,
comments text,
public boolean,
PRIMARY Key(id)
);

CREATE INDEX Comments_index1 ON Comments (request_id, id desc, public);



CREATE table Attachments
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
request_id int unsigned,
url varchar(200),
file_type varchar(40),
PRIMARY Key(id)
);

CREATE INDEX Attachments_index1 ON Attachments (request_id);

CREATE table Tier
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
tier_name varchar(20),
tier_description varchar(200),
PRIMARY Key(id)
);

CREATE table Contract
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
client_id int unsigned,
tier_id int unsigned,
start_date datetime,
end_date datetime,
final_completion_date datetime,
contract_status int unsigned,
PRIMARY Key(id)
);

CREATE table Time_Entry
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
task_id int unsigned,
hours_consumed double,
user_id int unsigned,
contract_id int unsigned,
client_id int unsigned,
PRIMARY Key(id)
);

CREATE INDEX Time_Entry_index1 ON Time_Entry (request_id);

CREATE INDEX Time_Entry_index2 ON Time_Entry (client_id, created);

CREATE INDEX Time_Entry_index3 ON Time_Entry (contract_id, created);

CREATE table Workflow_Operation
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
operation_nme varchar(30),
description varchar(200),
PRIMARY Key(id)
);

CREATE table Workflow_Step
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
operation_id int unsigned NOT NULL,
success_next_step int unsigned,
fail_next_step int unsigned,
description varchar(200),
email_template_id int unsigned,
assignment_group_id int unsigned,
instructions varchar(200),
new_status int unsigned,
write_metric boolean,
PRIMARY Key(id)
);

CREATE table Workflow_Instance
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
request_id int unsigned NOT NULL,
workflow_step int unsigned NOT NULL,
progress int unsigned NOT NULL default 0,
instance_status int unsigned NOT NULL,
PRIMARY Key(id)
);

CREATE INDEX Workflow_Instance_index1 ON Workflow_Instance (request_id, instance_status);

CREATE table Email_Template
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
email_to varchar(300),
email_subject varchar(200),
email_body text,
PRIMARY Key(id)
);

CREATE table Email_Log
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
email_direction varchar(30) NOT NULL,
email_from varchar(300) ,
email_recipient varchar(100),
email_subject varchar(200) NOT NULL,
email_body text,
email_template_id int unsigned,
email_table varchar(30),
email_table_rec_id int unsigned,
email_status int unsigned,
client_id int unsigned,
PRIMARY Key(id)
);

CREATE INDEX Email_Log_index1 ON Email_Log (created);

CREATE INDEX Email_Log_index2 ON Email_Log (client_id, email_status);

CREATE INDEX Email_Log_index3 ON Email_Log (templage, client_id);


CREATE table Approval
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
client_id int unsigned,
request_id int unsigned,
decision_by int unsigned,
decision_date datetime,
decision varchar(50),
approval_type varchar(100),
description varchar(500),
PRIMARY Key(id)
);

CREATE INDEX Approval_index1 ON Approval (request_id);

CREATE INDEX Approva2_index1 ON Approval (client_id, approval_type, decision);

CREATE table Availability
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
analyst_id int unsigned,
start datetime,
end datetime,
PRIMARY Key(id)
);

CREATE INDEX Availability_index1 ON Availability (analyst_id, start);

CREATE INDEX Availability_index2 ON Availability (start);

ALTER table Client ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Client ADD FOREIGN Key (updated_by) REFERENCES User(id);
ALTER table Client ADD FOREIGN KEY (primary_contact) REFERENCES USER(id);
ALTER table Client ADD FOREIGN KEY (q_manager) REFERENCES User(id);

ALTER table User ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table User ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table User ADD FOREIGN KEY (role) REFERENCES Role(id);

ALTER table User_Group ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table User_Group ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Group_Member ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Group_Member ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Group_Member ADD FOREIGN KEY (group_id) REFERENCES User_Group(id);
ALTER table Group_Member ADD FOREIGN KEY (user_id) REFERENCES User(id);

ALTER table Role ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Role ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Status ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Status ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Priority ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Priority ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Request_type ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Request_type ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Request_type ADD FOREIGN KEY (first_workflow_step) REFERENCES Workflow_Step(id);

ALTER table Request ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Request ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Request ADD FOREIGN KEY (requester) REFERENCES User(id);
ALTER table Request ADD FOREIGN KEY (req_status) REFERENCES Status(id);
ALTER table Request ADD FOREIGN KEY (priority) REFERENCES Priority(id);
ALTER table Request ADD FOREIGN KEY (request_type) REFERENCES Request_type(id);
ALTER table Request ADD FOREIGN KEY (contract_id) REFERENCES Contract(id);
ALTER table Request ADD FOREIGN KEY (tier) REFERENCES Tier(id);
ALTER table Request ADD FOREIGN KEY (resume_to) REFERENCES Status(id);
ALTER table Request ADD FOREIGN KEY (client_id) REFERENCES Client(id);

ALTER table Watch_List ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Watch_List ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Watch_List ADD FOREIGN KEY (request_id) REFERENCES Request(id);

ALTER table Task ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Task ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Task ADD FOREIGN KEY (request_id) REFERENCES Request(id);
ALTER table Task ADD FOREIGN KEY (assignment_group) REFERENCES User_Group(id);
ALTER table Task ADD FOREIGN KEY (task_status) REFERENCES Status(id);
ALTER table Task ADD FOREIGN KEY (assigned_to) REFERENCES User(id);

ALTER table Comments ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Comments ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Comments ADD FOREIGN KEY (equest_id) REFERENCES Request(id);

ALTER table Attachments ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Attachments ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Attachments ADD FOREIGN KEY (request_id) REFERENCES Request(id);

ALTER table Tier ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Tier ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Contract ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Contract ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Contract ADD FOREIGN KEY (client_id) REFERENCES Client(id);
ALTER table Contract ADD FOREIGN KEY (tier_id) REFERENCES Tier(id);
ALTER table Contract ADD FOREIGN KEY (contract_status) REFERENCES Status(id);

ALTER table Time_Entry ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (task_id) REFERENCES Task(id);
ALTER table Time_Entry ADD FOREIGN KEY (user_id) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (contract_id) REFERENCES Contract(id);
ALTER table Time_Entry ADD FOREIGN KEY (client_id) REFERENCES Client(id);

ALTER table Workflow_Operation ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Workflow_Operation ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Workflow_Step ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Workflow_Step ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Workflow_Step ADD FOREIGN KEY (success_next_step) REFERENCES Workflow_Step(id);
ALTER table Workflow_Step ADD FOREIGN KEY (fail_next_step) REFERENCES Workflow_Step(id);
ALTER table Workflow_Step ADD FOREIGN KEY (email_template_id) REFERENCES Email_Template(id);
ALTER table Workflow_Step ADD FOREIGN KEY (assignment_group_id) REFERENCES User_Group(id);
ALTER table Workflow_Step ADD FOREIGN KEY (new_status) REFERENCES Status(id);

ALTER table Workflow_Instance ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Workflow_Instance ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Workflow_Instance ADD FOREIGN KEY (request_id) REFERENCES Request(id);
ALTER table Workflow_Instance ADD FOREIGN KEY (workflow_step) REFERENCES Workflow_Step(id);
ALTER table Workflow_Instance ADD FOREIGN KEY (instance_status) REFERENCES Status(ID);

ALTER table Email_Template ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Email_Template ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Email_Log ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Email_Log ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Email_Log ADD FOREIGN KEY (client_id) REFERENCES Client(id);
ALTER table Email_Log ADD FOREIGN KEY (email_template_id) REFERENCES Email_Template(id);

ALTER table Approval ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Approval ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Approval ADD FOREIGN KEY (client_id) REFERENCES Client(id);
ALTER table Approval ADD FOREIGN KEY (request_id) REFERENCES Request(id);
ALTER table Approval ADD FOREIGN KEY (decision_by) REFERENCES User(id);

ALTER table Availability ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Availability ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Availability ADD FOREIGN KEY (analyst_id) REFERENCES User(id);

