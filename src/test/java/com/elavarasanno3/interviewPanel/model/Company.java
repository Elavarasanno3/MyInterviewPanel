package com.elavarasanno3.interviewPanel.model;

public class Company {
	private String companyName ;
	private int companyId;

	private String phoneNo;
	private String emailId;
	private String address;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getLibraryId() {
		return companyId;
	}

	public void setLibraryId(int companyId) {
		this.companyId = companyId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
