package com.vsportal.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.task.Task;
import com.vsportal.task.TaskRowMapper;
import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;

public class TaskDAO extends JdbcDaoSupport {

	//Create Task
	public Task insert(final Task task, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Task ( "
				+ " created_by,"
				+ " updated_by, "
				+ " request_id,"
				+ " assignment_group,"
				+ " assigned_to,"
				+ " instructions,"
				+ " task_status,"
				+ " task_nbr,"
				+ " resume_to,"
				+ " task_hours_consumed,"
				+ " poked_analyst, "
				+ " poked_date, "
				+ " poked_by, "
				+ " client"
				+ ")"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, task.getRequest().getId());
						ps.setInt(4, task.getAssignmentGroup().getId());
						ps.setInt(5, task.getAssignedTo().getId());
						ps.setString(6, task.getInstructions());
						ps.setInt(7, task.getStatus().getId());
						ps.setString(8, task.getNumber());
						ps.setInt(9, task.getResumeTo().getId());
						ps.setFloat(10, task.getHoursConsumed());
						ps.setInt(11, task.getPokedAnalyst().getId());
						ps.setDate(12, task.getPokedDate());
						ps.setInt(13, task.getPokedBy().getId());
						ps.setInt(14, task.getClient().getId());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Task
	public Task update(Task task, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		task.setUpdated(now);
		
		String sql = "UPDATE Task SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ " request_id= ?, "
				+ " assignment_group= ?, "
				+ " assigned_to= ?, "
				+ " instructions= ?, "
				+ " task_status= ?, "
				+ " task_nbr= ?, "
				+ " resume_to= ?, "
				+ " task_hours_consumed= ?, "
				+ " poked_analyst= ?, "
				+ " poked_date= ?, "
				+ " poked_by= ?, "
				+ " client= ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			task.getUpdated(),
			sessionUser.getId(),
			task.getRequest().getId(),
			task.getAssignmentGroup().getId(),
			task.getAssignedTo().getId(),
			task.getInstructions(),
			task.getStatus().getId(),
			task.getNumber(),
			task.getResumeTo().getId(),
			task.getHoursConsumed(),
			task.getPokedAnalyst().getId(),
			task.getPokedDate(),
			task.getPokedBy().getId(),
			task.getClient.getId(),
			task.getId()
		});
		
		return task;
	}
	//get Task
	public Task recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Task
			sql += " Task.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Task
				sql += " Task." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User As createdby ON Task.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User As updatedby ON Task.updated_by = updatedby.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			//Merge Request and: Task
			sqlJoin += " LEFT JOIN Request As requestid ON Task.request_id = requestid.id";
		}
		//Assignment Group
		if(columns.equals("*") || columns.contains("assignment_group")) {
			sql += " assignmentgroup.user_group_nme,";
			//Merge Group and: Task
			sqlJoin += " LEFT JOIN User_Group AS assignmentgroup ON Task.assignment_group = assignmentgroup.id";
		}
		//Assigned To
		if(columns.equals("*") || columns.contains("assigned_to")) {
			sql += " assignedto.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User AS assignedto ON Task.assigned_to = assignedto.id";
		}
		//Status
		if(columns.equals("*") || columns.contains("task_status")) {
			sql += " taskstatus.label,";
			//Merge Status and: Task
			sqlJoin += " LEFT JOIN Status AS taskstatus ON Task.task_status = taskstatus.id";
		}
		//Resume To
		if(columns.equals("*") || columns.contains("resume_to")) {
			sql += " resumeto.label,";
			//Merge Status and: Task
			sqlJoin += " LEFT JOIN Status AS resumeto ON Task.resume_to = resumeto.id";
		}
		//Poked Analyst
		if(columns.equals("*") || columns.contains("poked_analyst")) {
			sql += " pokedanalyst.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User AS pokedanalyst ON Task.poked_analyst = pokedanalyst.id";
		}
		//Poked by
		if(columns.equals("*") || columns.contains("poked_by")) {
			sql += " pokedby.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User AS pokedby ON Task.poked_by = pokedby.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client")) {
			sql += " clientid.client_nme,";
			//Merge client and: Task
			sqlJoin += " LEFT JOIN Client AS clientid ON Task.client = clientid.id";
		}
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Task
		sql += " FROM Task" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Task task = getJdbcTemplate().queryForObject(sql, new Object[]{}, new TaskRowMapper<Task>());
		
		return task;
	}
	
	//Get Task List
	public ArrayList<Task> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Task.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Task." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User As createdby ON Task.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User As updatedby ON Task.updated_by = updatedby.id";
		}
		
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			//Merge Request and: Task
			sqlJoin += " LEFT JOIN Request As requestid ON Task.request_id = requestid.id";
		}
		//Assignment Group
		if(columns.equals("*") || columns.contains("assignment_group")) {
			sql += " assignmentgroup.user_group_nme,";
			//Merge Group and: Task
			sqlJoin += " LEFT JOIN User_Group AS assignmentgroup ON Task.assignment_group = assignmentgroup.id";
		}
		//Assigned To
		if(columns.equals("*") || columns.contains("assigned_to")) {
			sql += " assignedto.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User AS assignedto ON Task.assigned_to = assignedto.id";
		}
		//Status
		if(columns.equals("*") || columns.contains("task_status")) {
			sql += " taskstatus.label,";
			//Merge Status and: Task
			sqlJoin += " LEFT JOIN Status AS taskstatus ON Task.task_status = taskstatus.id";
		}
		//Resume To
		if(columns.equals("*") || columns.contains("resume_to")) {
			sql += " resumeto.label,";
			//Merge Status and: Task
			sqlJoin += " LEFT JOIN Status AS resumeto ON Task.resume_to = resumeto.id";
		}
		//Poked Analyst
		if(columns.equals("*") || columns.contains("poked_analyst")) {
			sql += " pokedanalyst.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User AS pokedanalyst ON Task.poked_analyst = pokedanalyst.id";
		}
		//Poked by
		if(columns.equals("*") || columns.contains("poked_by")) {
			sql += " pokedby.full_name,";
			//Merge User and: Task
			sqlJoin += " LEFT JOIN User AS pokedby ON Task.poked_by = pokedby.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client")) {
			sql += " clientid.client_nme,";
			//Merge client and: Task
			sqlJoin += " LEFT JOIN Client AS clientid ON Task.client = clientid.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Task" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Task> taskList = (ArrayList<Task>)getJdbcTemplate().query(sql,new Object[]{}, new TaskRowMapper<Task>());
		
		return taskList;
	}
}
