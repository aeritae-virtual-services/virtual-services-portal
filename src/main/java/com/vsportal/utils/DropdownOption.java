package com.vsportal.utils;

public class DropdownOption {
	private String value;
	private String label;
	
	public DropdownOption(String value, String label) {
		this.setValue(value);
		this.setLabel(label);
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
