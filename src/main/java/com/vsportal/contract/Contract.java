package com.vsportal.contract;

import java.sql.Date;

import com.vsportal.user.User;
import com.vsportal.client.Client;
import com.vsportal.tier.Tier;
import com.vsportal.status.Status;

public class Contract {

	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private Client client;
	private Tier tier;
	private Date startDate;
	private Date endDate;
	private Date finalCompletionDate;
	private Status status;
	
	public Contract(){
		super();
	}
	public Contract(int id, String displayValue){
		this.id=id;
		this.displayValue=displayValue;
	}
	public Contract(int id, Date created, User createdBy, Date updated, User updatedBy,
			Client client, Tier tier, Date startDate, Date endDate, Date finalCompletionDate, Status status){
		super();
		this.id = id;
		this.created=created;
		this.createdBy=createdBy;
		this.updated=updated;
		this.updatedBy=updatedBy;
		this.client = client;
		this.tier = tier;
		this.startDate = startDate;
		this.endDate = endDate;
		this.finalCompletionDate = finalCompletionDate;
		this.status = status;
		this.displayValue = client.getDisplayValue();
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Tier getTier() {
		return tier;
	}
	public void setTier(Tier tier) {
		this.tier = tier;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getFinalCompletionDate() {
		return finalCompletionDate;
	}
	public void setFinalCompletionDate(Date finalCompletionDate) {
		this.finalCompletionDate = finalCompletionDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
