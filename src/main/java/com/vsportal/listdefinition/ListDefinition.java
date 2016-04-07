package com.vsportal.listdefinition;

import java.sql.Date;

import com.vsportal.role.Role;
import com.vsportal.user.User;

public class ListDefinition implements Comparable<ListDefinition>{
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private String tableName;
	private Role roleId;
	private String columnLabel;
	private String columnName;
	private int sequence;
	
	public ListDefinition() {
	}
	
	public ListDefinition(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
	}

	public ListDefinition(int id, Date created, User createdBy, Date updated, User updatedBy, String tableName,
			Role roleId, String columnLabel, String columnName, int sequence) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.tableName = tableName;
		this.roleId = roleId;
		this.columnLabel = columnLabel;
		this.columnName = columnName;
		this.sequence = sequence;
		this.displayValue = columnLabel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public String getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	public int compareTo(ListDefinition ld) {
		return Integer.compare(sequence, ld.getSequence());
	}
}
