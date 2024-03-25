package com.elavarasanno3.interviewPanel.manageinterviewer;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.model.Interviewer;

public class ManageInterviewerModel {
	private ManageInterviewerView manageInterviewerView;
	ManageInterviewerModel(ManageInterviewerView manageInterviewerView){
		this.manageInterviewerView = manageInterviewerView;
	}
	public void addNewInterviewer(Interviewer interviewer){
		if(CompanyDatabase.getInstance().insertInterviewer(interviewer)){
			manageInterviewerView.onInterviewerAdded(interviewer);
		}else{
			manageInterviewerView.onInterviewerExist(interviewer);
		}
	}
	public boolean nameAndEmailVerification(String name,String gmail){
		if(nameVerification(name)){
			if(gmailVerification(gmail)){
				return true;
			}else{
				manageInterviewerView.alertMessage("\n -----Alert : Enter valid name & gmail-----\n");
				return false;
			}
		}else{
			manageInterviewerView.alertMessage("\n-----Alert : Enter valid name-----\n");
			return false;
		}

	}
	public boolean nameVerification(String name){
		return name.length() >= 3 && name.length() <= 50;
	}
	public boolean gmailVerification(String gmail){
		if(gmail.length() < 10)
			return false;
		if(gmail.charAt(gmail.length()-11) == '.')
			return false ;
		if(!(gmail.endsWith("@gmail.com")))
			return false;
		for(int i = 0;i<gmail.length()-10;i++){
			char c = gmail.charAt(i);
			if(!(Character.isAlphabetic(c) || c == '.'|| Character.isDigit(c))) {
				return false;
			}
		}
		return true;
	}


	public Interviewer updateInterviewer(int id) {
		for(Interviewer interviewer : CompanyDatabase.getInstance().getInterviewerList()){
			if(interviewer.getId() == id){
				return interviewer;
			}
		}
		return null;
	}

	public void changeInterviewerName(String username, Interviewer interviewer) {
		interviewer.setName(username);
		CompanyDatabase.getInstance().updateInterviewer();
		System.out.println("---name changed successfully---");
	}

	public void changeInterviewerGmail(String gmail, Interviewer interviewer) {
		interviewer.setEmailId(gmail);
		CompanyDatabase.getInstance().updateInterviewer();
		System.out.println("---gmail changed successfully---");
	}

	public void changeInterviewerPassword(String password, Interviewer interviewer) {
		interviewer.setPassword(password);
		CompanyDatabase.getInstance().updateInterviewer();
		System.out.println("---password changed successfully---");
	}
}

