package com.vsportal.utils;

public class QueryHelper {
	
	public String toSQLQuery(String systemQuery) {
		String sqlQuery = null;
		URIHelper uh = new URIHelper();
		
		//Decode URI Component
		sqlQuery = uh.decodeURIComponent(systemQuery);
		
		sqlQuery = sqlQuery.replaceAll("^", " AND ");
		sqlQuery = sqlQuery.replaceAll("|", " OR ");
		
		return sqlQuery;
	}
	
	public String toSystemQuery(String sqlQuery) {
		String systemQuery = sqlQuery;
		
		systemQuery = systemQuery.replaceAll(" AND ", "^");
		systemQuery = systemQuery.replaceAll(" OR ", "|");
		
		return systemQuery;
	}
}
