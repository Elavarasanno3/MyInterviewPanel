package com.elavarasanno3.interviewPanel.manageinterviewer;

import java.util.Scanner;

import com.elavarasanno3.interviewPanel.model.Interviewer;

public class ManageInterviewerView {
	private ManageInterviewerModel manageInterviewerModel;
	public ManageInterviewerView(){
		manageInterviewerModel = new ManageInterviewerModel(this);
	}
	Scanner scanner = new Scanner(System.in);
	public void initAdd() {
		System.out.print(" --> Enter the following Interviewer Details: ");
		Interviewer interviewer = new Interviewer();
		System.out.print("\nEnter Interviewer name : ");
		String name = scanner.nextLine();
		interviewer.setName(name);
		System.out.print("\nEnter Interviewer emailId : ");
		String gmail = scanner.nextLine();
		interviewer.setEmailId(gmail);
		System.out.print("\nEnter new password : ");
		interviewer.setPassword(scanner.nextLine());
		if(manageInterviewerModel.nameAndEmailVerification(name,gmail)){
			manageInterviewerModel.addNewInterviewer(interviewer);
		}else{
			initAdd();
		}
	}
	public void onInterviewerAdded(Interviewer interviewer){
		System.out.println("\n------- Interviewer '" + interviewer.getName() + "' added successfully ------- \n");
		checkForAddNewInterviewer();
	}
	public void onInterviewerExist(Interviewer interviewer) {
		System.out.println("\n------- Interviewer '" + interviewer.getName() + "' already exist -------\n");
		checkForAddNewInterviewer();
	}
	public void alertMessage(String text){
		System.out.println(text);
		System.out.println("------------------------------------------------------------");
	}
	private void checkForAddNewInterviewer() {
		System.out.println("Do you want to add more Interviewer? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next().toLowerCase();
		if (choice.equals("yes")) {
			initAdd();
		} else if (choice.equals("no")) {
			System.out.println("\n Thanks for adding interviewer");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewInterviewer();
		}
	}


	public void updateInterviewer(int id) {
		Interviewer interviewer = manageInterviewerModel.updateInterviewer(id);
		if(interviewer != null){
			System.out.print("\n 1 --> change interviewer name\n 2 --> change interviewer gmail\n 3 --> change interviewer password\n 0 --> Exit");
			System.out.print("\nEnter your choice : ");
			String choice = scanner.nextLine();
			while(true){
				switch (choice){
					case "1" :
						System.out.print("Enter new Interviewer name : ");
						String interviewerName = scanner.nextLine();;
						manageInterviewerModel.changeInterviewerName(interviewerName,interviewer);
						return;
					case "2" :
						System.out.print("\nEnter new Interviewer gmail : ");
						String gmail = scanner.nextLine();
						manageInterviewerModel.changeInterviewerGmail(gmail,interviewer);
						return;
					case "3" :
						System.out.print("\nEnter new Interviewer password : ");
						String password = scanner.nextLine();
						manageInterviewerModel.changeInterviewerPassword(password,interviewer);
						return;
					case "0" :
						return;
					default:
						System.out.println("-- Enter valid choice --");
						updateInterviewer(id);
						break;

				}
			}

		}else{
			System.out.println("Enter a valid interviewer id");
			return;
		}
	}
}