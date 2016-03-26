package com.vsportal.request;

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

public class RequestDAO extends JdbcDaoSupport {

	//Create Request
	public Request insert(final Request request, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Request (created_by, updated_by, "
				+ "requester, req_nbr, description, short_description, client_req_nbr,"
				+ "req_status, request_completion_date, priority, update_set, request_loe,"
				+ "estimated_loe, hours_consumed, request_type, contract_id, tier, resume_to, client_id"
				+ ")"
				+ "VALUES(?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,?,?"
				+ ")";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, request.getRequester().getId());
						ps.setString(4, request.getNumber());
						ps.setString(5, request.getDescription());
						ps.setString(6, request.getShortDescription());
						ps.setString(7, request.getClientRequestNumber());
						ps.setInt(8, request.getStatus().getId());
						ps.setDate(9, request.getRequestedCompletionDate());
						ps.setInt(10, request.getPriority().getId());
						ps.setString(11, request.getUpdateSet());
						ps.setBoolean(12, request.isRequestLOE());
						ps.setFloat(13, request.getEstimatedLOE());
						ps.setFloat(14, request.getHoursConsumed());
						ps.setInt(15, request.getRequestType().getId());
						ps.setInt(16, request.getContract().getId());
						ps.setInt(17, request.getTier().getId());
						ps.setInt(18, request.getResumeTo().getId());
						//get client missing
						ps.setInt(19, request.getClient().getId());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Request
	public Request update(Request request, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		request.setUpdated(now);
		
		String sql = "UPDATE Request SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "requester = ?, "
				+ "req_nbr = ?,"
				+ "description = ?,"
				+ "short_description = ?,"
				+ "client_req_nbr = ?,"
				+ "req_status = ?,"
				+ "requested_completion_date = ?,"
				+ "priority = ?,"
				+ "update_set = ?,"
				+ "request_loe = ?,"
				+ "estimated_loe = ?,"
				+ "hours_consumed = ?,"
				+ "request_type = ?, "
				+ "contract_id = ?, "
				+ "tier = ?,"
				+ "resume_to = ?,"
				+ "client_id = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			request.getUpdated(),
			sessionUser.getId(),
			request.getRequester().getId(),
			request.getNumber(),
			request.getDescription(),
			request.getShortDescription(),
			request.getClientRequestNumber(),
			request.getStatus().getId(),
			request.getRequestedCompletionDate(),
			request.getPriority().getId(),
			request.getUpdateSet(),
			request.isRequestLOE(),
			request.getEstimatedLOE(),
			request.getHoursConsumed(),
			request.getRequestType().getId(),
			request.getContract().getId(),
			request.getTier().getId(),
			request.getResumeTo().getId(),
			//get client missing from request
			request.getClient().getId(),
			request.getId()
		});
		
