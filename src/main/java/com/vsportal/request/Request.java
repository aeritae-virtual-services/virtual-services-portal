package com.vsportal.request;

import java.sql.Date;

import com.vsportal.contract.Contract;
import com.vsportal.priority.Priority;
import com.vsportal.status.Status;
import com.vsportal.tier.Tier;
import com.vsportal.user.User;

public class Request {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private User requester;
	private String number;
	private String description;
	private String shortDescription;
	private String clientRequestNumber;
	private Status status;
	private Date requestedCompletionDate;
	private Priority priority;
	private String updateSet;
	private boolean requestLOE;
	private float estimatedLOE;
	private float hoursConsumed;
	private RequestType requestType;
	private Contract contract;
	private Tier tier;
	private Status resumeTo;
	
	public Request(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
	}
	public Request() {
		super();
	}

	public Request(int id, Date created, User createdBy, Date updated, User updatedBy, User requester, String number,
			String description, String shortDescription, String clientRequestNumber, Status status,
			Date requestedCompletionDate, Priority priority, String updateSet, boolean requestLOE, float estimatedLOE,
			float hoursConsumed, RequestType requestType, Contract contract, Tier tier) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.requester = requester;
		this.number = number;
		this.description = description;
		this.shortDescription = shortDescription;
		this.clientRequestNumber = clientRequestNumber;
		this.status = status;
		this.requestedCompletionDate = requestedCompletionDate;
		this.priority = priority;
		this.updateSet = updateSet;
		this.requestLOE = requestLOE;
		this.estimatedLOE = estimatedLOE;
		this.hoursConsumed = hoursConsumed;
		this.requestType = requestType;
		this.contract = contract;
		this.tier = tier;
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

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getClientRequestNumber() {
		return clientRequestNumber;
	}

	public void setClientRequestNumber(String clientRequestNumber) {
		this.clientRequestNumber = clientRequestNumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getRequestedCompletionDate() {
		return requestedCompletionDate;
	}

	public void setRequestedCompletionDate(Date requestedCompletionDate) {
		this.requestedCompletionDate = requestedCompletionDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getUpdateSet() {
		return updateSet;
	}

	public void setUpdateSet(String updateSet) {
		this.updateSet = updateSet;
	}

	public boolean isRequestLOE() {
		return requestLOE;
	}

	public void setRequestLOE(boolean requestLOE) {
		this.requestLOE = requestLOE;
	}

	public float getEstimatedLOE() {
		return estimatedLOE;
	}

	public void setEstimatedLOE(float estimatedLOE) {
		this.estimatedLOE = estimatedLOE;
	}

	public float getHoursConsumed() {
		return hoursConsumed;
	}

	public void setHoursConsumed(float hoursConsumed) {
		this.hoursConsumed = hoursConsumed;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public Status getResumeTo() {
		return resumeTo;
	}

	public void setResumeTo(Status resumeTo) {
		this.resumeTo = resumeTo;
	}
}
