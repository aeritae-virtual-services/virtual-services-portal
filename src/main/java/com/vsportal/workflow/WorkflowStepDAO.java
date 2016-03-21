package com.vsportal.workflow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;
public class WorkflowStepDAO extends JdbcDaoSupport {
	//Create WorkflowStep
	public WorkflowStep insert(final WorkflowStep workflowStep, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO WorkflowStep (created_by, updated_by, "
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
		
		String sql = "UPDATE WorkflowStep SET"
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
}