		return request;
	}
	

	//get Request
	public Request recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Request
			sql += " Request.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Request
				sql += " Request." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Request
			sqlJoin += " LEFT JOIN User As createdby ON Request.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Request
			sqlJoin += " LEFT JOIN User As updatedby ON Request.updated_by = updatedby.id";
		}
		//Requester
		if(columns.equals("*") || columns.contains("requester")) {
			sql += " requesterid.full_name,";
			//Merge User and: Request
			sqlJoin += " LEFT JOIN User As requesterid ON Request.requesterid = requesterid.id";
		}
		//Status
		if(columns.equals("*") || columns.contains("req_status")) {
			sql += " reqstatus.label,";
			//Merge Status and: Request
			sqlJoin += " LEFT JOIN Status As reqstatus ON Request.req_status = reqstatus.id";
		}
		//Priority
		if(columns.equals("*") || columns.contains("priority")) {
			sql += " priorityid.label,";
			//Merge Priority and: Request
			sqlJoin += " LEFT JOIN Priority As priorityid ON Request.priority = priorityid.id";
		}
		//RequestType
		if(columns.equals("*") || columns.contains("request_type")) {
			sql += " requesttype.req_type_nme,";
			//Merge RequestType and: Request
			sqlJoin += " LEFT JOIN RequestType As requesttype ON Request.request_type = requesttype.id";
		}
		//Contract
		if(columns.equals("*") || columns.contains("contract_id")) {
			sql += " contractclient.client_nme,";
			//Merge Contract and: Request
			sqlJoin += " LEFT JOIN Contract As contractid ON Request.contract_id = contractid.id";
			//Merge Client on contractid
			sqlJoin += " LEFT JOIN Client As contractclient ON contratid.client_id = contractclient.id";
		}
		//Tier
		if(columns.equals("*") || columns.contains("tier")) {
			sql += " tierid.teir_name,";
			//Merge Tier and: Request
			sqlJoin += " LEFT JOIN Tier As tierid ON Request.tier = tierid.id";
		}
		//Resume To
		if(columns.equals("*") || columns.contains("resume_to")) {
			sql += " resumeto.label,";
			//Merge Status and: Request
			sqlJoin += " LEFT JOIN Status As resumeto ON Request.resume_to = resumeto.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.client_nme,";
			//Merge Client and: Request
			sqlJoin += " LEFT JOIN Client As clientid ON Request.client_id = clientid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Request
		sql += " FROM Request" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Request request = getJdbcTemplate().queryForObject(sql, new Object[]{}, new RequestRowMapper<Request>());
		
		return request;
	}
	
	//Get Request List
	public ArrayList<Request> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Request.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Request." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Request
			sqlJoin += " LEFT JOIN User As createdby ON Request.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Request
			sqlJoin += " LEFT JOIN User As updatedby ON Request.updated_by = updatedby.id";
		}
		//Requester
		if(columns.equals("*") || columns.contains("requester")) {
			sql += " requesterid.full_name,";
			//Merge User and: Request
			sqlJoin += " LEFT JOIN User As requesterid ON Request.requesterid = requesterid.id";
		}
		//Status
		if(columns.equals("*") || columns.contains("req_status")) {
			sql += " reqstatus.label,";
			//Merge Status and: Request
			sqlJoin += " LEFT JOIN Status As reqstatus ON Request.req_status = reqstatus.id";
		}
		//Priority
		if(columns.equals("*") || columns.contains("priority")) {
			sql += " priorityid.label,";
			//Merge Priority and: Request
			sqlJoin += " LEFT JOIN Priority As priorityid ON Request.priority = priorityid.id";
		}
		//RequestType
		if(columns.equals("*") || columns.contains("request_type")) {
			sql += " requesttype.req_type_nme,";
			//Merge RequestType and: Request
			sqlJoin += " LEFT JOIN RequestType As requesttype ON Request.request_type = requesttype.id";
		}
		//Contract
		if(columns.equals("*") || columns.contains("contract_id")) {
			sql += " contractclient.client_nme,";
			//Merge Contract and: Request
			sqlJoin += " LEFT JOIN Contract As contractid ON Request.contract_id = contractid.id";
			//Merge Client on contractid
			sqlJoin += " LEFT JOIN Client As contractclient ON contratid.client_id = contractclient.id";
		}
		//Tier
		if(columns.equals("*") || columns.contains("tier")) {
			sql += " tierid.teir_name,";
			//Merge Tier and: Request
			sqlJoin += " LEFT JOIN Tier As tierid ON Request.tier = tierid.id";
		}
		//Resume To
		if(columns.equals("*") || columns.contains("resume_to")) {
			sql += " resumeto.label,";
			//Merge Status and: Request
			sqlJoin += " LEFT JOIN Status As resumeto ON Request.resume_to = resumeto.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.client_nme,";
			//Merge Client and: Request
			sqlJoin += " LEFT JOIN Client As clientid ON Request.client_id = clientid.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Request" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Request> requestList = (ArrayList<Request>)getJdbcTemplate().query(sql,new Object[]{}, new RequestRowMapper<Request>());
		
		return requestList;
	}
}
