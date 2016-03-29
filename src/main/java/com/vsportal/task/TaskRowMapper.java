package com.vsportal.task;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.request.Request;
import com.vsportal.group.Group;
import com.vsportal.status.Status;
import com.vsportal.client.Client;
public class TaskRowMapper<T> implements RowMapper<Task> {
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		Task task = new Task();
		task.setId(rs.getInt("Task.id"));
		task.setCreated(rs.getDate("Task.created"));
		User cb = new User(rs.getInt("Task.created_by"), rs.getString("createdby.full_name"));
		task.setCreatedBy(cb);
		task.setUpdated(rs.getDate("Task.updated"));
		User ub = new User(rs.getInt("Task.updated_by"), rs.getString("updatedby.full_name"));
		task.setUpdatedBy(ub);
		task.setRequest(new Request(rs.getInt("Task.request_id"),rs.getString("requestid.req_nbr")));
		task.setAssignmentGroup(new Group(rs.getInt("Task.assignment_group"),rs.getString("assignmentgroup.user_group_nme")));
		task.setAssignedTo(new User(rs.getInt("Task.assigned_to"),rs.getString("assignedto.full_name")));
		task.setInstructions(rs.getString("Task.instructions"));
		task.setStatus(new Status(rs.getInt("Task.task_status"),rs.getString("taskstatus.label")));
		task.setNumber(rs.getString("Task.task_nbr"));
		task.setResumeTo(new Status(rs.getInt("Task.resume_to"),rs.getString("resumeto.label")));
		task.setHoursConsumed(rs.getFloat("Task.task_hours_consumed"));
		task.setPokedAnalyst(new User(rs.getInt("Task.poked_analyst"),rs.getString("pokedanalyst.full_name")));
		task.setPokedDate(rs.getDate("Task.poked_date"));
		task.setPokedBy(new User(rs.getInt("Task.poked_by"),rs.getString("pokedby.full_name")));
		task.setClient(new Client(rs.getInt("Task.client"),rs.getString("clientid.client_nme")));
		return task;
	}
}
