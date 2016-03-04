package com.vsportal.utils;

import java.util.Calendar;

public class DateHelper {
	java.util.Date date;
	
	public DateHelper() {
		date = new java.util.Date();
	}
	
	public DateHelper(java.util.Date d) {
		date = d;
	}
	
	public void setDate(java.util.Date d) {
		date = d;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void subtract(int field, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, (0 - diff));
		date = c.getTime();
	}
	
	public void add(int field, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, diff);
		date = c.getTime();
	}
	
	public java.sql.Date getSQLDate() {
		return new java.sql.Date(date.getTime());
	}
}