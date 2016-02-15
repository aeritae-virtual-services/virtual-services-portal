CREATE table Field_type{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
name varchar(100),
jsp_partial varchar(100)
};

CREATE table Field{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
name varchar(100),
column varchar(100),
label varchar(100),
table varchar(100),
type int unsigned,
display boolean,
filter varchar(500)
};

CREATE table Company{
ID int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
name varchar(100),
primary_contact int unsigned,
url varchar(200),
address varchar(500),
queue_manager int unsigned,
migration boolean
};

CREATE table User{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
first_name varchar(100),
last_name varchar(100),
phone_number varchar(20),
email varchar(50),
company int unsigned,
role int unsigned
};

CREATE table Group{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
name varchar(100),
};

CREATE table Group_Member{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
group int unsigned,
user int unsigned
};

CREATE table Role{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
name varchar(100),
value int unsigned
};

CREATE table Status{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
label varchar(40),
value int unsigned,
type varchar(100)
};

CREATE table Priority{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
label varchar(40),
value int unsigned
};

CREATE table Request_Type{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
name varchar(100),
description text,
first_workflow_step int unsigned
};

CREATE table Service_Request{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
requester int unsigned,
number varchar(100),
description text,
client_request_number varchar(100),
status int unsigned,
requested_completion_date datetime,
priority int unsigned,
update_set varchar(100),
request_level_of_effort boolean,
estimated_level_of_effort double,
hours_consumed double,
request_type int unsigned,
contract int unsigned,
tier int unsigned
};

CREATE table Watch_List{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
service_request int unsigned,
email varchar(100)
};

CREATE table Task{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
service_request int unsigned,
assignment_group int unsigned,
assigned_to int unsigned
instructions varchar(500)
status int unsigned,
hours_consumed double
};

CREATE table Comment{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
service_request int unsigned,
comment text(4000),
public boolean
};

CREATE table Attachments{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
service_request int unsigned,
url varchar(200),
file_type varchar(40)
};

CREATE table Tier{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
name varchar(100)
};

CREATE table Contract{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
company int unsigned,
tier int unsigned,
start_date datetime,
end_date datetime,
final_completion_date datetime,
status int unsigned
};

CREATE table Time_Entry{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
task int unsigned,
hours_consumed double,
user int unsigned,
contract int unsigned
};

CREATE table Status_History{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
type varchar(100),
type_id int unsigned,
start datetime,
end datetime,
duration int unsigned,
status int unsigned
};

CREATE table Workflow_Operation{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
description varchar(500)
};

CREATE table Workflow_Step{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
operation varchar(100),
success_next_step int unsigned,
fail_next_step int unsigned,
description varchar(500),
email_template int unsigned,
assignment_group int unsigned,
instructions varchar(500),
new_status int unsigned
};

CREATE table Email_Template{
id int unsigned NOT NULL auto-increment,
created datetime NOT NUll default NOW(),
created_by int unsigned NOT NULL,
updated datetime NOT NULL default NOW(),
updated_by int unsigned NOT NULL,
to varchar(500),
body text(4000)
};

ALTER table Field_type ADD PRIMARY KEY (id);
ALTER table Field_type ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table field_type ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Field ADD PRIMARY KEY (id);
ALTER table Field ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Field ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Field ADD FOREIGN KEY (type) REFERENCES Field_type(id);

ALTER table Company ADD PRIMARY KEY (id);
ALTER table Company ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Company ADD FOREIGN Key (updated_by) REFERENCES User(id);
ALTER table Company ADD FOREIGN KEY (primary_contact) REFERENCES USER(id);
ALTER table Company ADD FOREIGN KEY (queue_manager) REFERENCES User(id);

ALTER table User ADD PRIMARY KEY (id);
ALTER table User ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table User ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table User ADD FOREIGN KEY (role) REFERENCES Role(id);

ALTER table Group ADD PRIMARY KEY (id);
ALTER table Group ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Group ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Group_Member ADD PRIMARY KEY (id);
ALTER table Group_Member ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Group_Member ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Group_Member ADD FOREIGN KEY (group) REFERENCES Group(id);
ALTER table Group_Member ADD FOREIGN KEY (user) REFERENCES User(id);

