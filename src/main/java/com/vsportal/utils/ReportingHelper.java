package com.vsportal.utils;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import com.vsportal.contract.Contract;
import com.vsportal.contract.ContractDAO;
import com.vsportal.task.TimeEntry;
import com.vsportal.task.TimeEntryDAO;

public class ReportingHelper {
	/*
	 * Hours Charged By Month
	 * Accepts Client ID and Number of Months
	 */
	public String getHoursChargedByMonthFor(String clientId, int numMonths) {
		DateHelper dh = new DateHelper();
		dh.subtract(Calendar.MONTH, numMonths);
		Date startDate = dh.getSQLDate();
		
		ContractDAO cd = new ContractDAO();
		ArrayList<Contract> conArr = cd.getListByQuery("SELET * FROM Contract WHERE client=" + clientId + " AND created > " + startDate.toString());
		String contractList = "";
		
		for(Contract c : conArr) {
			contractList += String.valueOf(c.getId()) + ",";
		}
		
		contractList = "(" + contractList.substring(0, contractList.length() - 1) + ")";
		
		TimeEntryDAO ted = new TimeEntryDAO();
		ArrayList<TimeEntry> teArr = ted.getListByQuery("SELECT * FROM TimeEntry WHERE contract IN " + contractList + " AND created > ");
		return "";
	}

}
