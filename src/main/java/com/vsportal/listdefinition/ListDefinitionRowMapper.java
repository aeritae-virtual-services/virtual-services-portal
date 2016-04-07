package com.vsportal.listdefinition;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.role.Role;
public class ListDefinitionRowMapper<T> implements RowMapper<ListDefinition> {
	public ListDefinition mapRow(ResultSet rs, int rowNum) throws SQLException {
		ListDefinition listDefinition = new ListDefinition();
		listDefinition.setId(rs.getInt("List_Definition.id"));
		listDefinition.setCreated(rs.getDate("List_Definition.created"));
		User cb = new User(rs.getInt("List_Definition.created_by"), rs.getString("createdby.full_name"));
		listDefinition.setCreatedBy(cb);
		listDefinition.setUpdated(rs.getDate("List_Definition.updated"));
		User ub = new User(rs.getInt("List_Definition.updated_by"), rs.getString("updatedby.full_name"));
		listDefinition.setUpdatedBy(ub);
		listDefinition.setTableName(rs.getString("List_Definition.table_nme"));
		listDefinition.setRoleId(new Role(rs.getInt("List_Definition.role_id"),rs.getString("roleid.role_nme")));
		listDefinition.setColumnLabel(rs.getString("List_Definition.column_label"));
		listDefinition.setColumnName(rs.getString("List_Definition.column_nme"));
		listDefinition.setSequence(rs.getInt("List_Definition.sequence"));
		return listDefinition;
	}
}
