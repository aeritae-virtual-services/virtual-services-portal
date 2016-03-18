package com.vsportal.approval;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.client.ClientDAO;
import com.vsportal.request.RequestDAO;
import com.vsportal.user.User;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.QueryHelper;

public class ApprovalDAO extends JdbcDaoSupport {
	
	//Create Approval
	public Approval insert(final Approval approval, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Approval (created_by, updated_by, client_id, decision_by,"
				+ "decision_date, request_id, description, decision, approval_type)"
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, approval.getClient().getId());
						ps.setInt(4, approval.getDecisionBy().getId());
						ps.setDate(5, approval.getDecisionDate());
						ps.setInt(6, approval.getRequest().getId());
						ps.setString(7, approval.getDescription());
						ps.setString(8, approval.getDecision());
						ps.setString(9, approval.getApprovalType());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Approval
	public Approval update(Approval approval, User sessionUser) {
		String sql = "UPDATE Approval SET"
				+ "updated = now(), "
				+ "updated_by = ?, "
				+ "client_id = ?, "
				+ "decision_by = ?, "
				+ "decision_date = ?, "
				+ "request_id = ?, "
				+ "description = ?, "
				+ "decision = ?,"
				+ "approval_type = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			sessionUser.getId(),
			approval.getClient().getId(),
			approval.getDecisionBy().getId(),
			approval.getDecisionDate(),
			approval.getRequest().getId(),
			approval.getDescription(),
			approval.getDecision(),
			approval.getApprovalType(),
			approval.getId()
		});
		
		return this.recordQuery("id=" + approval.getId(), "*");
	}
	
	//Get Approval Record
	public Approval recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		
		String sql = "SELECT " + columns + " FROM Approval";
		
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
			sql += " LIMIT 0,1";
		}
		
		Approval approval = getJdbcTemplate().queryForObject(sql, new Object[]{}, new ApprovalRowMapper<Approval>());
		
		UserDAO uDAO = new UserDAO();
		RequestDAO rDAO = new RequestDAO();
		ClientDAO cDAO = new ClientDAO();
		
		if(approval.getClient().getId() != 0) {
			approval.getClient().setDisplayValue(cDAO.recordQuery("id=" + approval.getClient().getId(), "client_nme").getName());
		} else {
			approval.setClient(null);
		}
		
		if(approval.getCreatedBy().getId() != 0) {
			approval.getCreatedBy().setDisplayValue(uDAO.recordQuery("id=" + approval.getCreatedBy().getId(), "full_nme").getFullName());
		} else {
			approval.setCreatedBy(null);
		}
		
		if(approval.getUpdatedBy().getId() != 0) {
			approval.getUpdatedBy().setDisplayValue(uDAO.recordQuery("id=" + approval.getUpdatedBy().getId(), "full_nme").getFullName());
		} else {
			approval.setUpdatedBy(null);
		}
		
		if(approval.getRequest().getId() != 0) {
			approval.getRequest().setDisplayValue(rDAO.recordQuery("id=" + approval.getRequest().getId(), "number").getNumber());
			approval.setDisplayValue(approval.getRequest().getDisplayValue());
		} else {
			approval.setRequest(null);
			approval.setDisplayValue("");
		}
		
		return approval;
	}
	
	
	//Get Approval List
	public ArrayList<Approval> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		
		String sql = "SELECT " + columns + " FROM Approval";
		
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		ArrayList<Approval> approvalList = (ArrayList<Approval>)getJdbcTemplate().query(sql,new Object[]{}, new ApprovalRowMapper<Approval>());
		
		UserDAO uDAO = new UserDAO();
		RequestDAO rDAO = new RequestDAO();
		ClientDAO cDAO = new ClientDAO();
		
		for(Approval approval : approvalList) {
			if(approval.getClient().getId() != 0) {
				approval.getClient().setDisplayValue(cDAO.recordQuery("id=" + approval.getClient().getId(), "client_nme").getName());
			} else {
				approval.setClient(null);
			}
			
			if(approval.getCreatedBy().getId() != 0) {
				approval.getCreatedBy().setDisplayValue(uDAO.recordQuery("id=" + approval.getCreatedBy().getId(), "full_nme").getFullName());
			} else {
				approval.setCreatedBy(null);
			}
			
			if(approval.getUpdatedBy().getId() != 0) {
				approval.getUpdatedBy().setDisplayValue(uDAO.recordQuery("id=" + approval.getUpdatedBy().getId(), "full_nme").getFullName());
			} else {
				approval.setUpdatedBy(null);
			}
			
			if(approval.getRequest().getId() != 0) {
				approval.getRequest().setDisplayValue(rDAO.recordQuery("id=" + approval.getRequest().getId(), "number").getNumber());
				approval.setDisplayValue(approval.getRequest().getDisplayValue());
			} else {
				approval.setRequest(null);
				approval.setDisplayValue("");
			}
		}
		
		return approvalList;
	}
}
