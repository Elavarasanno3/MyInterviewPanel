package com.elavarasanno3.interviewPanel.login;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;

class LoginModel {

	private LoginView loginView;

	LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void validateAdmin(String adminName, String password) {
		if (isValidInterviewerName(adminName)) {
			if (isValidPassword(adminName,password)) {
				loginView.onSuccess();
			} else {
				loginView.onLoginFailed("Invalid password");
			}
		} else {
			loginView.onLoginFailed("Invalid Admin Name");
		}
	}

	// this method should be private because this method used only with in this
	// class.
	private boolean isValidInterviewerName(String userName) {
		return userName.equals(CompanyDatabase.getInstance().admin.getName());
	}

	// this method should be private because this method used only with in this
	// class.
	private boolean isValidPassword(String userName, String password) {
		return (userName.equals(CompanyDatabase.getInstance().admin.getName())&&password.equals(CompanyDatabase.getInstance().admin.getPassword()));
	}
}
