package com.elavarasanno3.interviewPanel.login;

import java.util.Scanner;

import com.elavarasanno3.interviewPanel.companysetup.CompanySetupView;
import com.elavarasanno3.interviewPanel.InterviewPanel2024;

public class LoginView {

	private LoginModel loginModel;

	public LoginView() {
		loginModel = new LoginModel(this);
	}

	public void init() {
		System.out.println("-----"+ InterviewPanel2024.getInstance().getAppName() +"----- \n    ----- version "
				+ InterviewPanel2024.getInstance().getAppVersion()+" -----");
		System.out.println("\n----- Admin Portal login to proceed-----");
		proceedLogin();
	}

	public void onSuccess() {
		System.out.flush();
		System.out.println(
				"\nLogin successful...\n ----- welcome to " + InterviewPanel2024.getInstance().getAppName()
						+ "- V - " + InterviewPanel2024.getInstance().getAppVersion() + " ----- ");
		CompanySetupView companySetupView = new CompanySetupView();
		companySetupView.init();
	}

	public void onLoginFailed(String alertText) {
		System.out.println(alertText);
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("Do you try again? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			proceedLogin();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n ---- Thanks You ----");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForLogin();
		}
	}

	public void proceedLogin() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n Enter Admin name : ");
		String userName = scanner.nextLine();
		System.out.print("\n Enter password : ");
		String password = scanner.nextLine();
		loginModel.validateAdmin(userName, password);
	}
}