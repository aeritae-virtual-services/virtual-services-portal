package com.vsportal.attachment;

import java.sql.Date;

import com.vsportal.request.Request;
import com.vsportal.user.User;

public class Attachment {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private Request request;
	private String url;
	private String fileType;
	
	public Attachment() {
		
	}
	
	public Attachment(int id, String displayValue) {
		this.id = id;
		this.displayValue = displayValue;
	}
	
	public Attachment(User createdBy, User updatedBy, Request request, String url, String fileType) {
		super();
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.request = request;
		this.url = url;
		this.fileType = fileType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getDisplayValue(){
		return displayValue;
	}
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}
}
