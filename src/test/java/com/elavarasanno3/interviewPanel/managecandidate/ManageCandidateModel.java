package com.elavarasanno3.interviewPanel.managecandidate;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.model.Candidate;

class ManageCandidateModel {

	private ManageCandidateView manageCandidateView;

	ManageCandidateModel(ManageCandidateView manageCandidateView) {
		this.manageCandidateView = manageCandidateView;
	}

	public void addNewCandidate(Candidate candidate) {
		if (CompanyDatabase.getInstance().insertBook(candidate)) {
			manageCandidateView.onCandidateAdded(candidate);
		} else {
			manageCandidateView.onCandidateExist(candidate);
		}
	}
	public boolean nameAndEmailVerification(String name,String author){
		if(nameVerification(name)){
			if(nameVerification(author)){
				return true;
			}else{
				manageCandidateView.alertMessage("\n -----Alert : Enter valid Candidate name @ password -----");
				return false;
			}
		}else{
			manageCandidateView.alertMessage("\n -----Alert : Enter valid Candidate name-----");
			return false;
		}

	}
	public boolean nameVerification(String name){
		return name.length() >= 3 && name.length() <= 50;
	}

    public void deleteCandidate(int candidateId) {
        CompanyDatabase.getInstance().getCandidateList().removeIf(book -> book.getId() == candidateId);
		CompanyDatabase.getInstance().updateCandidate();
    }

	public Candidate updateCandidate(int id) {
		for(Candidate candidate : CompanyDatabase.getInstance().getCandidateList()){
			if(candidate.getId() == id){
				return candidate;
			}
		}
		return null;
	}

	public void changeCandidateName(String candidateName, Candidate candidate) {
		candidate.setName(candidateName);
		CompanyDatabase.getInstance().updateCandidate();
		System.out.println("---candidate name changed successfully---");
	}

	public void changeCandidateEmail(String email, Candidate candidate) {
		candidate.setEmail(email);
		CompanyDatabase.getInstance().updateCandidate();
		System.out.println("---candidate email changed successfully---");
	}

	public void changeQualification(String qualification, Candidate candidate) {
		candidate.setQualification(qualification);
		CompanyDatabase.getInstance().updateCandidate();
		System.out.println("---candidate qualification changed successfully---");
	}
}
