package com.elavarasanno3.interviewPanel.model;
import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class Interviewer {

	private String name;
	private int id;
	private String password;
	private String phoneNo;
	private String emailId;
	private String address;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
