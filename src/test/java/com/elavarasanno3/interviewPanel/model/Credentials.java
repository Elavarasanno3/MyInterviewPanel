package com.elavarasanno3.interviewPanel.model;

public class Credentials {
	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(int interviewerId) {
		this.interviewerId = interviewerId;
	}

	int candidateId = 1 ;
	int interviewerId  = 1;
	public Credentials(){
	}
}
