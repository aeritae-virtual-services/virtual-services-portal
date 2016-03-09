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
migration_req boolean,
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
role int unsigned,
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

CREATE INDEX Group_Member_index1 ON Group_Member (user_id);

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

CREATE table Request
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
requester int unsigned,
req_nbr varchar(20),
short_description varchar(100),
description text,
client_req_nbr varchar(30),
req_status int unsigned,
requested_completion_date datetime,
priority int unsigned,
update_set varchar(100),
request_loe boolean,
estimated_loe double,
hours_consumed double,
request_type int unsigned,
contract int unsigned,
tier int unsigned,
resume_to int unsigned,
client_id int unsigned,
PRIMARY Key(id)
);

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

CREATE table Comments
(
id int unsigned NOT NULL AUTO_INCREMENT,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
service_request int unsigned,
comments text,
public boolean,
PRIMARY Key(id)
);

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

CREATE table Email_LOG
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

ALTER table Field ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Field ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Field ADD FOREIGN KEY (type) REFERENCES Field_type(id);

ALTER table Client ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Client ADD FOREIGN Key (updated_by) REFERENCES User(id);
ALTER table Client ADD FOREIGN KEY (primary_contact) REFERENCES USER(id);
ALTER table Client ADD FOREIGN KEY (queue_manager) REFERENCES User(id);

ALTER table User ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table User ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table User ADD FOREIGN KEY (role) REFERENCES Role(id);

ALTER table Group ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Group ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Group_Member ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Group_Member ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Group_Member ADD FOREIGN KEY (group) REFERENCES Group(id);
ALTER table Group_Member ADD FOREIGN KEY (user) REFERENCES User(id);

ALTER table Role ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Role ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Status ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Status ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Priority ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Priority ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Request_type ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Request_type ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Request_type ADD FOREIGN KEY (first_workflow_step) REFERENCES Workflow_Step(id);

ALTER table Service_Request ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Service_Request ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Service_Request ADD FOREIGN KEY (requester) REFERENCES User(id);
ALTER table Service_Request ADD FOREIGN KEY (status) REFERENCES Status(id);
ALTER table Service_Request ADD FOREIGN KEY (priority) REFERENCES Priority(id);
ALTER table Service_Request ADD FOREIGN KEY (request_type) REFERENCES Request_type(id);
ALTER table Service_Request ADD FOREIGN KEY (contract) REFERENCES Contract(id);
ALTER table Service_Request ADD FOREIGN KEY (tier) REFERENCES Tier(id);

ALTER table Watch_List ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Watch_List ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Watch_List ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);

ALTER table Task ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Task ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Task ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);
ALTER table Task ADD FOREIGN KEY (assignment_group) REFERENCES Group(id);
ALTER table Task ADD FOREIGN KEY (status) REFERENCES Status(id);
ALTER table Task ADD FOREIGN KEY (assigned_to) REFERENCES User(id);

ALTER table Comment ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Comment ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Comment ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);

ALTER table Attachments ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Attachments ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Attachments ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);

ALTER table Tier ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Tier ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Contract ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Contract ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Contract ADD FOREIGN KEY (company) REFERENCES Company(id);
ALTER table Contract ADD FOREIGN KEY (tier) REFERENCES Tier(id);
ALTER table Contract ADD FOREIGN KEY (status) REFERENCES Status(id);

ALTER table Time_Entry ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (task) REFERENCES Task(id);
ALTER table Time_Entry ADD FOREIGN KEY (user) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (contract) REFERENCES Contract(id);

ALTER table Workflow_Operation ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Workflow_Operation ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Workflow_Step ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Workflow_Step ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Workflow_Step ADD FOREIGN KEY (success_next_step) REFERENCES Workflow_Step(id);
ALTER table Workflow_Step ADD FOREIGN KEY (fail_next_step) REFERENCES Workflow_Step(id);
ALTER table Workflow_Step ADD FOREIGN KEY (email_template) REFERENCES Email_Template(id);
ALTER table Workflow_Step ADD FOREIGN KEY (assignment_group) REFERENCES Group(id);
ALTER table Workflow_Step ADD FOREIGN KEY (new_status) REFERENCES Status(id);

ALTER table Email_Template ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Email_Template ADD FOREIGN KEY (updated_by) REFERENCES User(id);
