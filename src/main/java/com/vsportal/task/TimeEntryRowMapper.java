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
		timeEntry.setId(rs.getInt("Time_Entry.id"));
		timeEntry.setCreated(rs.getDate("Time_Entry.created"));
		User cb = new User(rs.getInt("Time_Entry.created_by"), rs.getString("createdby.full_name"));
		timeEntry.setCreatedBy(cb);
		timeEntry.setUpdated(rs.getDate("Time_Entry.updated"));
		User ub = new User(rs.getInt("Time_Entry.updated_by"), rs.getString("updatedby.full_name"));
		timeEntry.setUpdatedBy(ub);
		Task task = new Task(rs.getInt("Time_Entry.task"),rs.getString("taskid.task_nbr"));
		timeEntry.setTask(task);
		Request request = new Request(rs.getInt("Time_Entry.request_id"),rs.getString("requestid.req_nbr"));
		timeEntry.setRequest(request);
		timeEntry.setHoursConsumed(rs.getFloat("Time_Entry.hours_consumed"));
		User user = new User(rs.getInt("Time_Entry.user_id"),rs.getString("userid.full_name"));
		timeEntry.setUser(user);
		Contract contract = new Contract(rs.getInt("Time_Entry.contract_id"),rs.getString("contractclient.client_nme"));
		timeEntry.setContract(contract);
		Client client = new Client(rs.getInt("Time_Entry.client_id"),rs.getString("clientid.client_nme"));
		timeEntry.setClient(client);
		return timeEntry;
	}
}