ALTER table Role ADD PRIMARY KEY (id);
ALTER table Role ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Role ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Status ADD PRIMARY KEY (id);
ALTER table Status ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Status ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Priority ADD PRIMARY KEY (id);
ALTER table Priority ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Priority ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Request_type ADD PRIMARY KEY (id);
ALTER table Request_type ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Request_type ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Request_type ADD FOREIGN KEY (first_workflow_step) REFERENCES Workflow_Step(id);

ALTER table Service_Request ADD PRIMARY KEY (id);
ALTER table Service_Request ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Service_Request ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Service_Request ADD FOREIGN KEY (requester) REFERENCES User(id);
ALTER table Service_Request ADD FOREIGN KEY (status) REFERENCES Status(id);
ALTER table Service_Request ADD FOREIGN KEY (priority) REFERENCES Priority(id);
ALTER table Service_Request ADD FOREIGN KEY (request_type) REFERENCES Request_type(id);
ALTER table Service_Request ADD FOREIGN KEY (contract) REFERENCES Contract(id);
ALTER table Service_Request ADD FOREIGN KEY (tier) REFERENCES Tier(id);

ALTER table Watch_List ADD PRIMARY Key (id);
ALTER table Watch_List ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Watch_List ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Watch_List ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);

ALTER table Task ADD PRIMARY KEY (id);
ALTER table Task ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Task ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Task ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);
ALTER table Task ADD FOREIGN KEY (assignment_group) REFERENCES Group(id);
ALTER table Task ADD FOREIGN KEY (status) REFERENCES Status(id);
ALTER table Task ADD FOREIGN KEY (assigned_to) REFERENCES User(id);

ALTER table Comment ADD PRIMARY KEY (id);
ALTER table Comment ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Comment ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Comment ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);

ALTER table Attachments ADD PRIMARY KEY (id);
ALTER table Attachments ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Attachments ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Attachments ADD FOREIGN KEY (service_request) REFERENCES Service_Request(id);

ALTER table Tier ADD PRIMARY KEY (id);
ALTER table Tier ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Tier ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Contract ADD PRIMARY KEY (id);
ALTER table Contract ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Contract ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Contract ADD FOREIGN KEY (company) REFERENCES Company(id);
ALTER table Contract ADD FOREIGN KEY (tier) REFERENCES Tier(id);
ALTER table Contract ADD FOREIGN KEY (status) REFERENCES Status(id);

ALTER table Time_Entry ADD PRIMARY KEY (id);
ALTER table Time_Entry ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (task) REFERENCES Task(id);
ALTER table Time_Entry ADD FOREIGN KEY (user) REFERENCES User(id);
ALTER table Time_Entry ADD FOREIGN KEY (contract) REFERENCES Contract(id);

ALTER table Status_History ADD PRIMARY KEY (id);
ALTER table Status_History ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Status_History ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Status_History ADD FOREIGN KEY (status) REFERENCES Status(id);

ALTER table Workflow_Operation ADD PRIMARY KEY (id);
ALTER table Workflow_Operation ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Workflow_Operation ADD FOREIGN KEY (updated_by) REFERENCES User(id);

ALTER table Workflow_Step ADD PRIMARY KEY (id);
ALTER table Workflow_Step ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Workflow_Step ADD FOREIGN KEY (updated_by) REFERENCES User(id);
ALTER table Workflow_Step ADD FOREIGN KEY (success_next_step) REFERENCES Workflow_Step(id);
ALTER table Workflow_Step ADD FOREIGN KEY (fail_next_step) REFERENCES Workflow_Step(id);
ALTER table Workflow_Step ADD FOREIGN KEY (email_template) REFERENCES Email_Template(id);
ALTER table Workflow_Step ADD FOREIGN KEY (assignment_group) REFERENCES Group(id);
ALTER table Workflow_Step ADD FOREIGN KEY (new_status) REFERENCES Status(id);

ALTER table Email_Template ADD PRIMARY KEY (id);
ALTER table Email_Template ADD FOREIGN KEY (created_by) REFERENCES User(id);
ALTER table Email_Template ADD FOREIGN KEY (updated_by) REFERENCES User(id);
