package com.elavarasanno3.interviewPanel;

import com.elavarasanno3.interviewPanel.mainlogin.MainLoginView;

//LibraryManagement2024 Application class. 
//We can maintain application related details here.
public class InterviewPanel2024 {

	// This variable should be private so that other classes cannot access this
	// variable.
	// Also it should be static so that only one instance will be created.
	private static InterviewPanel2024 interviewPanel;

	private String appName = "Interview Panel System";

	private String appVersion = "0.1.0";

	// default constructor should be private so that we cannot create an instance
	// from other class.
	private InterviewPanel2024() {

	}

	// Creating a single instance of this application class.
	// So that we access the application info(appName, appVersion) from any where in
	// the application.
	public static InterviewPanel2024 getInstance() {
		if (interviewPanel == null) {
			interviewPanel = new InterviewPanel2024();
		}
		return interviewPanel;
	}

	private void create() {
		MainLoginView mainLoginView = new MainLoginView();
		mainLoginView.init();
	}

	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	// Application execution starts from here.1

	public static void main(String []arg) {

		// Application created and started from here.
		InterviewPanel2024.getInstance().create();
	}
}
