package com.elavarasanno3.interviewPanel.companysetup;

import java.util.Scanner;

import com.elavarasanno3.interviewPanel.InterviewPanel2024;
import com.elavarasanno3.interviewPanel.adminhome.AdminHomeView;
import com.elavarasanno3.interviewPanel.candidatehome.CandidateHomeView;
import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.interviewerhome.InterviewerHomeView;

//Access modifier for this CompanySetupView class should be public.
//So that outside of the package this class can be accessed and can create instance for this class.
public class CompanySetupView {

	private CompanySetupModel companySetupModel;
	public CompanySetupView(){
		companySetupModel = new CompanySetupModel(this);
	}
	public void init(){
		companySetupModel.startSetUp();
	}
	public void showAlert(String alert){
		System.out.println(alert);
		initialSetup();
	}

	public void initialSetup() {
		System.out.print("\nEnter Company details : ");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter Company name : ");
		String companyName =  scanner.nextLine();
		CompanyDatabase.getInstance().company.setCompanyName(companyName);
		System.out.print("\nEnter email id : " );
		String emailId = scanner.nextLine();
		CompanyDatabase.getInstance().company.setEmailId(emailId);
		if(!(companySetupModel.nameAndEmailVerification(companyName,emailId))){
			initialSetup();
		}else{
			CompanyDatabase.getInstance().updateCompany();
			onSetupComplete();
		}


	}

//	public void getUserBookListDetails(){
//		ArrayList<Book> bookList = CompanyDatabase.getInstance().getUserBookList();
//		System.out.println("\n-----------Book Details-------------");
//		for(Book book : bookList){
//			System.out.print("\n"+ book.getId() +  "."+ " Book name : " + book.getName());
//			System.out.print("\nAvailable books : " +book.getCount());
//			System.out.print("\nBook Author : "+ book.getAuthor());
//			System.out.print("\n");
//		}
//	}

	public void onSetupComplete(){
		System.out.print("\nCurrent Company Name : " + CompanyDatabase.getInstance().company.getCompanyName());
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.print("\n 1 --> Manage Interviewer\n 2 --> Manage Candidate\n 3 --> Manage Admin\n 0 --> Exit\n Enter your choice : ");
			String choice = in.next();
			switch (choice) {
				case "1":
					new InterviewerHomeView().init();
					break;
				case "2":
					new CandidateHomeView().init();
					break;
				case "3":
					new AdminHomeView().init();
					break;
				case "0":
					System.out.print("\n\n-- Thanks for using " + InterviewPanel2024.getInstance().getAppName() + "\n");
					return;
				default:
					System.out.print("\n\nPlease Enter valid choice\n");
			}
		}
	}
}
