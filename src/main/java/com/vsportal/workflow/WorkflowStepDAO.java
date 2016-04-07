package com.vsportal.workflow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;
public class WorkflowStepDAO extends JdbcDaoSupport {
	//Create WorkflowStep
	public WorkflowStep insert(final WorkflowStep workflowStep, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Workflow_Step (created_by, updated_by, "
				+ "operation_id, success_next_step, fail_next_step, description, email_template_id,"
				+ "assignment_group_id, instructions, new_status, write_metric)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, workflowStep.getOperation().getId());
						ps.setInt(4, workflowStep.getSuccessNextStep().getId());
						ps.setInt(5, workflowStep.getFailNextStep().getId());
						ps.setString(6, workflowStep.getDescription());
						ps.setInt(7, workflowStep.getEmailTemplate().getId());
						ps.setInt(8, workflowStep.getAssignmentGroup().getId());
						ps.setString(9, workflowStep.getInstructions());
						ps.setInt(10, workflowStep.getNewStatus().getId());
						ps.setBoolean(11, workflowStep.isWriteMetric());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update WorkflowStep
	public WorkflowStep update(WorkflowStep workflowStep, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		workflowStep.setUpdated(now);
		
		String sql = "UPDATE Workflow_Step SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "operation_id = ?, "
				+ "success_next_step = ?, "
				+ "fail_next_step = ?, "
				+ "description = ?, "
				+ "email_template_id = ?, "
				+ "assignment_group_id = ?, "
				+ "instructions = ?, "
				+ "new_status = ?, "
				+ "write_metric = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			workflowStep.getUpdated(),
			sessionUser.getId(),
			workflowStep.getOperation().getId(),
			workflowStep.getSuccessNextStep().getId(),
			workflowStep.getFailNextStep().getId(),
			workflowStep.getDescription(),
			workflowStep.getEmailTemplate().getId(),
			workflowStep.getAssignmentGroup().getId(),
			workflowStep.getInstructions(),
			workflowStep.getNewStatus().getId(),
			workflowStep.isWriteMetric(),
			workflowStep.getId()
		});
		return workflowStep;
	}

