package com.elavarasanno3.interviewPanel.managecandidate;

import java.util.Scanner;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.model.Candidate;
import com.elavarasanno3.interviewPanel.model.Credentials;

public class ManageCandidateView {
	private ManageCandidateModel manageCandidateModel;
	Scanner scanner = new Scanner(System.in);
	public ManageCandidateView(){
		manageCandidateModel = new ManageCandidateModel(this);
	}
	public void initAdd() {
		System.out.print("\nEnter the following Candidate Details: ");
		Scanner scanner = new Scanner(System.in);
		Candidate candidate = new Candidate();
		System.out.print("\nEnter Candidate name : ");
		String name = scanner.nextLine();
		candidate.setName(name);
		System.out.print("\nEnter email : ");
		String email = scanner.nextLine();
		candidate.setEmail(email);
		System.out.print("\nEnter the candidate qualification : ");
		candidate.setQualification(scanner.nextLine());

		Credentials credentials =  CompanyDatabase.getInstance().credentials;
		candidate.setId(credentials.getCandidateId());
		credentials.setCandidateId(credentials.getCandidateId()+1);
		CompanyDatabase.getInstance().updateCredentials(credentials);

		if(manageCandidateModel.nameAndEmailVerification(name,email)){
			manageCandidateModel.addNewCandidate(candidate);
		}else{
			initAdd();
		}
	}
	public void deleteCandidate(int id){
		manageCandidateModel.deleteCandidate(id);
	}

//	public void borrowingBook(Interviewer user, int id){
//        user.getUserBookList().removeIf(book -> book.getId() == id);
//		CompanyDatabase.getInstance().updateUser(user);
//		addToLibraryBookList(id,user);
//	}
//	public void addToLibraryBookList(int id, Interviewer user){
//		boolean flag = false;
//		for(Candidate book : CompanyDatabase.getInstance().getCandidateList()){
//			if(book.getId() == id){
//				book.setCount(book.getCount()+1);
//				CompanyDatabase.getInstance().updateBook();
//				flag = true;
//			}
//		}
//		if(!flag){
//			Candidate addBook = null;
//			for(Candidate book : user.getUserBookList()){
//				if(book.getId() == id){
//					addBook = book;
//				}
//			}
//			CompanyDatabase.getInstance().getCandidateList().add(addBook);
//			CompanyDatabase.getInstance().updateBook();
//		}
//	}
	public void alertMessage(String text){
		System.out.println(text);
		System.out.println("---------------------------------------------------");
	}

	public void onCandidateAdded(Candidate candidate){
		System.out.println("\n------- Candidate '" + candidate.getName() + "' added successfully ------- \n");
		checkForAddNewCandidate();
	}
	public void onCandidateExist(Candidate book) {
		System.out.println("\n------- Candidate '" + book.getName() + "' already exist -------\n");
		checkForAddNewCandidate();
	}
	private void checkForAddNewCandidate() {
		System.out.print("\nDo you want to add more Candidate? \n-----Type Yes/No-----");
		String choice = scanner.next().toLowerCase();
		if (choice.equals("yes")) {
			initAdd();
		} else if (choice.equals("no")) {
			System.out.print("\nThanks for adding Candidate");
		} else {
			System.out.print("\nInvalid choice, Please enter valid choice");
			checkForAddNewCandidate();
		}
	}

	public void updateCandidate(int id) {
		Candidate candidate = manageCandidateModel.updateCandidate(id);
		if(candidate != null){
			System.out.print("\n 1 --> change candidate name\n 2 --> change candidate gmail\n 3 --> change candidate qualification");
			System.out.print("\nEnter your choice : ");
			String choice = scanner.nextLine();
			while(true){
				switch (choice){
					case "1" :
						System.out.print("Enter new Candidate name : ");
						String bookName = scanner.nextLine();
						manageCandidateModel.changeCandidateName(bookName,candidate);
						return;
					case "2" :
						System.out.print("\nEnter new Candidate gmail : ");
						String author = scanner.nextLine();
						manageCandidateModel.changeCandidateEmail(author,candidate);
						return;
					case "3" :
						System.out.print("\nEnter new Candidate password : ");
						String qualification = scanner.nextLine();
						manageCandidateModel.changeQualification(qualification,candidate);
						return;
					case "0" :
						return;
					default:
						System.out.println("-- Enter valid choice --");
						updateCandidate(id);
						break;

				}
			}

		}else{
			System.out.println("Enter a valid user id");
		}
	}

	public void searchCandidate(String searchId) {
		for (Candidate candidate : CompanyDatabase.getInstance().getCandidateList()){
			if(candidate.getName().startsWith(searchId)){
				System.out.print("\n----------Candidate Details : \n_______________________________________");
				System.out.print("\n"+candidate.getId() +  " --  Candidate name : " + candidate.getName());
				System.out.print("\n --  Candidate Qualification : " +candidate.getQualification());
				System.out.print("\n --  Book Author : "+ candidate.getEmail());
			}
		}
	}
}
