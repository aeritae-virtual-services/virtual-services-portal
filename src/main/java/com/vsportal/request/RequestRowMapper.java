package com.vsportal.request;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.client.Client;
import com.vsportal.request.Request;
import com.vsportal.user.User;
import com.vsportal.status.Status;
import com.vsportal.priority.Priority;
import com.vsportal.request.RequestType;
import com.vsportal.contract.Contract;
import com.vsportal.tier.Tier;

public class RequestRowMapper<T> implements RowMapper<Request> {
	public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
		Request request = new Request();
		request.setId(rs.getInt("Request.id"));
		request.setCreated(rs.getDate("Request.created"));
		User cb = new User(rs.getInt("Request.created_by"), rs.getString("createdby.full_name"));
		request.setCreatedBy(cb);
		request.setUpdated(rs.getDate("Request.updated"));
		User ub = new User(rs.getInt("Request.updated_by"), rs.getString("updatedby.full_name"));
		request.setUpdatedBy(ub);
		User requester = new User(rs.getInt("Request.requester"),rs.getString("requesterid.full_name"));
		request.setRequester(requester);
		request.setNumber(rs.getString("Request.req_nbr"));
		request.setDescription(rs.getString("Request.description"));
		request.setShortDescription(rs.getString("Request.short_description"));
		request.setClientRequestNumber(rs.getString("Request.client_req_nbr"));
		Status status = new Status(rs.getInt("Request.req_status"),rs.getString("reqstatus.label"));
		request.setStatus(status);
		request.setRequestedCompletionDate(rs.getDate("Request.requested_completion_date"));
		Priority priority = new Priority(rs.getInt("Request.priority"),rs.getString("priorityid.label"));
		request.setPriority(priority);
		request.setUpdateSet("Request.update_set");
		request.setRequestLevelOfEffort(rs.getBoolean("Request.request_loe"));
		request.setEstimatedLevelOfEffort(rs.getFloat("Request.estimated_loe"));
		request.setHoursConsumed(rs.getFloat("Request.hours_consumed"));
		RequestType requestType = new RequestType(rs.getInt("Request.request_type"),rs.getString("requesttype.req_type_nme"));
		request.setRequestType(requestType);
		Contract contract = new Contract(rs.getInt("Request.contract_id"),rs.getString("contractclient.client_nme"));
		request.setContract(contract);
		Tier tier = new Tier(rs.getInt("Request.tier"),rs.getString("tierid.tier_name"));
		request.setTier(tier);
		Status resumeTo = new Status(rs.getInt("Request.resume_to"),rs.getString("resumeto.label"));
		request.setResumeTo(resumeTo);
		Client client = new Client(rs.getInt("Request.client_id"),rs.getString("clientid.client_nme"));
		request.setClient(client);
		return request;
	}
}