	//get WorkflowStep
	public WorkflowStep recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Workflow_Step
			sql += " Workflow_Step.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Workflow_Step
				sql += " Workflow_Step." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Workflow_Step
			sqlJoin += " LEFT JOIN User As createdby ON Workflow_Step.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Workflow_Step
			sqlJoin += " LEFT JOIN User As updatedby ON Workflow_Step.updated_by = updatedby.id";
		}
		//Workflow_Operation
		if(columns.equals("*") || columns.contains("operation_id")) {
			sql += " operationid.operation_nme,";
			//Merge Workflow_Operation and: Workflow_Step
			sqlJoin += " LEFT JOIN Workflow_Operation As operationid ON Workflow_Step.operation_id = operationid.id";
		}
		//Success Next Step
		if(columns.equals("*") || columns.contains("success_next_step")) {
			sql += " successnextsteptasktype.label,";
			//Merge Workflow_Step and: Workflow_Step
			sqlJoin += " LEFT JOIN Workflow_Step As successnextstep ON Workflow_Step.success_next_step = successnextstep.id";
			//Merge successnextstep and Task_Type
			sqlJoin += " LEFT JOIN Task_Type As successnextsteptasktype ON successnextstep.task_type = successnextsteptasktype.id";
		}
		//Fail Next Step
		if(columns.equals("*") || columns.contains("fail_next_step")) {
			sql += " failnextsteptasktype.label,";
			//Merge Workflow_Step and: Workflow_Step
			sqlJoin += " LEFT JOIN Workflow_Step As failnextstep ON Workflow_Step.fail_next_step = failnextstep.id";
			//Merge failsnextstep and Task_Type
			sqlJoin += " LEFT JOIN Task_Type As failnextsteptasktype ON failnextstep.task_type = failnextsteptasktype.id";
		}
		//Email Template
		if(columns.equals("*") || columns.contains("email_template_id")) {
			sql += " emailtemplateid.subject,";
			//Merge Email Template and: Workflow_Step
			sqlJoin += " LEFT JOIN Email_Template As emailtemplateid ON Workflow_Step.email_template_id = emailtemplateid.id";
		}
		//Assignment Group
		if(columns.equals("*") || columns.contains("assignment_group_id")) {
			sql += " assignmentgroupid.user_group_nme,";
			//Merge user_group and: Workflow_Step
			sqlJoin += " LEFT JOIN User_Group As assignmentgroupid ON Workflow_Step.assignment_group_id = assignmentgroupid.id";
		}
		//New Status
		if(columns.equals("*") || columns.contains("new_status")) {
			sql += " newstatus.label,";
			//Merge status and: Workflow_Step
			sqlJoin += " LEFT JOIN Status As newstatus ON Workflow_Step.new_status = newstatus.id";
		}
		//Task Type
		if(columns.equals("*") || columns.contains("task_type")) {
			sql += " tasktypeid.label,";
			//Merge Task Type and: Workflow_Step
			sqlJoin += " LEFT JOIN Task_Type As tasktypeid ON Workflow_Step.task_type = tasktypeid.id";
		}
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Workflow_Step
		sql += " FROM Workflow_Step" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		WorkflowStep workflowStep = getJdbcTemplate().queryForObject(sql, new Object[]{}, new WorkflowStepRowMapper<WorkflowStep>());
		
		return workflowStep;
	}
	
	//Get WorkflowStep List
	public ArrayList<WorkflowStep> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Workflow_Step.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Workflow_Step." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Workflow_Step
			sqlJoin += " LEFT JOIN User As createdby ON Workflow_Step.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Workflow_Step
			sqlJoin += " LEFT JOIN User As updatedby ON Workflow_Step.updated_by = updatedby.id";
		}
		//Workflow_Operation
		if(columns.equals("*") || columns.contains("operation_id")) {
			sql += " operationid.operation_nme,";
			//Merge Workflow_Operation and: Workflow_Step
			sqlJoin += " LEFT JOIN Workflow_Operation As operationid ON Workflow_Step.operation_id = operationid.id";
		}
		//Success Next Step
		if(columns.equals("*") || columns.contains("success_next_step")) {
			sql += " successnextsteptasktype.label,";
			//Merge Workflow_Step and: Workflow_Step
			sqlJoin += " LEFT JOIN Workflow_Step As successnextstep ON Workflow_Step.success_next_step = successnextstep.id";
			//Merge successnextstep and Task_Type
			sqlJoin += " LEFT JOIN Task_Type As successnextsteptasktype ON successnextstep.task_type = successnextsteptasktype.id";
		}
		//Fail Next Step
		if(columns.equals("*") || columns.contains("fail_next_step")) {
			sql += " failnextsteptasktype.label,";
			//Merge Workflow_Step and: Workflow_Step
			sqlJoin += " LEFT JOIN Workflow_Step As failnextstep ON Workflow_Step.fail_next_step = failnextstep.id";
			//Merge failsnextstep and Task_Type
			sqlJoin += " LEFT JOIN Task_Type As failnextsteptasktype ON failnextstep.task_type = failnextsteptasktype.id";
		}
		//Email Template
		if(columns.equals("*") || columns.contains("email_template_id")) {
			sql += " emailtemplateid.subject,";
			//Merge Email Template and: Workflow_Step
			sqlJoin += " LEFT JOIN Email_Template As emailtemplateid ON Workflow_Step.email_template_id = emailtemplateid.id";
		}
		//Assignment Group
		if(columns.equals("*") || columns.contains("assignment_group_id")) {
			sql += " assignmentgroupid.user_group_nme,";
			//Merge user_group and: Workflow_Step
			sqlJoin += " LEFT JOIN User_Group As assignmentgroupid ON Workflow_Step.assignment_group_id = assignmentgroupid.id";
		}
		//New Status
		if(columns.equals("*") || columns.contains("new_status")) {
			sql += " newstatus.label,";
			//Merge status and: Workflow_Step
			sqlJoin += " LEFT JOIN Status As newstatus ON Workflow_Step.new_status = newstatus.id";
		}
		//Task Type
		if(columns.equals("*") || columns.contains("task_type")) {
			sql += " tasktypeid.label,";
			//Merge Task Type and: Workflow_Step
			sqlJoin += " LEFT JOIN Task_Type As tasktypeid ON Workflow_Step.task_type = tasktypeid.id";
		}		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Workflow_Step" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<WorkflowStep> workflowStepList = (ArrayList<WorkflowStep>)getJdbcTemplate().query(sql,new Object[]{}, new WorkflowStepRowMapper<WorkflowStep>());
		
		return workflowStepList;
	}

	public WorkflowStep getStepByID(int stepID) {
		String sql = "Select * FROM Workflow_Step WHERE id= ?";
		WorkflowStep step = getJdbcTemplate().queryForObject(sql,new Object[]{ stepID },
				new WorkflowStepRowMapper());
		
		return step;
	}
}
