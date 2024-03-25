package com.elavarasanno3.interviewPanel.companysetup;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.model.Company;

//Access modifier for this CompanySetupModel class should be default.
//So that outside of the package this class cannot be accessed.
class CompanySetupModel {

	private CompanySetupView companySetupView;

	private Company company;
	public CompanySetupModel(CompanySetupView interviewSetupView){
		this.companySetupView = interviewSetupView;
		company = CompanyDatabase.getInstance().getCompany();
	}

	public void startSetUp() {
		if(company.getCompanyName() == null){
			companySetupView.initialSetup();
		}else{
			companySetupView.onSetupComplete();
		}
	}


	public boolean nameAndEmailVerification(String name,String gmail){
		if(nameVerification(name)){
			if(gmailVerification(gmail)){
				return true;
			}else{
				companySetupView.showAlert("\n -----Alert : Enter valid name &  gmail-----\n");
				return false;
			}
		}else{
			companySetupView.showAlert("\n-----Alert : Enter valid name-----\n");
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


}
