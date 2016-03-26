package com.vsportal.task;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.request.Request;
import com.vsportal.contract.Contract;
import com.vsportal.client.Client;

public class TimeEntryRowMapper<T> implements RowMapper<TimeEntry> {
	public TimeEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
		TimeEntry timeEntry = new TimeEntry();
		timeEntry.setId(rs.getInt("TimeEntry.id"));
		timeEntry.setCreated(rs.getDate("TimeEntry.created"));
		User cb = new User(rs.getInt("TimeEntry.created_by"), rs.getString("createdby.full_name"));
		timeEntry.setCreatedBy(cb);
		timeEntry.setUpdated(rs.getDate("TimeEntry.updated"));
		User ub = new User(rs.getInt("TimeEntry.updated_by"), rs.getString("updatedby.full_name"));
		timeEntry.setUpdatedBy(ub);
		Task task = new Task(rs.getInt("TimeEntry.task"),rs.getString("taskid.task_nbr"));
		timeEntry.setTask(task);
		Request request = new Request(rs.getInt("TimeEntry.request_id"),rs.getString("requestid.req_nbr"));
		timeEntry.setRequest(request);
		timeEntry.setHoursConsumed(rs.getFloat("TimeEntry.hours_consumed"));
		User user = new User(rs.getInt("TimeEntry.user_id"),rs.getString("userid.full_name"));
		timeEntry.setUser(user);
		Contract contract = new Contract(rs.getInt("TimeEntry.contract_id"),rs.getString("contractclient.client_nme"));
		timeEntry.setContract(contract);
		Client client = new Client(rs.getInt("TimeEntry.client_id"),rs.getString("clientid.client_nme"));
		timeEntry.setClient(client);
		return timeEntry;
	}
}
